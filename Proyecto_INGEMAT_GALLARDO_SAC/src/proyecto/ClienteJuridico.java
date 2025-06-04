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
   private String ruc;
    private String razonSocial;

    public ClienteJuridico(String direccion, String telefono, String correo, String razonSocial, String ruc) {
        super(direccion, telefono, correo);
        setRazonSocial(razonSocial);
        setRuc(ruc);
    }

    public void setRuc(String ruc) {
        if (ruc == null || !ruc.matches("\\d{11}")) {//VALIDA QUE EL DOCUMENTO(RUC) TENGA 11 DIGITOS OBLIGATORIAMENTE
            throw new IllegalArgumentException("RUC debe tener exactamente 11 dígitos");
        }
        this.ruc = ruc;
    }

    public void setRazonSocial(String razonSocial) {//VALIDA QUE LA RAZÓN SOCIAL NO ESTE VACÍA
        if (razonSocial == null || razonSocial.trim().isEmpty()) {
            throw new IllegalArgumentException("Razón social no puede estar vacía");
        }
        this.razonSocial = razonSocial.trim();
    }

    //@Override
    //public boolean validarDocumento() {
    //    return ruc != null && ruc.matches("\\d{11}");
    //}

    @Override
    public String getNombreCompleto() {
        return razonSocial;
    }

    @Override
    public String getDocumento() {
        return ruc;
    }

    public String getRazonSocial() { return razonSocial; }
    public String getRuc() { return ruc; }

    @Override
    public String toString() {//CONSTRUCTOR DEL CLIENTE JURIDICO
        return super.toString() + String.format(" | Tipo: Jurídico | Razón Social: %s | RUC: %s", razonSocial, ruc);
    }
}
