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
            arthur.PrimeiraAparicao = "Hospital Moinhos de Vento.";
            arthur.Nascimento = "25 de setembro de 1996.";
            arthur.Altura = 1.91;
            arthur.Peso = 85;
            arthur.Medidas = "O que importa é que sou alto e magro.";
            arthur.TipoSanguineo = "Um que os mosquitos gostam.";
            arthur.Habilidades = "Estudar.";
            arthur.Gosta = "Família, amigos, Inter, Subway";
            arthur.Desgosta = "Ver que a térmica está virada.";
            arthur.EstiloDeLuta = "#SemViolencia";
            arthur.Origem = "Rio Grande do Sul, Tchê.";
            arthur.FalaDeVitoria = "Copei!";
            arthur.Nick1 = "CRCH25";
            arthur.Nick2 = "boaarthur";
            arthur.Nick3 = "Woody";
            arthur.Stage1 = "Esteio - Cidade Maravilhosa, Brasil (Local randômico).";
            arthur.Stage2 = "Esteio (Esteio).";
            arthur.Golpes = "Corte de calcanhar, Chute de três dedos.";
            return View(arthur);
        }
    }
}