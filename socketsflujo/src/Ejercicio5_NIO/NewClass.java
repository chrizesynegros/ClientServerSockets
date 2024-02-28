/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5_NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author Usuario 1
 */
public class NewClass {

    public NewClass() {
    }
    
    public void nio(){
        try{
            RandomAccessFile aFile = new RandomAccessFile("datos.txt", "rw");
            FileChannel inChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(48);
            int bytesRead = inChannel.read(buf);
            while(bytesRead != -1){
                System.out.println("Read "+ bytesRead);
                buf.flip();
                while(buf.hasRemaining()){
                    System.out.print((char) buf.get());
                }
                buf.clear();
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        NewClass c = new NewClass();
        c.nio();
    }
    
}
