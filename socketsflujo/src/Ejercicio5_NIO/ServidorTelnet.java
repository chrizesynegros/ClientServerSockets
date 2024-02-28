/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5_NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 *
 * @author Chris
 */
public class ServidorTelnet {
    
    private ServerSocketChannel ssc;
    private SocketChannel sc;
    private ByteBuffer buffer;
    private int puerto;

    public ServidorTelnet(int puerto) {
       try{
        this.puerto = puerto;
        ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(puerto));
        //configurar el servidor en modo no bloqueante
        ssc.configureBlocking(false);
        
       }catch(IOException e){
           e.printStackTrace();
      
       }
    }
    
    public void escuchar(){
        try{
            //msj que enviamso al cliente
            buffer = ByteBuffer.wrap("Msj recibido".getBytes());
            while(true){
                System.out.println("Esperando conexiones");
                sc = ssc.accept();
                if(sc == null){
                    try{
                        Thread.sleep(5000);
                    }catch(InterruptedException ex){
                        ex.printStackTrace();
                    }
                }else{
                    System.out.println("Se conecto: "+sc.socket().toString());
                    buffer.rewind();//resetear posiciones
                    sc.write(buffer);//mandar msj 
                    sc.close();
                }
                System.out.println("Algo");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
    
    ServidorTelnet st = new ServidorTelnet(1234);
    st.escuchar();
    
    }
}
