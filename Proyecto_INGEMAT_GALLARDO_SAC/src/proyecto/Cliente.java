/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.util.regex.Pattern;//sirve para trabajar con expresiones regulares
//en este caso, la validación obligatoria de e-mail correctamente escrito.
/**
 *
 * @author Usuario
 */
public abstract class Cliente {
    private String direccion;
    private String telefono;
    private String correo;
    private String idCliente;

    public Cliente(String direccion, String telefono, String correo, String idCliente) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.idCliente = idCliente;
    }
    
    //MÉTODOS POLIMÓRFICOS PARA VALIDACIÓN
    public abstract boolean validarDocumento();
    public abstract String getNombreCompleto();
    public abstract String getDocumento();
    
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

    //SETTERS
    public void setCorreo(String correo) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (correo == null || !Pattern.compile(emailRegex).matcher(correo).matches()) {
            throw new IllegalArgumentException("Correo electrónico no válido");
        }
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
         if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía");
        }
        this.direccion = direccion.trim();
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //MÉTODO POLIMÓRFICO DE IMPRESIÓN
    @Override
    public String toString() {
        return String.format("ID: %s | Dirección: %s | Teléfono: %s | Email: %s", 
                idCliente, direccion, telefono, correo);
    }
    
}
