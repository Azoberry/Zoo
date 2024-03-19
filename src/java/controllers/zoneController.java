package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;
import java.sql.SQLException;
import modelsBeans.zone;
import modelsDAO.zoneDAO;

/*@author Sergio*/

public class zoneController extends HttpServlet {

    private final zoneDAO ZoneDAO;
    
    public zoneController() {this.ZoneDAO = new zoneDAO();}
    
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
                    agregarZone(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Borrar":
                try {
                    borrarZone(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "Editar":
                try {
                    editarZone(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Actualizar":
                try {
                    actualizarZone(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Opcion equivocada");
                break;
        }
    }
    
    private void agregarZone(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {        
        String ubicacion = request.getParameter("ubicacion");
        double area = Double.parseDouble(request.getParameter("area"));
        
        zone Zone = new zone(ubicacion, area);
        ZoneDAO.Agregar(Zone);
        response.sendRedirect("/Zoo/templates/administrador/zonaTablasAdmin.jsp");
    }
    
    private void borrarZone(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idZona = Integer.parseInt(request.getParameter("idZona"));
        ZoneDAO.Borrar(idZona);
        response.sendRedirect("/Zoo/templates/administrador/zonaTablasAdmin.jsp");
    }
    
    private void editarZone(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idZone = Integer.parseInt(request.getParameter("idZona"));
        zone existeZone = ZoneDAO.Buscar(idZone);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates/administrador/editarZonas.jsp");
        request.setAttribute("Zone", existeZone);
        dispatcher.forward(request, response);
        response.sendRedirect("/Zoo/templates/administrador/editarZonas.jsp");
    }
    
    private void actualizarZone(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idZona = Integer.parseInt(request.getParameter("idZona"));
        String ubicacion = request.getParameter("ubicacion");
        double area = Double.parseDouble(request.getParameter("area"));
        
        zone Zone = new zone(idZona, ubicacion, area);
        ZoneDAO.Actualizar(Zone);
        response.sendRedirect("/Zoo/templates/administrador/zonaTablasAdmin.jsp");
    }
}
