import java.util.*;
public class DicionarioSindarin {
    public static void main(String[] args){       
        HashMap<String, String> dicionarioSindarin = new HashMap<>();
        dicionarioSindarin.put("terra", "amar");
        dicionarioSindarin.put("fogo", "naur");
        dicionarioSindarin.put("vento", "gwaew");
        dicionarioSindarin.put("água", "nen");
        dicionarioSindarin.put("coração", "gûr");
        
        String terraEmSindarin = dicionarioSindarin.get("terra");
        
        dicionarioSindarin.put("água", "nîn");
        
        dicionarioSindarin.remove("água");
        boolean estaVazio = dicionarioSindarin.isEmpty();
        
        int tamanhoDePares = dicionarioSindarin.size();
        
        boolean contemChave = dicionarioSindarin.containsKey("água");
        
        boolean contemNaur = dicionarioSindarin.containsValue("naur");

        
        for(String chave : dicionarioSindarin.keySet()){
            System.out.println(chave);
        }
        
        dicionarioSindarin.put("FB", "facebook");
        dicionarioSindarin.put("Ea", "badoo");
    }
    
}
