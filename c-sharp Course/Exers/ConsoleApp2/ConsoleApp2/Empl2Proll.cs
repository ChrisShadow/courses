using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Herencia
{
    class Empl2Proll : Emp2
    {
        public decimal baseIncome { get; set; }
        public override decimal Income
        {
            get { return baseIncome; }
        }
        public Empl2Proll(string n, string ch, decimal bI) : base(n, ch)
        {
            baseIncome = bI;
        }
        public override void Workin()
        {
            Console.WriteLine("At work by Payroll...");
        }
    }
}
