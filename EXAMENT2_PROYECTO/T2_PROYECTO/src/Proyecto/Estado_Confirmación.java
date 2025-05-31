/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author Usuario
 */
public class Estado_Confirmación {
    private int idEstadoConf;
    private String estado;

    public Estado_Confirmación(int idEstadoConf, String estado) {
        this.idEstadoConf = idEstadoConf;
        this.estado = estado;
    }

    public int getIdEstadoConf() {
        return idEstadoConf;
    }

    public void setIdEstadoConf(int idEstadoConf) {
        this.idEstadoConf = idEstadoConf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método ejemplo
    public boolean esConfirmado() {
        return "Confirmado".equalsIgnoreCase(estado);
    }
}
