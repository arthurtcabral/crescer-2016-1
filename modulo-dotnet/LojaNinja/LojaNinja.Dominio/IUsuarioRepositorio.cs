using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinjaEF.Dominio
{
    public interface IUsuarioRepositorio
    {
        void Cadastrar(Usuario usuario);
        Usuario BuscarUsuarioPorAutenticacao(string email, string senha);
        List<Usuario> BuscarUsuarios();
    }
}
