using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegamanLista1
{
    public class Megaman : Robo
    {

        public override string Nome
        {
            get
            {
                return "Megaman";
            }
        }

        private int ataque;
        private int defesa;
        protected override int Ataque
        {
            get
            {
                return 6;
            }
            set
            {
                ataque = value;
            }
        }
        protected override int Defesa
        {
            get
            {
                return 0;
            }
            set
            {
                defesa = value;
            }
        }

        public override void Atacar(Robo robo)
        {
            if (Vida < 30)
            {
                robo.ReceberAtaque(this.Ataque + 3 + UpgradeBonusParaAtacar);
            }
            else
            {
                robo.ReceberAtaque(this.Ataque + UpgradeBonusParaAtacar);
            }
        }

        }
    }