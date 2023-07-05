using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class
{
    class Rec
    {
        public int Base { get; set; }
        public int Height { get; set; }
        
        public int CalcularArea()
        {
            return Base * Height;
        }
    }
}
