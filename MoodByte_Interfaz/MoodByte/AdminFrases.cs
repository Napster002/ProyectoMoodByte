using Conexiones;
using Modelo;
using ModeloDTO;
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
    public partial class AdminFrases : Form
    {

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

        private void btnInsertar_Click(object sender, EventArgs e)
        {
            CrearFrase fraseForm = new CrearFrase();
            fraseForm.Show();
        }

        private async void AdminFrases_Load(object sender, EventArgs e)
        {
            await CargarGrid();
            await CargarEstados();
        }

        private async Task CargarGrid()
        {
            var frases = await ConexionGenerica.CLIENTE.GetFromJsonAsync<List<FraseDTO>>(ConexionTabla.TablaFrase);
            if (frases != null)
            {
                dgvFrases.DataSource = frases;
                dgvFrases.AutoGenerateColumns = true;
                dgvFrases.SelectionMode = DataGridViewSelectionMode.FullRowSelect;

            }
            else
            {
                MessageBox.Show("No se pudieron cargar las frases.");
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

                cmbEstados.DataSource = null;
                cmbEstados.DataSource = estados;
                cmbEstados.DisplayMember = "nombre";
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al cargar los estados: " + ex.Message);
            }
        }

        private async void cmbEstados_SelectedIndexChanged(object sender, EventArgs e)
        {
            List<FraseDTO> frases = await ConexionGenerica.CLIENTE.GetFromJsonAsync<List<FraseDTO>>(ConexionTabla.TablaFrase);
            List<FraseDTO> frasesSeleccionadas = new List<FraseDTO>();
            EstadoDTO estadoSeleccionado = cmbEstados.SelectedItem as EstadoDTO;
            switch (estadoSeleccionado.nombre.ToLower())
            {
                case "muy bien":
                    foreach (var frase in frases)
                    {
                        if (frase.puntuacion == 5)
                        {
                            frasesSeleccionadas.Add(frase);
                        }
                    }
                    dgvFrases.DataSource = null;
                    dgvFrases.DataSource = frasesSeleccionadas;
                    dgvFrases.AutoGenerateColumns = true;
                    dgvFrases.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
                    break;
                case "bien":
                    foreach (var frase in frases)
                    {
                        if (frase.puntuacion == 4)
                        {
                            frasesSeleccionadas.Add(frase);
                        }
                    }
                    dgvFrases.DataSource = null;
                    dgvFrases.DataSource = frasesSeleccionadas;
                    dgvFrases.AutoGenerateColumns = true;
                    dgvFrases.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
                    break;
                case "regular":
                    foreach (var frase in frases)
                    {
                        if (frase.puntuacion == 3)
                        {
                            frasesSeleccionadas.Add(frase);
                        }
                    }
                    dgvFrases.DataSource = null;
                    dgvFrases.DataSource = frasesSeleccionadas;
                    dgvFrases.AutoGenerateColumns = true;
                    dgvFrases.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
                    break;
                case "un poco mal":
                    foreach (var frase in frases)
                    {
                        if (frase.puntuacion == 2)
                        {
                            frasesSeleccionadas.Add(frase);
                        }
                    }
                    dgvFrases.DataSource = null;
                    dgvFrases.DataSource = frasesSeleccionadas;
                    dgvFrases.AutoGenerateColumns = true;
                    dgvFrases.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
                    break;
                case "triste":
                    foreach (var frase in frases)
                    {
                        if (frase.puntuacion == 1)
                        {
                            frasesSeleccionadas.Add(frase);
                        }
                    }
                    dgvFrases.DataSource = null;
                    dgvFrases.DataSource = frasesSeleccionadas;
                    dgvFrases.AutoGenerateColumns = true;
                    dgvFrases.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
                    break;

            }
        }

        private void btnEditar_Click(object sender, EventArgs e)
        {
            if (dgvFrases.SelectedRows.Count > 0)
            {
                FraseDTO fraseSeleccionada = dgvFrases.SelectedRows[0].DataBoundItem as FraseDTO;
                CrearFrase editFrase = new CrearFrase(fraseSeleccionada);
                editFrase.Show();
            }
            else
            {
                MessageBox.Show("Seleccione una frase para editar.");
            }
        }

        private async void btnBorrar_Click(object sender, EventArgs e)
        {
            if (dgvFrases.SelectedRows.Count > 0)
            {
                FraseDTO fraseEliminar = dgvFrases.SelectedRows[0].DataBoundItem as FraseDTO;

                var response= await ConexionGenerica.CLIENTE.DeleteAsync($"{ConexionTabla.TablaFrase}/{fraseEliminar.id}");
                if (response.IsSuccessStatusCode)
                {
                    MessageBox.Show("Frase borrada");
                    await CargarGrid();
                }
                else
                {
                    MessageBox.Show("Error al borrar frase","ERROR");
                }
            }
        }

        ///-----------------------------------
    }
}
