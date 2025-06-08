package model;

public class GastosAdicionales {
    private int ID_Gast_Adi;
    private String Nom_Gast_Adi;
    private String Pre_Gast_Adi;

    public double calcularTotalGastos() {
        // Lógica
        return 0;
    }

    public void mostrarGastos() {
        // Lógica
    }

    public void agregarGasto(String nombre, double monto) {
        // Lógica
    }

    public void setID_Gast_Adi(int ID_Gast_Adi) {
        this.ID_Gast_Adi = ID_Gast_Adi;
    }

    public void setNom_Gast_Adi(String Nom_Gast_Adi) {
        this.Nom_Gast_Adi = Nom_Gast_Adi;
    }

    public void setPre_Gast_Adi(String Pre_Gast_Adi) {
        this.Pre_Gast_Adi = Pre_Gast_Adi;
    }

    public int getID_Gast_Adi() {
        return ID_Gast_Adi;
    }

    public String getNom_Gast_Adi() {
        return Nom_Gast_Adi;
    }

    public String getPre_Gast_Adi() {
        return Pre_Gast_Adi;
    }
    
}