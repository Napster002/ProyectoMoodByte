using Modelo;
using Newtonsoft.Json.Converters;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace ModeloDTO
{
    public class UsuarioDTO
    {
        public long id { get; set; }
        public string nombreCompleto { get; set; }
        public string nombreUsuario { get; set; }
        public string password { get; set; }
        public int edad { get; set; }

        [JsonConverter(typeof(JsonStringEnumConverter))]
        public Genero genero { get; set; }
        [JsonConverter(typeof(JsonStringEnumConverter))]
        public TipoUsuario tipoUsuario { get; set; }
        public DateOnly fechaRegistro { get; set; }
        public DateOnly fechaNacimiento { get; set; }
        public int nivel { get; set; }

        public double expAcumulada { get; set; }
    }
}
