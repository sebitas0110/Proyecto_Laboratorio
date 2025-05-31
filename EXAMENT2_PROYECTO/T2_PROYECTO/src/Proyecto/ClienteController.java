/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class ClienteController {
     private List<Cliente> listaClientes = new ArrayList<>();
     private int contadorClientes = 1;
     
     public String registrarCliente(Cliente c) {
        if (!validarDocumento(c.getDocumento(), c.getTipo())) return "DNI/RUC inválido";
        if (existeDocumento(c.getDocumento())) return "Este documento ya está registrado";

        //GENERAR Y ASIGNAR CÓDIGO AUTOMÁTICO AL CLIENTE
        String codigoCliente = String.format("CLI-%06d", contadorClientes++);
        c.setIdCliente(codigoCliente);
        
        listaClientes.add(c);
        return "Cliente registrado correctamente";
    }

    private boolean validarDocumento(String doc, String tipo) {
        if (tipo.equalsIgnoreCase("natural")) return doc.matches("\\d{8}");
        else return doc.matches("\\d{11}");
    }

    private boolean existeDocumento(String doc) {
        for (Cliente c : listaClientes) {
            if (c.getDocumento().equals(doc)) return true;
        }
        return false;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
}
