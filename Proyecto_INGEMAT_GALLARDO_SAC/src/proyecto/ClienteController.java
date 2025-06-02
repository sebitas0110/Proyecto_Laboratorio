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

    // GENERAR ID ÚNICO
    private String generarIdCliente() {
        return String.format("CLI-%04d", contadorClientes++);
    }

    // CREAR Y AGREGAR CLIENTE NATURAL
    public ClienteNatural agregarCliNat(String direccion, String telefono, String correo, String nombre, String dni) {
        try {
            String id = generarIdCliente();
            ClienteNatural cn = new ClienteNatural(id, direccion, telefono, correo, nombre, dni);
            listaClientes.add(cn);
            return cn;
        } catch (IllegalArgumentException ex) {
            System.out.println("Error al agregar cliente natural: " + ex.getMessage());
            return null;
        }
    }

    // CREAR Y AGREGAR CLIENTE JURIDICO
    public ClienteJuridico agregarCliJur(String direccion, String telefono, String correo, String razonSocial, String ruc) {
        try {
            String id = generarIdCliente();
            ClienteJuridico cj = new ClienteJuridico(id, direccion, telefono, correo, razonSocial, ruc);
            listaClientes.add(cj);
            return cj;
        } catch (IllegalArgumentException ex) {
            System.out.println("Error al agregar cliente jurídico: " + ex.getMessage());
            return null;
        }
    }

    // BUSCAR POR ID DE CLIENTE
    public Cliente buscarCliente(String idCliente) {
        for (Cliente c : listaClientes) {
            if (c.getIdCliente().equalsIgnoreCase(idCliente)) {
                return c;
            }
        }
        System.out.println("Cliente no encontrado.");
        return null;
    }

    // EDITAR CLIENTE
    public boolean editarCliente(String idCliente, String nuevoTelefono, String nuevoCorreo, String nuevaDireccion) {
        Cliente c = buscarCliente(idCliente);
        if (c != null) {
            try {
                c.setTelefono(nuevoTelefono);
                c.setCorreo(nuevoCorreo);
                c.setDireccion(nuevaDireccion);
                System.out.println("Cliente actualizado con éxito.");
                return true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error en edición: " + ex.getMessage());
            }
        }
        return false;
    }

    // ELIMINAR CLIENTE
    public boolean eliminarCliente(String idCliente) {
        Cliente c = buscarCliente(idCliente);
        if (c != null) {
            listaClientes.remove(c);
            System.out.println("Cliente eliminado con éxito.");
            return true;
        }
        return false;
    }

    // MOSTRAR TODOS LOS CLIENTES
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
