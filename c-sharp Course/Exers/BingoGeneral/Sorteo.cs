using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BingoGeneral
{
    internal class Sorteo
    {
        public int cantidadExtraccionBolilla { get; set; }

        //Pedir Cantidad de bolillas a extraer en el sorteo

        public void PedirCantidadSorteoBolillas()
        {
            do
            {
                Console.WriteLine("¿Cuántas bolillas se extran como sorteo?");
                Bolillero cantidadElementosEnBolillero = new Bolillero();
                string cantidadBolillasSorteoString = Console.ReadLine();
                bool cantidadBolillasSorteoStringEsNumero = cantidadBolillasSorteoStringEsNumero = int.TryParse(cantidadBolillasSorteoString, out int cantidadExtraccionBolillaInt);
                if (!cantidadBolillasSorteoStringEsNumero || cantidadExtraccionBolillaInt <= 0)
                {
                    Console.WriteLine("Error: La cantidad de bolillas a extraer debe ser un número entero.");
                    continue;
                }
                cantidadExtraccionBolilla = cantidadExtraccionBolillaInt;
                break;
            }
            while (true);
        }
    }
}
