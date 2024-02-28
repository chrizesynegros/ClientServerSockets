/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4_Objetos;

import java.io.Serializable;

/**
 *
 * @author Chris
 */
public class Empleado implements Serializable{
    private String nombre;
    private String direccion;
    private long tel;
    private String mail;
    private long ss;
    private String curp;

    public Empleado(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tel = 494101669;
        this.mail = "alonso@gmail.com";
        this.ss = 498218;
        this.curp = "aapm980829hzslrr02";
    }

    public Empleado(String nombre, String direccion, long tel, String mail, long ss, String curp) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tel = tel;
        this.mail = mail;
        this.ss = ss;
        this.curp = curp;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getSs() {
        return ss;
    }

    public void setSs(long ss) {
        this.ss = ss;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + "\n direccion=" + direccion + "\n tel=" + tel + "\n mail=" + mail + "\n ss=" + ss + "\n curp=" + curp + '}';
    }
    
    
}
