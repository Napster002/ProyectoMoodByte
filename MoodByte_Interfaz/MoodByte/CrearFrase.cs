using Conexiones;
using Modelo;
using ModeloDTO;
using System.Net.Http.Json;

namespace MoodByte
{
    public partial class CrearFrase : Form
    {
        private List<EstadoDTO> listaEstados;
        private bool esNuevo;
        private FraseDTO frase;

        public CrearFrase()
        {
            esNuevo = true;
            InitializeComponent();
            this.Load += CrearFrase_Load;
            btnGuardar.Text = "Guardar";
        }
        public CrearFrase(FraseDTO frase)
        {
            esNuevo = false;
            InitializeComponent();
            btnGuardar.Text = "Actualizar";
            this.Load += CrearFrase_Load;
            this.frase = frase;
        }

        public async Task CargarEstados()
        {
            try
            {
                var estados = await ConexionGenerica.CLIENTE
                    .GetFromJsonAsync<List<EstadoDTO>>(ConexionTabla.TablaEstado);

                if (estados == null)
                {
                    MessageBox.Show("No se recibieron estados.");
                    return;
                }

                listaEstados = estados;

                cmbEstado.DataSource = null;
                cmbEstado.DataSource = listaEstados;
                cmbEstado.DisplayMember = "nombre";
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al cargar los estados: " + ex.Message);
            }
        }
        public async Task InsertaFrase(Frase frase)
        {
            if (!esNuevo)
            {

                Frase fraseActualizada = new Frase
                {
                    id = frase.id,
                    frase = frase.frase,
                    puntuacion = frase.puntuacion
                };
                var respuesta = await ConexionGenerica.CLIENTE.PutAsJsonAsync($"{ConexionTabla.TablaFrase}/{fraseActualizada.id}", fraseActualizada);
                if (respuesta.IsSuccessStatusCode)
                {
                    MessageBox.Show("Frase actualizada", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                else
                {
                    MessageBox.Show("Fallo al actualizar frase" + respuesta.ReasonPhrase);
                }
            }
            else
            {
                var respuesta = await ConexionGenerica.CLIENTE.PostAsJsonAsync(ConexionTabla.TablaFrase, frase);
                if (respuesta.IsSuccessStatusCode)
                {
                    MessageBox.Show("Frase agregada", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                else
                {
                    MessageBox.Show("Fallo al agregar frase");
                }
            }
        }

        private void buttonLimpiar_Click(object sender, EventArgs e)
        {
            if (cmbEstado.Items.Count > 0)
                cmbEstado.SelectedIndex = 0;
            txtFrase.Clear();
            txtFrase.Focus();
        }

        private async void CrearFrase_Load(object sender, EventArgs e)
        {
            await CargarEstados();
            if (!esNuevo)
            {
                switch (frase.puntuacion)
                {
                    case 1: cmbEstado.SelectedItem = listaEstados.FirstOrDefault(e => e.nombre.ToLower() == "triste"); break;
                    case 2: cmbEstado.SelectedItem = listaEstados.FirstOrDefault(e => e.nombre.ToLower() == "estresado"); break;
                    case 3: cmbEstado.SelectedItem = listaEstados.FirstOrDefault(e => e.nombre.ToLower() == "regular"); break;
                    case 4: cmbEstado.SelectedItem = listaEstados.FirstOrDefault(e => e.nombre.ToLower() == "bien"); break;
                    case 5: cmbEstado.SelectedItem = listaEstados.FirstOrDefault(e => e.nombre.ToLower() == "feliz"); break;
                }
                cmbEstado.Enabled = false;
            }
        }

        private async void btnGuardar_Click(object sender, EventArgs e)
        {
            if (!Validaciones.validaFrase(txtFrase.Text, out var err))
            {
                epFrase.SetError(txtFrase, err);
                MessageBox.Show("Mal Insertado: Frase", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                var puntuaje = 0;
                epFrase.SetError(txtFrase, "");
                EstadoDTO estado = cmbEstado.SelectedItem as EstadoDTO;
                switch (estado.nombre.ToLower())
                {
                    case "triste": puntuaje = 5; break;
                    case "estresado": puntuaje = 4; break;
                    case "regular": puntuaje = 3; break;
                    case "bien": puntuaje = 2; break;
                    case "feliz": puntuaje = 1; break;
                }
                ;
                Frase fraseInsert = new Frase();
                if (!esNuevo)
                {
                    fraseInsert = new Frase
                    {
                        id = frase.id,
                        frase = txtFrase.Text,
                        puntuacion = puntuaje
                    };
                }
                else
                {
                    fraseInsert = new Frase
                    {
                        frase = txtFrase.Text,
                        puntuacion = puntuaje

                    };
                }
                await InsertaFrase(fraseInsert);
                this.DialogResult = DialogResult.OK;
                this.Close();

            }
        }

    }
}
