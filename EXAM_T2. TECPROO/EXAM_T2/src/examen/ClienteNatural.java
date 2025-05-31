/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

/**
 *
 * @author Usuario
 */
public class ClienteNatural extends Cliente{
    private String nombre;
    private String dni;

    public ClienteNatural(String direccion, String telefono, String correo, 
                         String nombre, String dni) {
        super(direccion, telefono, correo);
        setNombre(nombre);
        setDni(dni);
    }

    public void setDni(String dni) {
    if (dni == null || !dni.matches("\\d{8}")) {
        throw new IllegalArgumentException("DNI debe tener exactamente 8 dígitos numéricos");
    }
    this.dni = dni;
}

    @Override
    public boolean validarDocumento() {
        return this.dni != null && this.dni.matches("\\d{8}");
    }
    @Override
    public String getNombreCompleto() {
        return this.getNombre();
    }

    @Override
    public String getDocumento() {
        return this.getDni();
    }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: Natural | Nombre: %s | DNI: %s", nombre, dni);
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
}
