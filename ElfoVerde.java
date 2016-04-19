
public class ElfoVerde extends Elfo {
    
    public ElfoVerde(String nome){
        super(nome);
    }
    
    public void atirarFlecha(Dwarf dwarf){
        this.flechas--;
        dwarf.perdeVida();
        this.experiencia = this.experiencia + 2;
        
    }
    
    public void adicionarItem(Item item){
    if(item.getDescricao().equals("Espada de aço valiriano") || item.getDescricao().equals("Arco e Flecha de Vidro")){
        this.getInventario().getListaItens().add(item);
    }
 
}

}