/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class Formatos {
    private String nombre, descripcion, categoria, plantilla;
    private double precio;
    private boolean activo;
    private ArrayList<Formatos> formatos = new ArrayList<>();
    private static Formatos contenedorFormatos = new Formatos("Contenedor", "Contenedor de Servicios", "General", "BASE", 0.0, true);

    public Formatos(String nombre, String descripcion, String categoria, String plantilla, double precio, boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.plantilla = plantilla;
        this.precio = precio;
        this.activo = true;
    }
    public String agregarFormatos(Formatos f) {
        for (Formatos form : formatos) {
            if (form.getNombre().equalsIgnoreCase(f.getNombre()) &&
                form.getCategoria().equalsIgnoreCase(f.getCategoria())) {
                return "Servicio duplicado";
            }
        }
        formatos.add(f);
        return "Servicio agregado";
    }

    public ArrayList<Formatos> listarFormatosActivos() {
        ArrayList<Formatos> activos = new ArrayList<>();
        for (Formatos f : formatos) {
            if (f.estaActivo()) activos.add(f);
        }
        return activos;
    }

    public ArrayList<Formatos> getTodos() {
        return formatos;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public String getPlantilla() {
        return plantilla;
    }
    public double getPrecio() {
        return precio;
    }
    public boolean estaActivo(){
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPlantilla(String plantilla) {
        this.plantilla = plantilla;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public static Formatos getContenedorFormatos() {
        return contenedorFormatos;
    }

    public static void setContenedorFormatos(Formatos contenedorFormatos) {
        Formatos.contenedorFormatos = contenedorFormatos;
    }
    
    public static void precargarServicios() {
    contenedorFormatos.agregarFormatos(new Formatos("Analisis de suelo", "Deteccion de metales", "Quimica", "PLANT1", 150.0, true));
    contenedorFormatos.agregarFormatos(new Formatos("Ensayo geotecnio", "Resistencia de materiales", "Mecanica", "PLANT2", 200.0, true));
    contenedorFormatos.agregarFormatos(new Formatos("Evaluacion de cedimenatacion", "Clasificacion geotecnica", "Geotecnia", "PLANT3", 180.0, true));
}
    
}
