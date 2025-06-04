/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.util.regex.Pattern;//sirve para trabajar con expresiones regulares
//en este caso, la validación obl   igatoria de e-mail correctamente escrito.
/**
 *
 * @author Usuario
 */
public abstract class Cliente {
    private String direccion;
    private String telefono;
    private String correo;
    private String idCliente;
    
    public Cliente(String direccion, String telefono, String correo) {
        this.idCliente = idCliente;
        setDireccion(direccion);
        setTelefono(telefono);
        setCorreo(correo);
    }

    //MÉTODOS POLIMÓRFICOS
    //public abstract boolean validarDocumento();
    public abstract String getNombreCompleto();
    public abstract String getDocumento();

    //SETTERS
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

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía");
        }
        this.direccion = direccion;
    }
    
    
    //GETTERS
    public String getCorreo() { return correo; }
    public String getDireccion() { return direccion; }
    public String getIdCliente() { return idCliente; }
    public String getTelefono() { return telefono; }

    //Constructor
    @Override
    public String toString() {//CONSTRUCTOR PARA IMPRESIÓN DE LOS DATOS DEL CLIENTE
        return String.format("ID: %s | Dirección: %s | Teléfono: %s | Email: %s",
                idCliente, direccion, telefono, correo);
    }
}
