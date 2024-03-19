<%@page import="modelsBeans.animal"%>
<%@page import="modelsDAO.animalDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resumen Animales</title>
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
            <a href="mainAdmin.jsp" class="btn btn-ghost text-2xl text-black">ZooTechnology</a>
        </div>
        <div class="flex-none gap-2">
          <div class="form-control">
            <input type="text" placeholder="Busqueda..." class="input input-bordered w-24 md:w-auto bg-white text-black"/>
          </div>
          <div class="dropdown dropdown-end">
            <div tabindex="0" role="button" class="btn btn-ghost btn-circle avatar">
              <div class="w-10 rounded-full">
                <img alt="avatar de usuario" src="../public/admin.png" />
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
            <a href="animalTablasAdmin.jsp" class="flex flex-wrap gap-x-8">
              <img src="../public/barraLateral/paw-solid.svg" alt="imagen para la sección de animales" class="size-12 float-left">
              <p class="float-right leading-[50px] text-black font-medium text-3xl font-['K2D'] mb-7
              hover:underline">Animales</p>
            </a>
          </div>
          <div class="flex flex-row flex-wrap px-6 w-[100%]">
            <a href="boletosAdmin.jsp" class="flex flex-wrap gap-x-8">
              <img src="../public/barraLateral/tickets.svg" alt="imagen para la sección de animales" class="size-12 float-left">
              <p class="float-right leading-[50px] text-black font-medium text-3xl font-['K2D'] mb-7
              hover:underline">Boletos</p>
            </a>
          </div>
          <div class="flex flex-row flex-wrap px-6 w-[100%]">
            <a href="historial.jsp" class="flex flex-wrap gap-x-9">
              <img src="../public/barraLateral/historial.svg" alt="imagen para la sección de animales" class="size-11 float-left">
              <p class="float-right leading-[43px] text-black font-medium text-3xl font-['K2D'] mb-7
              hover:underline">Historial</p>
            </a>
          </div>
          <div class="flex flex-row flex-wrap px-6 w-[100%]">
            <a href="habitatTablasAdmin.jsp" class="flex flex-wrap gap-x-8">
              <img src="../public/barraLateral/area.svg" alt="imagen para la sección de animales" class="size-12 float-left">
              <p class="float-right leading-[50px] text-black font-medium text-3xl font-['K2D'] mb-7
              hover:underline">Habitats</p>
            </a>
          </div>
          <div class="flex flex-row flex-wrap px-6 w-[100%]">
            <a href="zonaTablasAdmin.jsp" class="flex flex-wrap gap-x-8">
              <img src="../public/barraLateral/zona.png" alt="imagen para la sección de animales" class="size-12 float-left">
              <p class="float-right leading-[50px] text-black font-medium text-3xl font-['K2D'] mb-7
              hover:underline">Zonas</p>
            </a>
          </div>
          <div class="flex flex-row flex-wrap px-6 w-[100%]">
            <a href="habitatTablasAdmin.jsp" class="flex flex-wrap gap-x-8">
              <img src="../public/barraLateral/usuario.svg" alt="imagen para la sección de animales" class="size-12 float-left">
              <p class="float-right leading-[50px] text-black font-medium text-3xl font-['K2D'] mb-7
              hover:underline">Usuarios</p>
            </a>
          </div>
        </div>
        <!-- CONTENIDO DEL LADO DERECHO -->
        <div class="border-2 w-screen h-screen bg-white">
          <div class="text-center h-fit pb-10 m-0 p-0 mb-10 border-b-[3px] rounded-b-3xl shadow-2xl border-black text-3xl text-black font-['K2D'] py-[30px]">
            <h1 class="text-center pt-10 text-3xl text-black font-medium">Resumen de Animales en el Zoologico</h1>
            <a href="agregarAnimal.jsp" type="submit" class="bg-gray-300 text-black w-fit h-fit py-1 px-5 rounded-2xl">
              <div class="flex">
                <i class="fa-solid fa-plus"></i>
                <span class="text-3xl leading-[29px]">Agregar</span>
              </div>
            </a>
          </div>
          <div class="container mx-auto border-2 border-black overflow-x-auto">
            <table>
              <thead>
                <tr class="text-xl bg-[#D9D9D9]">
                  <th>ID ANIMAL</th>
                  <th>NOMBRE</th>
                  <th>APODO</th>
                  <th>DIETA</th>
                  <th>DESCRIPCIÓN</th>
                  <th>HABITAT</th>
                  <th>SEXO</th>
                  <th>EDAD</th>
                  <th>PESO</th>
                  <th>TAMAÑO</th>
                  <th>ACCIONES</th>
                </tr>
              </thead>
              <tbody>
              <%
                animalDAO ANIMAL = new animalDAO();
                List<animal> listaAnimales = ANIMAL.lista();
                for(animal Animal : listaAnimales) {
              %>
              <tr class="text-lg">
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
                <td>
                    <a href="/Zoo/animalController?op=Editar&idAnimal=<%= Animal.getIdAnimal()%>" style="margin-right: 10px;">Editar</a>
                    <a href="/Zoo/animalController?op=Borrar&idAnimal=<%= Animal.getIdAnimal()%>">Borrar</a>
                </td>
              </tr>
              <% } %>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </body>
</html>
