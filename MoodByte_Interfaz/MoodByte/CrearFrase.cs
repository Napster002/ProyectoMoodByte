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
        public async void InsertaFrase(Frase frase)
        {
            var options = new JsonSerializerOptions
            {
                Converters = { new JsonStringEnumConverter() },
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
                PropertyNameCaseInsensitive = true
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

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            if (Validaciones.validaFrase(txtFrase.Text, out var err))
            {
                epFrase.SetError(txtFrase, err);
                MessageBox.Show("Mal Insertado: Frase", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                epFrase.SetError(txtFrase, "");
                var puntuaje = 0;
                switch (cmbEstado.SelectedIndex)
                {
                    case 0: puntuaje = 1; break;
                    case 1: puntuaje = 2; break;
                    case 2: puntuaje = 3; break;
                    case 3: puntuaje = 4; break;
                    case 4: puntuaje = 5; break;
                }
                Frase frase = new Frase
                {
                    frase = txtFrase.Text,
                    puntuacion = puntuaje
                };
                InsertaFrase(frase);
            }
        }
    }
}
