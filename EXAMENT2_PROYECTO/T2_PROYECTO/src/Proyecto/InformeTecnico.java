/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author Usuario
 */
public class InformeTecnico {
    private String id;
    private String plantilla;
    private String observaciones;
    private String conclusiones;
    private Venta venta;

    public InformeTecnico(String id, String plantilla, Venta venta) {
        this.id = id;
        this.plantilla = plantilla;
        this.venta = venta;
        this.observaciones = "";
        this.conclusiones = "";
    }

    public String getId() {
        return id;
    }

    public String getPlantilla() {
        return plantilla;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getConclusiones() {
        return conclusiones;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setObservaciones(String obs) {
        if (obs.length() > 5000)
            throw new IllegalArgumentException("Límite de texto excedido");
        this.observaciones = obs;
    }

    public void setConclusiones(String conc) {
        if (conc.length() > 5000)
            throw new IllegalArgumentException("Límite de texto excedido");
        this.conclusiones = conc;
    }

    public void generarInforme() {
        System.out.println("Informe generado para venta: " + venta.getCodigo());
    }
}
