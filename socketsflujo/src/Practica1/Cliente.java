/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * nombre: Mario Alonso Alvarez Perez
 * tema del programa: Practica 1
 * descripcion: cliente que separa mensaje puetro e ip
 * fecha: 1/febrero/2019
 */

public class Cliente {
    private String ip;// = "127.0.0.1";
    private int puerto;// = 5500;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private Socket cliente;
    
    //yo la puse
    private String mensaje; //="que onda";
    
    public Cliente(String ip, int puerto, String mensaje) {
        this.ip = ip;
        this.puerto = puerto;
        this.mensaje = mensaje;
            try 
        {
            cliente = new Socket(ip, puerto);
            salida = new DataOutputStream(cliente.getOutputStream());
            salida.writeUTF(mensaje);
            
            //Recibir mensaje del servidor
            entrada = new DataInputStream(cliente.getInputStream());
            System.out.println(" Servidor dice >>"+entrada.readUTF());
            
            cliente.close();
        } 
        catch (UnknownHostException e) 
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    
    }
    
    // esta funcion unifica lo que contenga Hola[] en un solo string
    public static String unir(String Hola[]){
        String aux=""; 
        for(int i=0; i<Hola.length; i++){
            aux+=Hola[i];
            if(i!=Hola.length-1){
                aux+=" ";
            }
        }
        return aux;
    }
    
    public static void main(String Hola[]){
        Separar s = new Separar(unir(Hola));
        // si la ip es valida se envia peticion al servidor
        if(s.ipVailda){
            Cliente c = new Cliente(s.ip, Integer.parseInt(s.puerto), s.mensaje);
            System.out.println("logrado");
        }else{
            // si la ip no es valida se retornara el mensaje fallo
            System.out.println("fallo");
        }
    }
    
}
