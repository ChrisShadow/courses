using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Polimorfismo
{
    class Program
    {
        static void Main(string[] args)

        {
            //Upcasting
            IFigure c = new Circle { Radius=5};
            IFigure t = new Triangle { Base=15, Height=55};
            IFigure r = new Rectangle { Base=20,Height=40};

            IFigure[] fig = new IFigure[] { c, t, r };
            foreach (var item in fig)
            {
                Console.WriteLine(item.GetArea());
            }

            //Downcasting
            Circle circ = c as Circle;
            Console.WriteLine("Data of Circle");
            circ.CircleData();
            Triangle tri = t as Triangle;
            Console.WriteLine("Data of Triangle");
            tri.TriangleData();
            Rectangle rec = r as Rectangle;
            Console.WriteLine("Data of rectangle");
            rec.RectangleData();

        }
    }
}
