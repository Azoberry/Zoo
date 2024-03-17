package modelsDAO;

import config.conexion;
import modelsBeans.habitat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*@author Sergio*/

public class habitatDAO {
    conexion conexion = new conexion();
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    int r;
    
    public List lista() {
        String sql = "SELECT * FROM habitat";
        List listHabitat = new ArrayList<>();
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                habitat Habitat = new habitat();
                
                Habitat.setIdHabitat(rs.getInt(1));
                Habitat.setNombre(rs.getString(2));
                Habitat.setDescripcion(rs.getString(3));
                Habitat.setCapacidad(rs.getInt(4));
                Habitat.setArea(rs.getDouble(5));
                Habitat.setHorarioAper(rs.getString(6));
                Habitat.setHorarioCier(rs.getString(7));
                Habitat.setIdZona(rs.getInt(8));
                
                listHabitat.add(Habitat);
            }
        } catch (SQLException e) {}
       return listHabitat;
    }
    
    public int Agregar(habitat Habitat) {
        String sql = "INSERT INTO habitat (nombre, descripcion, capacidad, area, horarioAper, horarioCier, idZona) VALUES (?,?,?,?,?,?,?)";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, Habitat.getNombre());
            pstm.setString(2, Habitat.getDescripcion());
            pstm.setInt(3, Habitat.getCapacidad());
            pstm.setDouble(4, Habitat.getArea());
            pstm.setString(5, Habitat.getHorarioAper());
            pstm.setString(6, String.valueOf(Habitat.getHorarioCier()));
            pstm.setString(7, String.valueOf(Habitat.getIdZona()));
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se agrego el habitat" + e.toString());
        }
        return r;
    }
    
    public int Actualizar(habitat Habitat) {
        String sql = "UPDATE habitat SET nombre = ?, descripcion = ?, capacidad = ?, area = ?, horarioAper = ?, horarioCier = ?, idZona = ? WHERE idHabitat = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, Habitat.getNombre());
            pstm.setString(2, Habitat.getDescripcion());
            pstm.setInt(3, Habitat.getCapacidad());
            pstm.setDouble(4, Habitat.getArea());
            pstm.setString(5, Habitat.getHorarioAper());
            pstm.setString(6, Habitat.getHorarioCier());
            pstm.setInt(7, Habitat.getIdZona());
            pstm.setInt(8, Habitat.getIdHabitat());
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se actualizo habitat" + e.toString());
        }
        return r;
    }
    
    public void Borrar(int id) {
        String sql = "DELETE FROM habitat WHERE idHabitat = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se borro habitat" + e.toString());
        }
    }
    
    public habitat Buscar(int id) {
        habitat Habitat = new habitat();
        String sql = "SELECT * FROM habitat WHERE idHabitat = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                Habitat.setIdHabitat(rs.getInt(1));
                Habitat.setNombre(rs.getString(2));
                Habitat.setDescripcion(rs.getString(3));
                Habitat.setCapacidad(rs.getInt(4));
                Habitat.setArea(rs.getDouble(5));
                Habitat.setHorarioAper(rs.getString(6));
                Habitat.setHorarioCier(rs.getString(7));
                Habitat.setIdZona(rs.getInt(8));
            }
        } catch (SQLException e) {
            System.out.println("No se listo" + e.toString());
        }
        return Habitat;
    }
}