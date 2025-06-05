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
    
    //CONSTANTES PARA DEFINIR EL TUPO DE EMPRESA(NO VARIAN DENTRO DEL CODIGO)
    public static final int EMPRESA_PRIVADA = 1;
    public static final int EMPRESA_GUBERNAMENTAL = 2;
    
    private String ruc;
    private String razonSocial;
    private String representanteLegal;
    private String documentoRepLeg;
    private int tipoEmpresa;

    public ClienteJuridico(String direccion, String telefono, String correo, 
            String razonSocial, String ruc, String representanteLegal, 
            String documentoRepLeg, int tipoEmpresa) {
        super(direccion, telefono, correo, TIPO_JURIDICO);
        setRazonSocial(razonSocial);
        setRuc(ruc);
        setRepresentanteLegal(representanteLegal);
        setDocumentoRepLeg(documentoRepLeg);
        setTipoEmpresa(tipoEmpresa);
    }

    //SETTERS
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

    public void setTipoEmpresa(int tipoEmpresa) {
        if (tipoEmpresa != EMPRESA_PRIVADA && tipoEmpresa != EMPRESA_GUBERNAMENTAL) {
            throw new IllegalArgumentException("Tipo de empresa no válido");
        }
        this.tipoEmpresa = tipoEmpresa;
    }
    
    
    //GETTERS
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

    public int getTipoEmpresa() {
        return tipoEmpresa;
    }
    
    //MÉTODO DE IMPRESION DEL TIPO DE EMPRESA A TEXTO: PRIVADA O GUBERNAMENTAL
    public String getTipoEmpresaTexto(){
        return tipoEmpresa == EMPRESA_PRIVADA ? "Privada" : "Gubernamental";
    }
    
    //MÉTODO DE IMPRESIÓN DE CLIENTE
    @Override
    public String toString() {//CONSTRUCTOR DEL CLIENTE JURIDICO
        return super.toString() + String.format("\n | Tipo: Jurídico "
                + "| Razón Social: %s | RUC: %s | Representante Legal: %s | RR.LL. Documento: %s | Tipo de Empresa: %s", 
                razonSocial, ruc, representanteLegal, documentoRepLeg, getTipoEmpresaTexto());
    }
}
