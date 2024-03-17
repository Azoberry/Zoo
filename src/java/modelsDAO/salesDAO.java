package modelsDAO;

import config.conexion;
import modelsBeans.sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*@author Kalos*/

public class salesDAO {
    
    conexion conexion = new conexion();
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    int r;
    
     public List lista() {
        String sql = "SELECT * FROM ventas";
        List listSales = new ArrayList<>();
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                sales Sales = new sales();
                
                Sales.setIdVenta(rs.getInt(1));
                Sales.setFechaVenta(rs.getString(2));
                Sales.setTotal(rs.getDouble(3));
                Sales.setIdUsuario(rs.getInt(4));
                
                listSales.add(Sales);
            }
        } catch (SQLException e) {}
       return listSales;
    }
    
    public int Agregar(sales Sales) {
        String sql = "INSERT INTO ventas (fechaVenta, total, idUsuario) VALUES (NOW(),?,?)";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setDouble(1, Sales.getTotal());
            pstm.setInt(2, Sales.getIdUsuario());
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se agrego la venta" + e.toString());
        }
        return r;
    }
    
    public int Actualizar(sales Sales) {
        String sql = "UPDATE ventas SET total = ? WHERE idVenta = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setDouble(1, Sales.getTotal());
            pstm.setInt(2, Sales.getIdVenta());
            
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se actualizo la venta" + e.toString());
        }
        return r;
    }
    
    public void Borrar(int id) {
        String sql = "DELETE FROM ventas WHERE idVenta = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se borro la venta" + e.toString());
        }
    }
    
    public sales Buscar(int id) {
        sales Sales = new sales();
        String sql = "SELECT * FROM ventas WHERE idVenta = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                Sales.setIdVenta(rs.getInt(1));
                Sales.setFechaVenta(rs.getString(2));
                Sales.setTotal(rs.getDouble(3));
                Sales.setIdUsuario(rs.getInt(4));
            }
        } catch (SQLException e) {
            System.out.println("No se listo" + e.toString());
        }
        return Sales;
    }
}