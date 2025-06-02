/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public class Tester {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    menuClientes(scanner);
                    break;
                case "2":
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        scanner.close();
    }

    // --------------------- MENÚ CLIENTES -------------------------
    public static void menuClientes(Scanner scanner) {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n--- MENÚ DE CLIENTES ---");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Buscar Cliente");
            System.out.println("3. Editar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Mostrar Clientes");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    registrarCliente(scanner);
                    break;
                case "2":
                    buscarCliente(scanner);
                    break;
                case "3":
                    editarCliente(scanner);
                    break;
                case "4":
                    eliminarCliente(scanner);
                    break;
                case "5":
                    mostrarClientes();
                    break;
                case "6":
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // --------------------- MÉTODOS CLIENTE -------------------------

    public static void registrarCliente(Scanner scanner) {
        System.out.println("\n--- Registro de Cliente ---");
        System.out.print("Tipo (1 = Natural, 2 = Jurídico): ");
        String tipo = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Teléfono (9 dígitos): ");
        String telefono = scanner.nextLine();

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        if (tipo.equals("1")) {
            System.out.print("Nombre completo: ");
            String nombre = scanner.nextLine();
            System.out.print("DNI (8 dígitos): ");
            String dni = scanner.nextLine();

            Cliente nuevo = new ClienteNatural(nombre, direccion, telefono, correo, dni, correo);
            System.out.println("Cliente natural registrado: " + nuevo.getIdCliente());

        } else if (tipo.equals("2")) {
            System.out.print("Razón Social: ");
            String razonSocial = scanner.nextLine();
            System.out.print("RUC (11 dígitos): ");
            String ruc = scanner.nextLine();

            Cliente nuevo = new ClienteJuridico(razonSocial, ruc, direccion, telefono, correo);
            System.out.println("Cliente jurídico registrado: " + nuevo.getIdCliente());

        } else {
            System.out.println("Tipo de cliente inválido.");
        }
    }

    public static void buscarCliente(Scanner scanner) {
        System.out.print("Ingrese DNI o RUC del cliente a buscar: ");
        String doc = scanner.nextLine();
        Cliente encontrado = buscarPorDocumento(doc);
        if (encontrado != null) {
            System.out.println("Cliente encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("No se encontró ningún cliente con ese documento.");
        }
    }

    public static void editarCliente(Scanner scanner) {
        System.out.print("Ingrese DNI o RUC del cliente a editar: ");
        String doc = scanner.nextLine();
        Cliente cliente = buscarPorDocumento(doc);
        if (cliente != null) {
            System.out.println("Editando cliente: " + cliente.getIdCliente());

            System.out.print("Nuevo teléfono: ");
            cliente.setTelefono(scanner.nextLine());

            System.out.print("Nuevo correo: ");
            cliente.setCorreo(scanner.nextLine());

            System.out.print("Nueva dirección: ");
            cliente.setDireccion(scanner.nextLine());

            System.out.println("Cliente actualizado.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public static void eliminarCliente(Scanner scanner) {
        System.out.print("Ingrese DNI o RUC del cliente a eliminar: ");
        String doc = scanner.nextLine();
        Cliente cliente = buscarPorDocumento(doc);
        if (cliente != null) {
            ClienteController.mostrarClientes().remove(cliente);
            System.out.println("Cliente eliminado.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public static void mostrarClientes() {
        ArrayList<Cliente> lista = Cliente.getListaClientesOriginal();
        if (lista.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("\n--- Lista de Clientes ---");
            for (Cliente c : lista) {
                System.out.println(c);
            }
        }
    }

    public static Cliente buscarPorDocumento(String doc) {
        for (Cliente c : Cliente.getListaClientesOriginal()) {
            if (c.getDocumento().equals(doc)) {
                return c;
            }
        }
        return null;
    }
}
