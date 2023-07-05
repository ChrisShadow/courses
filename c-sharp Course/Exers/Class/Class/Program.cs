using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Prueba1
{
    class Class1
    {
        public void Method1()
        {
            Console.WriteLine("Dentro de Class1");
        }
    }
}

namespace Prueba2
{
    class Class2
    {
        public void Method2()
        {
            Console.WriteLine("Dentro de Class2");
        }
    }
}



namespace Class
{
    class Program
    {
        static void Main(string[] args)
        {
            //Clase Rectángulo
            /*Console.WriteLine("Clase Rectángulo");
            Rec rec = new Rec();
            Rec rec2 = new Rec { Base = 6, Height = 4 };
            rec.Base = 10;
            rec.Height = 5;

            int area = rec.CalcularArea();
            int area2 = rec2.CalcularArea();
            Console.WriteLine("Medidas del rectángulo 1: {0}x{1}, el área es: {2}", rec.Base, rec.Height, area);
            Console.WriteLine("Medidas del rectángulo 2: {0}x{1}, el área es: {2}", rec2.Base, rec2.Height, area2);*/

            //Clase cuenta bancaria
            /*Console.WriteLine("Clase cuenta bancaria");
            CuentaBancaria cuenta = new CuentaBancaria("001");
            cuenta.Saldo = -100;
            Console.WriteLine("Primer Saldo asignado: {0}", cuenta.Saldo);
            cuenta.Saldo = 1000;
            Console.WriteLine("Segundo Saldo asignado: {0}", cuenta.Saldo);
            Console.WriteLine("Nro Cuenta: {0},Usuario: {1},Saldo: {2}", cuenta.NroCuenta,
                cuenta.Usuario, cuenta.Saldo);
            CuentaBancaria cuenta2 = new CuentaBancaria("002", "Marcos Gaona");
            Console.WriteLine("Nro Cuenta: {0},Usuario: {1},Saldo: {2}", cuenta2.NroCuenta,
                cuenta2.Usuario, cuenta2.Saldo);
            CuentaBancaria cuenta3 = new CuentaBancaria("003", "Estela Gaona", 1087);
            Console.WriteLine("Nro Cuenta: {0},Usuario: {1},Saldo: {2}", cuenta3.NroCuenta,
                cuenta3.Usuario, cuenta3.Saldo);
            CuentaBancaria cuenta4 = new CuentaBancaria("004", "Fabiola Gaona", 1097);
            CuentaBancaria.Banco = "BNF";
            Console.WriteLine("Nro Cuenta: {0},Usuario: {1},Saldo: {2}", cuenta4.NroCuenta,
                cuenta4.Usuario, cuenta4.Saldo);
            Console.WriteLine("Depositando 100$ a cuenta de {0} y retirando 50$ de {1}", cuenta3.Usuario,cuenta4.Usuario);
            cuenta3.Depositar(100);
            cuenta4.Retirar(50);
            Console.WriteLine(cuenta3.ToString()+"\n"+cuenta4.ToString());
            
            CuentaBancaria.AsignarBanco("Visión PY");
            Console.WriteLine(cuenta3.ToString() + "\n" + cuenta4.ToString());*/

            /*Persona p = new Persona("Christopher", "Rempel", 11);
            Console.WriteLine(p.ToString());
            p.Saludar();*/

            Prueba1.Class1 obj1 = new Prueba1.Class1();
            Prueba2.Class2 obj2 = new Prueba2.Class2();
            obj1.Method1();
            obj2.Method2();



            //



        }
    }
}
