package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;
import modelsBeans.sales;
import modelsDAO.salesDAO;
import modelsBeans.user;
import modelsBeans.salesTicketType;
import modelsBeans.ticketType;

/*@author Sergio*/

public class salesController extends HttpServlet {

    private final salesDAO SalesDAO;
    
    public salesController() {this.SalesDAO = new salesDAO();}
    
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
                    agregarSales(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Borrar":
                try {
                    borrarSales(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Editar":
                try {
                    editarSales(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Actualizar":
                try {
                    actualizarSales(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "DetallesVenta":
                try {
                    detallesSales(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Opcion equivocada");
                break;
        }
    }
    
    private void agregarSales(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {        
        double total = Double.parseDouble(request.getParameter("total"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        
        sales Sales = new sales(total, idUsuario);
        SalesDAO.Agregar(Sales);
        response.sendRedirect("/Zoo/tests/testSales.jsp");
    }
    
    private void borrarSales(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        SalesDAO.Borrar(idVenta);
        response.sendRedirect("/Zoo/tests/testSales.jsp");
    }
    
    private void editarSales(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        sales existeSale = SalesDAO.Buscar(idVenta);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/tests/testSales.jsp");
        request.setAttribute("Sales", existeSale);
        dispatcher.forward(request, response);
    }
    
    private void actualizarSales(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        double total = Double.parseDouble(request.getParameter("total"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        
        sales Sales = new sales(idVenta, total, idUsuario);
        SalesDAO.Actualizar(Sales);
        response.sendRedirect("/Zoo/tests/testSales.jsp");
    }
    
    private void detallesSales(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        
        user existeUser = SalesDAO.BuscarDetallesUsuario(idVenta);
        sales existeSale = SalesDAO.Buscar(idVenta);
        List<salesTicketType> listaSTT = SalesDAO.BuscarDetallesSTT(idVenta);
        
        List listaTT = new ArrayList<>();
        for(salesTicketType STT : listaSTT) {
            int idBoleto = STT.getIdBoleto();
            ticketType TT = SalesDAO.BuscarDetallesBoleto(idBoleto);
            listaTT.add(TT);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates/historialDetalles.jsp");
        request.setAttribute("User", existeUser);
        request.setAttribute("Sale", existeSale);
        request.setAttribute("listaSTT", listaSTT);
        request.setAttribute("listaTT", listaTT);
        dispatcher.forward(request, response);
        response.sendRedirect("/Zoo/templates/historialDetalles.jsp");
    }
}