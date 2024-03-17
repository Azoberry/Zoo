<%@page import="modelsBeans.zone"%>
<%@page import="modelsDAO.zoneDAO"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Animales</title>
    </head>
    <body>
        <h2>Animales</h2>
        
        <form action="/Zoo/zoneController" method="POST">
            <div>
                <label>idZona</label>
                <input type="text" value="${Zone.getIdZona()}" disabled><br>
                <input type="text" value="${Zone.getIdZona()}" name="idZona" hidden>

                <label>Ubicacion</label>
                <input type="text" value="${Zone.getUbicacion()}" name="ubicacion"><br>

                <label>Area</label>
                <input type="text" value="${Zone.getArea()}" name="area"><br>
            </div>

            <input type="submit" name="op" value="Agregar">
            <input type="submit" name="op" value="Actualizar">
        </form>
            
        <h2>Lista de zonas</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>idZona</th>
                    <th>Ubicacion</th>
                    <th>Area</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    zoneDAO ZONE = new zoneDAO();
                    List<zone> listaZonas = ZONE.lista();
                    for(zone Zone : listaZonas) {
                %>
                <tr>
                    <td><%= Zone.getIdZona()%></td>
                    <td><%= Zone.getUbicacion()%></td>
                    <td><%= Zone.getArea()%></td>
                    <td>
                        <a href="/Zoo/zoneController?op=Editar&idZona=<%= Zone.getIdZona()%>" style="margin-right: 10px;">Editar</a>
                        <a href="/Zoo/zoneController?op=Borrar&idZona=<%= Zone.getIdZona()%>">Borrar</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>