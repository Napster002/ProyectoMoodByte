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
        }
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
    }
}
