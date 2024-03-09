/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelsBeans;

/**
 *
 * @author Usuario
 */
public class userBean {
    private int id;
    private String nom;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private int edad;
    private char sexo;
    private char privilegio;

    public userBean() {
    }
    
    public userBean(int id, String nom, String apellidoPaterno, String apellidoMaterno, String correo, int edad, char sexo, char privilegio) {
        this.id = id;
        this.nom = nom;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.edad = edad;
        this.sexo = sexo;
        this.privilegio = privilegio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getapellidoPaterno() {
        return apellidoPaterno;
    }

    public void setapellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getapellidoMaterno() {
        return apellidoMaterno;
    }

    public void setapellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(char privilegio) {
        this.privilegio = privilegio;
    }

    @Override
    public String toString() {
        return "userBean{" + "id=" + id + ", nom=" + nom + ", apPat=" + apellidoPaterno + ", apMat=" + apellidoMaterno + ", correo=" + correo + ", edad=" + edad + ", sexo=" + sexo + ", privilegio=" + privilegio + '}';
    }
    
    
    
}
