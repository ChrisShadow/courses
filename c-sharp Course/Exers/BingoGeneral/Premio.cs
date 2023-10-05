using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BingoGeneral
{
    internal class Premio
    {
        private bool[,] premioSet { get; set; }
        private int cantidadFilasCarton;
        private int cantidadColumnasCarton;

        public void CrearPremio()
        {
            //Crear matriz
            do
            {
                do
                {
                    Console.WriteLine("Cantidad de filas del carton (número entero): ");
                    string filasString = Console.ReadLine();
                    bool filaEsNumero = int.TryParse(filasString, out int filaInt);
                    if (!filaEsNumero || filaInt <= 0)
                    {
                        Console.WriteLine("Error: debe introducir un número entero.");
                        continue;
                    }

                    cantidadFilasCarton = filaInt;
                    break;
                }
                while (true);

                do
                {
                    Console.WriteLine("Cantidad de columnas del carton (número entero): ");
                    string columnasString = Console.ReadLine();
                    bool columnaEsNumero = int.TryParse(columnasString, out int columnaInt);
                    if (!columnaEsNumero || columnaInt <= 0)
                    {
                        Console.WriteLine("Error: debe introducir un número entero.");
                        continue;
                    }
                    cantidadColumnasCarton = columnaInt;
                    break;
                }
                while (true);
                break;
            }
            while (true);
        }    
    }
                
}
