<%@page import="modelsBeans.animal"%>
<%@page import="modelsDAO.animalDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Animales</title>
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
          }
        </style>
    </head>
    <body>
      <!-- NAVBAR -->
      <div class="navbar bg-[#ffc44a] border-b-2 border-black">
        <div class="flex-1">
          <a href="inicio.jsp" class="btn btn-ghost text-2xl text-black">ZooTechnology</a>
        </div>
        <div class="flex-none gap-2"> 
          <div class="form-control">
            <input type="text" placeholder="Busqueda..." class="input input-bordered w-24 md:w-auto bg-white text-black"/>
          </div>
          <div class="dropdown dropdown-end">
            <div tabindex="0" role="button" class="btn btn-ghost btn-circle avatar">
              <div class="w-10 rounded-full">
                <img alt="avatar de usuario" src="public/iconoPerfil.png" />
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
        <div class="flex flex-col w-2/12 bg-white h-min-screen py-10 m-0 border-r-2 border-black">
          <div class="flex flex-row flex-wrap px-6 w-[100%]">
            <a href="animales.jsp" class="flex flex-wrap gap-x-8">
              <img src="public/barraLateral/paw-solid.svg" alt="imagen para la sección de animales" class="size-12 float-left">
              <p class="float-right leading-[50px] text-black font-medium text-3xl font-['K2D'] mb-7 opacity-0 lg:opacity-100
              hover:underline">Animales</p>
            </a>
          </div>
          <div class="flex flex-row flex-wrap px-6 w-[100%]">
            <a href="boletos.jsp" class="flex flex-wrap gap-x-8">
              <img src="public/barraLateral/tickets.svg" alt="imagen para la sección de animales" class="size-12 float-left">
              <p class="float-right leading-[50px] text-black font-medium text-3xl font-['K2D'] mb-7 opacity-0 lg:opacity-100
              hover:underline">Boletos</p>
            </a>
          </div>
          <div class="flex flex-row flex-wrap px-6 w-[100%]">
            <a href="historial.jsp" class="flex flex-wrap gap-x-9">
              <img src="public/barraLateral/historial.svg" alt="imagen para la sección de animales" class="size-11 float-left">
              <p class="float-right leading-[50px] text-black font-medium text-3xl font-['K2D'] mb-7 opacity-0 lg:opacity-100
              hover:underline">Historial</p>
            </a>
          </div>
          <div class="flex flex-row flex-wrap px-6 w-[100%]">
            <a href="habitats.jsp" class="flex flex-wrap gap-x-8">
              <img src="public/barraLateral/area.svg" alt="imagen para la sección de animales" class="size-12 float-left">
              <p class="float-right leading-[50px] text-black font-medium text-3xl font-['K2D'] mb-7 opacity-0 lg:opacity-100
              hover:underline">Habitats</p>
            </a>
          </div>
        </div>
        <!-- CONTENIDO DEL LADO DERECHO -->
        <div class="border-2 w-screen bg-white">
          <div class="container mx-auto text-center text-3xl text-black font-['K2D'] py-[30px]">
            <p class="mb-5">¡Aquí podras ver todos los animales con los que cuenta el Zoologico junto con alguna de su información disponible!</p>
            <!--
            <form action="" method="">
              <button type="submit" class="bg-gray-300 w-fit h-fit py-1 px-5 rounded-2xl">
                <div class="flex">
                  <img src="public/filtros/Dieta.png" class="size-8 mr-4" alt="imagen relacionada con la dieta">
                  <span class="text-3xl leading-[29px]">Dieta</span>
                </div>
              </button>
              <button type="submit" class="bg-gray-300 w-fit h-fit py-1 px-4 rounded-2xl">
                <div class="flex">
                  <img src="public/filtros/Nombre.svg" class="h-8 mr-3" alt="imagen relacionada con la dieta">
                  <span class="text-3xl leading-[29px]">Nombre</span>
                </div>
              </button>
              <button type="submit" class="bg-gray-300 w-fit h-fit py-1 px-4 rounded-2xl">
                <div class="flex">
                  <img src="public/filtros/Edad.svg" class="size-8 mr-3" alt="imagen relacionada con la dieta">
                  <span class="text-3xl leading-[29px]">Edad</span>
                </div>
              </button>
              <button type="submit" class="bg-gray-300 w-fit h-fit py-1 px-4 rounded-2xl">
                <div class="flex">
                  <img src="public/filtros/Peso.svg" class="size-8 mr-3" alt="imagen relacionada con la dieta">
                  <span class="text-3xl leading-[29px]">Peso</span>
                </div>
              </button>
              <button type="submit" class="bg-gray-300 w-fit h-fit py-1 px-4 rounded-2xl">
                <div class="flex">
                  <img src="public/filtros/Tamaño.svg" class="size-8 mr-3" alt="imagen relacionada con la dieta">
                  <span class="text-3xl leading-[29px]">Tamaño</span>
                </div>
              </button>
            </form>
            -->
          </div>
          <div class="container mx-auto grid grid-cols-3 text-2xl text-black font-['K2D'] py-6">
            <%
              animalDAO ANIMAL = new animalDAO();
              List<animal> listaAnimales = ANIMAL.lista();
              for(animal Animal : listaAnimales) {
            %>
            <div class="max-w-sm mx-auto bg-white border mb-8 border-gray-200 rounded-xl p-8 shadow dark:bg-gray-800 dark:border-gray-700">
              <img class="rounded-lg w-80 mx-auto" src="public/animales/Leon.jpg" alt="imagen de animal de zoologico" />
              <div class="p-5">
                <h5 class="mb-1 text-3xl font-bold tracking-tight text-gray-900 dark:text-white"><%= Animal.getNombre()%></h5>
                <ul class="dark:text-gray-400 text-xl">
                  <li><b>Cientifico: </b><span><%= Animal.getApodo()%></span></li>
                  <li><b>Dieta: </b><span><%= Animal.getDieta()%></span></li>
                  <li><b>Habitat: </b><span><%= Animal.getHabitatNat()%></span></li>
                  <li><b>Descripción: </b><p><%= Animal.getDescripcion()%></p></li>
                </ul>
              </div>
            </div>
            <% } %>
          </div>
        </div>
    </body>
</html>
