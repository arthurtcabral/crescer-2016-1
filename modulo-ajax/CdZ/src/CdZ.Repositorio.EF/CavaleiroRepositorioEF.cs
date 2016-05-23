using CdZ.Dominio;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System;

namespace CdZ.Repositorio.EF
{
    /*
     * Criamos nosso repositório de pedidos aqui, implementando nossa
     * interface de regras de repositório de pedidos.
     */
    public class CavaleiroRepositorioEF : ICavaleiroRepositorio
    {
        public int Adicionar(Cavaleiro cavaleiro)
        {
            using (var db = new ContextoDeDados())
            {
                /*
                 * Para informarmos um INSERT, devemos setar o State como Added.
                 */
                db.Entry<Cavaleiro>(cavaleiro).State = EntityState.Added;
                db.SaveChanges();
                return cavaleiro.Id;
            }
        }

        public Cavaleiro Buscar(int id)
        {
            using (var db = new ContextoDeDados())
            {
                return db.Cavaleiro
                    .Include(_ => _.LocalNascimento)
                    .Include(_ => _.LocalTreinamento)
                    .Include(_ => _.Golpes)
                    .Include(_ => _.Imagens)
                    .SingleOrDefault(_ => _.Id == id);
            }
        }

        public IEnumerable<Cavaleiro> Paginacao(int qtdCavaleiros, int pagina)
        {
            using (var db = new ContextoDeDados())
            {
                return db.Cavaleiro
                    .Include(​_ => _​.Imagens)
                    .Include(​_ => _​.Golpes)
                    .Include(​_ => _​.LocalNascimento)
                    .Include(​_ => _​.LocalTreinamento)
                    .OrderBy(​_ => _​.Nome)
                    .Skip(pagina * qtdCavaleiros)  //Pagina 1, 5 cavaleiros: 1 * 5 = 5. Pular 5 cavaleiros na tabela e...
                    .Take(qtdCavaleiros).ToList(); //Pegar os próximos 5.
            }
        }

        public void Excluir(int id)
        {
            using (var db = new ContextoDeDados())
            {
                /*
                 * Para realizar um DELETE no banco de dados,
                 * infelizmente precisamos buscar o objeto no banco para então
                 * removê-lo.
                 */

                var cavaleiroASerExcluido = Buscar(id);
                db.Entry<Cavaleiro>(cavaleiroASerExcluido).State = EntityState.Deleted;
                // TODO: exclusão em cascata
                db.SaveChanges();
            }
        }

        public void Atualizar(Cavaleiro cavaleiro)
        {
            /*
             * Para fazermos uma conexão com o banco via EF, precisamos
             * instanciar um objeto do mesmo tipo de nosso DbContext, que no nosso
             * caso é o ContextoDeDados.
             */
            using (var db = new ContextoDeDados())
            {
                // Atualizamos o estado de todos os objetos envolvidos em relacionamentos com Cavaleiro.
                // Caso Id seja diferente de 0, é atualizado. Caso seja 0, é inserido.
                db.Entry<Local>(cavaleiro.LocalNascimento).State = cavaleiro.LocalNascimento.Id == default(int) ? EntityState.Added : EntityState.Modified;
                db.Entry<Local>(cavaleiro.LocalTreinamento).State = cavaleiro.LocalTreinamento.Id == default(int) ? EntityState.Added : EntityState.Modified;

                foreach (var golpe in cavaleiro.Golpes)
                {
                    db.Entry<Golpe>(golpe).State = golpe.Id == default(int) ? EntityState.Added : EntityState.Modified;
                }

                foreach (var imagem in cavaleiro.Imagens)
                {
                    db.Entry<Imagem>(imagem).State = imagem.Id == default(int) ? EntityState.Added : EntityState.Modified;
                }

                db.Entry<Cavaleiro>(cavaleiro).State = EntityState.Modified;
                db.SaveChanges();
            }
        }
    }
}