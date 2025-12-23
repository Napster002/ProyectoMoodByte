using Conexiones;
using Modelo;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MoodByte
{
    public partial class AdminFrases : Form
    {
        private readonly HttpClient _httpClient = new HttpClient();
        public AdminFrases()
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
        ///-----------------------------------///
        public async Task CargarGrid()
        {
            try
            {
                // Obtener el JSON como string

                var json = await _httpClient.GetStringAsync(ConexionTabla.TablaFrase);


                // Configurar el deserializador para enums como strings
                var options = new JsonSerializerOptions
                {
                    Converters = { new JsonStringEnumConverter(JsonNamingPolicy.CamelCase) },
                    PropertyNameCaseInsensitive = true // útil si el JSON tiene mayúsculas distintas
                };

                // Deserializar a lista de frases
                var frases = JsonSerializer.Deserialize<List<Frase>>(json, options);

                // Asignar al DataGridView
                dgvFrases.DataSource = frases;
                dgvFrases.Columns["id"].Visible = false;
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al cargar las frases: " + ex.Message);
            }
        }
        private async void AdminFrases_LoadAsync(object sender, EventArgs e)
        {
            await CargarGrid();
        }
        private async void btnEditar_Click(object sender, EventArgs e)
        {
            Frase frase = new Frase();
            frase = dgvFrases.CurrentRow?.DataBoundItem as Frase;
            if (frase != null)
            {
                CrearFrase crearFrase = new CrearFrase(frase);
                crearFrase.Visible = true;
                //this.Close();
            }            
        }

        private async void btnInsertar_Click(object sender, EventArgs e)
        {
            CrearFrase crearFrase = new CrearFrase(new Frase());
            crearFrase.Visible = true;
            //this.Close();
        }
    }
}
