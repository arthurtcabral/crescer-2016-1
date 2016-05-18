namespace LojaNinjaEF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial1 : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Usuario", "Permissao_Id", "dbo.Permissao");
            DropIndex("dbo.Usuario", new[] { "Permissao_Id" });
            CreateTable(
                "dbo.UsuarioPermissao",
                c => new
                    {
                        Usuario_Id = c.Int(nullable: false),
                        Permissao_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.Usuario_Id, t.Permissao_Id })
                .ForeignKey("dbo.Usuario", t => t.Usuario_Id, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.Permissao_Id, cascadeDelete: true)
                .Index(t => t.Usuario_Id)
                .Index(t => t.Permissao_Id);
            
            DropColumn("dbo.Usuario", "Permissao_Id");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Usuario", "Permissao_Id", c => c.Int());
            DropForeignKey("dbo.UsuarioPermissao", "Permissao_Id", "dbo.Permissao");
            DropForeignKey("dbo.UsuarioPermissao", "Usuario_Id", "dbo.Usuario");
            DropIndex("dbo.UsuarioPermissao", new[] { "Permissao_Id" });
            DropIndex("dbo.UsuarioPermissao", new[] { "Usuario_Id" });
            DropTable("dbo.UsuarioPermissao");
            CreateIndex("dbo.Usuario", "Permissao_Id");
            AddForeignKey("dbo.Usuario", "Permissao_Id", "dbo.Permissao", "Id");
        }
    }
}
