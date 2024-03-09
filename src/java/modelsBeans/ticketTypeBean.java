/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelsBeans;

/**
 *
 * @author Kalos
 */
public class ticketTypeBean {
    private int  id;
    private String tipo;
    private double precio;

    public ticketTypeBean() {
    }

    public ticketTypeBean(int id, String tipo, double precio) {
        this.id = id;
        this.tipo = tipo;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ticketTypeBean{" + "id=" + id + ", tipo=" + tipo + ", precio=" + precio + '}';
    }
    
    
}
