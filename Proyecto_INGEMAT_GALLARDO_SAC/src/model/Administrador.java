/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Usuario
 */
public class Administrador {
    private String usuario;
    private String contraseña;

    public Administrador() {
        this.usuario="admin";
        this.contraseña="admin123";
    }

    public Administrador(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    //Getters
    public String getContraseña() {
        return contraseña;
    }
    public String getUsuario() {
        return usuario;
    }
    
    //SETTERS
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
