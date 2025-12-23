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
        private Boolean _update = false;
        private Frase _frase = new Frase();
        public CrearFrase(Frase frase)
        {
            InitializeComponent();
            if (frase.id != 0) { 
                cmbEstado.SelectedIndex = frase.puntuacion-1;
                txtFrase.Text = frase.frase;
                _update = true;
                _frase = frase;
            }
        }
        // Falta creacion al no saber el que necesita la clase Frase(falta Estado) y asignar que vuelva a AdminFrases
        private void btnGuardar_Click(object sender, EventArgs e)
        {
            // InsertarFrase(frase);
            if (Validaciones.validaFrase(txtFrase.Text,out var err))
            {
                epFrase.SetError(txtFrase, err);
                MessageBox.Show("Mal Insertado: Frase", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                var puntuaje=0;
                epFrase.SetError(txtFrase, "");
                switch (cmbEstado.SelectedIndex)
                {
                     case 0: puntuaje = 1;break;
                     case 1: puntuaje = 2;break;
                     case 2: puntuaje = 3;break;
                     case 3: puntuaje = 4;break;
                     case 4: puntuaje = 5;break;
                };
                _frase.frase = txtFrase.Text;
                _frase.puntuacion = puntuaje;
                InsertaFrase(_frase,_update);
            }
        }
        public async void InsertaFrase(Frase frase,Boolean update)
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
                HttpResponseMessage response;
                if (update)
                {
                    response = await _httpClient.PutAsync($"{ConexionTabla.TablaFrase}/{frase.id}", content);
                }
                else
                {
                    response = await _httpClient.PostAsync(ConexionTabla.TablaFrase, content);
                }
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
