using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models
{
    public class UsuarioLoginModel
    {
        
        [DisplayName("Nome")]
        [StringLength(100)]
        public string Nome { get; set; }

        [Required]
        [DisplayName("E-mail")]
        [StringLength(100)]
        [EmailAddress]
        public string Email { get; set; }

        [Required]
        [DisplayName("Senha")]
        [StringLength(100)]
        public string Senha { get; set; }
    }
}