using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Herencia
{
    class Pers
    {
        public string Name { get; set; }
        public int Age { get; set; }

        public Pers() { }

        public Pers(string nam, int a)
        {
            Name = nam;
            Age = a;
        }

        public virtual void Salute() { //modificable por la subclase
            Console.WriteLine("Hello, mi name is {0}", Name);
        }

        public override string ToString()
        {
            return string.Format("{0},{1} years old", Name,Age);
        }

    }
}
