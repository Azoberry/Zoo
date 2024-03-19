<%@page import="modelsBeans.animal"%>
<%@page import="modelsDAO.animalDAO"%>
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
        
        <form action="/Zoo/animalController" method="POST">
            <div>
                <label>idAnimal</label>
                <input type="text" value="${Animal.getIdAnimal()}" disabled><br>
                <input type="text" value="${Animal.getIdAnimal()}" name="idAnimal" hidden>

                <label>Nombre</label>
                <input type="text" value="${Animal.getNombre()}" name="nombre"><br>

                <label>Apodo</label>
                <input type="text" value="${Animal.getApodo()}" name="apodo"><br>
                
                <label>Dieta</label>
                <input type="text" value="${Animal.getDieta()}" name="dieta"><br>
                
                <label>Descripcion</label>
                <input type="text" value="${Animal.getDescripcion()}" name="descripcion"><br>
                
                <label>Habitat Natural</label>
                <input type="text" value="${Animal.getHabitatNat()}" name="habitatNat"><br>

                <label>Sexo</label>
                <input type="text" value="${Animal.getSexo()}" name="sexo"><br>
                
                <label>Edad</label>
                <input type="text" value="${Animal.getEdad()}" name="edad"><br>
                
                <label>Peso</label>
                <input type="text" value="${Animal.getPeso()}" name="peso"><br>
                
                <label>Tamaño</label>
                <input type="text" value="${Animal.getTamano()}" name="tamano"><br>
                
                <label>idHabitat</label>
                <input type="text" value="${Animal.getIdHabitat()}" name="idHabitat"><br>
            </div>

            <input type="submit" name="op" value="Agregar">
            <input type="submit" name="op" value="Actualizar">
        </form>
            
        <h2>Lista de animales</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>idAnimal</th>
                    <th>Nombre</th>
                    <th>Apodo</th>
                    <th>Dieta</th>
                    <th>Descripcion</th>
                    <th>Habitat Natural</th>
                    <th>Sexo</th>
                    <th>Edad</th>
                    <th>Peso</th>
                    <th>Tamaño</th>
                    <th>idHabitat</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    animalDAO ANIMAL = new animalDAO();
                    List<animal> listaAnimales = ANIMAL.lista();
                    for(animal Animal : listaAnimales) {
                %>
                <tr>
                    <td><%= Animal.getIdAnimal()%></td>
                    <td><%= Animal.getNombre()%></td>
                    <td><%= Animal.getApodo()%></td>
                    <td><%= Animal.getDieta()%></td>
                    <td><%= Animal.getDescripcion()%></td>
                    <td><%= Animal.getHabitatNat()%></td>
                    <td><%= Animal.getSexo()%></td>
                    <td><%= Animal.getEdad()%></td>
                    <td><%= Animal.getPeso()%></td>
                    <td><%= Animal.getTamano()%></td>
                    <td><%= Animal.getIdHabitat()%></td>
                    <td>
                        <a href="/Zoo/animalController?op=Editar&idAnimal=<%= Animal.getIdAnimal()%>" style="margin-right: 10px;">Editar</a>
                        <a href="/Zoo/animalController?op=Borrar&idAnimal=<%= Animal.getIdAnimal()%>">Borrar</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>