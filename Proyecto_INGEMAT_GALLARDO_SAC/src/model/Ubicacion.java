/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Usuario
 */
public class Ubicacion {
    private String idUbicacion;
    private String direccion;
    private Distrito distrito;
    private Provincia provincia;
    private Departamento departamento;

    public Ubicacion(String direccion, Distrito distrito, String idUbicacion) {
        this.idUbicacion = idUbicacion;
        this.direccion = direccion;
        this.distrito = distrito;
        this.provincia = distrito.getProvincia();
        this.departamento = provincia.getDepartamento();
    }

    public String getIdUbicacion() {
        return idUbicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public Provincia getProvincia() {
        return provincia;
    }
    

    @Override
    public String toString() {
        return direccion + ", " + distrito + ", " + provincia + ", " + departamento;
    }

}
