using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Conexiones
{
    // conexion generica para cada tabla y si hay que cambiar algo se cambia aqui
    public class ConexionTabla
    {
        public static string TablaUsuario { get; } = ConexionGenerica.Conexion + "/api/usuario";
        public static string TablaArticulo { get; } = ConexionGenerica.Conexion + "/api/articulo";
        public static string TablaEjercicio { get; } = ConexionGenerica.Conexion + "/api/ejercicio";
        public static string TablaFrase { get; } = ConexionGenerica.Conexion + "/api/frase";
        public static string TablaMusica { get; } = ConexionGenerica.Conexion + "/api/musica";
        public static string TablaEstado { get; } = ConexionGenerica.Conexion + "/api/estado";

    }
}
