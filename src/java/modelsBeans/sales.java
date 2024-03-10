package modelsBeans;

import java.util.Date;

/*@author Kalos*/

public class sales {
    private int idVenta;
    private Date fechaVenta;
    private double total;
    private int idUsuario;

    public sales() {
    }

    public sales(int id, Date fechaVenta, double total, int idUser) {
        this.idVenta = id;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.idUsuario = idUser;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "salesBean{" + "id=" + idVenta + ", fechaVenta=" + fechaVenta + ", total=" + total + ", idUser=" + idUsuario + '}';
    }
    
    
}
