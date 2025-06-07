/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.AdministradorController;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public class AdministradorView {
    private AdministradorController controller;

    public AdministradorView(AdministradorController controller) {
        this.controller = controller;
    }

    public boolean mostrarLogin() {
        Scanner scanner = new Scanner(System.in);
        int intentos = 0;
        final int MAX_INTENTOS = 3;

        while (intentos < MAX_INTENTOS) {
            System.out.print("Usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Contrasena: ");
            String contraseña = scanner.nextLine();

            if (controller.validarAcceso(usuario, contraseña)) {
                System.out.println(" Acceso concedido.");
                return true; // login exitoso
            } else {
                intentos++;
                System.out.println("Usuario o contrasena incorrectos. Intento " + intentos + " de " + MAX_INTENTOS);
            }
        }

        System.out.println("Se supero el numero maximo de intentos. Programa terminado.");
        return false; // login fallido
    }
}