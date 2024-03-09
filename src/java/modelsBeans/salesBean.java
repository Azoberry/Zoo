/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelsBeans;
import java.util.Date;
/**
 *
 * @author Kalos
 */
public class salesBean {
    private int id;
    private Date fechaVenta;
    private double total;
    private int idUser;

    public salesBean() {
    }

    public salesBean(int id, Date fechaVenta, double total, int idUser) {
        this.id = id;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "salesBean{" + "id=" + id + ", fechaVenta=" + fechaVenta + ", total=" + total + ", idUser=" + idUser + '}';
    }
    
    
}
