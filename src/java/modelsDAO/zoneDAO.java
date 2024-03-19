package modelsDAO;

import config.conexion;
import modelsBeans.zone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*@author Sergio*/

public class zoneDAO {
    conexion conexion = new conexion();
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    int r;
    
    public List lista() {
        String sql = "SELECT * FROM zona";
        List listZone = new ArrayList<>();
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                zone Zone = new zone();
                
                Zone.setIdZona(rs.getInt(1));
                Zone.setUbicacion(rs.getString(2));
                Zone.setArea(rs.getDouble(3));
                
                listZone.add(Zone);
            }
        } catch (SQLException e) {}
       return listZone;
    }
    
    public int Agregar(zone Zone) {
        String sql = "INSERT INTO zona (ubicacion, area) VALUES (?,?)";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, Zone.getUbicacion());
            pstm.setDouble(2, Zone.getArea());
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se agrego la zona" + e.toString());
        }
        return r;
    }
    
    public int Actualizar(zone Zone) {
        String sql = "UPDATE zona SET ubicacion = ?, area = ? WHERE idZona = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, Zone.getUbicacion());
            pstm.setDouble(2, Zone.getArea());
            pstm.setDouble(3, Zone.getIdZona());
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se actualizo zona" + e.toString());
        }
        return r;
    }
    
    public void Borrar(int id) {
        String sql = "DELETE FROM zona WHERE idZona = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se borro zona" + e.toString());
        }
    }
    
    public zone Buscar(int id) {
        zone Zone = new zone();
        String sql = "SELECT * FROM zona WHERE idZona = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                Zone.setIdZona(rs.getInt(1));
                Zone.setUbicacion(rs.getString(2));
                Zone.setArea(rs.getDouble(3));
            }
        } catch (SQLException e) {
            System.out.println("No se listo" + e.toString());
        }
        return Zone;
    }
}