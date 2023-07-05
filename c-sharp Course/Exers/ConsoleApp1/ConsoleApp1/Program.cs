using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Resultado de operaciones aritmética básica (par positivio o negativo, impar positivo o negativo o nulo)");
            Console.Write("Ingrese el nro 1: ");
            //Primero como cadena
            string data1 = Console.ReadLine();
            //Convertir
            float nro1 = int.Parse(data1);
            Console.Write("Ingrese el nro 2: ");
            string data2 = Console.ReadLine();
            float nro2 = int.Parse(data2);

            //Operaciones
            float mult = nro1*nro2;//par positivo 54
            float div = nro1 / nro2;//0,6 
            float res = nro1 - nro2;//impar negativo -3
            float suma = nro1 + nro2;//par positivo 15

            if (nro2==0)
            {
                Console.WriteLine("DIVISIÓN\n" + nro1+" no puede ser dividido entre "+nro2);
            }
            else
            {
                if (div % 2 == 0)
                {
                    if (div > 0)
                    {
                        Console.WriteLine("DIVISIÓN\n-Resultado par positivo: " + nro1 + " / " + nro2 + "=" + div);
                    }
                    else if (div < 0)
                    {
                        Console.WriteLine("DIVISIÓN\n-Resultado par negativo: " + nro1 + " / " + nro2 + "=" + div);
                    }
                    else
                    {
                        Console.WriteLine("DIVISIÓN\n-Resultado nulo: " + nro1 + " / " + nro2 + "=" + div);
                    }
                }
                else
                {
                    if (div > 0)
                    {
                        Console.WriteLine("DIVISIÓN\n-Resultado impar positivo: " + nro1 + " / " + nro2 + "=" + div);
                    }
                    else if (div < 0)
                    {
                        Console.WriteLine("DIVISIÓN\n-Resultado impar negativo: " + nro1 + " / " + nro2 + "=" + div);
                    }
                    else
                    {
                        Console.WriteLine("DIVISIÓN\n-Resultado nulo: " + nro1 + " / " + nro2 + "=" + div);
                    }

                }
            }


            if (mult % 2 == 0)
            {
                if (mult >0)
                {
                    Console.WriteLine("MULTIPLIACIÓN\n-Resultado par positivo: " + nro1 + " X " + nro2 + "=" + mult);
                }
                else if (mult <0)
                {
                    Console.WriteLine("MULTIPLIACIÓN\n-Resultado par negativo: " + nro1 + " X " + nro2 + "=" + mult);

                }
                else
                {
                    Console.WriteLine("MULTIPLIACIÓN\n-Resultado nulo: " + nro1 + " X " + nro2 + "=" + mult);
                }
                
            }
            else
            {
                if (mult >0)
                {
                    Console.WriteLine("MULTIPLIACIÓN\n-Resultado impar positivo: " + nro1 + " X " + nro2 + "=" + mult);
                }
                else if (mult<0) {
                    Console.WriteLine("MULTIPLIACIÓN\n-Resultado impar negativo: " + nro1 + " X " + nro2 + "=" + mult);
                }
                else
                {
                    Console.WriteLine("MULTIPLIACIÓN\n-Resultado nulo: " + nro1 + " X " + nro2 + "=" + mult);
                }
                
            }

            if (res % 2 == 0)
            {
                if (res >0)
                {
                    Console.WriteLine("RESTA\n-Resultado par positivo: " + nro1 + " - " + nro2 + "=" + res);
                }
                else if (res<0)
                {
                    Console.WriteLine("RESTA\n-Resultado par negativo: " + nro1 + " - " + nro2 + "=" + res);
                }
                else
                {
                    Console.WriteLine("RESTA\n-Resultado nulo: " + nro1 + " - " + nro2 + "=" + res);
                }
                
            }
            else
            {
                if (res >0)
                {
                    Console.WriteLine("RESTA\n-Resultado impar positivo: " + nro1 + " - " + nro2 + "=" + res);
                }
                else if (res <0)
                {
                    Console.WriteLine("RESTA\n-Resultado impar negativo: " + nro1 + " - " + nro2 + "=" + res);
                }
                else
                {
                    Console.WriteLine("RESTA\n-Resultado nulo: " + nro1 + " - " + nro2 + "=" + res);
                }
                
            }
            if (suma % 2 == 0)
            {
                if (suma>0)
                {
                    Console.WriteLine("SUMA\n-Resultado par positivo: " + nro1 + " + " + nro2 + "=" + suma);
                }
                else if (suma<0)
                {
                    Console.WriteLine("SUMA\n-Resultado par negativo: " + nro1 + " + " + nro2 + "=" + suma);
                }
                else
                {
                    Console.WriteLine("SUMA\n-Resultado nulo: " + nro1 + " + " + nro2 + "=" + suma);
                }

                
            }
            else
            {
                if (suma >0)
                {
                    Console.WriteLine("SUMA\n-Resultado impar positivo: " + nro1 + " + " + nro2 + "=" + suma);
                }
                else if (suma<0)
                {
                    Console.WriteLine("SUMA\n-Resultado impar negativo: " + nro1 + " + " + nro2 + "=" + suma);
                }
                else
                {
                    Console.WriteLine("SUMA\n-Resultado nulo: " + nro1 + " + " + nro2 + "=" + suma);
                }
                
            }
        }
    }
}
