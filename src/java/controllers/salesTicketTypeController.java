package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;
import java.sql.SQLException;
import modelsBeans.salesTicketType;
import modelsDAO.salesTicketTypeDAO;

/*@author Sergio*/

public class salesTicketTypeController extends HttpServlet {

    private final salesTicketTypeDAO sttDAO;
    
    public salesTicketTypeController() {this.sttDAO = new salesTicketTypeDAO();}
    
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
                    agregarSTT(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Borrar":
                try {
                    borrarSTT(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "Editar":
                try {
                    editarSTT(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Actualizar":
                try {
                    actualizarSTT(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Opcion equivocada");
                break;
        }
    }
    
    private void agregarSTT(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {        
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        int idBoleto = Integer.parseInt(request.getParameter("idBoleto"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        
        salesTicketType STT = new salesTicketType(idVenta, idBoleto, cantidad);
        sttDAO.Agregar(STT);
        response.sendRedirect("/Zoo/tests/testSalesTicketType.jsp");
    }
    
    private void borrarSTT(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        int idBoleto = Integer.parseInt(request.getParameter("idBoleto"));
        
        sttDAO.Borrar(idVenta, idBoleto);
        response.sendRedirect("/Zoo/tests/testSalesTicketType.jsp");
    }
    
    private void editarSTT(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        int idBoleto = Integer.parseInt(request.getParameter("idBoleto"));
        
        salesTicketType existeSTT = sttDAO.Buscar(idVenta, idBoleto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/tests/testSalesTicketType.jsp");
        request.setAttribute("STT", existeSTT);
        dispatcher.forward(request, response);
    }
    
    private void actualizarSTT(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        int idBoleto = Integer.parseInt(request.getParameter("idBoleto"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        
        salesTicketType STT = new salesTicketType(idVenta, idBoleto, cantidad);
        sttDAO.Actualizar(STT);
        response.sendRedirect("/Zoo/tests/testSalesTicketType.jsp");
    }
}