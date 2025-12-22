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
        ///-----------------------------------
        public async Task CargarGrid()
        {
            try
            {
                // Obtener el JSON como string

                var json = await _httpClient.GetStringAsync("http://192.168.56.1:5500/api/usuario");


                // Configurar el deserializador para enums como strings
                var options = new JsonSerializerOptions
                {
                    Converters = { new JsonStringEnumConverter(JsonNamingPolicy.CamelCase) },
                    PropertyNameCaseInsensitive = true // útil si el JSON tiene mayúsculas distintas
                };

                // Deserializar a lista de usuarios
                var usuarios = JsonSerializer.Deserialize<List<Usuario>>(json, options);

                // Asignar al DataGridView
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
            CrearUsuario CU = new CrearUsuario();
            CU.Visible = true;
            this.Visible = false;
        }
    }
}
