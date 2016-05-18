using LojaNinjaEF.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinjaEF.Repositorio
{
    public class UsuarioRepositorioADO : IUsuarioRepositorio
    {
        Usuario usuario = new Usuario();
        
        public void Cadastrar(Usuario usuario)
        {
            var connectionString = ConfigurationManager.ConnectionStrings["Conexao"].ConnectionString;
            using (var conexao = new SqlConnection(connectionString))
            {
                string sqlUsuario = String.Format("INSERT INTO Usuario (nome, email, senha) VALUES (@p_nome, @p_email, @p_senha)",
                    usuario.Nome, usuario.Email, usuario.Senha);
                var comandoUsuario = new SqlCommand(sqlUsuario, conexao);

                comandoUsuario.Parameters.Add(new SqlParameter("p_nome", usuario.Nome));
                comandoUsuario.Parameters.Add(new SqlParameter("p_email", usuario.Email));
                comandoUsuario.Parameters.Add(new SqlParameter("p_senha", usuario.Senha));

                conexao.Open();
                comandoUsuario.ExecuteNonQuery();

                usuario.Id = this.BuscarIdDeUsuario(usuario);

                string sqlUsuarioPorPermissao = String.Format("INSERT INTO UsuarioPorPermissao (idUsuario, idPermissao) VALUES "
                   + "(@p_idUsuario, @p_idPermissao)", usuario.Id, 2);
                var comandoUsuarioPorPermissao = new SqlCommand(sqlUsuarioPorPermissao, conexao);

                comandoUsuarioPorPermissao.Parameters.Add(new SqlParameter("p_idUsuario", usuario.Id));
                comandoUsuarioPorPermissao.Parameters.Add(new SqlParameter("p_idPermissao", 2));

                comandoUsuarioPorPermissao.ExecuteNonQuery();

            }
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            var connectionString = ConfigurationManager.ConnectionStrings["Conexao"].ConnectionString;
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
                    usuario.Senha = leitor["senha"].ToString();
                }

                return usuario;
            }
        }

        public List<Usuario> BuscarUsuarios()
        {
            List<Usuario> usuarios = new List<Usuario>();
            var connectionString = ConfigurationManager.ConnectionStrings["Conexao"].ConnectionString;
            using (var conexao = new SqlConnection(connectionString))
            {
                string sql = String.Format("SELECT * FROM Usuario");
                var comando = new SqlCommand(sql, conexao);

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();

                while (leitor.Read())
                {
                    Usuario usuario = new Usuario();
                    usuario.Nome = leitor["nome"].ToString();
                    usuario.Email = leitor["email"].ToString();
                    usuarios.Add(usuario);
                }
                return usuarios;
            }
       }

        private int BuscarIdDeUsuario(Usuario usuario)
        {
            var connectionString = ConfigurationManager.ConnectionStrings["Conexao"].ConnectionString;
            using (var conexao = new SqlConnection(connectionString))
            {
                int id = 0;
                string sql = String.Format("SELECT id FROM Usuario WHERE email=@p_email and senha=@p_senha", usuario.Email, usuario.Senha);
                var comando = new SqlCommand(sql, conexao);

                comando.Parameters.Add(new SqlParameter("p_email", usuario.Email));
                comando.Parameters.Add(new SqlParameter("p_senha", usuario.Senha));

                conexao.Open();
                SqlDataReader leitor = comando.ExecuteReader();

                if (leitor.Read())
                {
                    id = Convert.ToInt32(leitor["id"]);
                }
                return id;
            }
        }
    }
}
