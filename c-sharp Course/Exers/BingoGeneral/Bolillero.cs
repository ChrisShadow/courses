using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BingoGeneral
{
    internal class Bolillero
    {
        public int cantidadBolillas { get; set; }
        public List<int> listaBolillero { get; set; }




        //Pedir cantidad de Bolillas
        public void PedirCantidadBolillas()
        {
            bool cantidadBolillasEsNumero = false;
            do
            {
                Console.WriteLine("Cantidad de bolillas: ");
                string cantidadBolillasString = Console.ReadLine();
                cantidadBolillasEsNumero = int.TryParse(cantidadBolillasString, out int cantidadBolillasInt);
                if (!cantidadBolillasEsNumero)//|| cantidadBolillasInt<=0
                {
                    Console.WriteLine("Error: La cantidad de bolillas debe ser un número entero diferente de 0.");
                }
                cantidadBolillas = cantidadBolillasInt;
            }
            while (!cantidadBolillasEsNumero);//true

        }

        /// <summary>
        /// Crea lista de bolillas dentro del bolillero Random
        /// </summary>
        /// <returns> lista bolillas random</returns>
        //Crear lista de Bolillas        
        public List<int> CrearListaBolillas() //Crea lista de bolillas ordenadas al azar
        {
            listaBolillero = new List<int>();

            for (int i = 1; i < cantidadBolillas; i++)
            {
                listaBolillero.Add(i);
            }
            Random rand = new Random();
            listaBolillero = listaBolillero.OrderBy(a => rand.Next()).ToList();
            return listaBolillero;

        }

        //Imprimir Bolillas
        public List<int> ImprimirBolillero()
        {
            Console.WriteLine("Las Bolillas son: ");
            foreach (int k in listaBolillero)
            {
                Console.WriteLine(k);
            }
            return listaBolillero;
        }
    }
}
