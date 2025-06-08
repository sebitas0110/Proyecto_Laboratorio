/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import model.Ubicacion;
/**
 *
 * @author Usuario
 */
public class UbicacionView {
    public void mostrar(Ubicacion ubicacion) {
        System.out.println("\nUbicación registrada:");
        System.out.println("ID: " + ubicacion.getIdUbicacion());
        System.out.println("Dirección completa: " + ubicacion);
    }
}
