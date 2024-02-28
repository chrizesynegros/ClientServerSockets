/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario 1
 */
public class EnviarArchivo {
    
    String nombreArchivo;

    public EnviarArchivo(String cwindowScalcexe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void enviarArchivo(){
        try{
            InetAddress direccion = InetAddress.getByName("127.0.0.1");
            Socket socket = new Socket(direccion, 5000);
            socket.setSoTimeout(2000);
            socket.setKeepAlive(true);
            File archivo = new File(nombreArchivo);
            int tamañoArchivo = (int) archivo.length();
            DataOutputStream dos = new  DataOutputStream(socket.getOutputStream());
            System.out.println("Enviando Archivo: "+archivo.getName());
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
            JOptionPane.showMessageDialog(null, "Archivo Enviado: "+archivo.getName());
            bis.close();
            bos.close();
            socket.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    
}
