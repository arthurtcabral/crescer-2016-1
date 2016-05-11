using MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC.Controllers
{
    public class StreetFighterController : Controller
    {        
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult FichaTecnica()
        {
            return View();
        }
        public ActionResult SobreMim()
        {
            var arthur = new SobreMimModel();
            arthur.altura = 1.91;
            arthur.peso = 85;
            arthur.medidas = "O que importa é que sou alto e magro.";
            return View(arthur);
        }
    }
}