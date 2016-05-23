using CdZ.Dominio;
using CdZ.MVC.Extensions;
using CdZ.MVC.Filters;
using CdZ.MVC.Models.Cavaleiro;
using CdZ.MVC.Services;
using System.Net;
using System.Web.Mvc;

namespace CdZ.MVC.Controllers
{
    [CdZAutorizador]
    public class CavaleiroController : Controller
    {
        private ICavaleiroRepositorio _cavaleiros = ServicoInjecaoDeDependecia.CriarCavaleiroRepositorio();

        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public JsonResult Get()
        {
            return Json(new { data = _cavaleiros.Paginacao().FromModel() }, JsonRequestBehavior.AllowGet);
        }

        [HttpGet]
        [ActionName("GetById")]
        public JsonResult Get(int? id)
        {
            return Json(new { data = _cavaleiros.Buscar(id.Value).FromModel() }, JsonRequestBehavior.AllowGet);
        }
        
        [HttpPost]
        public JsonResult Post(CavaleiroViewModel cavaleiro)
        {
            var novoId = _cavaleiros.Adicionar(cavaleiro.ToModel());
            Response.StatusCode = (int)HttpStatusCode.Created;
            return Json(new { id = novoId });
        }

        [HttpDelete]
        public JsonResult Delete(int id)
        {
            _cavaleiros.Excluir(id);
            return NoContentJsonVazio();
            // OU retornar a lista atualizada de todos cavaleiros
            // return Json(new { data = _cavaleiros.Todos() });
        }

        [HttpPut]
        public JsonResult Put(CavaleiroViewModel cavaleiro)
        {
            _cavaleiros.Atualizar(cavaleiro.ToModel());
            return NoContentJsonVazio();
        }

        private JsonResult NoContentJsonVazio()
        {
            Response.StatusCode = (int)HttpStatusCode.NoContent;
            return Json(new { });
        }
    }
}