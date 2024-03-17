<%@page import="modelsBeans.habitat"%>
<%@page import="modelsDAO.habitatDAO"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Habitats</title>
    </head>
    <body>
        <h2>Habitats</h2>
        
        <form action="/Zoo/habitatController" method="POST">
            <div>
                <label>idHabitat</label>
                <input type="text" value="${Habitat.getIdHabitat()}" disabled><br>
                <input type="text" value="${Habitat.getIdHabitat()}" name="idHabitat" hidden>

                <label>Nombre</label>
                <input type="text" value="${Habitat.getNombre()}" name="nombre"><br>

                <label>Descripcion</label>
                <input type="text" value="${Habitat.getDescripcion()}" name="descripcion"><br>
                
                <label>Capacidad</label>
                <input type="text" value="${Habitat.getCapacidad()}" name="capacidad"><br>
                
                <label>Area</label>
                <input type="text" value="${Habitat.getArea()}" name="area"><br>
                
                <label>Horario de Apertura</label>
                <input type="time" value="${Habitat.getHorarioAper()}" name="horarioAper"><br>

                <label>Horario de Cierre</label>
                <input type="time" value="${Habitat.getHorarioCier()}" name="horarioCier"><br>
                
                <label>idZona</label>
                <input type="text" value="${Habitat.getIdZona()}" name="idZona"><br>
            </div>

            <input type="submit" name="op" value="Agregar">
            <input type="submit" name="op" value="Actualizar">
        </form>
            
        <h2>Lista de habitats</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>idHabitat</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Capacidad</th>
                    <th>Area</th>
                    <th>Horario de Apertura</th>
                    <th>Horario de Cierre</th>
                    <th>idZona</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    habitatDAO HABITAT = new habitatDAO();
                    List<habitat> listaHabitats = HABITAT.lista();
                    for(habitat Habitat : listaHabitats) {
                %>
                <tr>
                    <td><%= Habitat.getIdHabitat()%></td>
                    <td><%= Habitat.getNombre()%></td>
                    <td><%= Habitat.getDescripcion()%></td>
                    <td><%= Habitat.getCapacidad()%></td>
                    <td><%= Habitat.getArea()%></td>
                    <td><%= Habitat.getHorarioAper()%></td>
                    <td><%= Habitat.getHorarioCier()%></td>
                    <td><%= Habitat.getIdZona()%></td>
                    <td>
                        <a href="/Zoo/habitatController?op=Editar&idHabitat=<%= Habitat.getIdHabitat()%>" style="margin-right: 10px;">Editar</a>
                        <a href="/Zoo/habitatController?op=Borrar&idHabitat=<%= Habitat.getIdHabitat()%>">Borrar</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>