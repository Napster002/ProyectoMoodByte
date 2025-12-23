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
    public partial class CrearEjercicio : Form
    {
        private readonly HttpClient _httpClient = new HttpClient();
        public List<Estado> listaEstados;
        public  CrearEjercicio()
        {
            InitializeComponent();
            
        }

        private async void CrearEjercicio_Load(object sender, EventArgs e)
        {
            await CargarEstados();
        }
        public async Task CargarEstados()
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
        // Falta asignar que vuelva a Admin Ejercicio
        private async void btnGuardar_Click(object sender, EventArgs e)
        {
            var errores = new List<string>();

            if (!Validaciones.validaTitulo(txtTitulo.Text, out var err))
            {
                errores.Add(err);
                epEjercicio.SetError(txtTitulo, err);
            }
            else
            {
                epEjercicio.SetError(txtTitulo, "");
            }

            if (errores.Count > 0)
            {
                var sb = new StringBuilder();
                sb.AppendLine("Se han encontrado errores en el ejercicio:");
                foreach (var er in errores)
                    sb.AppendLine($"• {er}");
                MessageBox.Show(sb.ToString(), "Errores de validación", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            // Obtener el Estado seleccionado correctamente
            string nombreSeleccionado = cmbEstado.SelectedItem?.ToString();
            Estado guardaEstado = listaEstados.FirstOrDefault(e => e.nombre == nombreSeleccionado);
            if (guardaEstado == null)
            {
                MessageBox.Show("Selecciona un estado válido", "Error", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            // Duración como TimeOnly
            TimeOnly duracion = TimeOnly.FromTimeSpan(dtpDuracion.Value.TimeOfDay);

            Ejercicio ejercicio = new Ejercicio
            {
                estado = guardaEstado,
                titulo = txtTitulo.Text,
                descripcion = txtDescripcion.Text,
                duracion = duracion
            };

            await InsertaEjercicio(ejercicio);
        }
        public async Task InsertaEjercicio(Ejercicio ejercicio)
        {
            // Configurar la serialización para enums como strings
           var options = new JsonSerializerOptions
           {
             Converters = { new JsonStringEnumConverter() },
             PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
             PropertyNameCaseInsensitive = true
          };
            var json = JsonSerializer.Serialize(ejercicio, options);
            MessageBox.Show(json, "JSON a enviar", MessageBoxButtons.OK, MessageBoxIcon.Information);

            try
            {
                var content = new StringContent(json, Encoding.UTF8, "application/json");
                var response = await _httpClient.PostAsync(ConexionTabla.TablaEjercicio, content);

                if (response.IsSuccessStatusCode)
                {
                    var ejercicioJson = await response.Content.ReadAsStringAsync();
                    var ejercicioCreado = JsonSerializer.Deserialize<Ejercicio>(ejercicioJson);
                    MessageBox.Show("Se agregó correctamente el ejercicio", "Correcto", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    AdminEjercicios adminEjercicios = new AdminEjercicios();
                    adminEjercicios.Visible = true;
                    this.Close();
                }
                else
                {
                    MessageBox.Show("Error al crear ejercicio: " + response.StatusCode);
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
            dtpDuracion.Value = DateTime.Parse("00:00:00");
            txtTitulo.Clear();
            txtDescripcion.Clear();
            txtTitulo.Focus();
        }
    }
}
