
package Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/*
 * name: Christian Ulises Rodriguez Noriega
 * program theme: servidor  
 * description:telnet server
 * date: january/28/2019
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
