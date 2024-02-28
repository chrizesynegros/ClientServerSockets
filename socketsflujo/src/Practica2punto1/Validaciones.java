/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2punto1;

/**
 *
 * @author Usuario 1
 */
public class Validaciones {
    
    public String ip;
    public String mensaje;
    public String puerto;
    public boolean ipVailda;
    public boolean puertoValido;

    public Validaciones() {
    }
    
    public Validaciones(String entradas){
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
    public boolean puertoValido(String puerto){
        boolean v=true;
        for(int i=0; i<puerto.length(); i++){
            if(!noValida(puerto.charAt(i))){
                v=false;
                break;
            }
        }
        if(0<puerto.length()){
            if(v==true){
                int p=Integer.parseInt(puerto);
                if(p<0 || 65535<p){
                    v=false;
                }
            }
        }else{
            v=false;
        }
        return v;
    }
    
    // funcion que verifica si es una ip valia
    public boolean ipValida(String entradas){
        int aux=0;
        char c;
        boolean v=true;
        String s="";
        for(int i=0; i<entradas.length(); i++){
            c=entradas.charAt(i);
            if(noValida(c)){
                s+=c;
            }else{
                int no = Integer.parseInt(s);
                if(255<no || 3<s.length()){
                    v=false;
                    break;
                }
                s="";
            }
            if(i==0 || i==entradas.length()){
                if(c=='.' || c==' '){
                    v=false;
                    break;
                }
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
        if(aux!=3){
            v=false;
        }
        if(entradas.length()<7){
            v=false;
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
