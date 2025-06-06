/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
import controller.ClienteController;
import view.ClienteView;
/**
 *
 * @author Usuario
 */
public class Tester {

    public static void main(String[] args) {
        ClienteController controlador = new ClienteController();
        ClienteView vista = new ClienteView(controlador);
        
         vista.mostrarMenuPrincipal();
    }
}

