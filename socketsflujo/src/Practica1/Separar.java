/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;


/*
 * nombre: Christian Ulises Rodriguez Noriega
 * tema del programa: Practica 1
 * descripcion: cliente que separa mensaje puetro e ip
 * fecha: 1/febrero/2019
 */

// la funcion de esta clase es seccionar y validar 
public class Separar {

    public String ip;
    public String mensaje;
    public String puerto;
    public boolean ipVailda;
    public boolean puertoValido;
    
    public Separar(String entradas){
        this.ip=ip(entradas);
        this.ipVailda=ipValida(entradas);
        this.mensaje=mensaje(entradas);
        this.puerto=puerto(entradas);
        this.puertoValido=puertoValido(puerto);
    }
    
    // esta funcion nos separara la ip en un string
    private String ip(String entradas){
        String ip="";
        for(int i=0; i<inicioMensaje(entradas)-1; i++){
            ip+=entradas.charAt(i);
        }
        return ip;
    }
    
    // esta funcion valida que el puero sea valido 
    private boolean puertoValido(String puerto){
        boolean v=true;
        for(int i=0; i<puerto.length(); i++){
            if(!noValida(puerto.charAt(i))){
                v=false;
                break;
            }
        }
        int p=Integer.parseInt(puerto);
        if(p<0 || 65535<p){
            v=false;
        }
        return v;
    }
    
    // funcion que verifica si es una ip valia
    private boolean ipValida(String entradas){
        int aux=0;
        char c;
        boolean v=true;
        for(int i=0; i<entradas.length(); i++){
            c=entradas.charAt(i);
            if(i==0){
                if(c=='.' || c==' '){
                    v=false;
                    break;
                }
            }
            if(i==entradas.length()){
                if(c=='.'){
                    v=false;
                    break;
                }
            }
            if(c==' '){
                if(aux!=3){
                    v=false;
                }
                break;
            }
            if(c=='.'){
                aux++;
            }else{
                if(!noValida(c)){
                    v=false;
                    break;
                }
            }
        }
        return v;
    }
    
    // evalua calacteres para saber si es numerico
    private boolean noValida(char c){
        return c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9' || c=='0';
    }
    
    // encapsula el mensaje en un string
    private String mensaje(String entradas){
        String mensaje="";
        for(int i=inicioMensaje(entradas); i<finMensaje(entradas); i++){
            mensaje+=entradas.charAt(i);
        }
        return mensaje;
    }
    
    // encapsula el puerto
    private String puerto(String entradas){
        String puerto="";
        for(int i=finMensaje(entradas)+1; i<entradas.length(); i++){
            puerto+=entradas.charAt(i);
        }
        return puerto;
    }
    
    // retorna la posicion de inicio del mensaje
    private int inicioMensaje(String entradas){
        int a=0;
        for(int i=0; i<entradas.length(); i++){
            a++;
            if(entradas.charAt(i)==' '){
                break;
            }
        }
        return a;
    }
    
    // retorna la posicion final del mensaje
    private int finMensaje(String entradas){
        int i=entradas.length()-1;
        while(entradas.charAt(i)!=' '){
            i--;
        }
        return i;
    }

    //muestra los resultados
    @Override
    public String toString() {
        return "Separar{" + "ip=" + ip + ", mensaje=" + mensaje + ", puerto=" + puerto + ", ipVailda=" + ipVailda + ", puertoValido=" + puertoValido + '}';
    }
    
}
