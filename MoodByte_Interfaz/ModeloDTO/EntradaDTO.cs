using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ModeloDTO
{
    public class EntradaDTO
    {
        public long id { get; set; }
        public string texto { get; set; }
        public DateOnly fechaEntrada { get; set; }
        public long idDiario { get; set; }
    }
}
