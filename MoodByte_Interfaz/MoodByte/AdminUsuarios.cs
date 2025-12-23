using Conexiones;
using Modelo;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net.Http.Json;
using System.Text;
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MoodByte
{
    public partial class AdminUsuarios : Form
    {
        private readonly HttpClient _httpClient = new HttpClient();
        public AdminUsuarios()
        {
            InitializeComponent();
            navMenu.AbrirUsuarios += menu_abrirUsuarios;
            navMenu.AbrirArticulos += menu_abrirArticulos;
            navMenu.AbrirEjercicios += menu_abrirEjercicios;
            navMenu.AbrirFrases += menu_abrirFrases;
            navMenu.AbrirLogin += menu_abrirLogin;
        }
        //Metodos menu de navegacion-----------------------
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
        private void menu_abrirLogin(object sender, EventArgs e)
        {

            Program.log.Visible = true;
            this.Close();

        }
        ///-----------------------------------
        public async Task CargarGrid()
        {
            try
            {
                // Obtener el JSON como string

                var json = await _httpClient.GetStringAsync(ConexionTabla.TablaUsuario);


                // Configurar el deserializador para enums como strings
                var options = new JsonSerializerOptions
                {
                    Converters = { new JsonStringEnumConverter(JsonNamingPolicy.CamelCase) },
                    PropertyNameCaseInsensitive = true // útil si el JSON tiene mayúsculas distintas
                };

                // Deserializar a lista de usuarios
                var usuarios = JsonSerializer.Deserialize<List<Usuario>>(json, options);

                // Asignar al DataGridView
                dgvUsuarios.DataSource = null;
                dgvUsuarios.DataSource = usuarios;
                dgvUsuarios.Columns["Password"].Visible = false;
                dgvUsuarios.Columns["Id"].Visible = false;
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

        private void btnCrearUsuario_Click(object sender, EventArgs e)
        {
            CrearUsuario CU = new CrearUsuario(new Usuario());
            CU.UsuarioCreado_Editado += async (s, ev) => await CargarGrid();
            CU.ShowDialog();
        }

        private void btnEditarusuario_Click(object sender, EventArgs e)
        {
            if (dgvUsuarios.SelectedRows.Count>0)
            {
                var usuarioSeleccionado = dgvUsuarios.SelectedRows[0].DataBoundItem as Usuario;
                CrearUsuario crearUsuario = new CrearUsuario(usuarioSeleccionado);
                crearUsuario.UsuarioCreado_Editado += async (s, ev) => await CargarGrid();
                crearUsuario.ShowDialog();
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
                var usuarioSeleccionado = dgvUsuarios.CurrentRow.DataBoundItem as Usuario;
                if (usuarioSeleccionado != null)
                {
                    var resultado = MessageBox.Show($"¿Estás seguro de que deseas eliminar al usuario {usuarioSeleccionado.NombreUsuario}?", "Confirmar eliminación", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);
                    if (resultado == DialogResult.Yes)
                    {
                        await BorrarUsuario(usuarioSeleccionado);
                       await CargarGrid();
                    }
                }
            }
        }

        public async Task BorrarUsuario(Usuario usuario)
        {
            try
            {
                var respuesta = await _httpClient.DeleteAsync($"{ConexionTabla.TablaUsuario}/{usuario.Id}");
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
