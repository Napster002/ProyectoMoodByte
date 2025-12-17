using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelo
{
    public class Estado
    {
        public long id { get; set; }
        public string nombre { get; set; }
        List<Articulo>articulos { get; set; } = new List<Articulo>();

    }
}
