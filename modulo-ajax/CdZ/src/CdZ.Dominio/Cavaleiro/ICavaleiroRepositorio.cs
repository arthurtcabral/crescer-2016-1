using System.Collections.Generic;

namespace CdZ.Dominio
{
    public interface ICavaleiroRepositorio
    {
        int Adicionar(Cavaleiro cavaleiro);
        Cavaleiro Buscar(int id);
        void Excluir(int id);
        void Atualizar(Cavaleiro cavaleiro);
        IEnumerable<Cavaleiro> Paginacao(int qtdCavaleiros, int pagina);
    }
}
