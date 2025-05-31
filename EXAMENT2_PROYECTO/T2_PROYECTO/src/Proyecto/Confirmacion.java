/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author Usuario
 */
public class Confirmacion {
    private int idConfr;

    public Confirmacion(int idConfr) {
        this.idConfr = idConfr;
    }

    public int getIdConfr() {
        return idConfr;
    }

    public void setIdConfr(int idConfr) {
        this.idConfr = idConfr;
    }

    // Método ejemplo
    public String obtenerTipoConfirmacion() {
        // Lógica de negocio: por ejemplo, según ID retornar un tipo
        return "Confirmación estándar";
    }
}
