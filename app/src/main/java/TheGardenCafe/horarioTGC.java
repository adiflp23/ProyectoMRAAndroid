package TheGardenCafe;

public class horarioTGC {
    private String dia;
    private String apertura, cierre;

    public horarioTGC(String dia, String apertura, String cierre){
        this.dia = dia;
        this.apertura = apertura;
        this.cierre = cierre;
    }

    public String getDia() {
        return dia;
    }

    public String getApertura() {
        return apertura;
    }

    public String getCierre() {
        return cierre;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setApertura(String apertura) {
        this.apertura = apertura;
    }

    public void setCierre(String cierre) {
        this.cierre = cierre;
    }
}
