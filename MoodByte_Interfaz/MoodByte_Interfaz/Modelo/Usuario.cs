using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelo
{
    public class Usuario
    {
        public long id { get; set; }
        public string nombreUsuario { get; set; }
        public string nombreCompleto { get; set; }
        public int edad { get; set; }
        public int nivel { get; set; }
        public double expAcumulada { get; set; }
        public string password { get; set; }
        public DateTime fechaRegistro { get; set; }
        public DateTime fechaNacimiento { get; set; }
        public enumGenero genero { get; set; }
        public enumTipoUsuario tipoUsuario { get; set; }
    }
}
