/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Usuario
 */
public class ClienteNatural extends Cliente{
    private String nombre;
    private String dni;

    public ClienteNatural(Ubicacion ubicacion, String telefono, String correo, String nombre, String dni) {
        super(ubicacion, telefono, correo, TIPO_NATURAL);
        setNombre(nombre);
        setDni(dni);
    }

    public void setDni(String dni) {
        if (dni == null || !dni.matches("\\d{8}")) {//VALIDA QUE EL DNI TENGA 8 DÍGITOS OBLIGATORIAMENTE
            throw new IllegalArgumentException("DNI debe tener exactamente 8 dígitos");
        }
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {//OBLIGA A QUE EL NOMBRE NO ESTÉ VACIO(NULL O NONE)
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    
    @Override
    public String getNombreCompleto() {
        return nombre;
    }

    @Override
    public String getDocumento() {
        return dni;
    }

    public String getNombre() { 
        return nombre; 
    }
    public String getDni() { 
        return dni; 
    }

    @Override
    public String toString() {//IMPRESIÓN DE DATOS DEL CLIENTE NATURAL
        return super.toString() + String.format("\n | Tipo: Natural | Nombre: %s | DNI: %s", nombre, dni);
    }
}
