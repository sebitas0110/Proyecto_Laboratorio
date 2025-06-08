/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class EmpresaSolicitante {
    private int id;
    private String nombre;

    public EmpresaSolicitante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void registrarEmpresa() {
        // Lógica de registro
    }

    public String obtenerNombre() {
        return nombre;
    }

}
