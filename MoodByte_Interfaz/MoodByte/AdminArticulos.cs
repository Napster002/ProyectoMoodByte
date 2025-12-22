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
            List<Articulo> articulos = await _httpClient.GetFromJsonAsync<List<Articulo>>("http://192.168.56.1:5500/api/articulo");
            listViewArticulos.Items.Clear();
            foreach (var articulo in articulos)
            {
                var item = new ListViewItem(articulo.titulo);
                item.Tag = articulo;
                listViewArticulos.Items.Add(item);
            }
        }

        private async void AdminArticulos_Load(object sender, EventArgs e)
        {
            await CargarGrid();
        }

        private async void listViewArticulos_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listViewArticulos.SelectedItems.Count > 0)
            {
                var ArticuloSeleccionado = (Articulo)listViewArticulos.SelectedItems[0].Tag;
                await CargarImagen(ArticuloSeleccionado.imagen);
                lblTitulo.Text = ArticuloSeleccionado.titulo;
            }
            else
            {
                pictureBoxArticulo.Image = null;
            }
        }

        private async Task CargarImagen(string urlImagen)
        {
            try
            {
                var bytes = await _httpClient.GetByteArrayAsync(urlImagen);
                using var ms = new MemoryStream(bytes);
                pictureBoxArticulo.Image = Image.FromStream(ms);
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
                    await _httpClient.DeleteAsync($"http://192.168.56.1:5500/api/articulo/{articuloSeleccionado.id}");
                }
            }
            else
            {
                MessageBox.Show("Por favor, selecciona un artículo para borrar.");
            }
        }

        private void btnNuevoArticulo_Click(object sender, EventArgs e)
        {
            CrearArticulo fomrCreacion= new CrearArticulo(new Articulo());
            fomrCreacion.ShowDialog();
        }
    }
}
