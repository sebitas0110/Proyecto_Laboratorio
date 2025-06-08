package model;

public class CondicionesPresupuesto {
    private int ID_Condi_Presu;
    private int ID_Item_Ejec;
    private int ID_Pla_Pag;
    private String campo;

    public void mostrarCondiciones() {
        // Lógica
    }

    public boolean validarCondiciones() {
        // Lógica
        return true;
    }

    public void editarCondiciones(String nuevasCondiciones) {
        // Lógica
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public void setID_Condi_Presu(int ID_Condi_Presu) {
        this.ID_Condi_Presu = ID_Condi_Presu;
    }

    public void setID_Item_Ejec(int ID_Item_Ejec) {
        this.ID_Item_Ejec = ID_Item_Ejec;
    }

    public void setID_Pla_Pag(int ID_Pla_Pag) {
        this.ID_Pla_Pag = ID_Pla_Pag;
    }

    public String getCampo() {
        return campo;
    }

    public int getID_Condi_Presu() {
        return ID_Condi_Presu;
    }

    public int getID_Item_Ejec() {
        return ID_Item_Ejec;
    }

    public int getID_Pla_Pag() {
        return ID_Pla_Pag;
    }
    
}
