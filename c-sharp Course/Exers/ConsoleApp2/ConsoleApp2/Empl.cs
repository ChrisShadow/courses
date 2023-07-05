using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Herencia
{
    class Empl : Pers
    {
        public string Charge { get; set; }
        public decimal Income { get; set; }

        public Empl(string name, int age, string charge, decimal income):base(name, age) {
            Charge = charge;
            Income = income;
        }

        public override void Salute()
        {
            base.Salute();
            Console.WriteLine("Hi, my name is {0} and my charge is {1}", Name, Charge);
        }

        public void Workin()
        {
            Console.WriteLine("{0} is working 5 hours ago... ", Name);
        }
        public override string ToString()
        {
            return string.Format("Hey, it's {0} talking, I'm {1} years old, my current income is {2} $ and I am a {3}. ",Name, Age, Income, Charge);
        }


    }
}
