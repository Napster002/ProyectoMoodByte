using Conexiones;
using Modelo;
using System.Text.Json;
using System.Text.Json.Serialization;

namespace MoodByte
{
    public partial class Login : Form
    {
        private readonly HttpClient _httpClient = ConexionGenerica.CLIENTE;
        private List<Usuario> listaUsuarios=new List<Usuario>();
        public Login()
        {
            InitializeComponent();
        }
        public async Task CargarUsuarios()
        {
            try
            {
                // Obtener el JSON como string
                var json = await _httpClient.GetStringAsync(ConexionTabla.TablaUsuario);

                // Configurar el deserializador para enums como strings
                var options = new JsonSerializerOptions
                {
                    Converters = { new JsonStringEnumConverter(JsonNamingPolicy.CamelCase) },
                    PropertyNameCaseInsensitive = true // �til si el JSON tiene may�sculas distintas
                };
                // Deserializar a lista de usuarios
                 listaUsuarios= JsonSerializer.Deserialize<List<Usuario>>(json, options);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al cargar los usuarios: " + ex.Message);
            }
        }

        private async void Login_Load(object sender, EventArgs e)
        {
            await CargarUsuarios();
        }
        // Falta solo cambiar si va a otra pantalla
        private async void btnEntrar_Click(object sender, EventArgs e)
        {
            var encontrado = false;
            await CargarUsuarios();
            foreach (var usuario in listaUsuarios)
            {
                if (txtUsuario.Text.Equals(usuario.NombreUsuario) && txtPassword.Text.Equals(usuario.Password))
                {
                    if (usuario.TipoUsuario.ToString().ToLower().Equals("administrador"))
                    {
                        Menu menu = new Menu();
                        menu.Visible = true;
                        this.Visible = false;
                        encontrado = true;
                    }
                    else
                    {
                        MessageBox.Show("Solo los administradores pueden acceder");
                        encontrado = true;
                    }
                }
            }
            if (!encontrado)
            {
                                MessageBox.Show("Usuario o contraseña incorrectos");
            }
        }
    }
}
