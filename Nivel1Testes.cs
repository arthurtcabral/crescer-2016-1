using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MegamanLista1;
using System.Diagnostics;

namespace MegamanNivel1Testes
{
    [TestClass]
    public class Nivel1Testes
    {
        public IUpgrade CanhaoDePlasma { get; }

        [TestMethod]
        public void MegamanDeveTerMegamanComoNome()
        {
            var megaman = new Megaman();
            Assert.AreEqual("Megaman", megaman.Nome);
        }

        [TestMethod]
        public void ProtomanDeveTerProtomanComoNome()
        {
            var protoman = new Protoman();
            Assert.AreEqual("Protoman", protoman.Nome);
        }

        [TestMethod]
        public void BotDeveTerBotComoNome()
        {
            var bot = new Bot();
            Assert.AreEqual("Bot", bot.Nome);
        }

        [TestMethod]
        public void TodosCom100DeVidaNoInicio()
        {
            var megaman = new Megaman();
            Assert.AreEqual(100, megaman.Vida);

            var protoman = new Protoman();
            Assert.AreEqual(100, protoman.Vida);

            var bot = new Bot();
            Assert.AreEqual(100, bot.Vida);
        }

        [TestMethod]
        public void MegamanTira6DeVidaDoBot()
        {
            var megaman = new Megaman();
            var bot = new Bot();
            megaman.Atacar(bot);
            Assert.AreEqual(94, bot.Vida);
        }

        [TestMethod]
        public void MegamanGanha3DeBonusComMenosDe30DeVida()
        {
            var megaman = new Megaman();
            var bot = new Bot();
            for(var i = 0; i < 15; i++)
            {
               bot.Atacar(megaman);
            }
            megaman.Atacar(bot);
            Assert.AreEqual(91, bot.Vida);
            
        }

        [TestMethod]
        public void ProtomanTambemAtaca()
        {
            var protoman = new Protoman();
            var megaman = new Megaman();
            var bot = new Bot();
            protoman.Atacar(bot);
            Assert.AreEqual(95, bot.Vida);
            protoman.Atacar(megaman);
            Assert.AreEqual(95, megaman.Vida);
        }

        [TestMethod]
        public void BotTambemAtaca()
        {
            var megaman = new Megaman();
            var bot = new Bot();
            bot.Atacar(megaman);
            Assert.AreEqual(95, megaman.Vida);
        }

        [TestMethod]
        public void ProtomanRecebeMenosDano()
        {
            var protoman = new Protoman();
            var bot = new Bot();
            bot.Atacar(protoman);
            Assert.AreEqual(97, protoman.Vida);
        }

        [TestMethod]
        public void MegamanDeixaProtomanCom96DeVida()
        {
            var megaman = new Megaman();
            var protoman = new Protoman();
            megaman.Atacar(protoman);
            Assert.AreEqual(96, protoman.Vida);
        }

        [TestMethod]
        public void ProtomanGanha20DeVidaAoMorrer()
        {
            var megaman = new Megaman();
            var protoman = new Protoman();
            for (var i = 0; i < 25; i++)
            {
                megaman.Atacar(protoman);
            }
            megaman.Atacar(protoman);
            Assert.AreEqual(20, protoman.Vida);
        }

        [TestMethod]
        public void ProtomanSoGanha20DeVidaUmaVez()
        {
            var megaman = new Megaman();
            var protoman = new Protoman();
            for (var i = 0; i < 25; i++)
            {
                megaman.Atacar(protoman);
            }
            megaman.Atacar(protoman);
            Assert.AreEqual(20, protoman.Vida);
            for (var i = 0; i < 5; i++)
            {
                megaman.Atacar(protoman);
            }
            megaman.Atacar(protoman);
            Assert.AreEqual(-4, protoman.Vida);
        }

        [TestMethod]
        public void ProtomanGanha7DeAtaqueAoMorrer()
        {
            var megaman = new Megaman();
            var protoman = new Protoman();
            for (var i = 0; i < 25; i++)
            {
                megaman.Atacar(protoman);
            }
            megaman.Atacar(protoman);
            protoman.Atacar(megaman);
            Assert.AreEqual(93, megaman.Vida);
        }

        [TestMethod]
        public void CanhaoDePlasmaDaBonusDe2ParaAtaque()
        {
            IUpgrade iup = new CanhaoDePlasma();
            Assert.AreEqual(2, iup.BonusAtaque);
            Assert.AreEqual(0, iup.BonusDefesa);
        }

        [TestMethod]
        public void EscudoDeEnergiaDaBonusDe2ParaDefesa()
        {
            IUpgrade iup = new EscudoDeEnergia();
            Assert.AreEqual(0, iup.BonusAtaque);
            Assert.AreEqual(2, iup.BonusDefesa);
        }

        [TestMethod]
        public void BotasDeSuperVelocidadeDaBonusDe1ParaAtaqueEDe1ParaDefesa()
        {
            IUpgrade iup = new BotasDeSuperVelocidade();
            Assert.AreEqual(1, iup.BonusAtaque);
            Assert.AreEqual(1, iup.BonusDefesa);
        }

