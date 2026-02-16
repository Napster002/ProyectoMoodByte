using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ModeloDTO
{
    public class RegistroDTO
    {
        public long id { get; set; }
        public int puntuacion { get; set; }
        public DateOnly fechaRegistro   { get; set; }
        public long idUsuario { get; set; }
    }
}
