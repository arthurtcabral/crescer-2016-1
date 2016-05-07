using System;

namespace MegamanLista1
{
    public abstract class Robo
    {
        private int contadorUpgrades = 0;
        public abstract string Nome { get; }
        public virtual int Vida { get; protected set; }

        public virtual int UpgradeBonusParaAtacar { get; protected set; } 
        public virtual int UpgradeBonusParaDefender { get; protected set; }

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

        public virtual void EquiparUpgrade(IUpgrade upgrade)
        {
            Boolean ECanhaoDePlasma = upgrade.GetType() == typeof(CanhaoDePlasma);
            Boolean EEscudoDeEnergia = upgrade.GetType() == typeof(EscudoDeEnergia);
            Boolean EBotasDeSuperVelocidade = upgrade.GetType() == typeof(BotasDeSuperVelocidade);
            Boolean PossuiMenosDe3Upgrades = contadorUpgrades < 3;
            if (PossuiMenosDe3Upgrades)
            {
                if (ECanhaoDePlasma || EEscudoDeEnergia || EBotasDeSuperVelocidade)
                {
                    UpgradeBonusParaAtacar = UpgradeBonusParaAtacar + upgrade.BonusAtaque;
                    UpgradeBonusParaDefender = UpgradeBonusParaDefender + upgrade.BonusDefesa;
                }
                contadorUpgrades++;
            }
            
        }

        public virtual void Atacar(Robo robo)
        {
            robo.ReceberAtaque(this.Ataque + UpgradeBonusParaAtacar);
        }

        public virtual void ReceberAtaque(int ataque)
        {
            int dano = ataque - (this.Defesa + UpgradeBonusParaDefender);
            this.Vida -= dano;
        }

        public virtual string ToString()
        {
         
         return "Nome: " + Nome + ", Vida: " + Vida + ", Ataque: +" + Ataque + ", Defesa: " + Defesa;
            
        }
    }
}
