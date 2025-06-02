/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ClienteController {
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private int contadorClientes = 1;

    // VALIDAR DOCUMENTO REPETIDO
    private boolean documentoYaExiste(String documento) {
        for (Cliente c : listaClientes) {
            if (c.getDocumento().equals(documento)) {
                return true;
            }
        }
        return false;
    }
    
    private String generarIdCliente() {
        return String.format("CLI-%04d", contadorClientes++);
    }

    public ClienteNatural agregarCliNat(String direccion, String telefono, String correo, String nombre, String dni) {
        if (documentoYaExiste(dni)) {
          System.out.println("Ya existe un cliente con el DNI: " + dni);
          return null;
        }
        try {
        ClienteNatural cn = new ClienteNatural(direccion, telefono, correo, nombre, dni);
        String id = generarIdCliente();  // Generar ID SOLO después de construcción exitosa
        cn.setIdCliente(id);
        listaClientes.add(cn);
            System.out.println("Se agregó el cliente natural correctamente");
        return cn;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear cliente natural: " + e.getMessage());
            return null;
        }
    }

    public ClienteJuridico agregarCliJur(String direccion, String telefono, String correo, String razonSocial, String ruc) {
        if (documentoYaExiste(ruc)) {
          System.out.println("Ya existe un cliente con el RUC: " + ruc);
          return null;
        }
       try {
        ClienteJuridico cj = new ClienteJuridico(direccion, telefono, correo, razonSocial, ruc);
        String id = generarIdCliente();  // Generar ID solo si todo está bien
        cj.setIdCliente(id);
        listaClientes.add(cj);
           System.out.println("Se agrego el cliente juridico correctamente");
        return cj;
        }catch (IllegalArgumentException e) {
            System.out.println("Error al crear cliente jurídico: " + e.getMessage());
            return null;
        }
    }

    public Cliente buscarCliente(String documento) {
        for (Cliente c : listaClientes) {
            if (c.getDocumento().equalsIgnoreCase(documento)) {
                return c;
            }
        }
        System.out.println("Cliente con dni: " + documento + ", no encontrado");
        return null;
    }

    public boolean editarCliente(String documento, String nuevoTelefono, String nuevoCorreo, String nuevaDireccion) {
        Cliente c = buscarCliente(documento);
        if (c != null) {
            try {
            if (nuevoTelefono != null && !nuevoTelefono.isBlank())
                c.setTelefono(nuevoTelefono);
            if (nuevoCorreo != null && !nuevoCorreo.isBlank())
                c.setCorreo(nuevoCorreo);
            if (nuevaDireccion != null && !nuevaDireccion.isBlank())
                c.setDireccion(nuevaDireccion);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        }
        return false;
    }

    public boolean eliminarCliente(String documento) {
        Cliente c = buscarCliente(documento);
        if (c != null) {
            listaClientes.remove(c);
            System.out.println("Cliente eliminado con éxito.");
            return true;
        }
        return false;
    }

    public void mostrarClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente c : listaClientes) {
                System.out.println(c.toString());
            }
        }
    }
}
