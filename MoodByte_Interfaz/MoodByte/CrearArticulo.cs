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
    public partial class CrearArticulo : Form
    {
        private readonly HttpClient _httpClient = new HttpClient();
        public CrearArticulo()
        {
            InitializeComponent();
        }

        private void buttonLimpiar_Click(object sender, EventArgs e)
        {
            txtTitulo.Clear();
            txtSubtitulo.Clear();
            txtImagen.Clear();
            txtEnlace.Clear();
            txtTitulo.Focus();
        }
        // Si guarda que vuelva a AdminArticulo
        private async void btnGuardar_Click(object sender, EventArgs e)
        {
            var errores = new List<string>();
            if (!Validaciones.validaTitulo(txtTitulo.Text, out var err))
            {
                errores.Add(err);
                epArticulo.SetError(txtTitulo, err);
            }
            else
            {
                epArticulo.SetError(txtTitulo, "");
            }
            if (!Validaciones.validaSubtitulo(txtSubtitulo.Text, out var err2))
            {
                errores.Add(err2);
                epArticulo.SetError(txtSubtitulo, err2);
            }
            else
            {
                epArticulo.SetError(txtSubtitulo, "");
            }
            if (!Validaciones.validaImagen(txtImagen.Text, out var err3))
            {
                errores.Add(err3);
                epArticulo.SetError(txtImagen, err3);
            }
            else
            {
                epArticulo.SetError(txtImagen, "");
            }
            if (string.IsNullOrWhiteSpace(txtEnlace.Text))
            {
                errores.Add("Mal introducido: Enlace");
                epArticulo.SetError(txtEnlace, "Mal introducido: Enlace");
            }
            else
            {
                epArticulo.SetError(txtEnlace, "");
            }
            if (errores.Count > 0)
            {
                var sb = new StringBuilder();
                sb.AppendLine("Se han encontrado errores en el articulo:");
                foreach (var er in errores)
                    sb.AppendLine($"• {er}");
                MessageBox.Show(sb.ToString(), "Errores de validación", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            Articulo articulo = new Articulo
            {
                titulo = txtTitulo.Text,
                subtitulo = txtSubtitulo.Text,
                imagen = txtImagen.Text,
                enlace = txtEnlace.Text
            };
           await InsertarArticulo(articulo);

        }
        // No funciona el insertar Articulo comprobar codigo
        public async Task InsertarArticulo(Articulo articulo)
        {
            var options = new JsonSerializerOptions
            {
                Converters = { new JsonStringEnumConverter() },
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
                PropertyNameCaseInsensitive = true
            };
            var json = JsonSerializer.Serialize(articulo,options);
            var content = new StringContent(json, Encoding.UTF8, "application/json");
            try
            {
                var response = await _httpClient.PostAsync(ConexionTabla.TablaArticulo, content);

                if (response.IsSuccessStatusCode)
                {
                    var articuloJson = await response.Content.ReadAsStringAsync();
                    var articuloCreado = JsonSerializer.Deserialize<Articulo>(articuloJson);
                    MessageBox.Show("Articulo creado: " + articuloCreado.titulo);
                }
                else
                {
                    MessageBox.Show("Error al crear articulo: " + response.StatusCode);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error de conexión: " + ex.Message);
            }
        }

        private void CrearArticulo_Load(object sender, EventArgs e)
        {

        }
    }
}
