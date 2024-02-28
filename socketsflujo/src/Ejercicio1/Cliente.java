
package Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import Practica1.Separar;

/*
 * name: Christian Ulises Rodriguez Noriega
 * program theme: server
 * description: telnet server
 * fecha: 28/enero/2019
 */


public class Cliente 
{
    private String ip;// = "127.0.0.1";
    private int puerto;// = 5500;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private Socket cliente;
    
    //yo la puse
    private String mensaje; //="que onda";
    
    public Cliente()
    {
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
        if(s.ipVailda){
            Cliente c = new Cliente(s.ip, Integer.parseInt(s.puerto), s.mensaje);
            System.out.println("logrado");
        }else{
            System.out.println("fallo");
        }
    }
    
    
    
    
}
