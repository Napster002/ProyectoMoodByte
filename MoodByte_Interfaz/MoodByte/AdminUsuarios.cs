using Conexiones;
using ModeloDTO;
using System.Net.Http.Json;

namespace MoodByte
{
    public partial class AdminUsuarios : Form
    {
        private readonly HttpClient Cliente= ConexionGenerica.CLIENTE;
        public AdminUsuarios()
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

        ///-----------------------------------
        public async Task CargarGrid()
        {
            try
            {
                var usuarios = await Cliente.GetFromJsonAsync<List<UsuarioDTO>>(ConexionTabla.TablaUsuario);
                if(usuarios == null)
                {
                    MessageBox.Show("No se recibieron usuarios.");
                    return;
                }

                dgvUsuarios.DataSource = null;
                dgvUsuarios.DataSource = usuarios;
                dgvUsuarios.Columns["Password"].Visible = false;
                dgvUsuarios.Columns["Id"].Visible = false;
                dgvUsuarios.SelectionMode=DataGridViewSelectionMode.FullRowSelect;
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al cargar los usuarios: " + ex.Message);
            }
        }

        private async void AdminUsuarios_LoadAsync(object sender, EventArgs e)
        {
            await CargarGrid();
        }

        private async void btnCrearUsuario_Click(object sender, EventArgs e)
        {
            CrearUsuario CU = new CrearUsuario(false);
            CU.UsuarioCreado_Editado += async (s, ev) => await CargarGrid();
            CU.ShowDialog();
            if (CU.DialogResult == DialogResult.OK)
            {
                await CargarGrid();
            }
        }

        private async void btnEditarusuario_Click(object sender, EventArgs e)
        {
            if (dgvUsuarios.SelectedRows.Count>0)
            {
                var usuarioSeleccionado = dgvUsuarios.SelectedRows[0].DataBoundItem as UsuarioDTO;
                CrearUsuario crearUsuario = new CrearUsuario(usuarioSeleccionado,false);
                crearUsuario.UsuarioCreado_Editado += async (s, ev) => await CargarGrid();
                crearUsuario.ShowDialog();
                if (crearUsuario.DialogResult == DialogResult.OK)
                {
                    await CargarGrid();
                }
            }
            else
            {
                  MessageBox.Show("Por favor, selecciona un usuario para editar.");
            }
        }

        private async void btnBorrarUsuario_Click(object sender, EventArgs e)
        {
            if (dgvUsuarios.CurrentRow != null)
            {
                var usuarioSeleccionado = dgvUsuarios.CurrentRow.DataBoundItem as UsuarioDTO;
                if (usuarioSeleccionado != null)
                {
                    var resultado = MessageBox.Show($"¿Estás seguro de que deseas eliminar al usuario {usuarioSeleccionado.nombreUsuario}?", "Confirmar eliminación", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);
                    if (resultado == DialogResult.Yes)
                    {
                        await BorrarUsuario(usuarioSeleccionado);
                       await CargarGrid();
                    }
                }
            }
        }

        public async Task BorrarUsuario(UsuarioDTO usuario)
        {
            try
            {
                var respuesta = await Cliente.DeleteAsync($"{ConexionTabla.TablaUsuario}/{usuario.id}");
                if (respuesta.IsSuccessStatusCode)
                {
                    MessageBox.Show("Usuario borrado correctamente.");
                    await CargarGrid();
                }
                else
                {
                    MessageBox.Show("Error al borrar el usuario: " + respuesta.ReasonPhrase);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR" + ex.Message);
            }
        }
    }
}
