using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelo
{
    public class Usuario
    {
        public long Id { get; set; }
        public string NombreUsuario { get; set; }
        public string NombreCompleto { get; set; }
        public int Edad { get; set; }
        public int Nivel { get; set; }
        public double ExpAcumulada { get; set; }
        public string Password { get; set; }
        public DateTime FechaRegistro { get; set; }
        public DateTime FechaNacimiento { get; set; }
        public Genero Genero { get; set; }
        public TipoUsuario TipoUsuario { get; set; }
    }
}
