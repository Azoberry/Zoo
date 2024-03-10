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
                user user1 = new user();
                
                user1.setIdUsuario(rs.getInt(1));
                user1.setNombre(rs.getString(2));
                user1.setApellidoP(rs.getString(3));
                user1.setApellidoM(rs.getString(4));
                user1.setCorreo(rs.getString(5));
                user1.setEdad(rs.getInt(6));
                user1.setSexo(rs.getString(7).charAt(0));
                user1.setPrivilegio(rs.getString(8).charAt(0));
                
                listUser.add(user1);
            }
        } catch (SQLException e) {}
       return listUser;
    }
    
    public int Agregar(user user1) {
        String sql = "INSERT INTO usuario (nombre, apellidoP, apellidoM, correo, edad, sexo, privilegio) VALUES (?,?,?,?,?,?,?)";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, user1.getNombre());
            pstm.setString(2, user1.getApellidoP());
            pstm.setString(3, user1.getApellidoM());
            pstm.setString(4, user1.getCorreo());
            pstm.setInt(5, user1.getEdad());
            pstm.setString(6, String.valueOf(user1.getSexo()));
            pstm.setString(7, String.valueOf(user1.getPrivilegio()));
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se agrego el usuario" + e.toString());
        }
        return r;
    }
    
    public int Actualizar(user user1) {
        String sql = "UPDATE usuario SET nombre = ?, apellidoP = ?, apellidoM = ?, correo = ?, edad = ?, sexo = ?, privilegio = ? WHERE idUsuario = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, user1.getNombre());
            pstm.setString(2, user1.getApellidoP());
            pstm.setString(3, user1.getApellidoM());
            pstm.setString(4, user1.getCorreo());
            pstm.setInt(5, user1.getEdad());
            pstm.setString(6, String.valueOf(user1.getSexo()));
            pstm.setString(7, String.valueOf(user1.getPrivilegio()));
            pstm.setInt(8, user1.getIdUsuario());
            
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
        user user1 = new user();
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                user1.setIdUsuario(rs.getInt(1));
                user1.setNombre(rs.getString(2));
                user1.setApellidoP(rs.getString(3));
                user1.setApellidoM(rs.getString(4));
                user1.setCorreo(rs.getString(5));
                user1.setEdad(rs.getInt(6));
                user1.setSexo(rs.getString(7).charAt(0));
                user1.setPrivilegio(rs.getString(8).charAt(0));
            }
        } catch (SQLException e) {
            System.out.println("No se listo" + e.toString());
        }
        return user1;
    }
}