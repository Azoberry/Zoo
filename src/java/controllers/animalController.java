package controllers;

import config.conexion;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelsBeans.animal;
import modelsDAO.animalDAO;

/*@author Sergio*/
@MultipartConfig
public class animalController extends HttpServlet {
    
    private final animalDAO AnimalDAO;
    
    public animalController() {this.AnimalDAO = new animalDAO();}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        
        switch (op) {
            case "Agregar":
                try {
                    agregarAnimal(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Borrar":
                try {
                    borrarAnimal(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "Editar":
                try {
                    editarAnimal(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Actualizar":
                try {
                    actualizarAnimal(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Opcion equivocada");
                break;
        }
    }
    
    private void agregarAnimal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {        
        //AGREGAR IMAGEN
        Part file = request.getPart("image");
        
        String imageFileName = file.getSubmittedFileName();
        System.out.println("Selected image File Name: " + imageFileName);
        
        String uploadPath = "C:/Users/terra/OneDrive/Documentos/NetBeansProjects/Zoo/web/imagenes/"+imageFileName;
        System.out.println("Upload Path: " + uploadPath);
        
        try {
            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = file.getInputStream();

            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        try {
            conexion conexion = new conexion();
            Connection con;
            con = conexion.conn();
            PreparedStatement pstm;
            ResultSet rs;
            
            String query = "INSERT INTO imagen(nombreImagen) VALUES (?)";
            pstm = con.prepareStatement(query);
            pstm.setString(1, imageFileName);
            int row = pstm.executeUpdate();
            
            if (row > 0) {
                System.out.println("Agregado a la base de datos exitosamente");
            } else {
                System.out.println("ERROR al subir la imagen");
            }
        } catch(Exception e) {
            System.out.println("e");
        }
        
        //AGREGAR DATOS DEL ANIMAL
        String nombre = request.getParameter("nombre");
        String apodo = request.getParameter("apodo");
        String dieta = request.getParameter("dieta");
        String descripcion = request.getParameter("descripcion");
        String habitatNat = request.getParameter("habitatNat");
        char sexo = request.getParameter("sexo").charAt(0);
        int edad = Integer.parseInt(request.getParameter("edad"));
        double peso = Double.parseDouble(request.getParameter("peso"));
        double tamano = Double.parseDouble(request.getParameter("tamano"));
        int idHabitat = Integer.parseInt(request.getParameter("idHabitat"));
        
        animal Animal = new animal(nombre, apodo, dieta, descripcion, habitatNat, sexo, edad, peso, tamano, idHabitat);
        AnimalDAO.Agregar(Animal);
        response.sendRedirect("/Zoo/templates/administrador/animalTablasAdmin.jsp");
    }
    
    private void borrarAnimal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idAnimal = Integer.parseInt(request.getParameter("idAnimal"));
        AnimalDAO.Borrar(idAnimal);
        response.sendRedirect("/Zoo/templates/administrador/animalTablasAdmin.jsp");
    }
    
    private void editarAnimal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idAnimal = Integer.parseInt(request.getParameter("idAnimal"));
        animal existeAnimal = AnimalDAO.Buscar(idAnimal);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates/administrador/editarAnimal.jsp");
        request.setAttribute("Animal", existeAnimal);
        dispatcher.forward(request, response);
        response.sendRedirect("/Zoo/templates/administrador/editarAnimal.jsp");
    }
    
    private void actualizarAnimal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idAnimal = Integer.parseInt(request.getParameter("idAnimal"));
        String nombre = request.getParameter("nombre");
        String apodo = request.getParameter("apodo");
        String dieta = request.getParameter("dieta");
        String descripcion = request.getParameter("descripcion");
        String habitatNat = request.getParameter("habitatNat");
        char sexo = request.getParameter("sexo").charAt(0);
        int edad = Integer.parseInt(request.getParameter("edad"));
        double peso = Double.parseDouble(request.getParameter("peso"));
        double tamano = Double.parseDouble(request.getParameter("tamano"));
        int idHabitat = Integer.parseInt(request.getParameter("idHabitat"));
        
        animal Animal = new animal(idAnimal, nombre, apodo, dieta, descripcion, habitatNat, sexo, edad, peso, tamano, idHabitat);
        AnimalDAO.Actualizar(Animal);
        response.sendRedirect("/Zoo/templates/administrador/animalTablasAdmin.jsp");
    }
}
