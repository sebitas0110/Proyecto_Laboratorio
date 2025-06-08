package model;

public class Cotizacion {
    private int ID_Cotiza;
    private String Nom_Coti;
    private int Fec_Coti;

    public void mostrarCotizacion() {
        // Lógica para mostrar cotización
    }

    public void setFec_Coti(int Fec_Coti) {
        this.Fec_Coti = Fec_Coti;
    }

    public void setID_Cotiza(int ID_Cotiza) {
        this.ID_Cotiza = ID_Cotiza;
    }

    public void setNom_Coti(String Nom_Coti) {
        this.Nom_Coti = Nom_Coti;
    }

    public int getFec_Coti() {
        return Fec_Coti;
    }

    public int getID_Cotiza() {
        return ID_Cotiza;
    }

    public String getNom_Coti() {
        return Nom_Coti;
    }
    
}