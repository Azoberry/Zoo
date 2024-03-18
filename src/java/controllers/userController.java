package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;
import java.sql.SQLException;
import modelsBeans.user;
import modelsDAO.userDAO;

/*@author Sergio*/

public class userController extends HttpServlet {

    private final userDAO UserDAO;
    
    public userController() {this.UserDAO = new userDAO();}
    
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
}