package modelsBeans;

import java.sql.Time;

/*@author Sergio*/

public class habitat {
    private int idHabitat;
    private String nombre;
    private String descripcion;
    private int capacidad;
    private double area;
    private Time horarioAper;
    private Time horarioCier;
    private int idZona;

    public habitat(int idHabitat, String nombre, String descripcion, int capacidad, double area, Time horarioApertura, Time horarioCierre, int idZona) {
        this.idHabitat = idHabitat;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.area = area;
        this.horarioAper = horarioApertura;
        this.horarioCier = horarioCierre;
        this.idZona = idZona;
    }
    public habitat() {}

    public int getIdHabitat() {return idHabitat;}
    public void setIdHabitat(int idHabitat) {this.idHabitat = idHabitat;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public int getCapacidad() {return capacidad;}
    public void setCapacidad(int capacidad) {this.capacidad = capacidad;}

    public double getArea() {return area;}
    public void setArea(double area) {this.area = area;}

    public Time getHorarioAper() {return horarioAper;}
    public void setHorarioAper(Time horarioAper) {this.horarioAper = horarioAper;}

    public Time getHorarioCier() {return horarioCier;}
    public void setHorarioCier(Time horarioCier) {this.horarioCier = horarioCier;}

    public int getIdZona() {return idZona;}
    public void setIdZona(int idZona) {this.idZona = idZona;}

    @Override
    public String toString() {
        return "habitatBean{" + "idHabitat=" + idHabitat + ", nombre=" + nombre + ", descripcion=" + descripcion + ", capacidad=" + capacidad + ", area=" + area + ", horarioApertura=" + horarioAper + ", horarioCierre=" + horarioCier + ", idZona=" + idZona + '}';
    }
}