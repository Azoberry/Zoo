<%@page import="modelsBeans.user"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
    </head>
    <body>
        <h1>BIENVENIDO</h1>
        <form action="/Zoo/userController" method="POST">
        <div>
            
            <label>Correo</label>
            <input type="text" value="${User.getCorreo()}" name="correo"><br>
                
            <label>Contraseña</label>
            <input type="text" value="${User.getContrasena()}" name="contrasena"><br>
            
        </div>
            <input type="submit" name="op" value="Iniciar Sesion">
            <input type="submit" name="op" value="Crear cuenta">
        </form>
    </body>
</html>
