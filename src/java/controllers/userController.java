package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.sql.SQLException;

import modelsBeans.sales;
import modelsDAO.salesDAO;

import modelsBeans.user;
import modelsDAO.userDAO;

import modelsBeans.salesTicketType;
import modelsDAO.salesTicketTypeDAO;

/*@author Sergio*/

public class userController extends HttpServlet {

    private final userDAO UserDAO;
    private final salesDAO SalesDAO;
    private final salesTicketTypeDAO sttDAO;
    
    public userController() {
        this.UserDAO = new userDAO(); 
        this.SalesDAO = new salesDAO();
        this.sttDAO = new salesTicketTypeDAO();
    }
    
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
                    agregarUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Borrar":
                try {
                    borrarUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "Editar":
                try {
                    editarUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Actualizar":
                try {
                    actualizarUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "IniciarSesion":
                try {
                    iniciarSesion(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "CrearCuenta":
                try {
                    iniciarSesion(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Pagar":
                try {
                    actualizarUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;  
            default:
                System.out.println("Opcion equivocada");
                break;
        }
    }

    private void agregarUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {        
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoM = request.getParameter("apellidoM");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        int edad = Integer.parseInt(request.getParameter("edad"));
        char sexo = request.getParameter("sexo").charAt(0);
        char privilegio = request.getParameter("privilegio").charAt(0);
        
        user User = new user(nombre, apellidoP, apellidoM, correo, contrasena, edad, sexo, privilegio);
        UserDAO.Agregar(User);
        response.sendRedirect("/Zoo/tests/testUser.jsp");
    }
    
    private void borrarUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        UserDAO.Borrar(idUsuario);
        response.sendRedirect("/Zoo/tests/testUser.jsp");
    }
    
    private void editarUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        user existeUser = UserDAO.Buscar(idUsuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/tests/testUser.jsp");
        request.setAttribute("User", existeUser);
        dispatcher.forward(request, response);
    }
    
    private void actualizarUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoM = request.getParameter("apellidoM");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        int edad = Integer.parseInt(request.getParameter("edad"));
        char sexo = request.getParameter("sexo").charAt(0);
        char privilegio = request.getParameter("privilegio").charAt(0);
        
        user User = new user(idUsuario, nombre, apellidoP, apellidoM, correo, contrasena, edad, sexo, privilegio);
        UserDAO.Actualizar(User);
        response.sendRedirect("/Zoo/tests/testUser.jsp");
    }
    
    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        
        user existeUser = UserDAO.BuscarPorCredenciales(correo, contrasena);
        if (existeUser != null && existeUser.getIdUsuario() != 0) {
            if (existeUser.getPrivilegio() == 'U') {
                response.sendRedirect("/Zoo/templates/inicio.jsp");
            }
            else if (existeUser.getPrivilegio() == 'A') {
                response.sendRedirect("/Zoo/templates/administrador/mainAdmin.jsp");
            }
        } else {
        response.sendRedirect("/Zoo");
        }
    }
    public void pagar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String id = request.getParameter("id");
        String ninos = request.getParameter("ninos");
        String adultos = request.getParameter("adultos");
        String total = request.getParameter("costoTotal");
        
        int Id = Integer.parseInt(id);
        int Ninos = Integer.parseInt(ninos);
        int Adultos = Integer.parseInt(adultos);
        Double CostoTotal = Double.parseDouble(total);
        
        sales Sales = new sales(CostoTotal, Id);
        SalesDAO.Agregar(Sales);
        
        if(Ninos != 0){
            salesTicketType SalesTicketType1 = new salesTicketType(Sales.getIdVenta(),1,Ninos);
            sttDAO.Agregar(SalesTicketType1);
        }
        if(Adultos != 0){
            salesTicketType SalesTicketType2 = new salesTicketType(Sales.getIdVenta(),2,Adultos);
            sttDAO.Agregar(SalesTicketType2);
        }       
        response.sendRedirect("/Zoo/test/testBuy.jsp");
    }
}