package modelsDAO;

import config.conexion;
import modelsBeans.sales;
import modelsBeans.user;
import modelsBeans.salesTicketType;
import modelsBeans.ticketType;

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
    
    public int ObtenerUltimaVenta (){
    String sql = "SELECT * FROM ventas ORDER BY idVenta DESC LIMIT 1";
        int id = -1;
        
        try (Connection con = conexion.conn();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            if (rs.next()) {
                id = rs.getInt("idVenta");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return id;
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
    
    // Regresa un usuario con su nombre completo y su correo
    public user BuscarDetallesUsuario (int idVenta) {
        user User = new user();
        String sql = "SELECT Usuario.nombre, Usuario.apellidoP, Usuario.apellidoM, Usuario.correo FROM Ventas JOIN Usuario ON Ventas.idUsuario = Usuario.idUsuario WHERE Ventas.idVenta = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, idVenta);
            
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                User.setNombre(rs.getString(1));
                User.setApellidoP(rs.getString(2));
                User.setApellidoM(rs.getString(3));
                User.setCorreo(rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println("No se listo" + e.toString());
        }
        return User;
    }
    
    // Regresa una lista con idBoleto y la cantidad
    public List BuscarDetallesSTT (int idVenta) {
        String sql = "SELECT VT.idBoleto, VT.cantidad FROM ventaTipoBoleto VT JOIN Ventas ON VT.idVenta = Ventas.idVenta WHERE Ventas.idVenta = ?";
        List listSTT = new ArrayList<>();
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, idVenta);
            
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                salesTicketType STT = new salesTicketType();
                
                STT.setIdBoleto(rs.getInt(1));
                STT.setCantidad(rs.getInt(2));
                
                listSTT.add(STT);
            }
        } catch (SQLException e) {
            System.out.println("No se listo" + e.toString());
        }
        return listSTT;
    }
    
    // Regresa toda la informacion de un boleto
    public ticketType BuscarDetallesBoleto (int idBoleto) {
        ticketType TT = new ticketType();
        String sql = "SELECT * FROM tipoboleto WHERE idBoleto = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, idBoleto);
            
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                TT.setIdBoleto(rs.getInt(1));
                TT.setTipo(rs.getString(2));
                TT.setPrecio(rs.getDouble(3));
            }
        } catch (SQLException e) {
            System.out.println("No se listo" + e.toString());
        }
        return TT;
    }
}