        [TestMethod]
        public void MegamanUsaCanhaoDePlasma()
        {
            IUpgrade iup1 = new CanhaoDePlasma();
            var megaman = new Megaman();
            var bot = new Bot();

            megaman.EquiparUpgrade(iup1);
            megaman.Atacar(bot);
            Assert.AreEqual(92, bot.Vida);
        }

        [TestMethod]
        public void MegamanUsaEscudoDeEnergia()
        {
            IUpgrade iup1 = new EscudoDeEnergia();
            var megaman = new Megaman();
            var bot = new Bot();

            megaman.EquiparUpgrade(iup1);
            bot.Atacar(megaman);
            Assert.AreEqual(97, megaman.Vida);
        }

        [TestMethod]
        public void MegamanUsaBotasDeSuperVelocidade()
        {
            IUpgrade iup1 = new BotasDeSuperVelocidade();
            var megaman = new Megaman();
            var bot = new Bot();

            megaman.EquiparUpgrade(iup1);
            megaman.Atacar(bot);
            Assert.AreEqual(93, bot.Vida);
            bot.Atacar(megaman);
            Assert.AreEqual(96, megaman.Vida);
        }
        
        [TestMethod]
        public void MegamanUsaTudo()
        {
            IUpgrade iup1 = new CanhaoDePlasma();
            IUpgrade iup2 = new EscudoDeEnergia();
            IUpgrade iup3 = new BotasDeSuperVelocidade();
            var megaman = new Megaman();
            var bot = new Bot();

            megaman.EquiparUpgrade(iup1);
            megaman.EquiparUpgrade(iup2);
            megaman.EquiparUpgrade(iup3);
            megaman.Atacar(bot);
            Assert.AreEqual(91, bot.Vida);
            bot.Atacar(megaman);
            Assert.AreEqual(98, megaman.Vida);
        }

        [TestMethod]
        public void RobosNaoPodemUsarMaisDe3Upgrades()
        {
            IUpgrade iup1 = new CanhaoDePlasma();
            IUpgrade iup2 = new EscudoDeEnergia();
            IUpgrade iup3 = new BotasDeSuperVelocidade();
            IUpgrade iup4 = new CanhaoDePlasma();
            var megaman = new Megaman();
            var bot = new Bot();

            megaman.EquiparUpgrade(iup1);
            megaman.EquiparUpgrade(iup2);
            megaman.EquiparUpgrade(iup3);
            megaman.EquiparUpgrade(iup4); // Esse Upgrade não vai alterar o resultado. Resultado igual ao do teste anterior
            megaman.Atacar(bot);
            Assert.AreEqual(91, bot.Vida);
            bot.Atacar(megaman);
            Assert.AreEqual(98, megaman.Vida);
        }

        [TestMethod]
        public void ProtomanUsaCanhaoDePlasma()
        {
            IUpgrade iup1 = new CanhaoDePlasma();
            var megaman = new Protoman();
            var bot = new Bot();

            megaman.EquiparUpgrade(iup1);
            megaman.Atacar(bot);
            Assert.AreEqual(93, bot.Vida);
        }

        [TestMethod]
        public void ProtomanUsaEscudoDeEnergia()
        {
            IUpgrade iup1 = new EscudoDeEnergia();
            var megaman = new Protoman();
            var bot = new Bot();

            megaman.EquiparUpgrade(iup1);
            bot.Atacar(megaman);
            Assert.AreEqual(99, megaman.Vida);
        }

        [TestMethod]
        public void ProtomanUsaBotasDeSuperVelocidade()
        {
            IUpgrade iup1 = new BotasDeSuperVelocidade();
            var megaman = new Protoman();
            var bot = new Bot();

            megaman.EquiparUpgrade(iup1);
            megaman.Atacar(bot);
            Assert.AreEqual(94, bot.Vida);
            bot.Atacar(megaman);
            Assert.AreEqual(98, megaman.Vida);
        }

        [TestMethod]
        public void ProtomanUsaTudo()
        {
            IUpgrade iup1 = new CanhaoDePlasma();
            IUpgrade iup2 = new EscudoDeEnergia();
            IUpgrade iup3 = new BotasDeSuperVelocidade();
            var megaman = new Protoman();
            var bot = new Bot();

            megaman.EquiparUpgrade(iup1);
            megaman.EquiparUpgrade(iup2);
            megaman.EquiparUpgrade(iup3);
            megaman.Atacar(bot);
            Assert.AreEqual(92, bot.Vida);
            bot.Atacar(megaman);
            Assert.AreEqual(100, megaman.Vida);
        }
        [TestMethod]
        public void ContadorDeUpgradesSaoUnicosParaCadaTipoDeRobo()
        {
            IUpgrade iup1 = new CanhaoDePlasma();
            IUpgrade iup2 = new EscudoDeEnergia();
            IUpgrade iup3 = new BotasDeSuperVelocidade();
            IUpgrade iup4 = new BotasDeSuperVelocidade();
            var protoman = new Protoman();
            var bot = new Bot();

            protoman.EquiparUpgrade(iup1);
            protoman.EquiparUpgrade(iup2);
            protoman.EquiparUpgrade(iup3);
            bot.EquiparUpgrade(iup4);
            protoman.Atacar(bot);
            Assert.AreEqual(93, bot.Vida);
            bot.Atacar(protoman);
            Assert.AreEqual(99, protoman.Vida);
        }
    }
}

