using System;
using System.ComponentModel.DataAnnotations;

namespace LojaNinja.Dominio
{
    public class Pedido
    {

        /// <summary>
        /// Construtor utilizado para montar pedidos novos
        /// </summary>
        public Pedido(DateTime dataEntregaDesejada, string nomeProduto, decimal valor, TipoPagamento tipoPagamento, 
            string nomeCliente, string cidade, string estado)
        {
            DataEntregaDesejada = dataEntregaDesejada;
            NomeProduto = nomeProduto;
            Valor = valor;
            TipoPagamento = tipoPagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;

            //DateTime.Now contaria as horas, minutos e segundos, isso inviabliziaria algumas validações a seguir
            DataPedido = DateTime.Today;

            var diasRestantesParaConcluirEntrega = (dataEntregaDesejada - DataPedido).TotalDays;
            ValidaPossibilidadeEntrega(diasRestantesParaConcluirEntrega);
            PedidoUrgente = DefineUrgenciaDoPedido(diasRestantesParaConcluirEntrega);

        }

        /// <summary>
        /// Construtor utilizado para atualizar a lista
        /// </summary>
        public Pedido(int id, DateTime dataEntregaDesejada, string nomeProduto, decimal valor, TipoPagamento tipoPagamento,
            string nomeCliente, string cidade, string estado)
        {
            Id = id;
            DataEntregaDesejada = dataEntregaDesejada;
            NomeProduto = nomeProduto;
            Valor = valor;
            TipoPagamento = tipoPagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;

            //DateTime.Now contaria as horas, minutos e segundos, isso inviabliziaria algumas validações a seguir
            DataPedido = DateTime.Today;

            var diasRestantesParaConcluirEntrega = (dataEntregaDesejada - DataPedido).TotalDays;
            ValidaPossibilidadeEntrega(diasRestantesParaConcluirEntrega);
            PedidoUrgente = DefineUrgenciaDoPedido(diasRestantesParaConcluirEntrega);

        }

        /// <summary>
        /// Construtor utilizado para montar pedidos recuperados do repositório
        /// </summary>
        public Pedido(int id, DateTime dataPedido, DateTime dataEntregaDesejada, string nomeProduto, decimal valor, TipoPagamento tipoPagamento, string nomeCliente, string cidade, string estado, bool pedidoUrgente)
        {
            Id = id;
            DataEntregaDesejada = dataEntregaDesejada;
            NomeProduto = nomeProduto;
            Valor = valor;
            TipoPagamento = tipoPagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;
            DataPedido = dataPedido;
            PedidoUrgente = pedidoUrgente;
        }

        [Display(Name = "Id ")]
        public int Id { get; private set; }
        [Display(Name = "Data do pedido ")]
        public DateTime DataPedido { get; private set; }
        [Display(Name = "Data da entrega ")]
        public DateTime DataEntregaDesejada { get; private set; }
        [Display(Name = "Produto ")]
        public string NomeProduto { get; private set; }
        [Display(Name = "Valor ")]
        public decimal Valor { get; private set; }
        [Display(Name = "Tipo de Pagamento ")]
        public TipoPagamento TipoPagamento { get; private set; }
        [Display(Name = "Cliente ")]
        public string NomeCliente { get; private set; }
        [Display(Name = "Cidade ")]
        public string Cidade { get; private set; }
        [Display(Name = "Estado ")]
        public string Estado { get; private set; }
        [Display(Name = "É Urgente? ")]
        public bool PedidoUrgente { get; private set; }

        private void ValidaPossibilidadeEntrega(double diasRestantesParaConcluirEntrega)
        {            
            if (diasRestantesParaConcluirEntrega < 1)
                throw new ArgumentException("A data de entrega desejada deve ser no mínimo 1 dia maior do que a data atual.");
        }

        private bool DefineUrgenciaDoPedido(double diasRestantesParaConcluirEntrega)
        {
            return diasRestantesParaConcluirEntrega < 7;    
        }

        public void AtualizarId(int id)
        {
            if (Id != 0)
                throw new InvalidOperationException("Esse objeto já possuia Id, portanto ele já havia sido salvo no banco. Não é possível alterar esse valor.");

            Id = id;
        }
    }
}
