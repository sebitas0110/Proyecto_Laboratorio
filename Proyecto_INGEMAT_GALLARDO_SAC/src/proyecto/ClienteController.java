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

    //Método para agregar a clientes naturales
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

    //Método para agregar a clientes jurídicos
    public ClienteJuridico agregarCliJur(String direccion, String telefono, String correo, String razonSocial, 
                                                String ruc, String representanteLegal, String documentoRepLeg) {
        if (documentoYaExiste(ruc)) {
          System.out.println("Ya existe un cliente con el RUC: " + ruc);
          return null;
        }
       try {
        ClienteJuridico cj = new ClienteJuridico(direccion, telefono, correo, razonSocial, ruc, representanteLegal, documentoRepLeg);
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

    //Método para buscar al cliente mediante el número de documento
    public Cliente buscarCliente(String documento) {
        for (Cliente c : listaClientes) {
            if (c.getDocumento().equalsIgnoreCase(documento)) {
                return c;
            }
        }
        System.out.println("Cliente con n° de documento: " + documento + ", no encontrado");
        return null;
    }

    //Método para modificar al cliente mediante número de documento(dni o ruc)
    public boolean editarCliente(String documento, String nuevoTelefono, String nuevoCorreo, String nuevaDireccion, 
                             String nuevoRepresentanteLegal, String nuevoDocRepLeg,boolean documentoJustificante) {
    Cliente c = buscarCliente(documento);
    
    if (c != null) {
        try {
            if (nuevoTelefono != null && !nuevoTelefono.isBlank())
                c.setTelefono(nuevoTelefono);
            if (nuevoCorreo != null && !nuevoCorreo.isBlank())
                c.setCorreo(nuevoCorreo);
            if (nuevaDireccion != null && !nuevaDireccion.isBlank())
                c.setDireccion(nuevaDireccion);

            // Solo si es un cliente jurídico
            if (c.getTipoCliente() == Cliente.TIPO_JURIDICO && c instanceof ClienteJuridico) {
                ClienteJuridico cj = (ClienteJuridico) c;

                if (nuevoRepresentanteLegal != null && !nuevoRepresentanteLegal.isBlank()) {
                    if (documentoJustificante) {
                        cj.setRepresentanteLegal(nuevoRepresentanteLegal);
                        System.out.println("Representante legal actualizado correctamente.");
                    } else {
                        System.out.println("No se puede actualizar el representante legal sin documento justificante.");
                    }
                }
                
            }

            return true;

        } catch (IllegalArgumentException e) {
            System.out.println("Error al editar cliente: " + e.getMessage());
        }
    }

    return false;
}

    //eliminar al cliente encontrado por número de documento(dni o ruc)
    public boolean eliminarCliente(String documento) {
        Cliente c = buscarCliente(documento);
        if (c != null) {
            listaClientes.remove(c);
            System.out.println("Cliente eliminado con éxito.");
            return true;
        }
        return false;
    }

    //Muestra a todos los clientes
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
