using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class
{
    class CuentaBancaria
    {
        #region Att
        //automatic property
        public string NroCuenta { get; set; }
        public string Usuario { get; set; }

        //Backing field
        private decimal _saldo;
        //Full property
        public decimal Saldo
        {
            get { return _saldo; }
            set
            {
                //Evitar saldo negativo
                /*if (value < 0)
                {
                    _saldo = 0;
                }
                else
                {
                    _saldo = value;
                }*/
                _saldo = value < 0 ? 0 : value;
            }
        }

        public static string Banco { get; set; }
        #endregion

        #region cosntructores
        public CuentaBancaria(string noCuenta)
        {
            NroCuenta = noCuenta;
        }
        public CuentaBancaria(string noCuenta,string usu):this(noCuenta)
        {
            Usuario = usu;
        }
        public CuentaBancaria(string noCuenta, string usu, decimal saldo):this(noCuenta,usu)
        {
            Saldo = saldo;
        }
        public CuentaBancaria(string noCuenta, string usu, decimal saldo,string banco) : this(noCuenta, usu,saldo)
        {
            Banco=banco;
        }

        public CuentaBancaria() { }
        #endregion

        //vacío, cuando no se definió uno anterior

        #region Funciones
        public void Retirar(decimal cantidad)
        {
            if (cantidad > Saldo)
            {
                Console.WriteLine("Saldo insuficiente");
                return;
            }
            Saldo -= cantidad;
        }
        public void Depositar(decimal cantidad)
        {
            Saldo += cantidad;
        }
        public override string ToString()
        {
            return string.Format("Cuenta actualizada del usuario {0}, con número {1} , saldo {2} y Banco {3}",Usuario,NroCuenta,Saldo,Banco);
        }

        public static void AsignarBanco(string banco)
        {
            Console.WriteLine("Asignando nuevo banco...");
            Banco = banco;
        }
        #endregion
    }
}
