using Conexiones;
using ModeloDTO;
using System.Data;
using System.Net.Http.Json;

namespace MoodByte
{
    public partial class AdminEjercicios : Form
    {
        private List<EjercicioDTO> listaEjercicios = new List<EjercicioDTO>();
        public AdminEjercicios()
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
        private async Task CargarEstado()
        {
            var estados = await ConexionGenerica.CLIENTE.GetFromJsonAsync<List<EstadoDTO>>(ConexionTabla.TablaEstado);
            if (estados == null)
            {
                MessageBox.Show("No se recibieron estados.");
                return;
            }
            cmbEstado.DataSource = null;
            cmbEstado.DataSource = estados;
            cmbEstado.DisplayMember = "nombre";
        }
        private async Task CargarGrid()
        {
            var ejercicios = await ConexionGenerica.CLIENTE.GetFromJsonAsync<List<EjercicioDTO>>(ConexionTabla.TablaEjercicio);
            if (ejercicios == null)
            {
                MessageBox.Show("No se recibieron ejercicios.");
                return;
            }
            listaEjercicios = ejercicios;
            dgvEjercicio.DataSource = listaEjercicios;
            dgvEjercicio.AutoGenerateColumns = true;
            dgvEjercicio.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
            dgvEjercicio.Columns["Id"].Visible = false;
            dgvEjercicio.Columns["idEstado"].Visible = false;
        }

        private async void AdminEjercicios_Load(object sender, EventArgs e)
        {
            await CargarEstado();
            await CargarGrid();
        }

        private async void btnInsertarEjercicio_Click(object sender, EventArgs e)
        {
            CrearEjercicio crear = new CrearEjercicio();
            crear.ShowDialog();
            if (crear.DialogResult == DialogResult.OK)
            {
                await CargarGrid();
            }
        }

        private async void cmbEstado_SelectedIndexChanged(object sender, EventArgs e)
        {
            EstadoDTO estadoSeleccionado = cmbEstado.SelectedItem as EstadoDTO;
            if (estadoSeleccionado == null)
                return;
            var ejerciciosSeleccionados = listaEjercicios
                .Where(e => e.idEstado == estadoSeleccionado.id)
                .ToList();
            dgvEjercicio.DataSource = null;
            dgvEjercicio.DataSource = ejerciciosSeleccionados;
            dgvEjercicio.AutoGenerateColumns = true;
            dgvEjercicio.Columns["Id"].Visible = false;
            dgvEjercicio.Columns["idEstado"].Visible = false;
            dgvEjercicio.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
        }


        private async void btnEditar_Click(object sender, EventArgs e)
        {
            if (dgvEjercicio.SelectedRows.Count > 0)
            {
                EjercicioDTO ejercicioSeleccionado = dgvEjercicio.SelectedRows[0].DataBoundItem as EjercicioDTO;
                if (ejercicioSeleccionado != null)
                {
                    CrearEjercicio editar = new CrearEjercicio(ejercicioSeleccionado);
                    editar.ShowDialog();
                    if (editar.DialogResult == DialogResult.OK)
                    {
                        await CargarGrid();
                    }
                }
            }
        }

        private async void btnBorrar_Click(object sender, EventArgs e)
        {
            if (dgvEjercicio.SelectedRows.Count > 0)
            {
                EjercicioDTO ejercicioSeleccionado = dgvEjercicio.SelectedRows[0].DataBoundItem as EjercicioDTO;
                if(ejercicioSeleccionado != null)
                {
                    var confirmResult = MessageBox.Show("¿Estás seguro de que deseas eliminar este ejercicio?", "Confirmar eliminación", MessageBoxButtons.YesNo);
                    if (confirmResult == DialogResult.Yes)
                    {
                        var response=await ConexionGenerica.CLIENTE.DeleteAsync($"{ConexionTabla.TablaEjercicio}/{ejercicioSeleccionado.id}");
                        if (response.IsSuccessStatusCode)
                        {
                            MessageBox.Show("Ejercicio eliminado");
                            await CargarGrid();
                        }
                        else
                        {
                            MessageBox.Show("Error al eliminar el ejercicio");
                        }
                    }
                }
            }
        }
    }
}
