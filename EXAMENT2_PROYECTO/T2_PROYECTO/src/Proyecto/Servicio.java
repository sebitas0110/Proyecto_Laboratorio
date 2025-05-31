/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author Usuario
 */
public class Servicio {
    private String nombre, descripcion, categoria, plantilla;
    private double precio;
    private boolean activo;

    public Servicio(String nombre, String descripcion, String categoria, double precio,String plantilla) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.plantilla = plantilla;
        this.activo = true;
    }

    public String getNombre() { 
        return nombre; 
    }
    public String getDescripcion() { 
        return descripcion; 
    }
    public String getCategoria() { 
        return categoria; 
    }
    public double getPrecio() { 
        return precio; 
    }
    public String getPlantilla() { 
        return plantilla; 
    }
    public boolean isActivo() { 
        return activo; 
    }

    public void setActivo(boolean activo) { 
        this.activo = activo; 
    }
}
