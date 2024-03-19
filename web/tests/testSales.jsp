<%@page import="modelsBeans.sales"%>
<%@page import="modelsDAO.salesDAO"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>
    </head>
    <body>
        <h2>Ventas</h2>
        
        <form action="/Zoo/salesController" method="POST">
            <div>
                <label>idVenta</label>
                <input type="text" value="${Sales.getIdVenta()}" disabled><br>
                <input type="text" value="${Sales.getIdVenta()}" name="idVenta" hidden>

                <label>Fecha de la venta</label>
                <input type="text" value="${Sales.getFechaVenta()}" disabled><br>

                <label>Total</label>
                <input type="text" value="${Sales.getTotal()}" name="total"><br>
                
                <label>idUsuario</label>
                <input type="text" value="${Sales.getIdUsuario()}" name="idUsuario"><br>
            </div>

            <input type="submit" name="op" value="Agregar">
            <input type="submit" name="op" value="Actualizar">
        </form>
            
        <h2>Lista de ventas</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>idVenta</th>
                    <th>Fecha de venta</th>
                    <th>Total</th>
                    <th>idUsuario</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    salesDAO SALES = new salesDAO();
                    List<sales> listaSales = SALES.lista();
                    for(sales Sales : listaSales) {
                %>
                <tr>
                    <td><%= Sales.getIdVenta()%></td>
                    <td><%= Sales.getFechaVenta()%></td>
                    <td><%= Sales.getTotal()%></td>
                    <td><%= Sales.getIdUsuario()%></td>
                    <td>
                        <a href="/Zoo/salesController?op=Editar&idVenta=<%= Sales.getIdVenta()%>" style="margin-right: 10px;">Editar</a>
                        <a href="/Zoo/salesController?op=Borrar&idVenta=<%= Sales.getIdVenta()%>">Borrar</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>