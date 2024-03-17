<%@page import="modelsBeans.user"%>
<%@page import="modelsDAO.userDAO"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
    </head>
    <body>
        <h2>Usuarios</h2>
        
        <form action="/Zoo/userController" method="POST">
            <div>
                <label>idUsuario</label>
                <input type="text" value="${User.getIdUsuario()}" disabled><br>
                <input type="text" value="${User.getIdUsuario()}" name="idUsuario" hidden>

                <label>Nombre</label>
                <input type="text" value="${User.getNombre()}" name="nombre"><br>

                <label>Apellido Paterno</label>
                <input type="text" value="${User.getApellidoP()}" name="apellidoP"><br>
                
                <label>Apellido Materno</label>
                <input type="text" value="${User.getApellidoM()}" name="apellidoM"><br>
                
                <label>Correo</label>
                <input type="text" value="${User.getCorreo()}" name="correo"><br>
                
                <label>Contraseña</label>
                <input type="text" value="${User.getContrasena()}" name="contrasena"><br>
                
                <label>Edad</label>
                <input type="text" value="${User.getEdad()}" name="edad"><br>

                <label>Sexo</label>
                <input type="text" value="${User.getSexo()}" name="sexo"><br>

                <label>Privilegio</label>
                <input type="text" value="${User.getPrivilegio()}" name="privilegio"><br>
            </div>

            <input type="submit" name="op" value="Agregar">
            <input type="submit" name="op" value="Actualizar">
        </form>
            
        <h2>Lista de usuarios</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>idUsuario</th>
                    <th>Nombre</th>
                    <th>Apellido Paterno</th>
                    <th>Apellido Materno</th>
                    <th>Correo</th>
                    <th>Contraseña</th>
                    <th>Edad</th>
                    <th>Sexo</th>
                    <th>Privilegio</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    userDAO USER = new userDAO();
                    List<user> listaUsuarios = USER.lista();
                    for(user User : listaUsuarios) {
                %>
                <tr>
                    <td><%= User.getIdUsuario()%></td>
                    <td><%= User.getNombre()%></td>
                    <td><%= User.getApellidoP()%></td>
                    <td><%= User.getApellidoM()%></td>
                    <td><%= User.getCorreo()%></td>
                    <td><%= User.getContrasena()%></td>
                    <td><%= User.getEdad()%></td>
                    <td><%= User.getSexo()%></td>
                    <td><%= User.getPrivilegio()%></td>
                    <td>
                        <a href="/Zoo/userController?op=Editar&idUsuario=<%= User.getIdUsuario()%>" style="margin-right: 10px;">Editar</a>
                        <a href="/Zoo/userController?op=Borrar&idUsuario=<%= User.getIdUsuario()%>">Borrar</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>