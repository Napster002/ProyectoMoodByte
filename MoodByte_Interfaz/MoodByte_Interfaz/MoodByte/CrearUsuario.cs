using Modelo;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace MoodByte
{
    public partial class CrearUsuario : Form
    {
        public CrearUsuario()
        {
            InitializeComponent();
            cbTipoUsuario.DataSource = Enum.GetValues(typeof(enumTipoUsuario));
            cbGenero.DataSource=Enum.GetValues(typeof (enumGenero));
        }
        private void buttonGuardar_Click(object sender, EventArgs e)
        {

        }

        private void CrearUsuario_Load(object sender, EventArgs e)
        {
          tbNombre.Focus();
          cbGenero.SelectedIndex = 0;
          cbTipoUsuario.SelectedIndex = 0;
        }

        private void buttonLimpiar_Click(object sender, EventArgs e)
        {
            tbNombre.Clear();
            tbApellidos.Clear();
            dtpFechanacimiento.Value = DateTime.Today;
            cbGenero.SelectedIndex = 0;
            cbTipoUsuario.SelectedIndex = 0;
            tbNombreUsuario.Clear();
            tbContraseña.Clear();
            tbRepitecontraseña.Clear();
            tbNombre.Focus();
        }
    }
}
