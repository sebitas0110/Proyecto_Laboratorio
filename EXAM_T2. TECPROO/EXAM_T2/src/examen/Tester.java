/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class Tester {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Administrador admin = new Administrador();
    private static ArrayList<Presupuesto> presupuesto = new ArrayList<>(); // Lista global de ventas
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Formatos.precargarServicios();
        if(!validarAcceso()){
            System.out.println("Acceso denegado. Saliendo del sistema...");
            return;
        }
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            
            switch (opcion) {
                case 1:
                    registrarClienteNatural();
                    break;
                case 2:
                    registrarClienteJuridico();
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    registrarVenta();
                    break;
                case 5:
                    mostrarVentas(presupuesto);
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
        } while (opcion != 6);
    }
    
    private static  boolean validarAcceso(){
        System.out.println("=== SISTEMA DE GESTIÓN DE CLIENTES ===");
        System.out.println("Por favor autentiquese:");
        
        String usuario = leerCadena("Usuario: ");
        String contrasena = leerCadena("Contraseña: ");
        
        return admin.autenticarUsuario(usuario, contrasena);
    }
    
    private static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE REGISTRO DE CLIENTES ===");
        System.out.println("1. Registrar Cliente Natural");
        System.out.println("2. Registrar Cliente Juridico");
        System.out.println("3. Listar todos los clientes");
        System.out.println("4. Registrar venta");
        System.out.println("5. Mostrar ventas");
        System.out.println("6. Salir");
    }

    private static void registrarClienteNatural() {
        System.out.println("\n--- Registro de Cliente Natural ---");
        
        String direccion = leerCadena("Direccion: ");
        String telefono = leerCadena("Telefono (9 digitos): ");
        String correo = leerCadena("Correo electronico: ");
        String nombre = leerCadena("Nombre completo: ");
        String dni = leerCadena("DNI (8 digitos): ");

        try {
        ClienteNatural cliente = new ClienteNatural(direccion, telefono, correo, nombre, dni);
        // O para jurídico:
        // ClienteJuridico cliente = new ClienteJuridico(direccion, telefono, correo, razonSocial, ruc);
        System.out.println("Cliente registrado exitosamente!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar: " + e.getMessage());
        }
    }

    private static void registrarClienteJuridico() {
        System.out.println("\n--- Registro de Cliente Juridico ---");
        
        String direccion = leerCadena("Direccion: ");
        String telefono = leerCadena("Telefono (9 dígitos): ");
        String correo = leerCadena("Correo electronico: ");
        String razonSocial = leerCadena("Razon Social: ");
        String ruc = leerCadena("RUC (11 digitos): ");

        try {
            ClienteJuridico cliente = new ClienteJuridico(direccion, telefono, correo, razonSocial, ruc);
            System.out.println("Cliente juridico registrado exitosamente: ");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar: " + e.getMessage());
        }
    }

    private static void listarClientes() {
        ArrayList<Cliente> clientes = Cliente.getListaClientes();
        
        if (clientes.isEmpty()) {
            System.out.println("\nNo hay clientes registrados.");
            return;
        }

        System.out.println("\n=== LISTADO DE CLIENTES ===");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
            System.out.println("---------------------------");
        }
        System.out.println("Total: " + clientes.size() + " clientes");
    }
    
    private static void registrarVenta() {
        System.out.println("\n--- REGISTRAR VENTA DIRECTA ---");

        if (Cliente.getListaClientes().isEmpty()) {
            System.out.println("No hay clientes registrados. Registre al menos uno.");
            return;
        }

        System.out.println("Seleccione cliente por número:");
        ArrayList<Cliente> clientes = Cliente.getListaClientes();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            System.out.println(i + ". " + c.getNombreCompleto() + " (" + c.getDocumento() + ")");
        }

        System.out.print("Opción: ");
        int clienteIdx = Integer.parseInt(scanner.nextLine());
        if (clienteIdx < 0 || clienteIdx >= clientes.size()) {
            System.out.println("Índice de cliente inválido.");
            return;
        }
        Cliente clienteSeleccionado = clientes.get(clienteIdx);

        // Obtener servicios activos de tu clase Formatos
        ArrayList<Formatos> serviciosDisponibles = Formatos.getContenedorFormatos().listarFormatosActivos();

        if (serviciosDisponibles.isEmpty()) {
            System.out.println("No hay servicios activos disponibles.");
            return;
        }

        ArrayList<Formatos> carrito = new ArrayList<>();

        System.out.println("Servicios disponibles:");
        for (int i = 0; i < serviciosDisponibles.size(); i++) {
            Formatos s = serviciosDisponibles.get(i);
            System.out.printf("%d. %s - S/ %.2f\n", i, s.getNombre(), s.getPrecio());
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

        // Generación de código automático
        String codigoPresupuesto = String.format("VEN-%06d", presupuesto.size() + 1);

        // Crear y registrar la venta
        Presupuesto venta = new Presupuesto(codigoPresupuesto, clienteSeleccionado, carrito);
        presupuesto.add(venta);

        // Mostrar resumen
        double total = carrito.stream().mapToDouble(Formatos::getPrecio).sum();

        System.out.println("Venta registrada correctamente con código: " + codigoPresupuesto);
        System.out.printf("Total: S/ %.2f\n", total);
    }
    
        public static void mostrarVentas(ArrayList<Presupuesto> presupuesto) {
            if (presupuesto.isEmpty()) {
                System.out.println("No hay ventas registradas.");
                return;
            }

            System.out.println("\n--- LISTADO DE VENTAS ---");
            for (Presupuesto p : presupuesto) {
                Cliente c = p.getCliente();

                // Mostrar código de venta
                System.out.println("Código: " + p.getIdPresupuesto());

                // Mostrar datos del cliente (usando polimorfismo)
                System.out.println("Cliente: " + c.getNombreCompleto() + " (" + c.getDocumento() + ")");

                // Mostrar formatos vendidos
                System.out.println("Formatos vendidos:");
                p.getFormatos().forEach(formato -> 
                    System.out.println(" - " + formato.getNombre() + " | Precio: S/ " + String.format("%.2f", formato.getPrecio()))
                );

                // Mostrar total
                System.out.println("Total de la venta: S/ " + String.format("%.2f", p.getTotal()));

                System.out.println("------------------------------");
            }
        }
    
    // Métodos auxiliares para entrada de datos (versión corregida)
    private static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        // Limpiar buffer antes de leer
        scanner.skip("\\R?"); // Saltar posible salto de línea pendiente
        String input = "";
        while (input.isEmpty()) {
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Este campo no puede estar vacío. Intente nuevamente:");
            }
        }
        return input;
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                // Limpiar buffer antes de leer
                scanner.skip("\\R?");
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número valido.");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                scanner.nextLine(); // Limpiar buffer en caso de error
            }
        }
    }
    
}
