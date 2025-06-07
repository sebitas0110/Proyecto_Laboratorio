/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Administrador;
/**
 *
 * @author Usuario
 */
public class AdministradorController {
    private Administrador admin;

    public AdministradorController(Administrador admin) {
        this.admin = admin;
    }
    
    public boolean validarAcceso(String usuarioIngresado, String contraseñaIngresada){
        return admin.getUsuario().equals(usuarioIngresado) 
                && admin.getContraseña().equals(contraseñaIngresada);
    }
}
