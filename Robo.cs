using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegamanLista1
{
    public abstract class Robo
    {
        
        public abstract string Nome { get; }
        public virtual int Vida { get; protected set; }

        public Robo()
        {
            Vida = 100;
        }

        protected virtual int Ataque
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
        protected virtual int Defesa
        {
            get
            {
                return 0;
            }
            set
            {
                Defesa = value;
            }
        }
        public virtual void Atacar(Robo robo)
        {
            robo.ReceberAtaque(this.Ataque);
        }

        public virtual void ReceberAtaque(int ataque)
        {
            int dano = ataque - this.Defesa;
            this.Vida -= dano;
        }

        public virtual string ToString()
        {
         
         return "Nome: " + Nome + ", Vida: " + Vida + ", Ataque: +" + Ataque + ", Defesa: " + Defesa;
            
        }
    }
}
