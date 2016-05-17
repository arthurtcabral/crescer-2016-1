using LojaNinja.Dominio;
using LojaNinja.Filters;
using LojaNinja.MVC.Models;
using LojaNinja.Repositorio;
using LojaNinja.Services;
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
        private UsuarioServico _usuarioServico;

        public PedidoController()
        {
            _usuarioServico = new UsuarioServico(
                    new UsuarioRepositorioADO()
                );
        }

        [HttpGet]
        public ActionResult Index()
        {
            if (!ServicoDeSessao.EstaLogado)
            {
                return View();
            }

            return RedirectToAction("Cadastro");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(UsuarioLoginModel usuarioLoginModel)
        {
            if (ModelState.IsValid)
            {
                Usuario usuarioEncontrado =
                    _usuarioServico.BuscarUsuarioPorAutenticacao(
                            usuarioLoginModel.Email, usuarioLoginModel.Senha
                        );

                if (usuarioEncontrado != null)
                {
                    var usuarioLogadoModel = new UsuarioLogadoModel(usuarioEncontrado);
                    
                    ServicoDeSessao.CriarSessao(usuarioLogadoModel);
                    return RedirectToAction("Cadastro");
                }
                else
                {
                    ModelState.AddModelError("INVALID_USER", "Usuário ou senha inválido.");
                }
            }

            return View("Index", usuarioLoginModel);
        }

        [HttpGet]
        public ActionResult CadastroUsuario()
        {
            return View("CadastroUsuario");
        }

        [HttpPost]
        public ActionResult SucessoCadastroUsuario(UsuarioLoginModel usuarioLoginModel)
        {

            if (usuarioLoginModel.Senha != usuarioLoginModel.RepitaASenha)
            {
                ModelState.AddModelError("INVALID_PASSWORD", "Senhas não condizem.");
                return RedirectToAction("CadastroUsuario", usuarioLoginModel);
            }
            else if(usuarioLoginModel.Senha.Length < 8)
            {
                ModelState.AddModelError("INVALID_PASSWORD", "Senha deve possuir pelo menos 8 caracteres");
                return RedirectToAction("CadastroUsuario", usuarioLoginModel);
            }
            else
            {
                _usuarioServico.Cadastrar(usuarioLoginModel.Nome, usuarioLoginModel.Email, usuarioLoginModel.Senha);
                ViewBag.MensagemCadastroSucesso = "Cadastrado com sucesso!";
                return View("SucessoCadastroUsuario");
            }
            
        }
                
        [HttpGet]
        [Token(Roles = "ADMIN")]
        public ActionResult AreaSuuuperSecreta()
        {
            return View();
        }
        
        [HttpGet]
        [Token]
        public ActionResult Cadastro(int? id)
        {
            UsuarioLogadoModel usuarioLogado = ServicoDeSessao.UsuarioLogado;
            ViewBag.NomeUsuarioLogado = usuarioLogado.Nome;
            if (id.HasValue)
            {
                var pedido = repositorio.ObterPedidoPorId(id.Value);

                var model = new PedidoModel()
                {
                    Id = pedido.Id,
                    DataDesejoEntrega = pedido.DataEntregaDesejada,
                    NomeProduto = pedido.NomeProduto,
                    ValorVenda = pedido.Valor,
                    TipoDePagamento = pedido.TipoPagamento,
                    NomeCliente = pedido.NomeCliente,
                    Cidade = pedido.Cidade,
                    Estado = pedido.Estado
                }
                ;
                return View("Cadastro", model);
            }
            else
            {
                return View("Cadastro");
            }
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

                if (model.DataDesejoEntrega < DateTime.Today)
                    ModelState.AddModelError("DataDesejoEntrega", "Este dia já passou, escolha uma data válida");

                if (ModelState.IsValid)
                {
                Pedido pedidoAux = null;
                    try
                    {
                    if(model.Id == 0 || model.Id == null)
                    {
                var pedido = new Pedido(
                            model.DataDesejoEntrega,
                            model.NomeProduto,
                            model.ValorVenda,
                            model.TipoDePagamento,
                            model.NomeCliente,
                            model.Cidade,
                            model.Estado);
                        repositorio.IncluirPedido(pedido);
                        pedidoAux = pedido;
                }
                    else
                    {
                        var pedido = new Pedido(
                            (int) model.Id,
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
                        repositorio.AtualizarPedido(pedidoFinal);
                        pedidoAux = pedido;
                    } 
                    }
                    catch (ArgumentException ex)
                    {
                        ModelState.AddModelError("", ex.Message);
                        return View("Cadastro", model);
                    }
                return View("Detalhes", pedidoAux);
            }
                else
                {
                    return View("Cadastro", model);
                }
        }

        public ActionResult Listagem(string cliente, string produto)
        {
            var pedidos = repositorio.ObterPedidoPorFiltro(cliente, produto);
            return View("Listagem", pedidos);
        }

        public ActionResult Excluir(int id)
        {
            repositorio.ExcluirPedido(id);

            ViewBag.MensagemExclusao = "Pedido excluído!";

            return View();
        }
    }
}