/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2punto1;

import Practica2.EnviarArchivo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JFileChooser;

/**
 *
 * @author Chris
 */
public class Cliente {
    
    public String mensaje;
    
    public Cliente(){
    }
         
    public void enviarArchivo(String nombreArchivo, String ip, int puerto){
        try{
            InetAddress direccion = InetAddress.getByName(ip);
            Socket socket = new Socket(direccion, puerto);
            socket.setSoTimeout(2000);
            socket.setKeepAlive(true);
            File archivo = new File(nombreArchivo);
            int tamañoArchivo = (int)archivo.length();
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("Enviando Archivo: \n"+archivo.getName());
            mensaje="Enviando Archivo: "+archivo.getName();
            dos.writeUTF(archivo.getName());
            dos.writeInt(tamañoArchivo);
            FileInputStream fis = new FileInputStream(nombreArchivo);
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());          
            byte[] buffer = new byte[tamañoArchivo]; 
            bis.read(buffer); 
            for(int i=0; i<buffer.length; i++){
                bos.write(buffer[i]); 
            } 
            System.out.println("Archivo Enviado: "+archivo.getName());
            bis.close();
            bos.close();
            socket.close(); 
        }catch( Exception e ){
            System.out.println( e.toString() );
        }
    }
         
    public static void main( String args[] ){
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(file);
        File abre = file.getSelectedFile();
        Cliente ea = new Cliente();
        ea.enviarArchivo(abre.getPath(), "127.0.0.1", 4000);
    }
         
}
