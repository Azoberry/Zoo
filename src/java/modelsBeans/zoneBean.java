package modelsBeans;

public class zoneBean {
    private int idZona;
    private String ubicacion;
    private double area;

    public zoneBean(int idZona, String ubicacion, double area) {
        this.idZona = idZona;
        this.ubicacion = ubicacion;
        this.area = area;
    }
    public zoneBean() {}

    public int getIdZona() {return idZona;}
    public void setIdZona(int idZona) {this.idZona = idZona;}

    public String getUbicacion() {return ubicacion;}
    public void setUbicacion(String ubicacion) {this.ubicacion = ubicacion;}

    public double getArea() {return area;}
    public void setArea(double area) {this.area = area;}

    @Override
    public String toString() {
        return "zoneBean{" + "idZona=" + idZona + ", ubicacion=" + ubicacion + ", area=" + area + '}';
    }
}