using Conexiones;
using Modelo;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Linq.Expressions;
using System.Net.Http.Json;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MoodByte
{
    public partial class AdminArticulos : Form
    {
        private readonly HttpClient _httpClient = new HttpClient();
        public AdminArticulos()
        {
            InitializeComponent();
            navMenu.AbrirUsuarios += menu_abrirUsuarios;
            navMenu.AbrirArticulos += menu_abrirArticulos;
            navMenu.AbrirEjercicios += menu_abrirEjercicios;
            navMenu.AbrirFrases += menu_abrirFrases;
        }
        //Metodos menu de navegacion-------------------------
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

        ///---------------------------------------
        public async Task CargarGrid()
        {
            List<Articulo> articulos = await _httpClient.GetFromJsonAsync<List<Articulo>>(ConexionTabla.TablaArticulo);
            listViewArticulos.BeginUpdate();
            listViewArticulos.Items.Clear();
            foreach (var articulo in articulos)
            {
                var item = new ListViewItem(articulo.titulo);
                item.Tag = articulo;
                listViewArticulos.Items.Add(item);
            }
            listViewArticulos.EndUpdate();
        }

        private async void AdminArticulos_Load(object sender, EventArgs e)
        {
            await CargarGrid();
        }

        private async void listViewArticulos_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listViewArticulos.SelectedItems.Count == 0)
            {
                pictureBoxArticulo.Image = null;
                lblTitulo.Text = "";
            }
            else
            {

                var articulo = (Articulo)listViewArticulos.SelectedItems[0].Tag;
                lblTitulo.Text = articulo.titulo;
                await CargarImagen(articulo.imagen);
            }
        }

        private async Task CargarImagen(string urlImagen)
        {
            try
            {
                var bytes = await _httpClient.GetByteArrayAsync(urlImagen);
                using var ms = new MemoryStream(bytes);
                using var ImagenTemporal = Image.FromStream(ms);
                pictureBoxArticulo.Image?.Dispose();
                pictureBoxArticulo.Image = new Bitmap(ImagenTemporal);
                pictureBoxArticulo.SizeMode = PictureBoxSizeMode.Zoom;
            }
            catch
            {
                pictureBoxArticulo.Image = null;
            }
        }

        private async void btnBorrarArticulo_Click(object sender, EventArgs e)
        {
            if (listViewArticulos.SelectedItems.Count > 0)
            {
                var articuloSeleccionado = (Articulo)listViewArticulos.SelectedItems[0].Tag;
                var confirmResult = MessageBox.Show($"¿Estás seguro de que deseas borrar el artículo '{articuloSeleccionado.titulo}'?",
                                     "Confirmar Borrado",
                                     MessageBoxButtons.YesNo);
                if (confirmResult == DialogResult.Yes)
                {
                    await _httpClient.DeleteAsync($"{ ConexionTabla.TablaArticulo}/{ articuloSeleccionado.id}");
                    await CargarGrid();
                    Limpiar();
                }
            }
            else
            {
                MessageBox.Show("Por favor, selecciona un artículo para borrar.");
            }
        }

        private async void btnNuevoArticulo_Click(object sender, EventArgs e)
        {
            CrearArticulo formCreacion = new CrearArticulo(new Articulo());
            formCreacion.ArticuloModificado += async (s, ev) =>
            {
                await CargarGrid();
                Limpiar();
            };
            formCreacion.ShowDialog();
        }

        private async void btnEditarArticulo_Click(object sender, EventArgs e)
        {
            if (listViewArticulos.SelectedItems.Count > 0)
            {
                var articuloSeleccionado=(Articulo)listViewArticulos.SelectedItems[0].Tag;
                CrearArticulo formEdicion = new CrearArticulo(articuloSeleccionado);
                formEdicion.ArticuloModificado += async (s, ev) =>
                {
                    await CargarGrid();
                    Limpiar();
                };
                formEdicion.ShowDialog();
            }

            else
            {
                MessageBox.Show("Por favor, selecciona un artículo para editar.","Atencion",MessageBoxButtons.OK,MessageBoxIcon.Exclamation);
            }
        }
        public void Limpiar()
        {
            listViewArticulos.SelectedItems.Clear();
            listViewArticulos.FocusedItem = null;
            listViewArticulos.HideSelection = true;
            if (pictureBoxArticulo.Image != null)
            {
                pictureBoxArticulo.Image.Dispose();
                pictureBoxArticulo.Image = null;
            }
            lblTitulo.Text = "";
        }
    }
}
