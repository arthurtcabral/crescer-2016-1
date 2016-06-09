package br.com.crescer.file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MeuFileUtils {

    public MeuFileUtils(){
        
    }
    
    public static void main(String[] args) {
        MeuFileUtils mfu = new MeuFileUtils();
        Scanner teclado = new Scanner(System.in);
        String arquivo = "";
        System.out.println("mk || rm || ls || mv: ");
        String op = teclado.nextLine();
        if (op.equalsIgnoreCase("mk")) {
            System.out.println("Informe o nome do arquivo e sua extensão, caso não seja diretório: ");
            arquivo = teclado.nextLine();
            mfu.mk(arquivo);
        } else if (op.equalsIgnoreCase("rm")) {
            System.out.println("Informe o nome do arquivo: ");
            arquivo = teclado.nextLine();
            mfu.rm(arquivo);
        } else if (op.equalsIgnoreCase("ls")) {
            System.out.println("Informe o nome do arquivo: ");
            arquivo = teclado.nextLine();
            mfu.ls(arquivo);
        } else if (op.equalsIgnoreCase("mv")) {
            System.out.println("Informe o nome do arquivo e o destino: ");
            arquivo = teclado.nextLine();
            String destino = teclado.nextLine();
            mfu.mv(arquivo, destino);
        } else {
            System.exit(0);
        }

    }

    public static void mk(String arquivo) {
        try {
            if (arquivo.contains(".")) {
                final boolean b = new File(arquivo).createNewFile();
            } else {
                final boolean dir = new File(arquivo).mkdir();
            }
        } catch (IOException ex) {
            Logger.getLogger(MeuFileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void rm(String arquivo) {
        if (arquivo.contains(".")) {
            final boolean b = new File(arquivo).delete();
        } else {
            System.out.println("Arquivo inválido.");
        }
    }

    public static void ls(String arquivo) {
        if(arquivo.contains(".")){
            System.out.println(new File(arquivo).getAbsoluteFile());
        } else {
            for(String doc : new File(arquivo).list()){
                System.out.println(doc);
            }
        }
    }

    public static void mv(String arquivo, String destino) {
        if(arquivo.contains(".")){
            new File(arquivo).renameTo(new File(destino));
        }else{
            System.out.println("Arquivo inválido.");
        }
    }
    
    public static boolean eArquivo(String arquivo){
        return arquivo.contains(".");
    }

}