package modelsDAO;

import config.conexion;
import modelsBeans.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*@author Sergio*/

public class userDAO {
    conexion conexion = new conexion();
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    int r;
    
    public List lista() {
        String sql = "SELECT * FROM usuario";
        List listUser = new ArrayList<>();
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                user User = new user();
                
                User.setIdUsuario(rs.getInt(1));
                User.setNombre(rs.getString(2));
                User.setApellidoP(rs.getString(3));
                User.setApellidoM(rs.getString(4));
                User.setCorreo(rs.getString(5));
                User.setContrasena(rs.getString(6));
                User.setEdad(rs.getInt(7));
                User.setSexo(rs.getString(8).charAt(0));
                User.setPrivilegio(rs.getString(9).charAt(0));
                
                listUser.add(User);
            }
        } catch (SQLException e) {}
       return listUser;
    }
    
    public int Agregar(user User) {
        String sql = "INSERT INTO usuario (nombre, apellidoP, apellidoM, correo, contrasena, edad, sexo, privilegio) VALUES (?,?,?,?,?,?,?,?)";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, User.getNombre());
            pstm.setString(2, User.getApellidoP());
            pstm.setString(3, User.getApellidoM());
            pstm.setString(4, User.getCorreo());
            pstm.setString(5, User.getContrasena());
            pstm.setInt(6, User.getEdad());
            pstm.setString(7, String.valueOf(User.getSexo()));
            pstm.setString(8, String.valueOf(User.getPrivilegio()));
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se agrego el usuario" + e.toString());
        }
        return r;
    }
    
    public int Actualizar(user User) {
        String sql = "UPDATE usuario SET nombre = ?, apellidoP = ?, apellidoM = ?, correo = ?, contrasena = ?, edad = ?, sexo = ?, privilegio = ? WHERE idUsuario = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, User.getNombre());
            pstm.setString(2, User.getApellidoP());
            pstm.setString(3, User.getApellidoM());
            pstm.setString(4, User.getCorreo());
            pstm.setString(5, User.getContrasena());
            pstm.setInt(6, User.getEdad());
            pstm.setString(7, String.valueOf(User.getSexo()));
            pstm.setString(8, String.valueOf(User.getPrivilegio()));
            pstm.setInt(9, User.getIdUsuario());
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se actualizo usuario" + e.toString());
        }
        return r;
    }
    
    public void Borrar(int id) {
        String sql = "DELETE FROM usuario WHERE idUsuario = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se borro usuario" + e.toString());
        }
    }
    
    public user Buscar(int id) {
        user User = new user();
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                User.setIdUsuario(rs.getInt(1));
                User.setNombre(rs.getString(2));
                User.setApellidoP(rs.getString(3));
                User.setApellidoM(rs.getString(4));
                User.setCorreo(rs.getString(5));
                User.setContrasena(rs.getString(6));
                User.setEdad(rs.getInt(7));
                User.setSexo(rs.getString(8).charAt(0));
                User.setPrivilegio(rs.getString(9).charAt(0));
            }
        } catch (SQLException e) {
            System.out.println("No se listo" + e.toString());
        }
        return User;
    }
    
    public user BuscarPorCredenciales(String correo, String contrasena) {
        user User = null;
        String sql = "SELECT idUsuario, privilegio FROM usuario WHERE correo = ? AND contrasena = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, correo);
            pstm.setString(2, contrasena);
            
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                User = new user();
                User.setIdUsuario(rs.getInt(1));
                User.setPrivilegio(rs.getString(2).charAt(0));
            }
        } catch (SQLException e) {
            System.out.println("No se encuentra usuario" + e.toString());
        }
        return User;
    }
}