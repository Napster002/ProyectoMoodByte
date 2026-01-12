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
        public static bool validaApellido(string apellido, out string error)
        {
            if (!Regex.IsMatch(apellido, "^[A-ZÑ][ A-Za-záéíóúÁÉÍÓÚÑñ ]{1,15}$"))
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
        public static bool validaContraseña(string contraseña, out string error)
        {
            if (!Regex.IsMatch(contraseña, "[ A-Za-záéíóúÁÉÍÓÚÑñ1234567890 ]{1,15}"))
            {
                error = "Mal introducido: Contraseña: Introduce una contraseña valida";
                return false;
            }

            error = string.Empty;
            return true;
        }
        public static bool validaTitulo(string titulo, out string error)
        {
            if (!Regex.IsMatch(titulo, "^[A-ZÑ][ A-Za-záéíóúÁÉÍÓÚÑñ, ]{1,40}$"))
            {
                error = "Mal introducido: Titulo";
                return false;
            }

            error = string.Empty;
            return true;
        }
        public static bool validaSubtitulo(string subtitulo, out string error)
        {
            if (!Regex.IsMatch(subtitulo, "^[A-ZÑ][ A-Za-záéíóúÁÉÍÓÚÑñ, ]{1,60}$"))
            {
                error = "Mal introducido: Subtitulo";
                return false;
            }
            error = string.Empty;
            return true;
        }
        public static bool validaImagen(string imagen, out string error)
        {
            if (!Regex.IsMatch(imagen, @"\.(png|jpg|jpeg)$",RegexOptions.IgnoreCase))
            {
                error = "Mal introducido: Formato de imagen no valido(png|jpg|jpeg)";
                return false;
            }
            error = string.Empty;
            return true;
        }
        public static bool validaFrase(string frase, out string error)
        {
            if (!Regex.IsMatch(frase, "^[A-ZÑ][ A-Za-záéíóúÁÉÍÓÚÑñ ]{1,45}$"))
            {
                error = "Mal introducido: Formato de Frase";
                return false;
            }
            error = string.Empty;
            return true;
        }
    }
}
