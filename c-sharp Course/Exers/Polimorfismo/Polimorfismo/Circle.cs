using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Polimorfismo
{
    class Circle : IFigure
    {
        public double Radius { get; set; }
        public double GetArea()
        {
            return Math.PI * Radius;

        }

        public void CircleData()
        {
            Console.WriteLine("Radio: {0}", Radius);
        }
    }
}
