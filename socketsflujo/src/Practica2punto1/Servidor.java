/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2punto1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Usuario 1
 */
public class Servidor {
 
    private ServerSocket servidor = null;
    public String mensaje;
    
    public Servidor(int puerto) throws IOException{
       servidor = new ServerSocket(puerto);
       System.out.println("Esperando recepcion de archivos..."); 
    }

    public void iniciarServidor(){
//        while(true){
            try{
                Socket cliente = servidor.accept(); 
                DataInputStream dis = new DataInputStream( cliente.getInputStream() );
                String nombreArchivo = dis.readUTF().toString(); 
                int tam = dis.readInt(); 
                System.out.println( "Recibiendo archivo "+nombreArchivo );
                mensaje="Recibiendo archivo: \n"+nombreArchivo;
                FileOutputStream fos = new FileOutputStream("Recibidos\\"+nombreArchivo );
                BufferedOutputStream out = new BufferedOutputStream(fos);
                BufferedInputStream in = new BufferedInputStream( cliente.getInputStream() );
                byte[] buffer = new byte[tam];
                for(int i=0; i<buffer.length; i++){
                   buffer[i] = (byte)in.read(); 
                }
                out.write(buffer); 
                out.flush(); 
                in.close();
                out.close(); 
                cliente.close();
                System.out.println( "Archivo Recibido "+nombreArchivo );
            }
            catch( Exception e ){
               System.out.println( "Recibir: "+e.toString() ); 
            }
//        } 
    }

    public static void main( String args[] ) throws IOException{
        new Servidor(4000).iniciarServidor(); 
    }
}