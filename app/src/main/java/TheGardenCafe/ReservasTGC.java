package TheGardenCafe;

public class ReservasTGC {

    private String fecha_reserva;
    private String mesa;
    private String comensales;

    private int id;

    public ReservasTGC(String fecha_reserva, String mesa, String comensales, int id){
        this.fecha_reserva = fecha_reserva;
        this.mesa = mesa;
        this.comensales = comensales;
        this.id = id;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public String getMesa() {
        return mesa;
    }

    public String getComensales() {
        return comensales;
    }

    public int getId() {
        return id;
    }

    public void setfecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public void setmesa(String mesa) {
        this.mesa = mesa;
    }

    public void setComensales(String comensales) {
        this.comensales = comensales;
    }
}
