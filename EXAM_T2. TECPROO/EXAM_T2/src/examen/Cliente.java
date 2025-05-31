/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;
import java.util.ArrayList;
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
    private final String idCliente;
    private static int contadorClientes = 1;
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();

    public Cliente(String direccion, String telefono, String correo) {
        this.direccion = direccion;
        setTelefono(telefono);
        setCorreo(correo);
        this.idCliente = generarIdCliente();
        listaClientes.add(this);
    }
    
    private String generarIdCliente() {
        return String.format("CLI-%04d", contadorClientes++);
    }
    
    public abstract boolean validarDocumento();
    public abstract String getNombreCompleto();  // Para obtener nombre o razón social
    public abstract String getDocumento();       // Para obtener DNI o RUC
    
    // Validación de teléfono (9 dígitos)
    public void setTelefono(String telefono) {
        if (telefono == null || !telefono.matches("\\d{9}")) {
            throw new IllegalArgumentException("El teléfono debe tener exactamente 9 dígitos");
        }
        this.telefono = telefono;
    }
    
    // Validación de email básica
    public void setCorreo(String correo) {
        //valida mayúsculas, minusculas, simboloes, el '@' es obligatorio, y lo demás que siga(dominio)
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (correo == null || !Pattern.compile(emailRegex).matcher(correo).matches()) {
            throw new IllegalArgumentException("Correo electrónico no válido");
        }
        this.correo = correo;
    }
    
    public static ArrayList<Cliente> getListaClientes() {
        return new ArrayList<>(listaClientes);
    }
    
    // Getters (no setters para idCliente ya que es final)
    public String getCorreo() { return correo; }
    public String getDireccion() { return direccion; }
    public String getIdCliente() { return idCliente; }
    public String getTelefono() { return telefono; }
    
    public void setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía");
        }
        this.direccion = direccion;
    }
    
    @Override
    public String toString() {
        return String.format("ID: %s | Dirección: %s | Teléfono: %s | Email: %s", 
                idCliente, direccion, telefono, correo);
    }
}
