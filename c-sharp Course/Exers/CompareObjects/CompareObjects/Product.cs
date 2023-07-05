using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CompareObjects
{
    class Product : IComparable<Product>
    {
        public string Code { get; set; }
        public decimal Price { get; set; }
        
        public Product() { }

        public Product(string code, decimal price)
        {
            Code = code;
            Price = price;
        }

        public override string ToString()
        {
            return string.Format("Code:{0},\nPrice:{1}",Code,Price);
        }

        public int CompareTo(Product other)
        {
            //>0 mayor, ==0 igual,<0menor
            if (this.Price > other.Price) return 1;
            if (this.Price == other.Price) return 0;
            return -1; 
        }

    }
}
