package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;
import java.sql.SQLException;
import modelsBeans.habitat;
import modelsDAO.habitatDAO;
import java.sql.Time;

/*@author Sergio*/

public class habitatController extends HttpServlet {

    private final habitatDAO HabitatDAO;
    
    public habitatController() {this.HabitatDAO = new habitatDAO();}

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
                    agregarHabitat(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Borrar":
                try {
                    borrarHabitat(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "Editar":
                try {
                    editarHabitat(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Actualizar":
                try {
                    actualizarHabitat(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Opcion equivocada");
                break;
        }
    }
    
    private void agregarHabitat(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {        
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        int capacidad = Integer.parseInt(request.getParameter("capacidad"));
        double area = Double.parseDouble(request.getParameter("area"));
        String horarioAper = request.getParameter("horarioAper");
        String horarioCier = request.getParameter("horarioCier");
        int idZona = Integer.parseInt(request.getParameter("idZona"));
        
        habitat Habitat = new habitat(nombre, descripcion, capacidad, area, horarioAper, horarioCier, idZona);
        HabitatDAO.Agregar(Habitat);
        response.sendRedirect("/Zoo/templates/administrador/habitatTablasAdmin.jsp");
    }
    
    private void borrarHabitat(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idHabitat = Integer.parseInt(request.getParameter("idHabitat"));
        HabitatDAO.Borrar(idHabitat);
        response.sendRedirect("/Zoo/templates/administrador/habitatTablasAdmin.jsp");
    }
    
    private void editarHabitat(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idHabitat = Integer.parseInt(request.getParameter("idHabitat"));
        habitat existeHabitat = HabitatDAO.Buscar(idHabitat);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates/administrador/editarHabitat.jsp");
        request.setAttribute("Habitat", existeHabitat);
        dispatcher.forward(request, response);
        response.sendRedirect("/Zoo/templates/administrador/editarHabitat.jsp");
    }
    
    private void actualizarHabitat(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idHabitat = Integer.parseInt(request.getParameter("idHabitat"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        int capacidad = Integer.parseInt(request.getParameter("capacidad"));
        double area = Double.parseDouble(request.getParameter("area"));
        String horarioAper = request.getParameter("horarioAper");
        String horarioCier = request.getParameter("horarioCier");
        int idZona = Integer.parseInt(request.getParameter("idZona"));
        
        habitat Habitat = new habitat(idHabitat, nombre, descripcion, capacidad, area, horarioAper, horarioCier, idZona);
        HabitatDAO.Actualizar(Habitat);
        response.sendRedirect("/Zoo/templates/administrador/habitatTablasAdmin.jsp");
    }
}