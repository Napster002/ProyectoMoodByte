using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Modelo
{
    public class Validaciones
    {
        public static bool validaNombre(string nombre, out string error)
        {
            if (!Regex.IsMatch(nombre, "^[A-ZÑ][ A-Za-záéíóúÁÉÍÓÚÑñ ]{1,15}$"))
            {
                error = "Mal introducido: Nombre";
                return false;
            }
            error = string.Empty;
            return true;
        }
        public static bool validaApellido(string nombre, out string error)
        {
            if (!Regex.IsMatch(nombre, "^[A-ZÑ][ A-Za-záéíóúÁÉÍÓÚÑñ ]{1,15}$"))
            {
                error = "Mal introducido: Apellidos";
                return false;
            }
            error = string.Empty;
            return true;
        }
        public static bool validaFechaNacimiento(DateTime fechaNacimiento, out string error)
        {
            int edad= DateTime.Now.Year - fechaNacimiento.Year;
            if (edad<13)
            {
                error = "Mal introducido: Fecha: Debes tener al menos 13 años";
                return false;
            }
            error = string.Empty;
            return true;
        }
        public static bool validaContraseña(string nombre, out string error)
        {
            if (!Regex.IsMatch(nombre, "[ A-Za-záéíóúÁÉÍÓÚÑñ1234567890 ]{1,15}"))
            {
                error = "Mal introducido: Contraseña: Introduce una contraseña valida";
                return false;
            }

            error = string.Empty;
            return true;
        }
    }
}
