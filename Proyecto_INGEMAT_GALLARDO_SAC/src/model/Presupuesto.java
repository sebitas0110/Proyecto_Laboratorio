package model;

public class Presupuesto {
  private int ID_Propuesta;
    private int ID_Gast_AdiInt;
    private int ID_Condi_Presu;
    private int ID_Pro_Tec;
    private String ID_Medi_Pag;
    private int Total_pago;

    public void calcularTotal() {
        // Lógica
    }

    public void mostrarPresupuesto() {
        // Lógica
    }

    public void agregarItem(double monto) {
        // Lógica
    }

    public void setID_Condi_Presu(int ID_Condi_Presu) {
        this.ID_Condi_Presu = ID_Condi_Presu;
    }

    public void setID_Gast_AdiInt(int ID_Gast_AdiInt) {
        this.ID_Gast_AdiInt = ID_Gast_AdiInt;
    }

    public void setID_Medi_Pag(String ID_Medi_Pag) {
        this.ID_Medi_Pag = ID_Medi_Pag;
    }

    public void setID_Pro_Tec(int ID_Pro_Tec) {
        this.ID_Pro_Tec = ID_Pro_Tec;
    }

    public void setID_Propuesta(int ID_Propuesta) {
        this.ID_Propuesta = ID_Propuesta;
    }

    public void setTotal_pago(int Total_pago) {
        this.Total_pago = Total_pago;
    }
    
    
}
