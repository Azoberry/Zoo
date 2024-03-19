<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio Sesión</title>
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
    <!--CUERPO DE LA PANTALLA PRINCIPAL / INICIO DE SESIÓN-->
    <body style="background-image: url(templates/public/fondo.jpeg);">
      <div class="flex justify-center items-center w-screen h-screen flex-col">
        <!--<img src="templates/public/logo.png" alt="logo del zoologico" class="absolute top-10 z-10">-->
        <!-- CONTENEDOR DEL FORMULARIO -->
        <div class="w-5/12 border-2 border-white fondo-color py-2 px-14 rounded-3xl relative">
          <br><br><br><br>
          <!-- FORMULARIO -->
          <form action="" method="">
            <!-- INPUT PARA COLOCAR EL NOMBRE DE USUARIO -->
            <div class="relative h-20 w-full min-w-[200px]">
              <img src="templates/public/iconoUsuario.png" alt="imagen generica de usuario" class="absolute w-20">
              <input type="text" placeholder="USUARIO" class="w-full h-full rounded-2xl pl-20 text-3xl">
            </div>
            <br>
            <!-- TEXTO -->
            <p class="w-fit mx-auto text-3xl text-white text-border font-bold text-background">¿Olvidaste tu nombre de usuario y contraseña?</p>
            <p class="text-center">
              <a href="/" class="w-fit mx-auto text-3xl text-[#8CD771] text-border-2 font-bold text-background">Haz click aquí</a>
            </p>
            <br><br>
            <!-- INPUT PARA COLOCAR LA CONTRASEÑA DEL USUARIO -->
            <div class="relative h-20 w-full min-w-[200px]">
              <img src="templates/public/candado.png" alt="imagen generica de usuario" class="absolute ml-1 mt-1 w-[70px]">
              <input type="text" placeholder="CONTRASEÑA" class="w-full h-full rounded-2xl pl-20 text-3xl">
            </div>
            <!-- TEXTO -->
            <br>
            <p class="w-fit text-3xl text-white text-border font-bold text-background">¿No tienes cuenta? 
                <a href="templates/registro.jsp" class="text-[#8CD771] text-border-2 font-bold">Registrate aquí</a>
            </p>
            <br><br>
            <button type="submit" class="bg-[#8CD771] border-2 border-white rounded-3xl w-[276px] h-[63px]
            text-3xl font-semibold absolute right-20">Iniciar Sesión</button>
          </form>
          <br><br><br><br>
        </div>
      </div>
    </body>
</html>
