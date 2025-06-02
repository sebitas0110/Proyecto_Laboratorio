/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author Usuario
 */
public class ClienteJuridico extends Cliente{
    private String razonSocial;
    private String ruc;

    public ClienteJuridico(String razonSocial, String ruc, String direccion, String telefono, String correo) {
        super(direccion, telefono, correo, idCliente);
        this.razonSocial = razonSocial;
        this.ruc = ruc;
    }
    
    //GETTERS
    public String getRuc() {
        return ruc;
    }
    public String getRazonSocial() {
        return razonSocial;
    }
    
    
    //SETTERS DE razonSocial y ruc 
    public void setRazonSocial(String razonSocial) {
        if (razonSocial == null || razonSocial.trim().isEmpty()) {
            throw new IllegalArgumentException("Razón social no puede estar vacía");
        }
        this.razonSocial = razonSocial.trim();
    }

    public void setRuc(String ruc) {
         if (ruc == null || !ruc.matches("\\d{11}")) {
            throw new IllegalArgumentException("RUC debe tener exactamente 11 dígitos numéricos");
        }
        this.ruc = ruc;
    }
    
    //MÉTODOS POLIMÓRFICOS DE VALIDACIÓN
    @Override
    public boolean validarDocumento() {
        return ruc != null && ruc.matches("\\d{11}");
    }

    @Override
    public String getNombreCompleto() {
        return razonSocial;
    }

    @Override
    public String getDocumento() {
        return ruc;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: Jurídico | Razón Social: %s | RUC: %s", razonSocial, ruc);
    }
    
    
    
}
