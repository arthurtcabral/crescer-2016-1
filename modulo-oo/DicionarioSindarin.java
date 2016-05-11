import java.util.*;
public class DicionarioSindarin {
    
    public static void main(String[] args){
    Scanner teclado = new Scanner(System.in);
    
    System.out.println("Bem vindo ao tradutor Sindarin");
    System.out.println("[P]ortuguês [I]nglês");
    String idioma = teclado.nextLine();
    TradutorSindarin tradutor = null;
    switch(idioma.toLowerCase()){
    case "i":
        tradutor = new SindarinParaIngles();
        break;
    default:
        tradutor = new SindarinParaPortugues();
        break;
    }
    System.out.println("Escolha uma palavra abaixo: ");
    System.out.println(" ");
    System.out.println("amar");
    System.out.println("naur");
    System.out.println("gwaew");
    System.out.println("nen");
    System.out.println("gûr");
    String palavra = teclado.nextLine();
    if(palavra.equals("amar") || palavra.equals("naur") ||
    palavra.equals("gwaew") || palavra.equals("nen") || palavra.equals("gûr")){
    System.out.println(palavra + " significa " + tradutor.traduzir(palavra));
    }
    // System.out.println("Naur significa " + tradutor.traduzir("naur"));
    }
    
    public static void rodarExemplosHashMap(){       
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
