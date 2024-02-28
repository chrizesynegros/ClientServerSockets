/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Chris
 */
public class Servidor2 {
    public static void main(String[] args) throws IOException{
        ServerSocket servidor = null;
        JOptionPane.showMessageDialog(null, "Servidor Iniciado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        Servidor2 p = new Servidor2();
        servidor = new ServerSocket(5000);
        p.iniciarServidor(servidor);
    }

    public Servidor2() {
        System.out.println("Esperando recepcion de archivos...");
    }

    public void iniciarServidor(ServerSocket servidor) {
        while(true){
            try{
                Socket cliente = servidor.accept();
                DataInputStream dis = new DataInputStream(cliente.getInputStream());
                String nombreArchivo = dis.readUTF().toString();
                int tam = dis.readInt();
                System.out.println("Recibiendo Archivo "+nombreArchivo);
                FileOutputStream fos = new FileOutputStream("C:\\ArchivosRecibidos\\"+nombreArchivo);
                BufferedOutputStream out = new BufferedOutputStream(fos);
                BufferedInputStream in = new BufferedInputStream(cliente.getInputStream());
                byte[] buffer = new byte[tam];
                for(int i=0; i<buffer.length; i++){
                    buffer[i] = (byte)in.read();
                }
                out.write(buffer);
                out.flush();
                in.close();
                out.close();
                cliente.close();
                System.out.println("Archivo recivido "+nombreArchivo);
            }catch(Exception e){
                System.out.println("Recibir "+e.toString());
            }
        }
    }
}
