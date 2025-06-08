/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
import controller.ClienteController;
import view.ClienteView;
import model.Administrador;
import controller.AdministradorController;
import controller.UbicacionController;
import view.AdministradorView;
/**
 *
 * @author Usuario
 */
public class Tester {

    public static void main(String[] args) {
        Administrador adminDefault = new Administrador();
        AdministradorController controller = new AdministradorController(adminDefault);
        AdministradorView view = new AdministradorView(controller);

        boolean accesoConcedido = view.mostrarLogin();

        if (accesoConcedido) {
            System.out.println("Bienvenido al sistema, continúa la ejecución...");
            //CLIENTE
            ClienteController controlador = new ClienteController();
            UbicacionController ubicontroller = new UbicacionController();
            ClienteView vista = new ClienteView(controlador, ubicontroller);
        
            vista.mostrarMenuPrincipal();
        } else {
            // Terminar ejecución (opcional: System.exit)
            System.out.println("Cerrando aplicación...");
        }
    }
}

