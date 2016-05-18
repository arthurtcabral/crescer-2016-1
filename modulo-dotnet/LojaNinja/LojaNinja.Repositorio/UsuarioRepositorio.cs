using LojaNinjaEF.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinjaEF.Repositorio
{
    public class UsuarioRepositorio : IUsuarioRepositorio
    {

        private const string PATH_ARQUIVO = @"C:\Users\arthur.cabral\Documents\crescer-2016-1\modulo-dotnet\LojaNinja\usuarios.txt";
        private static readonly object objetoLock = new object();

        public void Cadastrar(Usuario usuario)
        {
            lock (objetoLock)
            {
                var novaLinha = ConverteUsuarioEmLinhaCSV(usuario);
                File.AppendAllText(PATH_ARQUIVO, novaLinha);
            }
            }

        public List<Usuario> ObterUsuarios()
        {
            var linhasArquivo = File.ReadAllLines(PATH_ARQUIVO, Encoding.UTF8).ToList();
            return ConverteLinhasEmUsuarios(linhasArquivo);
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            return this.ObterUsuarios().FirstOrDefault(usuario => usuario.Email == email && usuario.Senha == senha);            
        }

        private string ConverteUsuarioEmLinhaCSV(Usuario usuario)
        {
            return string.Format(Environment.NewLine + "{0};{1}",
                                usuario.Nome,
                                usuario.Email);
        }

        private List<Usuario> ConverteLinhasEmUsuarios(List<string> linhasArquivo)
        {
            var listaUsuarios = new List<Usuario>();

            //Remove linha do cabeçalho
            linhasArquivo.RemoveAt(0);

            foreach (var linha in linhasArquivo)
            {
                var nome = linha.Split(';')[0];
                var email = linha.Split(';')[1];
                var senha = linha.Split(';')[2];

                var usuario = new Usuario(nome, email, senha);
                listaUsuarios.Add(usuario);
            }

            return listaUsuarios;
        }

        public List<Usuario> BuscarUsuarios()
        {
            throw new NotImplementedException();
        }
    }
}
