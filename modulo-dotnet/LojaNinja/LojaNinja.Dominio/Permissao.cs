using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinjaEF.Dominio
{
    public class Permissao
    {

        public Permissao () { }

        public int Id { get; set; }
        public string TipoPermissao { get; set; }
        public List<Usuario> Usuarios { get; set; }
    }

}
