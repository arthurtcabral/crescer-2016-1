using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegamanLista1
{
    public class Bot : Robo
    {
        public Bot() : base(5, 0)
        {
        }

        public override string Nome
        {
            get
            {
                return "Bot";
            }
        }
    }
}
