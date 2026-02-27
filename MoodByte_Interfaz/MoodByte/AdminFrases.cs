using Conexiones;
using ModeloDTO;
using System.Net.Http.Json;

namespace MoodByte
{
    public partial class AdminFrases : Form
    {

        public AdminFrases()
        {
            InitializeComponent();
            navMenu.AbrirUsuarios += menu_abrirUsuarios;
            navMenu.AbrirArticulos += menu_abrirArticulos;
            navMenu.AbrirEjercicios += menu_abrirEjercicios;
            navMenu.AbrirFrases += menu_abrirFrases;
            navMenu.AbrirLogin += menu_abrirLogin;
        }
        private void menu_abrirLogin(object? sender, EventArgs e)
        {
            Program.log.Visible = true;
            this.Close();
        }

        private void menu_abrirUsuarios(object sender, EventArgs e)
        {

            AdminUsuarios usuarios = new AdminUsuarios();
            usuarios.Visible = true;
            this.Close();

        }
        private void menu_abrirArticulos(object sender, EventArgs e)
        {

            AdminArticulos articulos = new AdminArticulos();
            articulos.Visible = true;
            this.Close();

        }
        private void menu_abrirEjercicios(object sender, EventArgs e)
        {

            AdminEjercicios ejercicios = new AdminEjercicios();
            ejercicios.Visible = true;
            this.Close();

        }
        private void menu_abrirFrases(object sender, EventArgs e)
        {

            AdminFrases frases = new AdminFrases();
            frases.Visible = true;
            this.Close();
        }

        private async void btnInsertar_Click(object sender, EventArgs e)
        {
            CrearFrase fraseForm = new CrearFrase();
            fraseForm.ShowDialog();
            if(fraseForm.DialogResult == DialogResult.OK)
            {
                await CargarGrid();
            }
        }

        private async void AdminFrases_Load(object sender, EventArgs e)
        {
            await CargarGrid();
            await CargarEstados();
        }

        private async Task CargarGrid()
        {
            var frases = await ConexionGenerica.CLIENTE.GetFromJsonAsync<List<FraseDTO>>(ConexionTabla.TablaFrase);
            if (frases != null)
            {
                dgvFrases.DataSource = frases;
                dgvFrases.AutoGenerateColumns = true;
                dgvFrases.Columns["id"].Visible = false;
                dgvFrases.SelectionMode = DataGridViewSelectionMode.FullRowSelect;

            }
            else
            {
                MessageBox.Show("No se pudieron cargar las frases.");
            }
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

                cmbEstados.DataSource = null;
                cmbEstados.DataSource = estados;
                cmbEstados.DisplayMember = "nombre";
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al cargar los estados: " + ex.Message);
            }
        }

        private async void cmbEstados_SelectedIndexChanged(object sender, EventArgs e)
        {
            List<FraseDTO> frases = await ConexionGenerica.CLIENTE.GetFromJsonAsync<List<FraseDTO>>(ConexionTabla.TablaFrase);
            List<FraseDTO> frasesSeleccionadas = new List<FraseDTO>();
            EstadoDTO estadoSeleccionado = cmbEstados.SelectedItem as EstadoDTO;
            switch (estadoSeleccionado.nombre.ToLower())
            {
                case "feliz":
                    foreach (var frase in frases)
                    {
                        if (frase.puntuacion == 1)
                        {
                            frasesSeleccionadas.Add(frase);
                        }
                    }
                    dgvFrases.DataSource = null;
                    dgvFrases.DataSource = frasesSeleccionadas;
                    dgvFrases.AutoGenerateColumns = true;
                    dgvFrases.Columns["id"].Visible = false;
                    dgvFrases.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
                    break;
                case "bien":
                    foreach (var frase in frases)
                    {
                        if (frase.puntuacion == 2)
                        {
                            frasesSeleccionadas.Add(frase);
                        }
                    }
                    dgvFrases.DataSource = null;
                    dgvFrases.DataSource = frasesSeleccionadas;
                    dgvFrases.AutoGenerateColumns = true;
                    dgvFrases.Columns["id"].Visible = false;
                    dgvFrases.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
                    break;
                case "regular":
                    foreach (var frase in frases)
                    {
                        if (frase.puntuacion == 3)
                        {
                            frasesSeleccionadas.Add(frase);
                        }
                    }
                    dgvFrases.DataSource = null;
                    dgvFrases.DataSource = frasesSeleccionadas;
                    dgvFrases.AutoGenerateColumns = true;
                    dgvFrases.Columns["id"].Visible = false;
                    dgvFrases.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
                    break;
                case "estresado":
                    foreach (var frase in frases)
                    {
                        if (frase.puntuacion == 4)
                        {
                            frasesSeleccionadas.Add(frase);
                        }
                    }
                    dgvFrases.DataSource = null;
                    dgvFrases.DataSource = frasesSeleccionadas;
                    dgvFrases.AutoGenerateColumns = true;
                    dgvFrases.Columns["id"].Visible = false;
                    dgvFrases.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
                    break;
                case "triste":
                    foreach (var frase in frases)
                    {
                        if (frase.puntuacion == 5)
                        {
                            frasesSeleccionadas.Add(frase);
                        }
                    }

                    dgvFrases.DataSource = null;
                    dgvFrases.DataSource = frasesSeleccionadas;
                    dgvFrases.AutoGenerateColumns = true;
                    dgvFrases.Columns["id"].Visible = false;
                    dgvFrases.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
                    break;

            }
        }

        private async void btnEditar_Click(object sender, EventArgs e)
        {
            if (dgvFrases.SelectedRows.Count > 0)
            {
                FraseDTO fraseSeleccionada = dgvFrases.SelectedRows[0].DataBoundItem as FraseDTO;
                CrearFrase editFrase = new CrearFrase(fraseSeleccionada);
                editFrase.ShowDialog();
                if (editFrase.DialogResult == DialogResult.OK)
                {
                    await CargarGrid();
                }
            }
            else
            {
                MessageBox.Show("Seleccione una frase para editar.");
            }
        }

        private async void btnBorrar_Click(object sender, EventArgs e)
        {
            if (dgvFrases.SelectedRows.Count > 0)
            {
                FraseDTO fraseEliminar = dgvFrases.SelectedRows[0].DataBoundItem as FraseDTO;

                var response= await ConexionGenerica.CLIENTE.DeleteAsync($"{ConexionTabla.TablaFrase}/{fraseEliminar.id}");
                if (response.IsSuccessStatusCode)
                {
                    MessageBox.Show("Frase borrada");
                    await CargarGrid();
                }
                else
                {
                    MessageBox.Show("Error al borrar frase","ERROR");
                }
            }
        }
    }
}
