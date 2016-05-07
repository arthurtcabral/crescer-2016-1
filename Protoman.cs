using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegamanLista1
{
    public class Protoman : Robo
    {
        public Protoman() : base(5, 2)
        {
        }

        public override string Nome
        {
            get
            {
                return "Protoman";
            }
        }            
    }
}
