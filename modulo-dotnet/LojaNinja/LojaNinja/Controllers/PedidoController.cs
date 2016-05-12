using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using LojaNinja.Models;

namespace LojaNinja.Controllers
{
    public class PedidoController : Controller
    {
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

        public ActionResult Detalhes(PedidoModel pedido)
        {
            return View(pedido);
        }
    }
}