using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Herencia
{
    class Pers2
    {
        public string Name { get; set; }
        public int Age { get; set; }

        public Pers2(string n, int a)
        {
            Name = n;
            Age = a;
        }
        public override bool Equals(object obj)
        {
            if (obj == null)
            {
                return false;
            }
            Pers2 p = obj as Pers2;
            if (p == null)
            {
                return false;
            }
            return (this.Name == p.Name) && (this.Age == p.Age);
        }

        public override int GetHashCode()
        {
            int hash = 17;
            hash = (hash * 7) + Name.GetHashCode();
            hash = (hash * 7) + Age.GetHashCode();
            return hash;
        }
    }
}
