/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2punto1;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class Lista {

    public Lista() {
    }
    
    public String lista(final File carpeta) {
        String archivos="";
        for (final File ficheroEntrada : carpeta.listFiles()) {
            if (ficheroEntrada.isDirectory()) {
                lista(ficheroEntrada);
            }else{
                archivos += ficheroEntrada.getName()+"\n";
                System.out.println(ficheroEntrada.getName());
            }
        }
        return archivos;
    }

    public static void main(String args[]){
        final File carpeta = new File("Recibidos\\");
        Lista l = new Lista();
        System.out.println(l.lista(carpeta));
    }
    
}
