using Conexiones;
using Modelo;
using ModeloDTO;
using System.Net.Http.Json;
using System.Text;

namespace MoodByte
{
    public partial class CrearUsuario : Form
    {
        private readonly HttpClient Cliente = ConexionGenerica.CLIENTE;
        private UsuarioDTO usuario;
        public EventHandler UsuarioCreado_Editado;
        private bool esNuevo;
        private bool nuevoRegistro;
        public CrearUsuario(UsuarioDTO usuario,bool nuevoRegistro)
        {
            esNuevo = false;
            InitializeComponent();
            this.usuario = usuario;
            this.nuevoRegistro = nuevoRegistro;
        }
            public CrearUsuario(bool nuevoRegistro)
            {
            esNuevo = true;
            InitializeComponent();
            this.nuevoRegistro = nuevoRegistro;
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
            var user = new Usuario();
            {
                if (!esNuevo)
                {
                    user = new Usuario
                    {
                        Id = usuario.id,
                        NombreCompleto = tbNombre.Text + "," + tbApellidos.Text,
                        NombreUsuario = tbNombreUsuario.Text,
                        Edad = edad,
                        Nivel = usuario.nivel,
                        ExpAcumulada = usuario.expAcumulada,
                        Password = tbContraseña.Text,
                        FechaRegistro = DateOnly.FromDateTime(dtpFechaRegistro.Value),
                        FechaNacimiento = DateOnly.FromDateTime(dtpFechanacimiento.Value),
                        Genero = (Genero)cbGenero.SelectedItem,
                        TipoUsuario = (TipoUsuario)cbTipoUsuario.SelectedItem
                    };
                }
                else
                {
                    user = new Usuario
                    {
                        NombreCompleto = tbNombre.Text + "," + tbApellidos.Text,
                        NombreUsuario = tbNombreUsuario.Text,
                        Edad = edad,
                        Nivel = 0,
                        ExpAcumulada = 0,
                        Password = tbContraseña.Text,
                        FechaRegistro = DateOnly.FromDateTime(DateTime.Today),
                        FechaNacimiento = DateOnly.FromDateTime(dtpFechanacimiento.Value),
                        Genero = (Genero)cbGenero.SelectedItem,
                        TipoUsuario = (TipoUsuario)cbTipoUsuario.SelectedItem
                    }
;
            }
                    await InsertarUsuario(user);
                if (nuevoRegistro)
                {
                    Menu menu = new Menu();
                    menu.Show();
                }
                this.DialogResult = DialogResult.OK;
                this.Close();
            }
            }
        public async Task InsertarUsuario(Usuario usuario)
        {
            try
            {
                if (!esNuevo)
                {
                    var respuesta = await Cliente.PutAsJsonAsync<Usuario>($"{ConexionTabla.TablaUsuario}/{usuario.Id}", usuario);
                    if (respuesta.IsSuccessStatusCode)
                    {
                        MessageBox.Show("Usuario actualizado");
                    }
                    else
                    {
                        MessageBox.Show("Fallo al actualizar usuario "+respuesta.ReasonPhrase);
                    }
                }
                else
                {
                    var respuesta = await Cliente.PostAsJsonAsync<Usuario>(ConexionTabla.TablaUsuario, usuario);
                    if (respuesta.IsSuccessStatusCode)
                    {
                        MessageBox.Show("Usuario creado");
                    }
                    else
                    {
                        MessageBox.Show("Fallo al crear usuario");
                    }
                }
                    }catch(Exception ex)
            {

            }

        }
            private void CrearUsuario_Load(object sender, EventArgs e)
           {
                if (esNuevo)
                {
                    buttonGuardar.Text = "Crear";

            }
            else
            {
                buttonGuardar.Text = "Actualizar";
                dtpFechaRegistro.Enabled = false;
                var partes = usuario.nombreCompleto.Split(',');
                tbNombre.Text = partes[0];
                tbApellidos.Text = partes.Length > 1 ? partes[1] : "";
                tbNombreUsuario.Text = usuario.nombreUsuario;
                dtpFechanacimiento.Value = usuario.fechaNacimiento.ToDateTime(TimeOnly.MinValue);
                cbGenero.SelectedItem = usuario.genero;
                cbTipoUsuario.SelectedItem = usuario.tipoUsuario;
                tbContraseña.Text = usuario.password;
                tbRepitecontraseña.Text = usuario.password;
            }
            cbTipoUsuario.DataSource = Enum.GetValues(typeof(TipoUsuario));
            cbGenero.DataSource = Enum.GetValues(typeof(Genero));
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
