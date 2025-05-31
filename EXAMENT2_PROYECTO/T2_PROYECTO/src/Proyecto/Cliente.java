/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author Usuario
 */
public class Cliente {
    private String tipo; // natural o jurídico
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private String documento; // DNI o RUC
    private String idCliente;

    public Cliente(String tipo, String nombre, String direccion, String telefono, String correo, String documento) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.documento = documento;
        this.idCliente = idCliente;
    }

    public String getTipo() { 
        return tipo; 
    }
    public String getNombre() { 
        return nombre; 
    }
    public String getDireccion() { 
        return direccion; 
    }
    public String getTelefono() { 
        return telefono; 
    }
    public String getCorreo() { 
        return correo; 
    }
    public String getDocumento() { 
        return documento; 
    }
    public String getIdCliente() {
        return idCliente;
    }
    
    public void setTipo(String tipo) { 
        this.tipo = tipo; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    public void setDireccion(String direccion) { 
        this.direccion = direccion; 
    }
    public void setTelefono(String telefono) { 
        this.telefono = telefono; 
    }
    public void setCorreo(String correo) { 
        this.correo = correo; 
    }
    public void setDocumento(String documento) { 
        this.documento = documento; 
    }
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
}
