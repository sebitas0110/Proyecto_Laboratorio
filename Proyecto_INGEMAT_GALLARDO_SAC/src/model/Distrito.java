/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Usuario
 */
public class Distrito {
    private String idDistrito;
    private String nombreDistrito;
    private Provincia provincia;

    public Distrito(String nombreDistrito, Provincia provincia, String idDistrito) {
        this.idDistrito = idDistrito;
        this.nombreDistrito = nombreDistrito;
        this.provincia = provincia;
    }
    
    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    @Override
    public String toString() {
        return nombreDistrito;
    }
}
