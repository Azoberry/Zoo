package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;
import java.sql.SQLException;
import modelsBeans.animal;
import modelsDAO.animalDAO;

/*@author Sergio*/

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
    
    private void agregarAnimal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {        
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
        response.sendRedirect("/Zoo/tests/testAnimal.jsp");
    }
    
    private void borrarAnimal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idAnimal = Integer.parseInt(request.getParameter("idAnimal"));
        AnimalDAO.Borrar(idAnimal);
        response.sendRedirect("/Zoo/tests/testAnimal.jsp");
    }
    
    private void editarAnimal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idAnimal = Integer.parseInt(request.getParameter("idAnimal"));
        animal existeAnimal = AnimalDAO.Buscar(idAnimal);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/tests/testAnimal.jsp");
        request.setAttribute("Animal", existeAnimal);
        dispatcher.forward(request, response);
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
        response.sendRedirect("/Zoo/tests/testAnimal.jsp");
    }
}
