using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Estructuras
{
    struct Reto
    {
        public double Real { get; }
        public double Imaginario { get; }

        public  Reto(double r, double i):this()
        {
            Real = r;
            Imaginario = i;
        }

        public Reto Suma(Reto suma)
        {
            return new Reto(Real + suma.Real, Imaginario + suma.Imaginario);
        }

        public Reto Multip(Reto mult)
        {
            return new Reto(Real * mult.Real - Imaginario * mult.Imaginario, Real * mult.Imaginario + Imaginario * mult.Real);
        }

        public override string ToString()
        {
            return string.Format("Real: {0:0.0} - Imaginario: {1:0.0}i",Real, Imaginario);
        }

    }
}
