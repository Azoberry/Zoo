package modelsDAO;

import config.conexion;
import modelsBeans.ticketType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*@author Kalos*/

public class ticketTypeDAO {
    
    conexion conexion = new conexion();
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    int r;
    
     public List lista() {
        String sql = "SELECT * FROM tipoboleto";
        List listTicketType = new ArrayList<>();
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ticketType TicketType = new ticketType();
                
                TicketType.setIdBoleto(rs.getInt(1));
                TicketType.setTipo(rs.getString(2));
                TicketType.setPrecio(rs.getDouble(3));
                
                listTicketType.add(TicketType);
            }
        } catch (SQLException e) {}
       return listTicketType;
    }
    
    public int Agregar(ticketType TicketType) {
        String sql = "INSERT INTO tipoboleto (tipo, precio) VALUES (?,?)";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, TicketType.getTipo());
            pstm.setDouble(2, TicketType.getPrecio());
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se agrego el tipo de boleto" + e.toString());
        }
        return r;
    }
    
    public int Actualizar(ticketType TicketType) {
        String sql = "UPDATE tipoboleto SET tipo = ?, precio = ? WHERE idBoleto = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, TicketType.getTipo());
            pstm.setDouble(2, TicketType.getPrecio());
            pstm.setInt(3, TicketType.getIdBoleto());
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se actualizo el tipo de boleto" + e.toString());
        }
        return r;
    }
    
    public void Borrar(int id) {
        String sql = "DELETE FROM tipoboleto WHERE idBoleto = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se borro el tipo de boleto" + e.toString());
        }
    }
    
    public ticketType Buscar(int id) {
        ticketType TicketType = new ticketType();
        String sql = "SELECT * FROM tipoboleto WHERE idBoleto = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                TicketType.setIdBoleto(rs.getInt(1));
                TicketType.setTipo(rs.getString(2));
                TicketType.setPrecio(rs.getDouble(3));
                
            }
        } catch (SQLException e) {
            System.out.println("No se listo" + e.toString());
        }
        return TicketType;
    }

}