<%@page import="modelsBeans.ticketType"%>
<%@page import="modelsDAO.ticketTypeDAO"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Boletos</title>
    </head>
    <body>
        <h2>Tipos de boletos</h2>
        
        <form action="/Zoo/ticketTypeController" method="POST">
            <div>
                <label>idBoleto</label>
                <input type="text" value="${Ticket.getIdBoleto()}" disabled><br>
                <input type="text" value="${Ticket.getIdBoleto()}" name="idBoleto" hidden>

                <label>Tipo</label>
                <input type="text" value="${Ticket.getTipo()}" name="tipo"><br>

                <label>Precio</label>
                <input type="text" value="${Ticket.getPrecio()}" name="precio"><br>
            </div>

            <input type="submit" name="op" value="Agregar">
            <input type="submit" name="op" value="Actualizar">
        </form>
            
        <h2>Lista de tipos de boletos</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>idBoleto</th>
                    <th>Tipo</th>
                    <th>Precio</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ticketTypeDAO TICKET = new ticketTypeDAO();
                    List<ticketType> listaTickets = TICKET.lista();
                    for(ticketType Ticket : listaTickets) {
                %>
                <tr>
                    <td><%= Ticket.getIdBoleto()%></td>
                    <td><%= Ticket.getTipo()%></td>
                    <td><%= Ticket.getPrecio()%></td>
                    <td>
                        <a href="/Zoo/ticketTypeController?op=Editar&idBoleto=<%= Ticket.getIdBoleto()%>" style="margin-right: 10px;">Editar</a>
                        <a href="/Zoo/ticketTypeController?op=Borrar&idBoleto=<%= Ticket.getIdBoleto()%>">Borrar</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>