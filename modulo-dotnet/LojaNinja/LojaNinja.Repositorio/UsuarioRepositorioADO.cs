using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio
{
    public class UsuarioRepositorioADO : IUsuarioRepositorio
    {
        Usuario usuario = new Usuario();


        public void Cadastrar(Usuario usuario)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["Conexao"].ConnectionString;
            using (var conexao = new SqlConnection(connectionString))
            {
                string sqlUsuario = String.Format("INSERT INTO Usuario (nome, email, senha) VALUES @p_nome, @p_email, @p_senha",
                    usuario.Nome, usuario.Email, usuario.Senha);
                var comandoUsuario = new SqlCommand(sqlUsuario, conexao);

                comandoUsuario.Parameters.Add(new SqlParameter("p_nome", usuario.Nome));
                comandoUsuario.Parameters.Add(new SqlParameter("p_email", usuario.Email));
                comandoUsuario.Parameters.Add(new SqlParameter("p_senha", usuario.Senha));

                conexao.Open();
                comandoUsuario.ExecuteNonQuery();

                string sqlUsuarioPorPermissao = String.Format("INSERT INTO UsuarioPorPermissao(idUsuario, idPermissao)VALUES")
                
                //TODO: Implementar regra para inserção na tabela intermediária
                
            }
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["Conexao"].ConnectionString;
            using (var conexao = new SqlConnection(connectionString))
            {
                string sql = String.Format("SELECT * FROM Usuario WHERE email=@p_email and senha=@p_senha", email, senha);
                var comando = new SqlCommand(sql, conexao);

                comando.Parameters.Add(new SqlParameter("p_email", email));
                comando.Parameters.Add(new SqlParameter("p_senha", senha));

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();

                if (leitor.Read())
                {
                    usuario.Nome = leitor["nome"].ToString();
                    usuario.Email = leitor["email"].ToString();
                }

                return usuario;
            }
        }

    }
}
