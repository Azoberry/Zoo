package modelsBeans;

/*@author Kalos*/

public class salesTicketType {
    private int idVenta;
    private int idBoleto;
    private int cantidad;

    public salesTicketType() {
    }

    public salesTicketType(int idVenta, int idBoleto, int cantidad) {
        this.idVenta = idVenta;
        this.idBoleto = idBoleto;
        this.cantidad = cantidad;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "salesTicketTypeBean{" + "idVenta=" + idVenta + ", idBoleto=" + idBoleto + ", cantidad=" + cantidad + '}';
    }
    
    
}
