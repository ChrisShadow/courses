using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BingoGeneral
{
    internal class Program
    {
        static void Main(string[] args)
        {
      
            //BOLILLERO
            Bolillero bolillero = new Bolillero();
            bolillero.PedirCantidadBolillas();
            bolillero.CrearListaBolillas();
            //bolillero.ImprimirBolillero();

            // SORTEO
            Sorteo sorteo = new Sorteo();
            sorteo.PedirCantidadSorteoBolillas();
            
            // CARTON
            //Construir carton
            Carton carton = new Carton();
            carton.ConstruirCarton();
            carton.CrearCarton();
            
         
            //PREMIO
            Premio premio = new Premio();
           premio.CrearPremio();
        
          /*  Bolillero bolillero = new Bolillero();
            bolillero.PedirCantidadBolillas();
            bolillero.CrearListaBolillas();
            bolillero.ImprimirBolillero();
            Console.ReadLine();
          */


         

            
        }
    }
}
