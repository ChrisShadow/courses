using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class
{
    class Persona
    {
        #region Att
        public string Nombre { get; set; }
        public string Apellido { get; set; }
        private int _age;
        public int Edad
        {
            get { return _age; }
            set
            {
                _age = value < 0 ? 0 : value;
            }
        }
        #endregion
        #region Constructres
        public Persona(string name)
        {
            Nombre = name;
        }
        public Persona(string name, string lastName) : this(name)
        {
            Apellido = lastName;
        }
        public Persona(string name, string lastName, int edad) : this(name, lastName)
        {
            Edad = edad;
        }

        public Persona(){ }
        #endregion

        #region Funciones
        public void Saludar()
        {
            Console.WriteLine("Bienvenido {0} {1}.",Nombre,Apellido);
        }

        public override string ToString()
        {
            return string.Format("Usuario {0} {1} tiene actualmente {2} años de edad.",Nombre, Apellido, Edad);
        }
        #endregion
        }
}
