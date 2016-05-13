using LojaNinja.Dominio;
using LojaNinja.MVC.Models;
using LojaNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        private RepositorioVendas repositorio = new RepositorioVendas();

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Cadastro()
        {
            return View();
        }

        public ActionResult RecebeCadastro(PedidoModel pedido)
        {
            return RedirectToAction("Detalhes", pedido);
        }

        public ActionResult Detalhes(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);

            return View(pedido);
        }

        public ActionResult Salvar(PedidoModel model)
        {
            if (model.Estado == "RS" && model.Cidade == "SL")
                ModelState.AddModelError("", "Cidade e Estado inválidos");

            if (model.DataDesejoEntrega.AddDays(-7) < DateTime.Today)
                ModelState.AddModelError("DataEntrega", "Data deve ser maior do que 7 dias");

            if(model.DataDesejoEntrega < DateTime.Today)
                ModelState.AddModelError("DataDesejoEntrega", "Este dia já passou, escolha uma data válida");

            if (ModelState.IsValid)
            {
                try
                {
                    var pedido = new Pedido(
                        model.DataDesejoEntrega,
                        model.NomeProduto,
                        model.ValorVenda,
                        model.TipoDePagamento,
                        model.NomeCliente,
                        model.Cidade,
                        model.Estado);

                    var pedidoFinal = new Pedido(
                        pedido.Id,
                        pedido.DataPedido,
                        pedido.DataEntregaDesejada,
                        pedido.NomeProduto,
                        pedido.Valor,
                        pedido.TipoPagamento,
                        pedido.NomeCliente,
                        pedido.Cidade,
                        pedido.Estado,
                        pedido.PedidoUrgente
                        );
                    //repositorio.IncluirPedido(pedido);
                    

                    return View("Detalhes", pedidoFinal);
                } 
                catch(ArgumentException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                    return View("Cadastro", model);
                }
                
            }
            else
            {
                return View("Cadastro", model);
            }
        }

        public ActionResult Listagem()
        {
            var pedidos = repositorio.ObterPedidos();

            return View(pedidos);
        }
    }
}