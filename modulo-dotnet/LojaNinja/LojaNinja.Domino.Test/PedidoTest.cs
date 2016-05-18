using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LojaNinjaEF.Dominio;

namespace LojaNinjaEF.Domino.Test
{
    [TestClass]
    public class PedidoTest
    {
        [TestMethod]
        public void ConstrutorDePedidosNovos()
        {
            DateTime d = new DateTime(2016, 05, 25);

            var pedido = new Pedido(
                d,
                "Apito",
                2,
                TipoPagamento.AMEX,
                "Julia",
                "Esteio",
                "RS"
                );
            Assert.IsTrue(pedido.DataEntregaDesejada == d);
            Assert.IsTrue(pedido.NomeProduto.Equals("Apito"));
            Assert.IsTrue(pedido.TipoPagamento == TipoPagamento.AMEX);
            Assert.IsTrue(pedido.NomeCliente.Equals("Julia"));
            Assert.IsTrue(pedido.Cidade.Equals("Esteio"));
            Assert.IsTrue(pedido.Estado.Equals("RS"));
        }

        [TestMethod]
        public void ConstrutorUtilizadoParaAtualizarALista()
        {
            DateTime d = new DateTime(2016, 05, 25);

            var pedido = new Pedido(
                1,
                d,
                "Apito",
                2,
                TipoPagamento.AMEX,
                "Julia",
                "Esteio",
                "RS"
                );
            Assert.AreEqual(pedido.Id, 1);
            Assert.IsTrue(pedido.DataEntregaDesejada == d);
            Assert.IsTrue(pedido.NomeProduto.Equals("Apito"));
            Assert.IsTrue(pedido.TipoPagamento == TipoPagamento.AMEX);
            Assert.IsTrue(pedido.NomeCliente.Equals("Julia"));
            Assert.IsTrue(pedido.Cidade.Equals("Esteio"));
            Assert.IsTrue(pedido.Estado.Equals("RS"));
        }

        [TestMethod]
        public void ConstrutorUtiizadoParaMontarPedidosRecuperadosDoRepositorio()
        {
            DateTime d = new DateTime(2016, 05, 25);
            DateTime d2 = new DateTime(2001, 1, 1);

            var pedido = new Pedido(
                1,
                d2,
                d,
                "Apito",
                2,
                TipoPagamento.AMEX,
                "Julia",
                "Esteio",
                "RS",
                true
                );
            Assert.AreEqual(pedido.Id, 1);
            Assert.AreEqual(pedido.DataPedido, d2);
            Assert.IsTrue(pedido.DataEntregaDesejada == d);
            Assert.IsTrue(pedido.NomeProduto.Equals("Apito"));
            Assert.IsTrue(pedido.TipoPagamento == TipoPagamento.AMEX);
            Assert.IsTrue(pedido.NomeCliente.Equals("Julia"));
            Assert.IsTrue(pedido.Cidade.Equals("Esteio"));
            Assert.IsTrue(pedido.Estado.Equals("RS"));
            Assert.IsTrue(pedido.PedidoUrgente == true);
        }

        [TestMethod]
        public void PedidoDeveSerUrgenteSeADataDeEntregaForEmMenosDe7Dias()
        {
            DateTime d = new DateTime(2016, 05, 18);

            var pedido = new Pedido(
                d,
                "Apito",
                2,
                TipoPagamento.AMEX,
                "Julia",
                "Esteio",
                "RS"
                );
            Assert.IsTrue(pedido.PedidoUrgente == true);
        }

        [TestMethod]
        public void PedidoNaoDeveSerUrgenteSeADataDeEntregaForEmMaisDe7Dias()
        {
            DateTime d = new DateTime(2016, 06, 18);

            var pedido = new Pedido(
                d,
                "Apito",
                2,
                TipoPagamento.AMEX,
                "Julia",
                "Esteio",
                "RS"
                );
            Assert.IsTrue(pedido.PedidoUrgente == false);
        }
    }
}
