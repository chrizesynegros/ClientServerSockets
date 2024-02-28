/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Chris
 */
public class Servidor {

    public Servidor() {
            try{
            ServerSocket servidor = new ServerSocket(4000);
            Socket cliente = servidor.accept();
            InputStream llegada = cliente.getInputStream();
            FileOutputStream destino = new FileOutputStream(llegada.toString());
            byte[] buffer = new byte[1024];
            int len =0;
            while(0<(len = llegada.read(buffer))){
                destino.write(buffer, 0 , len);
            }
            destino.close();
            llegada.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    public static void main(String args[]){
        try{
            ServerSocket servidor = new ServerSocket(4000);
            Socket cliente = servidor.accept();
            InputStream llegada = cliente.getInputStream();
            FileOutputStream destino = new FileOutputStream("C:\\Users\\Usuario 1\\Documents\\socketsflujo\\Recibidos\\alonso.docx");
            byte[] buffer = new byte[1024];
            int len =0;
            while(0<(len = llegada.read(buffer))){
                destino.write(buffer, 0 , len);
            }
            destino.close();
            llegada.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
