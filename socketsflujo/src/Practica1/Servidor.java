/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * nombre: Mario Alonso Alvarez Perez
 * tema del programa: Practica 1
 * descripcion: cliente que separa mensaje puetro e ip
 * fecha: 1/febrero/2019
 */

public class Servidor 
{
    private int puerto = 5500;
    private ServerSocket servidor;
    private Socket cliente;
    private DataInputStream entrada;
    private DataOutputStream salida;
    
    
    public Servidor()
    {
        try
        {
            servidor = new ServerSocket(puerto);
            while(true)
            {
            cliente = servidor.accept();
            //Entrada DataInputStream
            //Salida DataOutputStream
            entrada = new DataInputStream(cliente.getInputStream());
            //Mostrar lo que manda el cliente
            String ip = cliente.getInetAddress().getHostAddress();
            int puerto = cliente.getPort();
            System.out.println(ip + ":" + puerto + " dice >> " + entrada.readUTF());
            //Mensaje al cliente
            salida = new DataOutputStream(cliente.getOutputStream());
            salida.writeUTF("Mensaje recibido prro.... como andas?");
            
            
            //Cierro conexion del cliente
            cliente.close();
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void main(String args[])
    {
        Servidor s = new Servidor();
    }
    
    
    
}
