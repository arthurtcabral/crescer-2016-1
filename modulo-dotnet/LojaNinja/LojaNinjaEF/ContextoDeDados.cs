using LojaNinjaEF.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinjaEF
{
    public class ContextoDeDados : DbContext
    {
        public ContextoDeDados() : base("Conexao")
        {

        }

        public DbSet <Usuario> Usuario { get; set; }
        public DbSet <Permissao> Permissao { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
            base.OnModelCreating(modelBuilder);
        }

    }
}
