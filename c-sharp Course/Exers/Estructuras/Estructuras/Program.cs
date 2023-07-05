using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Estructuras
{
    class Program
    {
        static void Main(string[] args)
        {
            /*ArrayE a1 = new ArrayE(1, 2, 3);
            ArrayE a2 = new ArrayE(4, 5, 6);

            Console.WriteLine("Módulo vector 1: {0}", a1.CalcularModulo());
            Console.WriteLine("Módulo vector 2: {0}", a2.CalcularModulo());

            ArrayE res = a1.Suma(a2);
            Console.WriteLine(a1);
            Console.WriteLine(a2);
            Console.WriteLine("------");
            Console.WriteLine(res);*/
            /*Reto r1 = new Reto(3, 4);
            Reto r2 = new Reto(-0.8, 2);
            Console.WriteLine(r1);
            Console.WriteLine(r2);

            Reto res = r1.Suma(r2);
            
            Reto res1 = r1.Multip(r2);

            Console.WriteLine("Suma\n"+res+ "\nMultiplicación\n"+ res1);
            //Para encapsular datos pequeños con pocas propiedades de tipo predefinido int , double de entidad no compleja*/

            Console.WriteLine("Tipos de valor: se copian al ser asignado a una nueva variable. Son modificados los valores de la copia, original mantienes sus valores iniciales");
            PuntoVal puntoV = new PuntoVal(5, 10);
            PuntoVal otro = puntoV;
            otro.X = 100;
            otro.Y = 60;
            Console.WriteLine("Primero: ({0},{1})",puntoV.X,puntoV.Y);
            Console.WriteLine("Segundo: ({0},{1})", otro.X, otro.Y);
            Console.WriteLine("Tipos de referencia: se crea un solo objeto pero ese mismo puede ser modificado desde un distinto lugar");
            PuntoRef puntoR = new PuntoRef(40, 8);
            PuntoRef otroP = puntoR;

            otroP.X = 5;
            otroP.Y = 15;
            Console.WriteLine("Primero: ({0},{1})", puntoR.X, puntoR.Y);
            Console.WriteLine("Segundo: ({0},{1})", otroP.X, otroP.Y);
        }
    }
}
