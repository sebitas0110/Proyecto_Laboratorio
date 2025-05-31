/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author Usuario
 */
public class Factura {
    private String numero;
    private Venta venta;
    private String usuarioEmisor;
    private double subtotal, igv, total;

    public Factura(String numero, Venta venta, String usuario) {
        this.numero = numero;
        this.venta = venta;
        this.usuarioEmisor = usuario;
        this.total = venta.getTotal();
        this.subtotal = total / 1.18;
        this.igv = total - subtotal;
    }

    public String getNumero() {
        return numero;
    }

    public Venta getVenta() {
        return venta;
    }

    public String getUsuarioEmisor() {
        return usuarioEmisor;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public double getTotal() {
        return total;
    }

    public void generarPDF() {
        System.out.println("Factura generada para: " + venta.getCliente().getNombre());
    }
}
