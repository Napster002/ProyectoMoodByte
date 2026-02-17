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
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace MoodByte
{
    public partial class CrearUsuario : Form
    {
        private readonly HttpClient _httpClient = new HttpClient();
        private Usuario usuarioActual;
        public EventHandler UsuarioCreado_Editado;
        public CrearUsuario(Usuario usuario)
        {
            InitializeComponent();
            cbTipoUsuario.DataSource = Enum.GetValues(typeof(TipoUsuario));
            cbGenero.DataSource = Enum.GetValues(typeof(Genero));
            dtpFechaRegistro.Enabled = false;
            if (usuarioActual != null)
            {
                var partes = usuarioActual.NombreCompleto.Split(',');
                tbNombre.Text = partes[0];
                tbApellidos.Text = partes.Length > 1 ? partes[1] : "";
                tbNombreUsuario.Text = usuarioActual.NombreUsuario;
                dtpFechanacimiento.Value = usuarioActual.FechaNacimiento.ToDateTime(TimeOnly.MinValue);
                cbGenero.SelectedItem = usuarioActual.Genero;
                cbTipoUsuario.SelectedItem = usuarioActual.TipoUsuario;
                tbContraseña.Text = usuarioActual.Password;
                tbRepitecontraseña.Text = usuarioActual.Password;
            }
        }
        // Falta la opcion de salir al guardar correctamnete
        private async void buttonGuardar_Click(object sender, EventArgs e)
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
            var user = new Usuario
            {
                Id = usuarioActual?.Id ?? 0,
                NombreCompleto = tbNombre.Text + "," + tbApellidos.Text,
                NombreUsuario = tbNombreUsuario.Text,
                Edad = edad,
                Nivel = 0,
                ExpAcumulada = 0,
                Password = tbContraseña.Text,
                FechaRegistro = DateOnly.FromDateTime(dtpFechaRegistro.Value),
                FechaNacimiento = DateOnly.FromDateTime(dtpFechanacimiento.Value),
                Genero = (Genero)cbGenero.SelectedItem,
                TipoUsuario = (TipoUsuario)cbTipoUsuario.SelectedItem
            };
            await InsertarUsuario(user);
        }
        //Metodo para guardar en la base de datos el usuario
        // No inserta el usuario cambiar
        public async Task InsertarUsuario(Usuario usuario)
        {
            // Configurar la serialización para enums como strings
            var options = new JsonSerializerOptions
            {
                Converters = { new JsonStringEnumConverter() },
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
                PropertyNameCaseInsensitive = true
            };

            if (usuario.Id == 0)
            {
                var json = JsonSerializer.Serialize(usuario, options);
                // Muestra el usuario creado sin enviar a la db
                MessageBox.Show(json, "JSON a enviar", MessageBoxButtons.OK, MessageBoxIcon.Information);

                // Pasar el contenido de usuario a Json
                var content = new StringContent(json, Encoding.UTF8, "application/json");
                // revienta aqui
                var response = await _httpClient.PostAsync(ConexionTabla.TablaUsuario, content);

                //Comprobacion de que se inserto correctamnete
                // Si procesa correctamente la solicitud
                if (response.IsSuccessStatusCode)
                {
                    var usuarioJson = await response.Content.ReadAsStringAsync();
                    var usuarioCreado = JsonSerializer.Deserialize<Usuario>(usuarioJson);
                    MessageBox.Show("Se agrego correctamnete e usuario", "Correcto", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    UsuarioCreado_Editado?.Invoke(this, EventArgs.Empty);
                }
                else
                {
                    MessageBox.Show("Error al crear usuario: " + response.StatusCode + response.ToString());
                }
            }
            else
            {
                var json = JsonSerializer.Serialize(usuario, options);
                // Muestra el usuario creado sin enviar a la db
                MessageBox.Show(json, "JSON a enviar", MessageBoxButtons.OK, MessageBoxIcon.Information);

                // Pasar el contenido de usuario a Json
                var content = new StringContent(json, Encoding.UTF8, "application/json");
                // revienta aqui
                var response = await _httpClient.PutAsync($"{ConexionTabla.TablaUsuario}/{usuario.Id}", content);

                //Comprobacion de que se inserto correctamnete
                // Si procesa correctamente la solicitud
                if (response.IsSuccessStatusCode)
                {
                    var usuarioJson = await response.Content.ReadAsStringAsync();
                    var usuarioCreado = JsonSerializer.Deserialize<Usuario>(usuarioJson);
                    MessageBox.Show("Se actualizó correctamnete el usuario", "Correcto", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    UsuarioCreado_Editado?.Invoke(this, EventArgs.Empty);
                }
                else
                {
                    MessageBox.Show("Error al actualizar usuario: " + response.StatusCode + response.ToString());
                }
            }
        }
            private void CrearUsuario_Load(object sender, EventArgs e)
           {
            if (usuarioActual.Id == 0)
            {
                tbNombre.Focus();
                cbGenero.SelectedIndex = 0;
                cbTipoUsuario.SelectedIndex = 0;
            }
            else
            {
                buttonGuardar.Text = "Actualizar";
                var partes = usuarioActual.NombreCompleto.Split(',');

                tbNombre.Text = partes[0];
                tbApellidos.Text = partes.Length > 1 ? partes[1] : "";
                dtpFechanacimiento.Value = new DateTime(usuarioActual.FechaNacimiento.Year, usuarioActual.FechaNacimiento.Month, usuarioActual.FechaNacimiento.Day);
                cbGenero.SelectedItem = usuarioActual.Genero;
                cbTipoUsuario.SelectedItem = usuarioActual.TipoUsuario;
                tbNombreUsuario.Text = usuarioActual.NombreUsuario;
                dtpFechaRegistro.Value = new DateTime(usuarioActual.FechaRegistro.Year, usuarioActual.FechaRegistro.Month, usuarioActual.FechaRegistro.Day);
                tbNombre.Focus();
            }
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
