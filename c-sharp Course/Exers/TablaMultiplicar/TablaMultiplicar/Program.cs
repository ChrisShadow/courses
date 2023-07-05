using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TablaMultiplicar
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Tabla de multiplicar en función a número ingresado.");
            int nro = -1;
            string data = "";
            do
            {
                Console.WriteLine("\nIngrese cualquier nro del conjunto de los enteros, pero para cancelar 0: ");
                data = Console.ReadLine();
                nro = int.Parse(data);
                if (nro==0)
                {
                    break;
                }
                else
                {
                    Console.WriteLine("{0}: ¡Ingresado correctamente!", nro);
                    Console.WriteLine("Los productos del " + data + " son:\n");
                    if (nro>0)
                    {
                        for (int i = 1; i <= nro; i++)
                        {
                            int acu = nro * i;
                            Console.Write(acu + ",");
                        }
                        Console.WriteLine("\n");
                        nro = -1;
                    }
                    else
                    {
                        for (int i = -1; i >= nro; i--)
                        {
                            int acu = nro * i;
                            Console.Write(acu*(-1) + ",");
                        }
                        Console.WriteLine("\n");
                        nro = -1;
                    }
                    
                }
            } while (nro!=0);
            Console.WriteLine("**PROGRAMA FINALIZADO**");

        }
    }
}
