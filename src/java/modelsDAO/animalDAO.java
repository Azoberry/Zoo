package modelsDAO;

import config.conexion;
import modelsBeans.animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*@author Sergio*/

public class animalDAO {
    conexion conexion = new conexion();
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    int r;
    
    public List lista() {
        String sql = "SELECT * FROM animal";
        List listAnimal = new ArrayList<>();
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                animal Animal = new animal();
                
                Animal.setIdAnimal(rs.getInt(1));
                Animal.setNombre(rs.getString(2));
                Animal.setApodo(rs.getString(3));
                Animal.setDieta(rs.getString(4));
                Animal.setDescripcion(rs.getString(5));
                Animal.setHabitatNat(rs.getString(6));
                Animal.setSexo(rs.getString(7).charAt(0));
                Animal.setEdad(rs.getInt(8));
                Animal.setPeso(rs.getDouble(9));
                Animal.setTamano(rs.getDouble(10));
                Animal.setIdHabitat(rs.getInt(11));
                
                listAnimal.add(Animal);
            }
        } catch (SQLException e) {}
       return listAnimal;
    }
    
    public int Agregar(animal Animal) {
        String sql = "INSERT INTO animal (nombre, apodo, dieta, descripcion, habitatNat, sexo, edad, peso, tamano, idHabitat) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, Animal.getNombre());
            pstm.setString(2, Animal.getApodo());
            pstm.setString(3, Animal.getDieta());
            pstm.setString(4, Animal.getDescripcion());
            pstm.setString(5, Animal.getHabitatNat());
            pstm.setString(6, String.valueOf(Animal.getSexo()));
            pstm.setInt(7, Animal.getEdad());
            pstm.setDouble(8, Animal.getPeso());
            pstm.setDouble(9, Animal.getTamano());
            pstm.setInt(10, Animal.getIdHabitat());
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se agrego el animal" + e.toString());
        }
        return r;
    }
    
    public int Actualizar(animal Animal) {
        String sql = "UPDATE animal SET nombre = ?, apodo = ?, dieta = ?, descripcion = ?, habitatNat = ?, sexo = ?, edad = ?, peso = ?, tamano = ?, idHabitat = ? WHERE idAnimal = ?";
        
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, Animal.getNombre());
            pstm.setString(2, Animal.getApodo());
            pstm.setString(3, Animal.getDieta());
            pstm.setString(4, Animal.getDescripcion());
            pstm.setString(5, Animal.getHabitatNat());
            pstm.setString(6, String.valueOf(Animal.getSexo()));
            pstm.setInt(7, Animal.getEdad());
            pstm.setDouble(8, Animal.getPeso());
            pstm.setDouble(9, Animal.getTamano());
            pstm.setInt(10, Animal.getIdHabitat());
            pstm.setInt(11, Animal.getIdAnimal());
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se actualizo el animal" + e.toString());
        }
        return r;
    }
    
    public void Borrar(int id) {
        String sql = "DELETE FROM animal WHERE idAnimal = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se borro animal" + e.toString());
        }
    }
    
    public animal Buscar(int id) {
        animal Animal = new animal();
        String sql = "SELECT * FROM animal WHERE idAnimal = ?";
        try {
            con = conexion.conn();
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                Animal.setIdAnimal(rs.getInt(1));
                Animal.setNombre(rs.getString(2));
                Animal.setApodo(rs.getString(3));
                Animal.setDieta(rs.getString(4));
                Animal.setDescripcion(rs.getString(5));
                Animal.setHabitatNat(rs.getString(6));
                Animal.setSexo(rs.getString(7).charAt(0));
                Animal.setEdad(rs.getInt(8));
                Animal.setPeso(rs.getDouble(9));
                Animal.setTamano(rs.getDouble(10));
                Animal.setIdHabitat(rs.getInt(11));
            }
        } catch (SQLException e) {
            System.out.println("No se listo" + e.toString());
        }
        return Animal;
    }
}
