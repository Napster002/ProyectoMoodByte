using Conexiones;
using Modelo;
using ModeloDTO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
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
    public partial class CrearEjercicio : Form
    {
        private readonly HttpClient Cliente = ConexionGenerica.CLIENTE;
        private List<EstadoDTO> listaEstados;
        private EjercicioDTO ejercicio;
        private Boolean esNuevo;
        public  CrearEjercicio()
        {
            esNuevo = true;
            InitializeComponent();
            
        }
        public CrearEjercicio(EjercicioDTO ejercicio)
        {
            esNuevo = false;
            InitializeComponent();
            this.ejercicio = ejercicio;


        }

        private async void CrearEjercicio_Load(object sender, EventArgs e)
        {
            await CargarEstados();
            if (!esNuevo)
            {
                txtTitulo.Text = ejercicio.titulo;
                txtDescripcion.Text = ejercicio.descripcion;
                txtUrl.Text = ejercicio.recursoUrl;
                dtpDuracion.Value = DateTime.Parse(ejercicio.duracion.ToString());
                btnGuardar.Text = "Actualizar";
            }
        }
        public async Task CargarEstados()
        {
            try
            {
                var estados = await ConexionGenerica.CLIENTE
                    .GetFromJsonAsync<List<EstadoDTO>>(ConexionTabla.TablaEstado);

                if (estados == null)
                {
                    MessageBox.Show("No se recibieron estados.");
                    return;
                }

                listaEstados = estados;

                cmbEstado.DataSource = null;
                cmbEstado.DataSource = listaEstados;
                cmbEstado.DisplayMember = "nombre";
                if (!esNuevo)
                {
                        switch (ejercicio.idEstado)
                        {
                            case 1: cmbEstado.SelectedItem = listaEstados.FirstOrDefault(e => e.id==ejercicio.idEstado); break;
                            case 2: cmbEstado.SelectedItem = listaEstados.FirstOrDefault(e => e.id == ejercicio.idEstado); break;
                            case 3: cmbEstado.SelectedItem = listaEstados.FirstOrDefault(e => e.id == ejercicio.idEstado); break;
                            case 4: cmbEstado.SelectedItem = listaEstados.FirstOrDefault(e => e.id == ejercicio.idEstado); break;
                            case 5: cmbEstado.SelectedItem = listaEstados.FirstOrDefault(e => e.id == ejercicio.idEstado); break;
                        }
                        cmbEstado.Enabled = false;
                    }
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
            Ejercicio ejercicioGuardar = new Ejercicio();
            if (!esNuevo)
            {
                EstadoDTO estado = (EstadoDTO)cmbEstado.SelectedItem;
                ejercicioGuardar = new Ejercicio
                {
                    id = ejercicio.id,
                    titulo = txtTitulo.Text,
                    descripcion = txtDescripcion.Text,
                    duracion = TimeOnly.FromDateTime(dtpDuracion.Value).ToString("HH:mm:ss"),
                    recursoUrl = txtUrl.Text,
                    estado = new Estado
                    {
                        id=estado.id,
                        nombre=estado.nombre }
                }; 
            }
            else
            {
                EstadoDTO estado = (EstadoDTO)cmbEstado.SelectedItem;
                ejercicioGuardar = new Ejercicio
                {
                    titulo = txtTitulo.Text,
                    descripcion = txtDescripcion.Text,
                    duracion = TimeOnly.FromDateTime(dtpDuracion.Value).ToString("HH:mm:ss"),
                    recursoUrl = txtUrl.Text,
                    estado = new Estado
                    {
                        id=estado.id,
                        nombre=estado.nombre
                    }
                };
            }

            await InsertaEjercicio(ejercicioGuardar);
        }
        public async Task InsertaEjercicio(Ejercicio ejercicio)
        {
            try
            {
                if (!esNuevo)
                { 
                    var respuesta= await Cliente.PutAsJsonAsync<Ejercicio>($"{ConexionTabla.TablaEjercicio}/{ejercicio.id}",ejercicio);
                    if (respuesta.IsSuccessStatusCode)
                    {
                        MessageBox.Show("Se actualizó el Ejercicio");
                    }
                    else
                    {
                        MessageBox.Show("Fallo al actualizar "+respuesta.ReasonPhrase);
                    }
                }
                else
                {
                    var respuesta = await Cliente.PostAsJsonAsync<Ejercicio>(ConexionTabla.TablaEjercicio, ejercicio);
                    if(respuesta.IsSuccessStatusCode)
                    {
                        MessageBox.Show("Ejercicio creado");
                    }
                    else
                    {
                        MessageBox.Show("Fallo al crear ejercicio "+respuesta.ReasonPhrase);
                    }
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
