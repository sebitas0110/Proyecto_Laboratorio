
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.ClienteController;
import model.Cliente;
import model.ClienteJuridico;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public class ClienteView {
    private Scanner sc;
    private ClienteController controlador;
    
    public ClienteView(ClienteController controlador) {
        this.sc = new Scanner(System.in);
        this.controlador = controlador;
    }
    public void mostrarMenuPrincipal() {
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
                    mostrarMenuClientes();
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

    private void mostrarMenuClientes() {
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
                    agregarClienteNatural();
                    break;
                case "2":
                    agregarClienteJuridico();
                    break;
                case "3":
                    buscarCliente();
                    break;
                case "4":
                    editarCliente();
                    break;
                case "5":
                    eliminarCliente();
                    break;
                case "6":
                    mostrarTodosClientes();
                    break;
                case "7":
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private void agregarClienteNatural() {
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
    }

    private void agregarClienteJuridico() {
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
        System.out.print("Propietario: ");
        String propietario = sc.nextLine();
        System.out.print("Documento del propietario: ");
        String docProp = sc.nextLine();
        System.out.print("Representante legal: ");
        String repLeg = sc.nextLine();
        System.out.print("Documento del RR.LL.: ");
        String repDoc = sc.nextLine();
        System.out.print("Tipo de empresa (privada/gubernamental): ");
        String tipoEmpresaTexto = sc.nextLine().trim().toLowerCase();

        while (!tipoEmpresaTexto.equals("privada") && !tipoEmpresaTexto.equals("gubernamental")) {
            System.out.print("Tipo inválido. Ingrese 'privada' o 'gubernamental': ");
            tipoEmpresaTexto = sc.nextLine().trim().toLowerCase();
        }

        int tipoEmpresa = tipoEmpresaTexto.equals("privada") ? 
            ClienteJuridico.EMPRESA_PRIVADA : ClienteJuridico.EMPRESA_GUBERNAMENTAL;
            
        controlador.agregarCliJur(dirJ, telJ, mailJ, razon, ruc, propietario, docProp,repLeg, repDoc, tipoEmpresa);
    }

    private void buscarCliente() {
        System.out.print("Ingrese N° de Documento del cliente a buscar:(dni o ruc)");
        String idBuscar = sc.nextLine();
        Cliente encontrado = controlador.buscarCliente(idBuscar);
        if (encontrado != null) {
            System.out.println(encontrado);
        }
    }

    private void editarCliente() {
        System.out.print("Ingrese el documento (DNI o RUC) del cliente a editar: ");
        String docEditar = sc.nextLine();
        System.out.print("Nuevo Teléfono (dejar vacío para no modificar): ");
        String nuevoTel = sc.nextLine();
        System.out.print("Nuevo Correo (dejar vacío para no modificar): ");
        String nuevoCorreo = sc.nextLine();
        System.out.print("Nueva Dirección (dejar vacío para no modificar): ");
        String nuevaDir = sc.nextLine();
        
        String nuevoRepLeg = null;
        String nuevoDocRepLeg = null;
        boolean documentoJustificante = false;

        Cliente clienteAEditar = controlador.buscarCliente(docEditar);

        if (clienteAEditar != null && clienteAEditar.getTipoCliente() == Cliente.TIPO_JURIDICO) {
            System.out.print("¿Desea modificar el representante legal? (si/no): ");
            String respuesta = sc.nextLine().trim().toLowerCase();
            if (respuesta.equals("si")) {
                System.out.print("Ingrese el nuevo nombre del representante legal: ");
                nuevoRepLeg = sc.nextLine();
                System.out.print("Ingrese el nuevo documento del RR.LL.:");
                nuevoDocRepLeg = sc.nextLine();
                System.out.print("¿Cuenta con documento justificante? (si/no): ");
                String docResp = sc.nextLine().trim().toLowerCase();
                documentoJustificante = docResp.equals("si");
            }
        }

        boolean exito = controlador.editarCliente(
            docEditar, 
            nuevoTel, 
            nuevoCorreo, 
            nuevaDir, 
            nuevoRepLeg,
            nuevoDocRepLeg,
            documentoJustificante
        );

        if (exito) {
            System.out.println("Cliente editado exitosamente.");
        } else {
            System.out.println("No se pudo editar el cliente.");
        }
    }

    private void eliminarCliente() {
        System.out.print("ID del cliente a eliminar: ");
        String idEliminar = sc.nextLine();
        controlador.eliminarCliente(idEliminar);
    }

    private void mostrarTodosClientes() {
        controlador.mostrarClientes();
    }
}
