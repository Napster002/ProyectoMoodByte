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
        private Articulo articulo;
        public CrearArticulo(Articulo _articulo)
        {
            InitializeComponent();
            this.articulo = _articulo;
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
            articulo.enlace = txtEnlace.Text;
            articulo.imagen = txtImagen.Text;
            articulo.subtitulo = txtSubtitulo.Text;
            articulo.titulo = txtTitulo.Text;

            await InsertarArticulo(articulo);
            articulo = null;
            this.Close();
        }
        // No funciona el insertar Articulo comprobar codigo
        public async Task InsertarArticulo(Articulo articulo)
        {
             // Configurar la serialización para enums como strings
            var options = new JsonSerializerOptions
              {
               Converters = { new JsonStringEnumConverter() },
            PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
             PropertyNameCaseInsensitive = true
            };

            try{
                if (articulo.id==0) {
                    var json = JsonSerializer.Serialize(articulo, options);
                    var content = new StringContent(json, Encoding.UTF8, "application/json");
                    var response = await _httpClient.PostAsync(ConexionTabla.TablaArticulo, content);

                    if (response.IsSuccessStatusCode)
                    {
                        var articuloJson = await response.Content.ReadAsStringAsync();
                        var articuloCreado = JsonSerializer.Deserialize<Articulo>(articuloJson);
                        MessageBox.Show("Articulo creado: " + articuloCreado.titulo);
                        AdminArticulos adminArticulos = new AdminArticulos();
                        adminArticulos.Visible = true;
                        this.Close();
                    }
                    else
                    {
                        MessageBox.Show("Error al crear articulo: " + response.StatusCode);
                    }
                }
                else {
                    var json = JsonSerializer.Serialize(articulo, options);
                    var content = new StringContent(json, Encoding.UTF8, "application/json");
                    
                    var response = await _httpClient.PutAsync($"{ ConexionTabla.TablaArticulo}/{ articulo.id}",
                    content);
                    if (response.IsSuccessStatusCode)
                    {
                        var articuloJson = await response.Content.ReadAsStringAsync();
                        var articuloCreado = JsonSerializer.Deserialize<Articulo>(articuloJson);
                        MessageBox.Show("Articulo actualizado: " + articuloCreado.titulo);
                    }
                    else
                    {
                        MessageBox.Show("Error al actualizar articulo: " + response.StatusCode);
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error de conexión: " + ex.Message);
            }
        }

        private void CrearArticulo_Load(object sender, EventArgs e)
        {
            if(articulo.id != 0)
            {
                txtTitulo.Text = articulo.titulo;
                txtSubtitulo.Text = articulo.subtitulo;
                txtImagen.Text = articulo.imagen;
                txtEnlace.Text = articulo.enlace;
                btnGuardar.Text = "Actualizar";
            }
            else
            {
                btnGuardar.Text = "Crear";
            }
        }
    }
}
