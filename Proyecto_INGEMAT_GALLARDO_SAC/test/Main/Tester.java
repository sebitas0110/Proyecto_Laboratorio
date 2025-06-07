/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
import controller.ClienteController;
import view.ClienteView;
import model.Administrador;
import controller.AdministradorController;
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
            // Aquí va el resto de tu programa
            System.out.println("Bienvenido al sistema, continúa la ejecución...");
            //CLIENTE
            ClienteController controlador = new ClienteController();
            ClienteView vista = new ClienteView(controlador);
        
            vista.mostrarMenuPrincipal();
        } else {
            // Terminar ejecución (opcional: System.exit)
            System.out.println("Cerrando aplicación...");
        }
    }
}

