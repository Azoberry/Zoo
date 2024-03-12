package modelsBeans;

/*@author Sergio*/

public class animal {
    private int idAnimal;
    private String nombre;
    private String apodo;
    private String dieta;
    private String descripcion;
    private String habitatNat;
    private char sexo;
    private int edad;
    private double peso;
    private double tamano;
    private int idHabitat;

    public animal(int idAnimal, String nombre, String apodo, String dieta, String descripcion, String habitatNat, char sexo, int edad, double peso, double tamano, int idHabitat) {
        this.idAnimal = idAnimal;
        this.nombre = nombre;
        this.apodo = apodo;
        this.dieta = dieta;
        this.descripcion = descripcion;
        this.habitatNat = habitatNat;
        this.sexo = sexo;
        this.edad = edad;
        this.peso = peso;
        this.tamano = tamano;
        this.idHabitat = idHabitat;
    }
    public animal(String nombre, String apodo, String dieta, String descripcion, String habitatNat, char sexo, int edad, double peso, double tamano, int idHabitat) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.dieta = dieta;
        this.descripcion = descripcion;
        this.habitatNat = habitatNat;
        this.sexo = sexo;
        this.edad = edad;
        this.peso = peso;
        this.tamano = tamano;
        this.idHabitat = idHabitat;
    }
    public animal() {}
    
    public int getIdAnimal() {return idAnimal;}
    public void setIdAnimal(int idAnimal) {this.idAnimal = idAnimal;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApodo() {return apodo;}
    public void setApodo(String apodo) {this.apodo = apodo;}

    public String getDieta() {return dieta;}
    public void setDieta(String dieta) {this.dieta = dieta;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    
    public String getHabitatNat() {return habitatNat;}
    public void setHabitatNat(String habitatNat) {this.habitatNat = habitatNat;}

    public char getSexo() {return sexo;}
    public void setSexo(char sexo) {this.sexo = sexo;}

    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}

    public double getPeso() {return peso;}
    public void setPeso(double peso) {this.peso = peso;}

    public double getTamano() {return tamano;}
    public void setTamano(double tamano) {this.tamano = tamano;}

    public int getIdHabitat() {return idHabitat;}
    public void setIdHabitat(int idHabitat) {this.idHabitat = idHabitat;}

    @Override
    public String toString() {
        return "animalBean{" + "idAnimal=" + idAnimal + ", nombre=" + nombre + ", apodo=" + apodo + ", dieta=" + dieta + ", descripcion=" + descripcion + ", habitatNatural=" + habitatNat + ", sexo=" + sexo + ", edad=" + edad + ", peso=" + peso + ", tamano=" + tamano + ", idHabitat=" + idHabitat + '}';
    }
}