package modelsBeans;

/*@author Kalos*/

public class user {
    private int idUsuario;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String correo;
    private int edad;
    private char sexo;
    private char privilegio;

    public user() {
    }
    
    public user(int idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, int edad, char sexo, char privilegio) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoP = apellidoPaterno;
        this.apellidoM = apellidoMaterno;
        this.correo = correo;
        this.edad = edad;
        this.sexo = sexo;
        this.privilegio = privilegio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
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
        return "userBean{" + "id=" + idUsuario + ", nom=" + nombre + ", apPat=" + apellidoP + ", apMat=" + apellidoM + ", correo=" + correo + ", edad=" + edad + ", sexo=" + sexo + ", privilegio=" + privilegio + '}';
    }
    
    
    
}
