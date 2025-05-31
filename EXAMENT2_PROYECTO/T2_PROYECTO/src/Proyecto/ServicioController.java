/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class ServicioController {
    private List<Servicio> servicios = new ArrayList<>();

    public String agregarServicio(Servicio s) {
        for (Servicio serv : servicios) {
            if (serv.getNombre().equalsIgnoreCase(s.getNombre()) &&
                serv.getCategoria().equalsIgnoreCase(s.getCategoria())) {
                return "Servicio duplicado";
            }
        }
        servicios.add(s);
        return "Servicio agregado";
    }

    public List<Servicio> listarServiciosActivos() {
        List<Servicio> activos = new ArrayList<>();
        for (Servicio s : servicios) {
            if (s.isActivo()) activos.add(s);
        }
        return activos;
    }

    public List<Servicio> getTodos() {
        return servicios;
    }
}
