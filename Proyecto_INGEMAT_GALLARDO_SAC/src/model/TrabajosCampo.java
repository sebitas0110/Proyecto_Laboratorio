package model;

public class TrabajosCampo {
 private int ID_TrabajosCampo;
    private int ID_Informe;
    private String Procedimientos;

    public void registrarProcedimiento(String procedimiento) {
        this.Procedimientos = procedimiento;
    }

    public String obtenerResumenProcedimiento() {
        return Procedimientos;
    }

    public void setID_Informe(int ID_Informe) {
        this.ID_Informe = ID_Informe;
    }

    public void setID_TrabajosCampo(int ID_TrabajosCampo) {
        this.ID_TrabajosCampo = ID_TrabajosCampo;
    }

    public void setProcedimientos(String Procedimientos) {
        this.Procedimientos = Procedimientos;
    }

    public int getID_Informe() {
        return ID_Informe;
    }

    public int getID_TrabajosCampo() {
        return ID_TrabajosCampo;
    }

    public String getProcedimientos() {
        return Procedimientos;
    }
    
}
