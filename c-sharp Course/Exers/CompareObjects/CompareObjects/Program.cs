using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CompareObjects
{
    class Program
    {
        static void Main(string[] args)
        {
            Product p1 = new Product{ Code = "01", Price = 122 };
            Product p2 = new Product { Code = "02", Price = 20 };
            Product p3 = new Product { Code = "03", Price = 30.5m };

            Product[] pr = new Product[] { p1, p2, p3 };
            Array.Sort(pr);
            foreach (var item in pr)
            {
                Console.WriteLine(item.ToString());
            }

        }
    }
}
