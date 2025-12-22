using Controles;

namespace Controles
{
    public partial class Menu : UserControl
    {
        public event EventHandler AbrirUsuarios;
        public event EventHandler AbrirArticulos;
        public event EventHandler AbrirEjercicios;
        public event EventHandler AbrirFrases;
        public event EventHandler AbrirMusica;
        public event EventHandler AbrirLogin;
        public Menu()
        {
            InitializeComponent();
        }

        private void usuarios_Click(object sender, EventArgs e)
        {
            AbrirUsuarios.Invoke(this, new EventArgs());
        }
        private void articulos_Click(object sender, EventArgs e)
        {
            AbrirArticulos.Invoke(this, new EventArgs());
        }
        private void ejercicios_Click(object sender, EventArgs e)
        {
            AbrirEjercicios.Invoke(this, new EventArgs());
        }
        private void frases_Click(object sender, EventArgs e)
        {
            AbrirFrases.Invoke(this, new EventArgs());
        }
        private void musica_Click(object sender, EventArgs e)
        {
            //AbrirMusica.Invoke(this, new EventArgs());
        }
        private void cerrarSesion_Click(object sender, EventArgs e) { 

            AbrirLogin.Invoke(this, new EventArgs());

        }
    }
}
