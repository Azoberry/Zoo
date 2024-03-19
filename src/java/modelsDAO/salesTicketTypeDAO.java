package modelsDAO;

import config.conexion;
import modelsBeans.salesTicketType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*@author Kalos*/

public class salesTicketTypeDAO {
 
    conexion conexion = new conexion();
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    int r;
    
     public List lista() {
        String sql = "SELECT * FROM ventatipoboleto";
        List listSalesTicketType = new ArrayList<>();
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                salesTicketType SalesTicketType = new salesTicketType();
                
                SalesTicketType.setIdVenta(rs.getInt(1));
                SalesTicketType.setIdBoleto(rs.getInt(2));
                SalesTicketType.setCantidad(rs.getInt(3));
                
                listSalesTicketType.add(SalesTicketType);
            }
        } catch (SQLException e) {}
       return listSalesTicketType;
    }
    
    public int Agregar(salesTicketType SalesTicketType) {
        String sql = "INSERT INTO ventatipoboleto (idVenta, idBoleto, cantidad) VALUES (?,?,?)";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, SalesTicketType.getIdVenta());
            pstm.setInt(2, SalesTicketType.getIdBoleto());
            pstm.setInt(3, SalesTicketType.getCantidad());
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se agrego la venta de tipo de boleto" + e.toString());
        }
        return r;
    }
    
    public int Actualizar(salesTicketType SalesTicketType) {
        String sql = "UPDATE ventatipoboleto SET  cantidad = ? WHERE idVenta = ? AND idBoleto = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
           
            pstm.setInt(1, SalesTicketType.getCantidad());
            pstm.setInt(2, SalesTicketType.getIdVenta());
            pstm.setInt(3, SalesTicketType.getIdBoleto());
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se actualizo la venta de tipo de boleto" + e.toString());
        }
        return r;
    }
    
    public void Borrar(int idVenta, int idBoleto) {
        String sql = "DELETE FROM ventatipoboleto WHERE idVenta = ? AND idBoleto = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, idVenta);
            pstm.setInt(2, idBoleto);
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se borro la venta" + e.toString());
        }
    }
    
    public salesTicketType Buscar(int idVenta, int idBoleto) {
        salesTicketType SalesTicketType = new salesTicketType();
        String sql = "SELECT * FROM ventatipoboleto WHERE idVenta = ? AND idBoleto = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, idVenta);
            pstm.setInt(2, idBoleto);
            
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                SalesTicketType.setIdVenta(rs.getInt(1));
                SalesTicketType.setIdBoleto(rs.getInt(2));
                SalesTicketType.setCantidad(rs.getInt(3));   
            }
        } catch (SQLException e) {
            System.out.println("No se listo" + e.toString());
        }
        return SalesTicketType;
    }

}
