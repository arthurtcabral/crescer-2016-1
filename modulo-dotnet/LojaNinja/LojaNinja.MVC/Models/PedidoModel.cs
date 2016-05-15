using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models
{
    public class PedidoModel
    {

        public int? Id { get; set; }

        [Display(Name = "Data de entrega ")]
        [Required(ErrorMessage = "Informe a data de entrega.")]
        [DisplayFormat(DataFormatString = "{0:dd-mm-yyyy}")]
        public DateTime DataDesejoEntrega { get; set; }

        [Display(Name = "Nome do produto ")]
        [Required(ErrorMessage = "Informe o nome do produto.")]
        public string NomeProduto { get; set; }

        [Display(Name = "Valor da venda ")]
        [Required(ErrorMessage = "Informe o valor da venda.")]
        [RegularExpression(@"^\d+.\d{0,2}$", ErrorMessage = "Valor da venda deverá ser informado.")]
        public decimal ValorVenda { get; set; }

        [Display(Name = "Escolha um tipo de pagamento.")]
        public TipoPagamento TipoDePagamento { get; set; }

        [Display(Name = "Nome ")]
        [RegularExpression("^[a-zA-Z ]*$", ErrorMessage = "Digite apenas letras.")]
        [Required(ErrorMessage = "Informe seu nome.")]
        public string NomeCliente { get; set; }

        [Display(Name = "Cidade ")]
        [Required(ErrorMessage = "Informe a cidade.")]
        public string Cidade { get; set; }

        [Display(Name = "Estado ")]
        [StringLength(2, ErrorMessage = "Estado deverá ter 2 caracteres")]
        [Required(ErrorMessage = "Informe o estado.")]
        public string Estado { get; set; }

    }
}