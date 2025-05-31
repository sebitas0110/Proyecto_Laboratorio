/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

/**
 *
 * @author Usuario
 */
public class ClienteJuridico extends Cliente{
    private String ruc;
    private String razonSocial;
    
    public ClienteJuridico(String direccion, String telefono, String correo, 
                          String razonSocial, String ruc) {
        super(direccion, telefono, correo);
        setRazonSocial(razonSocial);
        setRuc(ruc);
    }
    @Override
    public String getNombreCompleto() {
        return this.getRazonSocial();
    }

    @Override
    public String getDocumento() {
        return this.getRuc();
    }
    public void setRuc(String ruc) {
    if (ruc == null || !ruc.matches("\\d{11}")) {
        throw new IllegalArgumentException("RUC debe tener exactamente 11 dígitos numéricos");
    }
    this.ruc = ruc;
}

    @Override
    public boolean validarDocumento() {
        return this.ruc != null && this.ruc.matches("\\d{11}");
    }
    
    public void setRazonSocial(String razonSocial) {
        if (razonSocial == null || razonSocial.trim().isEmpty()) {
            throw new IllegalArgumentException("Razón social no puede estar vacía");
        }
        this.razonSocial = razonSocial.trim();
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: Jurídico | Razón Social: %s | RUC: %s", 
                razonSocial, ruc);
    }
    
    // Getters
    public String getRazonSocial() { return razonSocial; }
    public String getRuc() { return ruc; }
}
