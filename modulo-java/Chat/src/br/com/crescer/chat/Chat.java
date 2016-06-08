package br.com.crescer.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chat {
    public static BufferedReader getReader(String fila) throws FileNotFoundException {
        return new BufferedReader(new FileReader(fila));
    }
    
    public static BufferedWriter getWriter(String fila) throws IOException {
        return new BufferedWriter(new FileWriter(fila,true));
    }
    
    public static void main(String []args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe seu nick: ");
        String nick = teclado.nextLine();
        new Thread(new Runnable() {
            @Override
            public void run() {
            BufferedReader bufferReader = null;
            try {
            bufferReader = Chat.getReader("//10.0.100.102/cwitmp/carloshenrique/crescer.txt");
            while(true){
                String readLine = bufferReader.readLine();
                if(readLine != null && !readLine.isEmpty())
                    System.out.println(readLine);
            }
            
            }catch(Exception e){
                e.printStackTrace();
            }
            finally {
                try {
                    if(bufferReader != null) {
                        bufferReader.close();
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            }
        }).start();
        
        while(true){
            System.out.println("Fale: ");
            String nextLine = teclado.nextLine();
            if(":q!".equals(nextLine)){
                System.exit(0);
            }
            BufferedWriter bufferedWriter = null;
            
            try {
                bufferedWriter = Chat.getWriter("//10.0.100.102/cwitmp/carloshenrique/crescer.txt");
                Date today = Calendar.getInstance().getTime(); 
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String data = df.format(today);
                bufferedWriter.write(data + " - " + nick + ": " + nextLine);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (IOException ex) {
                Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                try {
                    bufferedWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    }
}