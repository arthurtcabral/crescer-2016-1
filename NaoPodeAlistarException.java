
public class NaoPodeAlistarException extends Exception {
    
    public NaoPodeAlistarException(){
        this("Elfos do tipo normal não podem ser alistados.");
    }
    
    public NaoPodeAlistarException(String message){
        super(message);
    }
    
}
