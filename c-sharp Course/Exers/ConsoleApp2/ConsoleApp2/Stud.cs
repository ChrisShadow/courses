using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Herencia
{
    class Stud : Pers
    {
        public double Average { get; set; }
        public string Semester { get; set; }

        public Stud(string name, int age, double aver, string semester):base(name, age)
        {
            Average = aver;
            Semester = semester;
        }
        public override void Salute()
        {
            Console.WriteLine("Hi, my name is {0} and I am currently {1} semester", Name, Semester);
        }

        public override string ToString()
        {
            return string.Format("Hey, it's {0} talking, I'm {1} years old, my current semester is {2} and I have {3} as average. ", Name, Age, Semester, Average);
        }

        public void Studin()
        {
            Console.WriteLine("{0} is studing 5 hours every day... ", Name);
        }

        public void GoinClass()
        {
            Console.WriteLine("{0} goes to class every day from 6:00 pm to 10:00 pm except Wednesday... ", Name);
        }
    }
}
