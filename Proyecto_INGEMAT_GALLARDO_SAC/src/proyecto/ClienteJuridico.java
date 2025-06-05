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
    private String representanteLegal;
    private String documentoRepLeg;

    public ClienteJuridico(String direccion, String telefono, String correo, String razonSocial, String ruc, String representanteLegal, String documentoRepLeg) {
        super(direccion, telefono, correo, TIPO_JURIDICO);
        setRazonSocial(razonSocial);
        setRuc(ruc);
        setRepresentanteLegal(representanteLegal);
        setDocumentoRepLeg(documentoRepLeg);
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

    public void setRepresentanteLegal(String representanteLegal) {
        if(representanteLegal == null || representanteLegal.trim().isEmpty()){
            throw new IllegalArgumentException("El representante legal no puede estar vacío");
        }
        this.representanteLegal = representanteLegal;
    }

    public void setDocumentoRepLeg(String documentoRepLeg) {
        if(documentoRepLeg == null || documentoRepLeg.trim().isEmpty()){
            throw new IllegalArgumentException("El representante legal no puede estar vacío");
        }
        this.documentoRepLeg = documentoRepLeg;
    }
 

    @Override
    public String getNombreCompleto() {
        return razonSocial;
    }

    @Override
    public String getDocumento() {
        return ruc;
    }

    public String getRazonSocial() { 
        return razonSocial; 
    }
    public String getRuc() { 
        return ruc; 
    }
    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    @Override
    public String toString() {//CONSTRUCTOR DEL CLIENTE JURIDICO
        return super.toString() + String.format("\n | Tipo: Jurídico | Razón Social: %s | RUC: %s | Representante Legal: %s", razonSocial, ruc, representanteLegal);
    }
}
