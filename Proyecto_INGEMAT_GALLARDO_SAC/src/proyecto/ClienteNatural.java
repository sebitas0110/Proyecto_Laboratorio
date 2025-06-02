/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author Usuario
 */
public class ClienteNatural extends Cliente{
    private String nombre;
    private String dni;

    public ClienteNatural(String nombre, String dni, String direccion, String telefono, String correo, String idCliente) {
        super(direccion, telefono, correo, idCliente);
        this.nombre = nombre;
        this.dni = dni;
    }
    //SETTERS DE NOMBRE Y DNI
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }
    public void setDni(String dni) {
        if (dni == null || !dni.matches("\\d{8}")) {
            throw new IllegalArgumentException("DNI debe tener exactamente 8 dígitos numéricos");
        }
        this.dni = dni;
    }

    
    //GETTERS DE NOMBRE Y DOCUMENTO
    @Override
    public String getNombreCompleto() {
        return nombre;
    }
    @Override
    public String getDocumento() {
        return dni;
    }
    
    //MÉTODOS POLIMÓRFICOS HEREDADOS
    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }    
    @Override
    public boolean validarDocumento() {
        return dni != null && dni.matches("\\d{8}");
    }
    
    
    
}
