using Conexiones;
using Modelo;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MoodByte
{
    public partial class CrearFrase : Form
    {
        private readonly HttpClient _httpClient = new HttpClient();
        public List<Estado> listaEstados;
        public CrearFrase()
        {
            InitializeComponent();
            CargarEstados();
        }
        public async void CargarEstados()
        {
            try
            {
                var json = await _httpClient.GetStringAsync(ConexionTabla.TablaEstado);
                listaEstados = JsonSerializer.Deserialize<List<Estado>>(json);

                cmbEstado.Items.Clear();
                foreach (var estado in listaEstados)
                {
                    cmbEstado.Items.Add(estado.nombre);
                }

                if (cmbEstado.Items.Count > 0)
                    cmbEstado.SelectedIndex = 0;
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al cargar los estados: " + ex.Message);
            }
        }
        // Falta creacion al no saber el que necesita la clase Frase(falta Estado) y asignar que vuelva a AdminFrases
        private void btnGuardar_Click(object sender, EventArgs e)
        {
          // InsertarFrase(frase);
        }
        public async void InsertaFrase(Frase frase)
        {
            var options = new JsonSerializerOptions
            {
                Converters = { new JsonStringEnumConverter(JsonNamingPolicy.CamelCase) },
                PropertyNameCaseInsensitive = true,
                ReferenceHandler = ReferenceHandler.IgnoreCycles
            };

            var json = JsonSerializer.Serialize(frase, options);
            MessageBox.Show(json, "JSON a enviar", MessageBoxButtons.OK, MessageBoxIcon.Information);

            try
            {
                var content = new StringContent(json, Encoding.UTF8, "application/json");
                var response = await _httpClient.PostAsync(ConexionTabla.TablaFrase, content);

                if (response.IsSuccessStatusCode)
                {
                    var fraseJson = await response.Content.ReadAsStringAsync();
                    var fraseCreada = JsonSerializer.Deserialize<Frase>(fraseJson);
                    MessageBox.Show("Se agregó correctamente la frase", "Correcto", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                else
                {
                    MessageBox.Show("Error al crear frase: " + response.StatusCode);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error de conexión: " + ex.Message);
            }
        }

        private void buttonLimpiar_Click(object sender, EventArgs e)
        {
            if (cmbEstado.Items.Count > 0)
                cmbEstado.SelectedIndex = 0;
            txtFrase.Clear();
            txtFrase.Focus();
        }
    }
}
