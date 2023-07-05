using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Herencia
{
    class Program
    {
        static void Main(string[] args)
        {
            /*Pers p = new Pers("Chris", 23);
            p.Salute();
            Empl e = new Empl("Bene", 32, "CEO", 3700);
            e.Salute();
            e.Workin();
            Stud s = new Stud("David", 21, 78, "3rd");
            s.Salute();
            s.GoinClass();
            Console.WriteLine(s);
            Empl2Hon eh = new Empl2Hon("Rodd", "CEO", 15000);
            eh.Salute();
            eh.Workin();
            Console.WriteLine("Fee {0}",eh.Income);
            Empl2Proll ep = new Empl2Proll("Suzanne", "CFO", 9000);
            ep.Salute();
            ep.Workin();
            Console.WriteLine("Payroll {0}", ep.Income);*/

            Pers2 p1 = new Pers2("Joha", 18);
            Pers2 p2 = new Pers2("Joha", 18);
            Pers2 p3 = p1;

            //Reference
            Console.WriteLine("Por Referencia");
            Console.Write("Ref p1 y p2 Iguales: ");
            Console.WriteLine(p1 == p2);
            Console.Write("Ref p2 y p3 Iguales: ");
            Console.WriteLine(p2 == p3);
            Console.Write("Ref p3 y p1 Iguales: ");
            Console.WriteLine(p3 == p1);
            Console.WriteLine();

            //Objects
            Console.WriteLine("Por objetos");
            Console.Write("Ref p1 y p2 Iguales: ");
            Console.WriteLine(p1.Equals(p2));
            Console.Write("Ref p2 y p3 Iguales: ");
            Console.WriteLine(p2.Equals(p3));
            Console.Write("Ref p3 y p1 Iguales: ");
            Console.WriteLine(p3.Equals(p1));
            Console.WriteLine();

        }
    }
}
