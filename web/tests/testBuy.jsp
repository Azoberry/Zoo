<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Compra</title>
    <script>
        function calcularCostoTotal() {
            var boletosNino = document.getElementById("nino").value;
            var boletosAdulto = document.getElementById("adulto").value;
            var costoNino = 40;
            var costoAdulto = 65;
            var total = (parseInt(boletosNino) * costoNino) + (parseInt(boletosAdulto) * costoAdulto);
            document.getElementById("costoTotal").value = total;
        }
    </script>
</head>
<body>
    <h1>Compra</h1>
    <form action="/Zoo/userController" method="POST">
        
        <label>idUsuario</label>
        <input type="number" value="0" name="id"><br>
        
        <label>Boletos niño</label>
        <input type="number" value="0" name="nino" id="nino" oninput="calcularCostoTotal()" default="0" min="0"><br>
            
        <label>Boletos adulto</label>
        <input type="number" value="0" name="adulto" id="adulto" oninput="calcularCostoTotal()" default="0" min="0"><br>
        
        <label>Costo Total</label>
        <input type="text" id="costoTotal" value="0" readonly><br>
        
        <input type="submit" name="op" value="Pagar">
    </form>
</body>
</html>