using Modelo;
using System.Net.Http;
using System.Text.Json;
using System.Text.Json.Serialization;

namespace MoodByte
{
    public partial class Login : Form
    {
        private readonly HttpClient _httpClient = new HttpClient();
        private List<Usuario> listaUsuarios=new List<Usuario>();
        public Login()
        {
            InitializeComponent();
        }
        public async Task CargarGrid()
        {
            try
            {
                // Obtener el JSON como string
                var json = await _httpClient.GetStringAsync("http://10.0.2.15:5500/api/usuario");

                // Configurar el deserializador para enums como strings
                var options = new JsonSerializerOptions
                {
                    Converters = { new JsonStringEnumConverter(JsonNamingPolicy.CamelCase) },
                    PropertyNameCaseInsensitive = true // útil si el JSON tiene mayúsculas distintas
                };
                // Deserializar a lista de usuarios
                 listaUsuarios= JsonSerializer.Deserialize<List<Usuario>>(json, options);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al cargar los usuarios: " + ex.Message);
            }
        }
        private void btnRegistrar_Click(object sender, EventArgs e)
        {
            CrearUsuario CU=new CrearUsuario();
            CU.Visible=true;
            this.Visible=false;
        }

        private async void Login_Load(object sender, EventArgs e)
        {
            await CargarGrid();
        }

        private async void btnEntrar_Click(object sender, EventArgs e)
        {
            await CargarGrid();
            foreach (var usuario in listaUsuarios)
            {
                if (listaUsuarios != null && txtUsuario.Equals(usuario.NombreUsuario) && txtPassword.Equals(usuario.Password))
                {

                    return;
                }
            }
        }
    }
}
