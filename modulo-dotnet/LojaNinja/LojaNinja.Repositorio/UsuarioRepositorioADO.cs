﻿using LojaNinja.Dominio;
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

        public void Cadastrar(Usuario usuario)
        {
            throw new NotImplementedException();
        }
    }
}