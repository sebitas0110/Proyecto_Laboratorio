/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Venta {
    private String idVenta;
    private Cliente cliente;
    private List<Servicio> servicios;
    private double total;
    private String estado;
    private Date fecha;

    public Venta(String idVenta, Cliente cliente, List<Servicio> servicios) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.servicios = servicios;
        this.estado = "Finalizada";
        this.fecha = new Date();
        calcularTotal();
    }

    private void calcularTotal() {
        total = 0;
        for (Servicio s : servicios) {
            total += s.getPrecio();
        }
    }

    public String getCodigo() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public double getTotal() {
        return total;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
