package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;
import java.sql.SQLException;
import modelsBeans.ticketType;
import modelsDAO.ticketTypeDAO;

/*@author Sergio*/

public class ticketTypeController extends HttpServlet {

    private final ticketTypeDAO ticketDAO;
    
    public ticketTypeController() {this.ticketDAO = new ticketTypeDAO();}

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
                    agregarTicketType(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Borrar":
                try {
                    borrarTicketType(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "Editar":
                try {
                    editarTicketType(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Actualizar":
                try {
                    actualizarTicketType(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Opcion equivocada");
                break;
        }
    }
    
    private void agregarTicketType(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {        
        String tipo = request.getParameter("tipo");
        double precio = Double.parseDouble(request.getParameter("precio"));
        
        ticketType ticket = new ticketType(tipo, precio);
        ticketDAO.Agregar(ticket);
        response.sendRedirect("/Zoo/tests/testTicketType.jsp");
    }
    
    private void borrarTicketType(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idBoleto = Integer.parseInt(request.getParameter("idBoleto"));
        ticketDAO.Borrar(idBoleto);
        response.sendRedirect("/Zoo/tests/testTicketType.jsp");
    }
    
    private void editarTicketType(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idBoleto = Integer.parseInt(request.getParameter("idBoleto"));
        ticketType existeTicket = ticketDAO.Buscar(idBoleto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/tests/testTicketType.jsp");
        request.setAttribute("Ticket", existeTicket);
        dispatcher.forward(request, response);
    }
    
    private void actualizarTicketType(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idBoleto = Integer.parseInt(request.getParameter("idBoleto"));
        String tipo = request.getParameter("tipo");
        double precio = Double.parseDouble(request.getParameter("precio"));

        ticketType ticket = new ticketType(idBoleto, tipo, precio);
        ticketDAO.Actualizar(ticket);
        response.sendRedirect("/Zoo/tests/testTicketType.jsp");
    }
}
