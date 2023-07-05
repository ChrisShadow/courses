using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Polimorfismo
{
    class Rectangle : IFigure
    {
        public double Base { get; set; }
        public double Height { get; set; }
        public double GetArea()
        {
            return Base * Height;
        }

        public void RectangleData()
        {
            Console.WriteLine("Base: {0}, Height: {1}", Base, Height);
        }
    }
}
