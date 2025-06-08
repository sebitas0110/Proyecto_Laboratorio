package model;

public class InformeLegal {
     private int ID_Informe;
    private int ID_TrabajosCampo;
    private int ID_Estructura;
    private int ID_DatosSolicitante;
    private int ID_Verificacion;
    private int ID_Factura;

    public void generar(Cotizacion cotizacion, Administrador admin) {
        // Lógica para generar
    }

    public void exportarPDF() {
        // Lógica para exportar
    }

    public static InformeLegal buscarPorId(String id) {
        // Lógica para buscar
        return new InformeLegal();
    }
}
