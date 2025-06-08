/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.Scanner;
import model.Departamento;
import model.Distrito;
import model.Provincia;
import model.Ubicacion;
/**
 *
 * @author Usuario
 */
public class UbicacionController {
    private final Scanner scanner = new Scanner(System.in);
    private int contadorDepartamentos = 1;
    private int contadorProvincias = 1;
    private int contadorDistritos = 1;
    private int contadorUbicaciones = 1;

    private String generarIdDepartamento() {
        return String.format("DEP-%04d", contadorDepartamentos++);
    }

    private String generarIdProvincia() {
        return String.format("PROV-%04d", contadorProvincias++);
    }

    private String generarIdDistrito() {
        return String.format("DIST-%04d", contadorDistritos++);
    }

    private String generarIdUbicacion() {
        return String.format("UBI-%04d", contadorUbicaciones++);
    }

    public Ubicacion crearUbicacion() {
        System.out.print("\nDirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Distrito: ");
        String nombreDistrito = scanner.nextLine();
        System.out.print("Provincia: ");
        String nombreProvincia = scanner.nextLine();
        System.out.print("Departamento: ");
        String nombreDepartamento = scanner.nextLine();

        Departamento departamento = new Departamento(nombreDepartamento, generarIdDepartamento());
        Provincia provincia = new Provincia(nombreProvincia, departamento, generarIdProvincia());
        Distrito distrito = new Distrito(nombreDistrito, provincia, generarIdDistrito());

        return new Ubicacion(direccion, distrito, generarIdUbicacion());
    }
    /*
    public Ubicacion editarUbicacion() {
    System.out.println("== Editar nueva ubicación ==");
    System.out.print("Dirección: ");
    String direccion = scanner.nextLine();
    System.out.print("Departamento: ");
    String nombreDepartamento = scanner.nextLine();
    System.out.print("Provincia: ");
    String nombreProvincia = scanner.nextLine();
    System.out.print("Distrito: ");
    String nombreDistrito = scanner.nextLine();

    Departamento departamento = new Departamento(nombreDepartamento, generarIdDepartamento());
    Provincia provincia = new Provincia(nombreProvincia, departamento, generarIdProvincia());
    Distrito distrito = new Distrito(nombreDistrito, provincia, generarIdDistrito());

    return new Ubicacion(direccion, distrito, generarIdUbicacion());
}*/
    public Ubicacion editarUbicacion(Ubicacion original) {
    System.out.print("Nueva dirección (actual: " + original.getDireccion() + "): ");
    String nuevaDireccion = scanner.nextLine();
    if (nuevaDireccion.isBlank()) nuevaDireccion = original.getDireccion();

    System.out.print("Nuevo departamento (actual: " + original.getDepartamento().getNombreDepartamento() + "): ");
    String nuevoDepartamento = scanner.nextLine();
    if (nuevoDepartamento.isBlank()) nuevoDepartamento = original.getDepartamento().getNombreDepartamento();

    System.out.print("Nueva provincia (actual: " + original.getProvincia().getNombreProvincia() + "): ");
    String nuevaProvincia = scanner.nextLine();
    if (nuevaProvincia.isBlank()) nuevaProvincia = original.getProvincia().getNombreProvincia();

    System.out.print("Nuevo distrito (actual: " + original.getDistrito().getNombreDistrito() + "): ");
    String nuevoDistrito = scanner.nextLine();
    if (nuevoDistrito.isBlank()) nuevoDistrito = original.getDistrito().getNombreDistrito();

    Departamento dpto = new Departamento(nuevoDepartamento, generarIdDepartamento());
    Provincia prov = new Provincia(nuevaProvincia, dpto, generarIdProvincia());
    Distrito dist = new Distrito(nuevoDistrito, prov, generarIdDistrito());

    return new Ubicacion(nuevaDireccion, dist, generarIdUbicacion());
}
    /*
    public void editarUbicacion(Ubicacion ubicacion) {
    System.out.println("Editando ubicación con ID: " + ubicacion.getIdUbicacion());

    System.out.print("Nueva dirección (actual: " + ubicacion.getDireccion() + "): ");
    String nuevaDireccion = scanner.nextLine();
    if (!nuevaDireccion.isBlank()) {
        ubicacion.setDireccion(nuevaDireccion);
    }

    // Obtenemos la jerarquía actual para mostrarla
    Distrito distrito = ubicacion.getDistrito();
    Provincia provincia = distrito.getProvincia();
    Departamento departamento = provincia.getDepartamento();

    System.out.print("Nuevo departamento (actual: " + departamento.getNombreDepartamento() + "): ");
    String nuevoDepartamento = scanner.nextLine();
    if (!nuevoDepartamento.isBlank()) {
        departamento.setNombreDepartamento(nuevoDepartamento);
    }

    System.out.print("Nueva provincia (actual: " + provincia.getNombreProvincia() + "): ");
    String nuevaProvincia = scanner.nextLine();
    if (!nuevaProvincia.isBlank()) {
        provincia.setNombreProvincia(nuevaProvincia);
    }

    System.out.print("Nuevo distrito (actual: " + distrito.getNombreDistrito() + "): ");
    String nuevoDistrito = scanner.nextLine();
    if (!nuevoDistrito.isBlank()) {
        distrito.setNombreDistrito(nuevoDistrito);
    }

    System.out.println("Ubicación editada correctamente.");
}*/
}


