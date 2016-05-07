using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegamanLista1
{
    public class Megaman : Robo
    {
        public Megaman() : base(6, 0)
        { 
        }

        public override string Nome
        {
            get
            {
                return "Megaman";
            }
        }

        public override void Atacar(Robo robo)
        {
            if (Vida < 30)
            {
                robo.Vida = robo.Vida - 3;
                base.Atacar(robo);
            }
            else
            {
                base.Atacar(robo);
            }
        }

    }
}
