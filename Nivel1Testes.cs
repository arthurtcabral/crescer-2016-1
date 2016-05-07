﻿using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MegamanLista1;
using System.Diagnostics;

namespace MegamanNivel1Testes
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void GerarToString()
        {
            var megaman = new Megaman();
            Debug.WriteLine(megaman.ToString());

            var protoman = new Protoman();
            Debug.WriteLine(protoman.ToString());

            var bot = new Bot();
            Debug.WriteLine(bot.ToString());
        }

        [TestMethod]
        public void ToStringRetornaString()
        {
            var megaman = new Megaman();
            Assert.AreEqual(true, megaman.ToString().GetType() == typeof(string));

            var protoman = new Protoman();
            Assert.AreEqual(true, protoman.ToString().GetType() == typeof(string));

            var bot = new Bot();
            Assert.AreEqual(true, bot.ToString().GetType() == typeof(string));
        }

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
            megaman.Vida = 25;
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
            protoman.Vida = 4;
            megaman.Atacar(protoman);
            Assert.AreEqual(20, protoman.Vida);
        }

        [TestMethod]
        public void ProtomanSoGanha20DeVidaUmaVez()
        {
            var megaman = new Megaman();
            var protoman = new Protoman();
            protoman.Vida = 4;
            megaman.Atacar(protoman);
            Assert.AreEqual(20, protoman.Vida);
            protoman.Vida = 1;
            megaman.Atacar(protoman);
            Assert.AreEqual(-3, protoman.Vida);
        }

    }
}
