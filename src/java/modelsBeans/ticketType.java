package modelsBeans;

/*@author Kalos*/

public class ticketType {
    private int  idBoleto;
    private String tipo;
    private double precio;

    public ticketType(int idBoleto, String tipo, double precio) {
        this.idBoleto = idBoleto;
        this.tipo = tipo;
        this.precio = precio;
    }
    public ticketType(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }
    public ticketType() {}

    public int getIdBoleto() {return idBoleto;}
    public void setIdBoleto(int idBoleto) {this.idBoleto = idBoleto;}

    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    public double getPrecio() {return precio;}
    public void setPrecio(double precio) {this.precio = precio;}

    @Override
    public String toString() {
        return "ticketTypeBean{" + "id=" + idBoleto + ", tipo=" + tipo + ", precio=" + precio + '}';
    }
}