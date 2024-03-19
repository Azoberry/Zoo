<%@page import="modelsBeans.user"%>
<%@page import="modelsBeans.sales"%>
<%@page import="modelsBeans.salesTicketType"%>
<%@page import="modelsBeans.ticketType"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalles Venta</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=K2D:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/62fafb1513.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/daisyui@4.7.3/dist/full.min.css" rel="stylesheet" type="text/css" />
        <script src="https://cdn.tailwindcss.com"></script>
        <style type="text/tailwindcss">
            @layer utilities {
            .text-border {
                -webkit-text-stroke: 1.2px black;
            }

            .text-border-2 {
                -webkit-text-stroke: 1.3px black;
            }

            .rounded-2-5xl {
                border-radius: 20px;
            }

            .fondo-color {
                background-color: rgba(129, 226, 94, 0.4);
            }

            .text-background {
                border-radius: 25px;
                background-color: rgba(255, 255, 255, 25%);
            }

            table {
                width: 100%;
            }

            table, th, td {
                color: black;
                font-family: 'K2D', sans-serif;
                text-align: center;
            }

            table, th {
                border:1px solid black;
            }
        }
        </style>
    </head>
<body>
  <!-- NAVBAR -->
  <div class="navbar bg-[#ffc44a] border-b-2 border-black">
    <div class="flex-1">
      <a href="templates/inicio.jsp" class="btn btn-ghost text-2xl text-black">ZooTechnology</a>
    </div>
    <div class="flex-none gap-2">
      <div class="form-control">
        <input type="text" placeholder="Busqueda..." class="input input-bordered w-24 md:w-auto bg-white text-black"/>
      </div>
      <div class="dropdown dropdown-end">
        <div tabindex="0" role="button" class="btn btn-ghost btn-circle avatar">
          <div class="w-10 rounded-full">
            <img alt="avatar de usuario" src="templates/public/iconoPerfil.png"/>
          </div>
        </div>
        <ul tabindex="0" class="mt-3 z-[1] p-2 shadow menu menu-sm dropdown-content bg-base-100 rounded-box w-52 bg-[#ffc44a] text-black
        font-semibold">
          <li>
            <a>
              Perfil
            </a>
          </li>
          <li><a>Cerrar Sesión</a></li>
        </ul>
      </div>
    </div>
  </div>
  <!-- CONTENIDO POSTERIOR A LA NAVBAR -->
  <div class="flex">
    <!-- BARRA LATERAL IZQUIERDA -->
    <div class="flex flex-col w-2/12 bg-white py-10 m-0 border-r-2 border-black">
      <div class="flex flex-row flex-wrap px-6 w-[100%]">
          <a href=">templates/animales.jsp" class="flex flex-wrap gap-x-8">
            <img src="templates/public/barraLateral/paw-solid.svg" alt="imagen para la sección de animales" class="size-12 float-left">
          <p class="float-right leading-[50px] text-black font-medium text-3xl font-['K2D'] mb-7 opacity-0 lg:opacity-100
          hover:underline">Animales</p>
        </a>
      </div>
      <div class="flex flex-row flex-wrap px-6 w-[100%]">
        <a href="templates/boletos.jsp" class="flex flex-wrap gap-x-8">
          <img src="templates/public/barraLateral/tickets.svg" alt="imagen para la sección de animales" class="size-12 float-left">
          <p class="float-right leading-[50px] text-black font-medium text-3xl font-['K2D'] mb-7 opacity-0 lg:opacity-100
          hover:underline">Boletos</p>
        </a>
      </div>
      <div class="flex flex-row flex-wrap px-6 w-[100%]">
        <a href="templates/historial.jsp" class="flex flex-wrap gap-x-9">
          <img src="templates/public/barraLateral/historial.svg" alt="imagen para la sección de animales" class="size-11 float-left">
          <p class="float-right leading-[43px] text-black font-medium text-3xl font-['K2D'] mb-7 opacity-0 lg:opacity-100
          hover:underline">Historial</p>
        </a>
      </div>
      <div class="flex flex-row flex-wrap px-6 w-[100%]">
        <a href="templates/habitats.jsp" class="flex flex-wrap gap-x-8">
          <img src="templates/public/barraLateral/area.svg" alt="imagen para la sección de animales" class="size-12 float-left">
          <p class="float-right leading-[50px] text-black font-medium text-3xl font-['K2D'] mb-7 opacity-0 lg:opacity-100
          hover:underline">Habitats</p>
        </a>
      </div>
    </div>
    <!-- CONTENIDO DEL LADO DERECHO -->
    <div class="border-2 w-screen h-screen bg-white">
      <div class="h-fit pb-10 m-0 p-0 mb-10 border-b-[3px] rounded-b-3xl shadow-2xl border-black">
        <h1 class="text-center pt-10 text-3xl text-black font-medium">Detalles de la venta #${Sale.getIdVenta()}</h1>
      </div>
      <div class="container mx-auto border-2 border-black overflow-x-auto">
          <p class="text-2xl text-black font-semibold">Número de venta: ${Sale.getIdVenta()}</p>
          <p class="text-2xl text-black font-semibold">Fecha: ${Sale.getFechaVenta()}</p>
          <p class="text-2xl text-black font-semibold">Nombre: ${User.getNombre()} ${User.getApellidoP()} ${User.getApellidoM()}</p>
          <p class="text-2xl text-black font-semibold">Correo: ${User.getCorreo()}</p>
          <p class="text-2xl text-black font-semibold">Boletos:</p>
          <%
            try {
            List<salesTicketType> listaSTT = (List<salesTicketType>) request.getAttribute("listaSTT");
            List<ticketType> listaTT = (List<ticketType>) request.getAttribute("listaTT");
            
            Map<Integer, ticketType> mapTT = new HashMap<>();
            for (ticketType TT : listaTT) {
                mapTT.put(TT.getIdBoleto(), TT);
            }

            for (salesTicketType STT : listaSTT) {
                int cantidad = STT.getCantidad();
                int idBoleto = STT.getIdBoleto();
                ticketType TT = mapTT.get(idBoleto);
                if (TT != null) {
                String tipoBoleto = TT.getTipo();
                double precio = TT.getPrecio();
          %>
            <p class="text-2xl text-black font-semibold">Tipo de boleto: <%= tipoBoleto %>, Cantidad: <%= cantidad %>, Precio: <%= precio %>$</p>
          <% }}} catch (Exception e) {e.printStackTrace();}%>
          <p class="text-2xl text-black font-semibold">Monto total: ${Sale.getTotal()}$</p>
        <br>
      </div>
    </div>
  </div>
</body>
</html>