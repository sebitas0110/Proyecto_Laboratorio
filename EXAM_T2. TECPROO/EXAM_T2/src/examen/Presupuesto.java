/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Presupuesto {
    private String idPresupuesto;
    private Cliente cliente;
    private ArrayList<Formatos> formatos;
    private double total;
    private String estado;
    private Date fecha;

    public Presupuesto(String idPresupuesto, Cliente cliente, ArrayList<Formatos> formatos) {
        this.idPresupuesto = idPresupuesto;
        this.cliente = cliente;
        this.formatos = formatos;
        this.estado = "Finalizada";
        this.fecha = new Date();
        calcularTotal();
    }
    private void calcularTotal() {
            total = 0;
            for (Formatos f : formatos) {
                total += f.getPrecio();
            }
        }

    public String getIdPresupuesto() {
        return idPresupuesto;
    }
    public void setIdPresupuesto(String idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public ArrayList<Formatos> getFormatos() {
        return formatos;
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
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public void setFormatos(ArrayList<Formatos> formatos) {
        this.formatos = formatos;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
