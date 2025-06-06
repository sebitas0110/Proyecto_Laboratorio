/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.regex.Pattern;//sirve para trabajar con expresiones regulares
//en este caso, la validación obl   igatoria de e-mail correctamente escrito.
/**
 *
 * @author Usuario
 */
public abstract class Cliente {
    //CONSTANTES PARA DEFINIR EL TIPO DE CLIENTE(NO VARÍAN DENTRO DEL CODIGO)
    public static final int TIPO_NATURAL = 1;
    public static final int TIPO_JURIDICO = 2;
    
    private String direccion;
    private String telefono;
    private String correo;
    private String idCliente;
    private int tipoCliente;
    
    public Cliente(String direccion, String telefono, String correo, int tipoCliente) {
        setIdCliente(idCliente);
        setDireccion(direccion);
        setTelefono(telefono);
        setCorreo(correo);
        setTipoCliente(tipoCliente);
    }

    //MÉTODOS POLIMÓRFICOS
    public abstract String getNombreCompleto();
    public abstract String getDocumento();

    //SETTERS
    public void setTipoCliente(int tipoCliente) {//VALIDACIÓN DE TIPO DE CLIENTE(NATURAL O JURIDICO)
        if (tipoCliente != TIPO_NATURAL && tipoCliente != TIPO_JURIDICO) {
            throw new IllegalArgumentException("Tipo de cliente inválido");
        }
        this.tipoCliente = tipoCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    public void setTelefono(String telefono) {
        if (telefono == null || !telefono.matches("\\d{9}")) {//VALIDA QUE EL NÚMERO DE TELÉFONO TENGA 9 DÍGITOS OBLIGATORIAMENTE
            throw new IllegalArgumentException("El teléfono debe tener exactamente 9 dígitos");
        }
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";//VALIDA QUE EL CORREO DEBA TENER EL '@' OBLIGATORIO ADEMÁS DEL DOMINIO CORRECTO
        if (correo == null || !Pattern.compile(emailRegex).matcher(correo).matches()) {
            throw new IllegalArgumentException("Correo electrónico no válido");
        }
        this.correo = correo;
    }

    public void setDireccion(String direccion) {//VALIDA QUE LA DIRECCION NO PUEDA SER NULL Y SEA OBLIGATORIA DE PONER
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía");
        }
        this.direccion = direccion;
    }
    
    
    //GETTERS
    public String getCorreo() { 
        return correo; 
    }
    public String getDireccion() { 
        return direccion; 
    }
    public String getIdCliente() { 
        return idCliente; 
    }
    public String getTelefono() { 
        return telefono; 
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    //Constructor
    @Override
    public String toString() {//CONSTRUCTOR PARA IMPRESIÓN DE LOS DATOS DEL CLIENTE
        return String.format("- ID: %s | Dirección: %s | Teléfono: %s | Email: %s",
                idCliente, direccion, telefono, correo);
    }
}
