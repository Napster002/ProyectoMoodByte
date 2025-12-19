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
                sb.AppendLine("Se han encontrado errores en el usuario:");
                foreach (var er in errores)
                    sb.AppendLine($"• {er}");
                MessageBox.Show(sb.ToString(), "Errores de validación", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            int edad = DateTime.Today.Year - dtpFechanacimiento.Value.Year;
            var usuario = new Usuario
            {
                NombreCompleto = tbNombre.Text + tbApellidos.Text,
                NombreUsuario = tbNombreUsuario.Text,
                Edad = edad,
                Nivel = 0,
                ExpAcumulada = 0,
                Password = tbContraseña.Text,
                FechaRegistro = dtpFechaRegistro.Value,
                FechaNacimiento = dtpFechanacimiento.Value,
                Genero = (Genero)cbGenero.SelectedItem,
                TipoUsuario = (TipoUsuario)cbTipoUsuario.SelectedItem
            };
            InsertarUsuario(usuario);
            MessageBox.Show("Se agrego correctamnete", "Correcto", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
        //Metodo para guardar en la base de datos el usuario
        // No inserta el usuario cambiar
        public async void InsertarUsuario(Usuario usuario)
        {
            using (var httpClient = new HttpClient())
            {
                // Configurar la serialización para enums como strings
                var options = new JsonSerializerOptions
                {
                    Converters = { new JsonStringEnumConverter(JsonNamingPolicy.CamelCase) },
                    PropertyNameCaseInsensitive = true
                };
                var json = JsonSerializer.Serialize(usuario, options);
                MessageBox.Show(json, "JSON a enviar", MessageBoxButtons.OK, MessageBoxIcon.Information);

                // Pasar el contenido de usuario a Json
                var content = new StringContent(json, Encoding.UTF8, "application/json");
                // revienta aqui
                var response = await httpClient.PostAsync("http://10.0.2.15:5500/api/usuario", content);

                //Comprobacion de que se inserto correctamnete
                // Si procesa correctamente la solicitud
                if (response.IsSuccessStatusCode)
                {
                    var usuarioJson = await response.Content.ReadAsStringAsync();
                    var usuarioCreado = JsonSerializer.Deserialize<Usuario>(usuarioJson);
                    MessageBox.Show("Usuario creado: " + usuarioCreado.NombreUsuario);
                }
                else
                {
                    MessageBox.Show("Error al crear usuario: " + response.StatusCode);
                }
            }
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
