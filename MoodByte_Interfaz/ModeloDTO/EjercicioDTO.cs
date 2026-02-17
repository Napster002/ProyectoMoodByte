using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ModeloDTO
{
    public class EjercicioDTO
    {
        public long id { get; set; }
        public string titulo { get; set; }
        public string descripcion { get; set; }
        public string recursoUrl { get; set; }
        public TimeOnly duracion { get; set; }
        public long idEstado { get; set; }
    }
}
