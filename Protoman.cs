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
        public override string Nome
        {
            get
            {
                return "Protoman";
            }
        }
        protected override int Ataque
        {
            get
            {
                return 5;
            }
            set
            {
                Ataque = value;
            }
        }
        protected override int Defesa
        {
            get
            {
                return 2;
            }
        }
        public override void ReceberAtaque(int ataque)
        {
            Boolean protomanMorreu = this.Vida <= 0;
            Boolean protomanAindaNaoHaviaMorrido = contadorMortesProtoman == 0;
            int dano = ataque - this.Defesa;
            this.Vida -= dano;
            if (protomanMorreu && protomanAindaNaoHaviaMorrido)
            {
                this.Vida = 20;
                this.Ataque = this.Ataque + 2;
                contadorMortesProtoman++;
            }
        }
    }
}
