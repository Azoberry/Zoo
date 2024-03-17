package modelsBeans;

/*@author Kalos*/

public class sales {
    private int idVenta;
    private String fechaVenta;
    private double total;
    private int idUsuario;

    public sales(int id, String fechaVenta, double total, int idUser) {
        this.idVenta = id;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.idUsuario = idUser;
    }
    public sales(int id, double total, int idUser) {
        this.idVenta = id;
        this.total = total;
        this.idUsuario = idUser;
    }
    public sales(double total, int idUser) {
        this.total = total;
        this.idUsuario = idUser;
    }
    public sales() {}

    public int getIdVenta() {return idVenta;}
    public void setIdVenta(int idVenta) {this.idVenta = idVenta;}

    public String getFechaVenta() {return fechaVenta;}
    public void setFechaVenta(String fechaVenta) {this.fechaVenta = fechaVenta;}

    public double getTotal() {return total;}
    public void setTotal(double total) {this.total = total;}

    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    @Override
    public String toString() {
        return "salesBean{" + "id=" + idVenta + ", fechaVenta=" + fechaVenta + ", total=" + total + ", idUser=" + idUsuario + '}';
    }
}