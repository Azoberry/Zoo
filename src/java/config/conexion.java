/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Kalos
 */
public class conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/prueba?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    String user = "";
    String pass = "";
    
    public Connection conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException e){
            System.out.println("error conexion"+ e.toString());
        }
        return con;
    }
}