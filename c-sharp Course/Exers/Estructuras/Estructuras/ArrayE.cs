using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Estructuras
{
    struct ArrayE //propiedades y métodos así como Class
    {
        public double X { get; set; }
        public double Y { get; set; }
        public double Z { get; set; }
        //no define constructo vacío
        public ArrayE (double x, double y, double z) : this()
        {
            X = x;
            Y = y;
            Z = z;
        }

        public double CalcularModulo()
        {
            return Math.Sqrt(X * X + Y * Y + Z * Z); // Módulo: raíz cuadrada de la suma de los cuadrados de sus componentes.
        }

        public ArrayE Suma(ArrayE suma)//inmutabilidad,operaciones entre objetos
        {
            return new ArrayE(X + suma.X, Y + suma.Y, Z + suma.Z);
        }

        public override string ToString()
        {
            return string.Format("{0},{1},{2}", X, Y, Z);
        }
    }
}
