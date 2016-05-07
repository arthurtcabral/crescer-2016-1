using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegamanLista1
{
    public abstract class Robo
    {
        private int vida = 100;
        private int ataque = 5;
        private int defesa = 0;
        private int contadorMortesProtoman = 0;

        public Robo(int ataque, int defesa)
        {
            this.ataque = ataque;
            this.defesa = defesa;
        }

        public abstract string Nome { get; }
        public virtual int Vida
        {
            get
            {
                return this.vida;
            }
            set
            {
                vida = value;
            }
        } 
        protected virtual int Ataque
        {
            get
            {
                return ataque;
            }
        }
        protected virtual int Defesa
        {
            get
            {
                return defesa;
            }
        }
        public virtual void Atacar(Robo robo)
        {
            robo.vida = robo.vida - (ataque - robo.defesa);
            Boolean protomanMorreu = robo.Nome.Equals("Protoman") && robo.Vida <= 0;
            Boolean protomanAindaNaoHaviaMorrido = contadorMortesProtoman == 0;
            if (protomanMorreu && protomanAindaNaoHaviaMorrido)
            {
                contadorMortesProtoman++;
                robo.vida = 20;
            }
        }
        public virtual string ToString()
        {
         
         return "Nome: " + Nome + ", Vida: " + Vida + ", Ataque: +" + Ataque + ", Defesa: " + Defesa;
            
        }
    }
}
