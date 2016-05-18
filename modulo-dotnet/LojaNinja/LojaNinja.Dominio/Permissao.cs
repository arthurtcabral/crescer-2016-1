using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Permissao
    {
        public int Id { get; set; }
        public string Nome { get; set; }

        public List<Usuario> Usuarios { get; set; }

        public Permissao() { }
    }
}
