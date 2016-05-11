using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC.Controllers
{
    public class DesafioController : Controller
    {

        public ActionResult DesafioAnime(string aluno)
        {
            ViewBag.Path = ("~/Content/Estilos/" + aluno + ".css");
            return View();
        }
    }
}