
public class IrishDwarf extends Dwarf {
    
   
   public IrishDwarf(String nome){ // Em caso de herança, ele chama o construtor vazio da classe pai
       super(nome);
    }
   
   public IrishDwarf(String nome, DataTerceiraEra dataNascimento){
       super(nome, dataNascimento);
    }
    
    public void tentarSorte(){
        if(this.getNumeroSorte() == -3333.0){
            for(int i = 0; i < this.inventario.getListaItens().size(); i++){
            this.inventario.getListaItens().get(i).sorteIrishDwarf();        
        }
        }
    }
    
}
