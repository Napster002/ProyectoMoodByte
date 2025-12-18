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
            cbTipoUsuario.DataSource = Enum.GetValues(typeof(TipoUsuario));
            cbGenero.DataSource=Enum.GetValues(typeof (Genero));
            dtpFechaRegistro.Enabled = false;
        }
        private void buttonGuardar_Click(object sender, EventArgs e)
        {
            var errores = new List<string>();
            if (!Validaciones.validaNombre(tbNombre.Text, out var err))
            {
                errores.Add(err);
                epUsuario.SetError(tbNombre, err);
            }
            else
            {
                epUsuario.SetError(tbNombre, "");
            }
            if (!Validaciones.validaApellido(tbApellidos.Text, out var err1))
            {
                errores.Add(err1);
                epUsuario.SetError(tbApellidos, err1);
            }
            else
            {
                epUsuario.SetError(tbApellidos, "");
            }
            if (!Validaciones.validaFechaNacimiento(dtpFechanacimiento.Value, out var err2))
            {
                errores.Add(err2);
                epUsuario.SetError(dtpFechanacimiento, err2);
            }
            else
            {
                epUsuario.SetError(dtpFechanacimiento, "");
            }
            if (!Validaciones.validaNombre(tbNombreUsuario.Text, out var err3))
            {
                errores.Add(err3);
                epUsuario.SetError(tbNombreUsuario, err3);
            }
            else
            {
                epUsuario.SetError(tbNombreUsuario, "");
            }
            if (!Validaciones.validaContraseña(tbContraseña.Text, out var err4))
            {
                errores.Add(err4);
                epUsuario.SetError(tbContraseña, err4);
            }
            else
            {
                epUsuario.SetError(tbContraseña, "");
            }
            if (!Validaciones.validaContraseña(tbRepitecontraseña.Text, out var err5))
            {
                errores.Add(err5);
                epUsuario.SetError(tbRepitecontraseña, err5);
            }
            else
            {
                epUsuario.SetError(tbRepitecontraseña, "");
            }
            if (!tbContraseña.Text.Equals(tbRepitecontraseña.Text))
            {
                MessageBox.Show("Las contraseñas no coinciden", "Errores de validación", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            if (errores.Count > 0)
            {
                var sb = new StringBuilder();
                sb.AppendLine("Se han encontrado errores en el formulario:");
                foreach (var er in errores)
                    sb.AppendLine($"• {er}");
                MessageBox.Show(sb.ToString(), "Errores de validación", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            int edad = DateTime.Today.Year - dtpFechanacimiento.Value.Year;
            var usuario = new Usuario
            {
                NombreCompleto =tbNombre.Text+tbApellidos.Text,
                NombreUsuario=tbNombreUsuario.Text,
                Edad=edad,
                Password=tbContraseña.Text,
                FechaRegistro=dtpFechaRegistro.Value,
                FechaNacimiento=dtpFechanacimiento.Value,
                Genero= (Genero)cbGenero.SelectedItem,
                TipoUsuario=(TipoUsuario)cbTipoUsuario.SelectedItem
            };
            MessageBox.Show("Se agrego correctamnete", "Correcto", MessageBoxButtons.OK, MessageBoxIcon.Information);
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
