namespace Conexiones
{
    public class ConexionGenerica
    {

        public static string Conexion { get; } = "http://localhost:5500";
        public static HttpClient CLIENTE = new HttpClient();
    }
}
