/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Usuario
 */
public class Provincia {
    private String idProvincia;
    private String nombreProvincia;
    private Departamento departamento;

    public Provincia(String nombreProvincia, Departamento departamento, String idProvincia) {
        this.idProvincia = idProvincia;
        this.nombreProvincia = nombreProvincia;
        this.departamento = departamento;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }
    

    public Departamento getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return nombreProvincia;
    }
}