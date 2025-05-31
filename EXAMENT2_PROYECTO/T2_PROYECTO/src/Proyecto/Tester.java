/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proyecto;
import java.util.*;
/**
 *
 * @author Usuario
 */
public class Tester {

    static ClienteController clienteController = new ClienteController();
    static ServicioController servicioController = new ServicioController();
    static List<Venta> ventas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        PrecargarServicios(); // Para tener algo que vender

        while (true) {
            System.out.println("\n===== INGEMAT GALLARDO S.A.C. =====");
            System.out.println("1. Escanear y registrar cliente");
            System.out.println("2. Listar clientes registrados");
            System.out.println("3. Registrar venta directa");
            System.out.println("4. Listar ventas realizadas");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opcion: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    ingresarClientes();
                    break;
                case "2":
                    listarClientes();
                    break;
                case "3":
                    registrarVenta();
                    break;
                case "4":
                    listarVentas();
                    break;
                case "5":
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        }
    }

    private static void ingresarClientes() {
        System.out.println("Ingrese sus datos personales: ");
        String tipo;
        while (true) {
            System.out.print("Tipo (natural/juridico): ");
            tipo = scanner.nextLine().trim().toLowerCase(); // Limpiamos espacios y pasamos a minúsculas

        if (tipo.equals("natural") || tipo.equals("juridico")) {
            break; // Entrada válida, salimos del bucle
        } else {
            System.out.println("Entrada invalida. Escriba 'natural' o 'juridico'. Intente nuevamente.");
        }
}
        String nombre;
        while (true) {
            System.out.print("Nombre o Razon Social: ");
            nombre = scanner.nextLine().trim();

            // Validar que no esté vacío y que no contenga números
            if (!nombre.isEmpty() && nombre.matches("^[^\\d]+$")) {
                break;
            } else {
                System.out.println("Entrada invalida. No debe contener numeros ni estar vacía. Intente nuevamente.");
            }
        }

        System.out.print("Direccion: ");
        String direccion = scanner.nextLine();

        String telefono;
        while (true) {
            System.out.print("Telefono: ");
            telefono = scanner.nextLine().trim();

            // Validar que tenga exactamente 9 dígitos y solo números
            if (telefono.matches("\\d{9}")) {
                break;
            } else {
                System.out.println("Entrada invalida. El telefono debe tener exactamente 9 digitos numericos. Intente nuevamente.");
            }
        }

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        System.out.print("DNI o RUC: ");
        String documento = scanner.nextLine();

        Cliente nuevo = new Cliente(tipo, nombre, direccion, telefono, correo, documento);
        String resultado = clienteController.registrarCliente(nuevo);
        System.out.println("Resultado: " + resultado);
    }

    private static void listarClientes() {
        List<Cliente> lista = clienteController.getListaClientes();
        if (lista.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        System.out.println("\nClientes Registrados:");
        for (Cliente c : lista) {
            System.out.println("- " + c.getIdCliente() + " | "+ c.getTipo() + " | " + c.getNombre() + " | " + c.getDocumento());
        }
    }

    private static void registrarVenta() {
    System.out.println("\n--- REGISTRAR VENTA DIRECTA ---");

    if (clienteController.getListaClientes().isEmpty()) {
        System.out.println("No hay clientes registrados. Registre al menos uno.");
        return;
    }

    System.out.println("Seleccione cliente por número:");
    List<Cliente> clientes = clienteController.getListaClientes();
    for (int i = 0; i < clientes.size(); i++) {
        System.out.println(i + ". " + clientes.get(i).getNombre() + " (" + clientes.get(i).getDocumento() + ")");
    }

    System.out.print("Opción: ");
    int clienteIdx = Integer.parseInt(scanner.nextLine());
    Cliente clienteSeleccionado = clientes.get(clienteIdx);

    List<Servicio> serviciosDisponibles = servicioController.listarServiciosActivos();
    List<Servicio> carrito = new ArrayList<>();

    System.out.println("Servicios disponibles:");
    for (int i = 0; i < serviciosDisponibles.size(); i++) {
        Servicio s = serviciosDisponibles.get(i);
        System.out.println(i + ". " + s.getNombre() + " - S/ " + String.format("%.2f", s.getPrecio()));
    }

    while (true) {
        System.out.print("Ingrese número del servicio a agregar (o 'fin' para terminar): ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("fin")) break;

        try {
            int servicioIdx = Integer.parseInt(input);
            if (servicioIdx >= 0 && servicioIdx < serviciosDisponibles.size()) {
                carrito.add(serviciosDisponibles.get(servicioIdx));
                System.out.println("Servicio agregado.");
            } else {
                System.out.println("Índice fuera de rango.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    if (carrito.isEmpty()) {
        System.out.println("No se puede registrar una venta sin servicios.");
        return;
    }

    // ✅ Generación del código automático
    String codigoVenta = String.format("VEN-%06d", ventas.size() + 1);

    // Crear y registrar la venta
    Venta venta = new Venta(codigoVenta, clienteSeleccionado, carrito);
    ventas.add(venta);

    System.out.println("Venta registrada correctamente con código: " + codigoVenta);
    System.out.println("Total: S/ " + String.format("%.2f", venta.getTotal()));
}

    private static void listarVentas() {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }

        System.out.println("\n--- LISTADO DE VENTAS ---");
        for (Venta v : ventas) {
            System.out.println("Codigo: " + v.getCodigo() +
                               " | Cliente: " + v.getCliente().getNombre() +
                               " | Total: S/ " + v.getTotal());
        }
    }

    private static void PrecargarServicios() {
        servicioController.agregarServicio(new Servicio("Analisis de suelo", "Deteccion de metales", "Quimica", 150.0,"PLANT1"));
        servicioController.agregarServicio(new Servicio("Ensayo geotecnio", "Resistencia de materiales", "Mecanica", 200.0, "PLANT2"));
        servicioController.agregarServicio(new Servicio("Evaluacion de cedimenatacion", "Clasificacion geotecnica", "Geotecnia", 180.0, "PLANT3"));
    }
}
    

