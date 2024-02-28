/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import javax.swing.JFileChooser;

/**
 *
 * @author Chris
 */
public class Cliente {
    public static void main(String args[]){
        try{
            Socket s = new Socket("127.0.0.1", 4000);
            OutputStream os = s.getOutputStream();
            PrintStream envio =new PrintStream(os);
            // leer el atchivo 
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();
            
//            byte[] nombre = new byte[1240];
//            for(int i=0; i<abre.getName().length(); i++){
//                nombre[i] = (byte) abre.getName().charAt(i);
//            }

            FileInputStream origen = new FileInputStream(abre);
            byte[] buffer = new byte [1024];
            int len =0;
            while(0<(len = origen.read(buffer))){
                envio.write(buffer,0,len);
            }
            
//            envio.write(nombre, 0, abre.getName().length());
            
            origen.close();
            envio.close();
//            File f = new File("archivo.txt");
//            FileReader fr = new FileReader(f);
//            BufferedReader br = new BufferedReader(fr);
//            String aux, texto="";
//            while((aux=br.readLine())!=null){
//                texto+=aux+"\n";
//            }
//            System.out.println(texto);
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
