using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegamanLista1
{
    public class Protoman : Robo
    {

        private int contadorMortesProtoman = 0;
        private int bonusAtaqueProtomanPorMorrer = 0;
        public override string Nome
        {
            get
            {
                return "Protoman";
            }
        }

        private int ataque;
        private int defesa;
        protected override int Ataque
        {
            get
            {
                return 5;
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
                return 2;
            }
            set
            {
                defesa = value;
            }
        }
        public virtual void Atacar(Robo robo)
        {
            robo.ReceberAtaque(this.Ataque + UpgradeBonusParaAtacar + bonusAtaqueProtomanPorMorrer);
        }
        public override void ReceberAtaque(int ataque)
        {
            Boolean protomanMorreu = this.Vida <= 0;
            Boolean protomanAindaNaoHaviaMorrido = contadorMortesProtoman == 0;
            int dano = ataque - (this.Defesa + UpgradeBonusParaDefender);
            this.Vida -= dano;
            if (protomanMorreu && protomanAindaNaoHaviaMorrido)
            {
                this.Vida = 20;
                this.bonusAtaqueProtomanPorMorrer = 2;
                contadorMortesProtoman++;
            }
        }
    }
}
