using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelo
{
    internal class Ejercicio
    {
        public long id { get; set; }
        public string titulo { get; set; }
        public string descripcion { get; set; }
        public TimeOnly duracion { get; set; }
        public Estado estado { get; set; }
    }
}
