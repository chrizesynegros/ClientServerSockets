
package Ejercicio2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * nombre: Christian Ulises Rodriguez Noriega
 * tema del programa: servidor  
 * descripcion: servidor telnet
 * fecha: 28/enero/2019
 */

public class ServidorTelnet 
{
    private ServerSocket servidor;
    private Socket cliente;
    private int puerto;
    //private DataInputStream entrada;
    private BufferedReader entrada;
    private DataOutputStream salida;

    public ServidorTelnet(int port)
    {
        this.puerto = port;
        try 
        {
            servidor = new ServerSocket(this.puerto);
            //el while hace que no se cierre el servidor hasta que le demos la orden
            while(true){
                cliente = servidor.accept();
                //Recibir mensaje
                //entrada = new DataInputStream(cliente.getInputStream());
                entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                //Mandar mensaje
                if(entrada.readLine().toString().equals("SALIDA")){
                    System.out.println("adios ccliente");
                    salida = new DataOutputStream(cliente.getOutputStream());
                    salida.writeUTF("adios");
                    break;
                }else{
                    System.out.println(entrada.readLine());
                    salida = new DataOutputStream(cliente.getOutputStream());
                    salida.writeUTF("Que onda!");
                }
                cliente.close();
            }
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public static void main(String xdxd[]){
        ServidorTelnet st = new ServidorTelnet(5500);
    }
}
