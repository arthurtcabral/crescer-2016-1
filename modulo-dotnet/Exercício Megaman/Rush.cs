using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegamanLista1
{
    public class Rush : Robo, IUpgrade
    {
        public int BonusAtaque
        {
            get
            {
                return Ataque + UpgradeBonusParaAtacar;
            }
        }

        public int BonusDefesa
        {
            get
            {
                return Defesa;
            }
        }

        public override string Nome
        {
            get
            {
                return "Rush";
            }
        }

        private int ataque;
        private int defesa;
        protected override int Ataque
        {
            get
            {
                return 4;
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
                return 3;
            }
            set
            {
                defesa = value;
            }
        }
        public override void EquiparUpgrade(IUpgrade upgrade)
        {
            Boolean RushPossuiMenosDe2Upgrades = contadorUpgrades < 2;
            if (RushPossuiMenosDe2Upgrades)
            {
                UpgradeBonusParaAtacar = UpgradeBonusParaAtacar + upgrade.BonusAtaque;
                UpgradeBonusParaDefender = UpgradeBonusParaDefender + upgrade.BonusDefesa;
                contadorUpgrades++;
            }
        }
    }
}
