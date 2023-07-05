using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MultArrs
{
    class Program
    {
        static void Main(string[] args)
        {
            /*int[,] arrs = new int[4, 4] { {0,0,0,0 }, {1,1,1,1 }, {2,2,2,2 }, { 3,3,3,3} };
            Console.WriteLine("Matriz de dimensión {0}x{1}",arrs.GetLength(0),arrs.GetLength(1));
            for (int i = 0; i < arrs.GetLength(0); i++)
            {  
                for (int j = 0; j < arrs.GetLength(1); j++)
                {
                    Console.Write("{0} ", arrs[i, j]);
                }
                Console.WriteLine("");
            }*/

            double[,] maA = { {1.5,1.7}, {7.4,2.9} };
            double[,] maB = { {-7.6,3.7}, {0,4.8} };

            Console.WriteLine("Matriz A: ");
            ShowArrs(maA);
            Console.WriteLine("Matriz B: ");
            ShowArrs(maB);

            double[,] addit = new double[2, 2];
            Console.WriteLine("Matriz suma: ");
            ShowArrs(addit);
            for (int i = 0; i < addit.GetLength(0); i++)
            {
                for (int j = 0; j < addit.GetLength(1); j++)
                {
                    addit[i, j] = maA[i, j] + maB[i, j];
                }
                Console.WriteLine("");
            }
            Console.WriteLine("Matriz suma resultante: ");
            ShowArrs(addit);
        }

        static void ShowArrs(double [,] arr)
        {
            for(int i = 0; i < arr.GetLength(0);i++)
            {
                for(int j=0;j<arr.GetLength(1);j++)
                {
                    Console.Write("{0:0.#0} ", arr[i, j]);
                }
                Console.WriteLine("");
            }
        }
            
    }
}
