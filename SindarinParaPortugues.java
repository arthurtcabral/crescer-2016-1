import java.util.*;

public class SindarinParaPortugues implements TradutorSindarin{
    
    private HashMap<String, String> dicionario = new HashMap<String, String>(){
        {
        put("naur", "fogo");
        
    }
    };
    
    public String traduzir(String palavraEmSindarin){
    return dicionario.get(palavraEmSindarin);
    }
    
    // não está na interface, precisaria fazer casting
    public void limpar(){
    dicionario.clear();
    };
    
}
