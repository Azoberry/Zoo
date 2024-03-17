<%@page import="modelsBeans.salesTicketType"%>
<%@page import="modelsDAO.salesTicketTypeDAO"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VentasTipoBoleto</title>
    </head>
    <body>
        <h2>VentasTipoBoleto</h2>
        
        <form action="/Zoo/salesTicketTypeController" method="POST">
            <div>
                <label>idVenta</label>
                <input type="text" value="${STT.getIdVenta()}" name="idVenta"><br>
                
                <label>idBoleto</label>
                <input type="text" value="${STT.getIdBoleto()}" name="idBoleto"><br>

                <label>Cantidad</label>
                <input type="text" value="${STT.getCantidad()}" name="cantidad"><br>
            </div>

            <input type="submit" name="op" value="Agregar">
            <input type="submit" name="op" value="Actualizar">
        </form>
            
        <h2>Lista de VentasTipoBoleto</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>idVenta</th>
                    <th>idBoleto</th>
                    <th>Cantidad</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    salesTicketTypeDAO stt = new salesTicketTypeDAO();
                    List<salesTicketType> listaSTT = stt.lista();
                    for(salesTicketType STT : listaSTT) {
                %>
                <tr>
                    <td><%= STT.getIdVenta()%></td>
                    <td><%= STT.getIdBoleto()%></td>
                    <td><%= STT.getCantidad()%></td>
                    <td>
                        <a href="/Zoo/salesTicketTypeController?op=Editar&idVenta=<%= STT.getIdVenta()%>&idBoleto=<%= STT.getIdBoleto()%>" style="margin-right: 10px;">Editar</a>
                        <a href="/Zoo/salesTicketTypeController?op=Borrar&idVenta=<%= STT.getIdVenta()%>&idBoleto=<%= STT.getIdBoleto()%>">Borrar</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>