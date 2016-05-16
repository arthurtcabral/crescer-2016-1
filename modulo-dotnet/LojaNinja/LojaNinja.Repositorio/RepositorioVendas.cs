using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio
{
    public class RepositorioVendas
    {
        private const string PATH_ARQUIVO = @"C:\Users\arthur.cabral\Documents\crescer-2016-1\modulo-dotnet\LojaNinja\vendas.txt";
        private static readonly object objetoLock = new object();

        public List<Pedido> ObterPedidos()
        {
            var linhasArquivo = File.ReadAllLines(PATH_ARQUIVO, Encoding.UTF8).ToList();
            return ConverteLinhasEmPedidos(linhasArquivo);
        }

        public Pedido ObterPedidoPorId(int id)
        {
            return this.ObterPedidos().FirstOrDefault(x => x.Id == id);
        }

        public void IncluirPedido(Pedido pedido)
        {
            lock (objetoLock)
            {
                var utlimoId = this.ObterPedidos().Max(x => x.Id);
                var idGerado = utlimoId + 1;
                var novaLinha = ConvertePedidoEmLinhaCSV(pedido, idGerado);

                File.AppendAllText(PATH_ARQUIVO, novaLinha);

                pedido.AtualizarId(idGerado);
            }
        }

        public List<Pedido> ObterPedidoPorFiltro(string cliente, string produto)
        {
            var pedidos = this.ObterPedidos()
              .Where(p =>
                  (cliente == null || cliente == "" || p.NomeCliente.Contains(cliente))
                  &&
                  (produto == null || produto == "" || p.NomeProduto == produto)).ToList();
            return pedidos;
        }

        public void AtualizarPedido(Pedido pedido)
        {
            var linhasArquivo = ObterPedidos();
            var idPedido = linhasArquivo.FindIndex(linha => linha.Id == pedido.Id); //Retorna indice do array
            linhasArquivo.Remove(linhasArquivo.FirstOrDefault(linha => linha.Id == pedido.Id));
            linhasArquivo.Insert(idPedido, pedido);
            string linhas = "Numero do pedido;Data do pedido;Data de Entrega;Nome do produto;Valor produto;Tipo de pagamento;Nome do cliente;Nome da cidade;Nome do estado;Urgente";
            foreach (var linha in linhasArquivo)
            {
                linhas += this.ConvertePedidoEmLinhaCSV(linha, linha.Id);
            }
            File.WriteAllText(PATH_ARQUIVO, linhas);
        }

        public void ExcluirPedido(int id)
        {
            var linhasArquivo = File.ReadAllLines(PATH_ARQUIVO, Encoding.UTF8).ToList();
            foreach (var linha in linhasArquivo)
            {
                if (linha.StartsWith(id.ToString()))
                {
                    linhasArquivo.Remove(linha);
                    break;
                }
            }
            File.WriteAllLines(PATH_ARQUIVO, linhasArquivo);
        }

        private string ConvertePedidoEmLinhaCSV(Pedido pedido, int proximoId)
        {
            return string.Format(Environment.NewLine + "{0};{1};{2};{3};{4};{5};{6};{7};{8};{9}",
                                proximoId,
                                pedido.DataPedido.ToString("dd/MM/yyyy HH:mm"),
                                pedido.DataEntregaDesejada.ToString("dd/MM/yyyy HH:mm"),
                                pedido.NomeProduto,
                                pedido.Valor,
                                pedido.TipoPagamento,
                                pedido.NomeCliente,
                                pedido.Cidade,
                                pedido.Estado,
                                pedido.PedidoUrgente);
        }

        private List<Pedido> ConverteLinhasEmPedidos(List<string> linhasArquivo)
        {
            var listaPedidos = new List<Pedido>();

            //Remove linha do cabeçalho
            linhasArquivo.RemoveAt(0);

            foreach (var linha in linhasArquivo)
            {
                var id = Convert.ToInt32(linha.Split(';')[0]);
                var dataPedido = Convert.ToDateTime(linha.Split(';')[1]);
                var dataEntregaDesejada = Convert.ToDateTime(linha.Split(';')[2]);
                var nomeProduto = linha.Split(';')[3];
                var valorVenda = Convert.ToDecimal(linha.Split(';')[4]);
                TipoPagamento tipoPagamento;
                Enum.TryParse(linha.Split(';')[5], out tipoPagamento);
                var nomeCliente = linha.Split(';')[6];
                var cidade = linha.Split(';')[7];
                var estado = linha.Split(';')[8];
                var urgente = Convert.ToBoolean(linha.Split(';')[9]);

                var pedido = new Pedido(id, dataPedido, dataEntregaDesejada, nomeProduto, valorVenda, tipoPagamento, nomeCliente, cidade, estado, urgente);
                listaPedidos.Add(pedido);
            }

            return listaPedidos;
        }
    }
}
