using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ArrayExam
{
    class Program
    {
        static void Main(string[] args)
        {
            //1
            /*int[] array = new int[4];
            array[0] = 1;
            array[1] = 2;
            array[2] = 3;
            array[3] = 4;

            Console.WriteLine(array[3]);*/

            //2
            /*char[] array1 = new char[] { 'H', 'e', 'l', 'l', 'o' };
            Console.WriteLine(array1[1]);*/

            //3
            /*double[] array2 = { 1.1, 2.2, 3.3, 4.4 };
            Console.WriteLine("Elementos del vector iterados con for");
            for (int i = 0; i <= array2.Length - 1; i++)
            {
                Console.Write(" "+array2[i]);
            }
            Console.WriteLine("\nElementos del vector iterados con foreach");
            foreach (double a in array2)
            {
                Console.Write(" " +a);
            }
            Console.WriteLine("\nDimensión: {0}\nY el último elemento es {1}", array2.Length,array2[array2.Length-1]);
            Console.WriteLine("Imrpimiendo valores de manera inversa");
            string[] str = { "today", "maybe", "not", "tomorrow" };
            for (int i=str.Length-1;i>=0;i--)
            {
                Console.Write(" " + str[i]);
            }
            Console.WriteLine("\nDimensión: {0}\nY el primer elemento es {1}", str.Length, str[0]);*/
            Console.Write("Ingresa la cantidad de parciales incluyento el examen final:");
            int dim = Convert.ToInt32(Console.ReadLine());
            while (dim <= 0)
            {
                Console.WriteLine("No corresponde, reingrese correctamente.");
                Console.Write("Ingresa la cantidad de parciales incluyento el examen final:");
                dim = Convert.ToInt32(Console.ReadLine());

            }
            int[] value = new int[dim];
            
            int item = 0;
            for(int i = 0; i <= value.Length - 1;i++)
            {
                item += 1;
               
                do
                {
                    Console.Write("Ingresa la calificación del examen {0}", item + "(1-100): ");

                    value[i] = Convert.ToInt32(Console.ReadLine());
                    if (value[i] <=0 || value[i] > 100)
                    {
                        Console.WriteLine("No corresponde, reingrese correctamente.");
                    }

                } while (value[i]<=0 || value[i]>100);

            }
            Console.WriteLine("Calificaciones ingresadas");
            ShowArray(value);
            SumaPromedio(value);

            //ARRAY
            /*int[] list = { 1, 9, 2, 8, 3, 7 };
            int[] temp = new int[list.Length];*/

            //Generar copia
            /*Array.Copy(list, temp, list.Length);
            Console.WriteLine("Arreglo Original");
            ShowArray(list);
            Console.WriteLine("Arreglo Espejo");
            ShowArray(temp);*/
            //Invertir
            /*Array.Reverse(temp);
            Console.WriteLine("Invertido");
            ShowArray(temp);*/
            //Ordenar
            /*Array.Sort(list);
            Console.WriteLine("De menor a mayor");
            ShowArray(list);*/



        }
        static void ShowArray(int[] array)
        {
            int item = 0;
            foreach (int i in array)
            {
                item+= 1;
                if (array.Length==item)
                {
                    Console.WriteLine("Final-){0}",i);

                }else
                Console.WriteLine("Parcial {0}-) {1}", item, i);

            }
            Console.WriteLine();
        }
        static void SumaPromedio(int[] arr)
        {
            int score = arr.Length * 100;
            int sum=0;
            double prom;
            for (int i=0;i<=arr.Length-1;i++)
            {
                sum += arr[i];
                
            }
            prom = sum / arr.Length;

            Console.WriteLine("La suma de las calificaciones es {0}/{1} y el promedio {2}/100", sum,score, prom);
            double porcentajeSuma = score * 0.6;

            Console.WriteLine("Nota mínima para aprobar: "+ porcentajeSuma+ "(60% suma de calificaciones) y 60(en el promedio)");
            if(sum>=240 && prom >= 60)
            {
                Console.WriteLine("Estudiante con puntaje {0} y promedio {1},APROBADO", sum, prom);
            }
            else
            {
                Console.WriteLine("Estudiante con puntaje {0} y promedio {1}, NO APROBADO", sum, prom);
            }

        }
    }
}
