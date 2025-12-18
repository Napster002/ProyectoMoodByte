using Modelo;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net.Http.Json;
using System.Text;
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
        public async void CargarGrid()
        {
            try
            {
                var usuarios = await _httpClient.GetFromJsonAsync<List<Usuario>>("http://localhost:8080/api/usuarios");
                dgvUsuarios.DataSource = usuarios;
                dgvUsuarios.Columns["Password"].Visible = false;
                dgvUsuarios.Columns["Id"].Visible = false;
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al cargar los usuarios: " + ex.Message);
            }
        }

        private void AdminUsuarios_Load(object sender, EventArgs e)
        {
            CargarGrid();
        }
    }
}
