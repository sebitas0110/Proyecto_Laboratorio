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
        Scanner sc = new Scanner(System.in);
        ClienteController controlador = new ClienteController();

        boolean salir = false;
        while (!salir) {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Opción futura");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            String opcionPrincipal = sc.nextLine();

            switch (opcionPrincipal) {
                case "1":
                    boolean volver = false;
                    while (!volver) {
                        System.out.println("\n--- GESTIÓN DE CLIENTES ---");
                        System.out.println("1. Agregar Cliente Natural");
                        System.out.println("2. Agregar Cliente Jurídico");
                        System.out.println("3. Buscar Cliente");
                        System.out.println("4. Editar Cliente");
                        System.out.println("5. Eliminar Cliente");
                        System.out.println("6. Mostrar Todos los Clientes");
                        System.out.println("7. Volver al Menú Principal");
                        System.out.print("Seleccione una opción: ");
                        String opcionCliente = sc.nextLine();

                        switch (opcionCliente) {
                            case "1":
                                System.out.print("Dirección: ");
                                String dirN = sc.nextLine();
                                System.out.print("Teléfono: ");
                                String telN = sc.nextLine();
                                System.out.print("Correo: ");
                                String mailN = sc.nextLine();
                                System.out.print("Nombre: ");
                                String nom = sc.nextLine();
                                System.out.print("DNI: ");
                                String dni = sc.nextLine();
                                controlador.agregarCliNat(dirN, telN, mailN, nom, dni);
                                break;

                            case "2":
                                System.out.print("Dirección: ");
                                String dirJ = sc.nextLine();
                                System.out.print("Teléfono: ");
                                String telJ = sc.nextLine();
                                System.out.print("Correo: ");
                                String mailJ = sc.nextLine();
                                System.out.print("Razón Social: ");
                                String razon = sc.nextLine();
                                System.out.print("RUC: ");
                                String ruc = sc.nextLine();
                                controlador.agregarCliJur(dirJ, telJ, mailJ, razon, ruc);
                                break;

                            case "3":
                                System.out.print("Ingrese N° de Documento del cliente a buscar:(dni o ruc)");
                                String idBuscar = sc.nextLine();
                                Cliente encontrado = controlador.buscarCliente(idBuscar);
                                if (encontrado != null) {
                                    System.out.println(encontrado);
                                }
                                break;

                            case "4":
                                System.out.print("ID del cliente a editar: ");
                                String idEditar = sc.nextLine();
                                System.out.print("Nuevo Teléfono: ");
                                String nuevoTel = sc.nextLine();
                                System.out.print("Nuevo Correo: ");
                                String nuevoCorreo = sc.nextLine();
                                System.out.print("Nueva Dirección: ");
                                String nuevaDir = sc.nextLine();
                                controlador.editarCliente(idEditar, nuevoTel, nuevoCorreo, nuevaDir);
                                break;

                            case "5":
                                System.out.print("ID del cliente a eliminar: ");
                                String idEliminar = sc.nextLine();
                                controlador.eliminarCliente(idEliminar);
                                break;

                            case "6":
                                controlador.mostrarClientes();
                                break;

                            case "7":
                                volver = true;
                                break;

                            default:
                                System.out.println("Opción no válida. Intente nuevamente.");
                        }
                    }
                    break;

                case "2":
                    System.out.println("Funcionalidad aún no implementada.");
                    break;

                case "3":
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        sc.close();
    }
}

