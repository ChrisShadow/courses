using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BingoGeneral
{
    internal class Carton
    {
        public int cantidadNumerosCarton;

        private int cantidadFilasCarton; 
        
        public int cantidadColumnasCarton { get; set; }
        public int cantidadCartones { get; set; }
        public int cantidadBolillasCartonBolillero { get; set; }// 
        public List<int> listaBolillasCarton { get; set; }

        //CONSTRUIR CARTON
        public void ConstruirCarton()
        {

            //Cantidad de bolillas para el Bolillero del carton
            do
            {
                Console.WriteLine("Cantidad bolillas para el Bolillero del carton (número entero): ");
                string cantidadBolillasCartonBolilleroString = Console.ReadLine();
                bool cantidadBolillasCartonBolilleroEsNumero = int.TryParse(cantidadBolillasCartonBolilleroString, out int cantidadBolillasCartonBolilleroInt);
                if (!cantidadBolillasCartonBolilleroEsNumero || cantidadBolillasCartonBolilleroInt <= 0)
                {
                    Console.WriteLine("Error: debe introducir un número entero.");
                    continue;
                }
                cantidadBolillasCartonBolillero = cantidadBolillasCartonBolilleroInt;
                break;
            }
            while (true);

            // Cantidad de números en el carton.
            do
            {
                Console.WriteLine("Cantidad de números en el carton (número entero): ");
                string numerosCartonString = Console.ReadLine();
                bool numeroCartonEsNumero = int.TryParse(numerosCartonString, out int numerosCartonInt);
                if (!numeroCartonEsNumero || numerosCartonInt <= 0)
                {
                    Console.WriteLine("Error: debe introducir un número entero.");
                    continue;
                }
                cantidadNumerosCarton = numerosCartonInt;
                break;
            }
            while (true);

            //Cantidad de filas y columnas
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

            // Cantidad de cartones a generar
            do
            {
                Console.WriteLine("Cantidad de cartones a jugar (número entero): ");
                string cantidadCartonesString = Console.ReadLine();
                bool cantidadCartonesEsNumero = int.TryParse(cantidadCartonesString, out int cantidadCartonesInt);
                if (!cantidadCartonesEsNumero || cantidadCartonesInt <= 0)
                {
                    Console.WriteLine("Error: debe introducir un número entero.");
                    continue;
                }

                cantidadCartones = cantidadCartonesInt;
                break;
            }
            while (true);
            Console.WriteLine("Estructura del carton creada con éxito! ");
        }

        //CREAR CARTON
        //Cantidad de cartones
        public List<int> CrearCarton()
        {
            for (int contador = 0; contador < cantidadCartones; contador++)
            {
                // Obtener la lista de bolillas del Bolillero para el cartón
                Bolillero bolillas = new Bolillero();
                bolillas.cantidadBolillas = cantidadBolillasCartonBolillero;
                List<int> listaBolilleroCarton = bolillas.CrearListaBolillas();

                // Asignar el valor de retorno a una propiedad de la clase Carton
                this.listaBolillasCarton = listaBolilleroCarton;

                // Elegir primeros cantidadNumerosCarton de la lista de bolillas del bolillero

                //Console.WriteLine("Los primeros {0} números del carton: ", cantidadNumerosCarton);
                List<int> numerosSeteoCarton = new List<int>();
                numerosSeteoCarton = listaBolillasCarton.Take(cantidadNumerosCarton).ToList();
                numerosSeteoCarton.Sort(); //Ordenar la lista en orden ascendente

                //Crear matriz cartonFinal
                int x = cantidadFilasCarton;
                int y = cantidadColumnasCarton;
                int[,] cartonFinal = new int[x, y];

                //Recorrer la matriz de izquierda a derecha y de arriba hacia abajo
                Console.WriteLine("Carton {0} :", contador + 1);
                for (int j = 0; j < y; j++)
                {
                    for (int i = 0; i < x; i++)
                    {
                        // Buscar el valor mínimo en la lista de números del cartón que aún no se ha agregado a la matriz
                        int valorMinimo = numerosSeteoCarton.Where(n => !cartonFinal.Cast<int>().Contains(n)).Min();

                        // Asignar el valor mínimo a la posición correspondiente en la matriz
                        cartonFinal[i, j] = valorMinimo;
                    }
                }

                //Imprimir la matriz resultante
                for (int i = 0; i < x; i++)
                {
                    for (int j = 0; j < y; j++)
                    {
                        Console.Write(cartonFinal[i, j] + "\t");
                    }
                    Console.WriteLine();
                }
                Console.ReadLine();
            }
            return listaBolillasCarton;
        }
    }
}
