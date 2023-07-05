using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Herencia
{
    abstract class Emp2
    {
        public string Name{get;set;}
        public string Charge { get; set; }
        public abstract decimal Income { get; }

        
        public Emp2(string name, string charge)
        {
            Name = name;
            Charge = charge;    
        }

        public void Salute()
        {
            Console.WriteLine("Hi, my name is {0} and my charge is {1}", Name, Charge);
        }

        public abstract void Workin(); // Sin implimentación

    }
}
