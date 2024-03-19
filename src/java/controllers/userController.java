package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.sql.SQLException;
import java.util.Map;
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
        //Esta linea se usa para mostrar los parametros y los valores que le llegan a la peticion
//        Map<String, String[]> parametros = request.getParameterMap();
//
//    // Iterar sobre el mapa de parámetros e imprimir cada parámetro y sus valores
//    for (Map.Entry<String, String[]> entry : parametros.entrySet()) {
//        String nombreParametro = entry.getKey();
//        String[] valoresParametro = entry.getValue();
//        
//        // Imprimir el nombre del parámetro
//        System.out.println("Nombre del parámetro: " + nombreParametro);
//
//        // Imprimir cada valor del parámetro
//        for (String valor : valoresParametro) {
//            System.out.println("Valor: " + valor);
//        }
//    }
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
                    crearUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Pagar":
                try {
                    pagar(request, response);
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
        response.sendRedirect("/Zoo/index.jsp");
    }
    
    private void crearUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {        
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoM = request.getParameter("apellidoM");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        int edad = Integer.parseInt(request.getParameter("edad"));
        char sexo = request.getParameter("sexo").charAt(0);
        char privilegio = 'U';
        
        user User = new user(nombre, apellidoP, apellidoM, correo, contrasena, edad, sexo, privilegio);
        UserDAO.Agregar(User);
        response.sendRedirect("/Zoo/templates/inicio.jsp");
    }
    
    private void borrarUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        UserDAO.Borrar(idUsuario);
        response.sendRedirect("/Zoo/templates/administrador/usuarioTablasAdmin.jsp");
    }
    
    private void editarUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        user existeUser = UserDAO.Buscar(idUsuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates/administrador/editarUsuario.jsp");
        request.setAttribute("User", existeUser);
        dispatcher.forward(request, response);
        response.sendRedirect("/Zoo/templates/administrador/editarUsuario.jsp");
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
        response.sendRedirect("/Zoo/templates/administrador/usuarioTablasAdmin.jsp");
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
        String junior = request.getParameter("junior");
        String estandar = request.getParameter("estandar");
        String combo = request.getParameter("combo");
        String total = request.getParameter("costo");
      
        int Id = Integer.parseInt(id);
        int Junior = Integer.parseInt(junior);
        int Estandar = Integer.parseInt(estandar);
        int Combo = Integer.parseInt(combo);
        Double CostoTotal = Double.parseDouble(total);
        
        sales Sales = new sales(CostoTotal, Id);
        SalesDAO.Agregar(Sales);
        int ultima = SalesDAO.ObtenerUltimaVenta();
        
        //System.out.println("El id de la venta es:"+ultima);
        
        if(Junior != 0){
            salesTicketType SalesTicketType1 = new salesTicketType(ultima,1,Junior);
            sttDAO.Agregar(SalesTicketType1);
        }
        if(Estandar != 0){
            salesTicketType SalesTicketType2 = new salesTicketType(ultima,2,Estandar);
            sttDAO.Agregar(SalesTicketType2);
        }
        if(Combo != 0){
            salesTicketType SalesTicketType3 = new salesTicketType(ultima,3,Combo);
            sttDAO.Agregar(SalesTicketType3);
        }
        response.sendRedirect("/Zoo/index.jsp");
    }
    
}