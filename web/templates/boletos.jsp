<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Boletos</title>
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
        <div class="flex flex-col w-2/12 bg-white py-10 m-0 border-r-2 border-black">
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
              <p class="float-right leading-[43px] text-black font-medium text-3xl font-['K2D'] mb-7 opacity-0 lg:opacity-100
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
        <div class="m-0 p-0 w-full bg-white">
          <!-- CABECERA -->
          <div class="h-fit pb-10 m-0 p-0 mb-10 border-b-[3px] rounded-b-3xl shadow-2xl border-black">
            <h1 class="text-center pt-10 text-3xl text-black font-medium">¡Aqui podrás comprar tus boletos para tus visitas en el Zoologico!</h1>
          </div>
          <!-- PARTE DE LOS BOLETOS -->
          <!-- BOLETO JUNIOR -->
          <div class="flex flex-col items-center w-5/12 text-center h-fit border-[0.5px] shadow-2xl bg-[#F8F3F3] p-5 border-black rounded-3xl text-black text-2xl font-['K2D'] mx-auto py-6"> 
            <div class="border-[0.5px] border-black rounded-3xl px-10">
              <img src="public/boletos/boletoJunior.svg" class="size-52 aspect-video" alt="imagen de un boleto">
            </div>
            <p class="text-3xl font-semibold my-5">Boleto Junior</p>
            <p class="text-3xl">¡Valido desde los 2 años hasta los 12 años!</p>
            <p class="text-3xl font-semibold mt-5">$40</p>
            <p class="text-3xl">Pesos Mexicanos</p>
            <br>
            <button class="py-7 px-16 text-[35px] bg-[#ED6C66]/70 rounded-3xl font-medium border-2 border-black" data-open-modal>Agregar</button>
            <dialog class="w-5/12 bg-[#F8F3F3] border-[0.5px] border-black rounded-3xl text-black text-3xl h-fit py-8" data-modal>
              <p class="mb-10">Agregar</p>
              <div class="flex items-center w-3/6 place-content-between mx-auto mb-5">
                <p >Boleto Junior</p>
                <div class="flex items-center">
                  <p id="contador">0</p>
                  <button class="w-fit p-1 mx-5 bg-red-400 border-black border-2 px-3 rounded-xl" id="aumentar">+</button>
                  <button class="w-fit p-1 bg-blue-400 border-black border-2 px-3 rounded-xl" id="disminuir">-</button>
                </div>
              </div>
              <div class="flex items-center w-3/6 place-content-between mx-auto">
                <button class="bg-[#ED6C66]/25 border-black border-2 rounded-3xl py-2 px-6" data-close-modal>Cancelar</button>
                <button class="bg-[#ED6C66]/25 border-black border-2 rounded-3xl py-2 px-6">Agregar</button>
              </div>
            </dialog>
          </div>
          <br>
          <!-- BOLETO ESTANDAR -->
          <div class="flex flex-col items-center w-5/12 text-center h-fit border-[0.5px] shadow-2xl bg-[#F8F3F3] p-5 border-black rounded-3xl text-black text-2xl font-['K2D'] mx-auto py-6"> 
            <div class="border-[0.5px] border-black rounded-3xl px-10">
              <img src="public/boletos/boletoeEstandar.png" class="size-52 aspect-video" alt="imagen de un boleto">
            </div>
            <p class="text-3xl font-semibold my-5">Boleto Estandar</p>
            <p class="text-3xl font-semibold mt-5">$65</p>
            <p class="text-3xl">Pesos Mexicanos</p>
            <br>
            <button class="py-7 px-16 text-[35px] bg-[#9AB5FB]/70 rounded-3xl font-medium border-2 border-black" data-open-modal-estandar>Agregar</button>
            <dialog class="w-5/12 bg-[#F8F3F3] border-[0.5px] border-black rounded-3xl text-black text-3xl h-fit py-8" data-modal-estandar>
              <p class="mb-10">Agregar</p>
              <div class="flex items-center w-3/6 place-content-between mx-auto mb-5">
                <p >Boleto Estandar</p>
                <div class="flex items-center">
                  <p id="contadorEstandar">0</p>
                  <button class="w-fit p-1 mx-5 bg-red-400 border-black border-2 px-3 rounded-xl" id="aumentarEstandar">+</button>
                  <button class="w-fit p-1 bg-blue-400 border-black border-2 px-3 rounded-xl" id="disminuirEstandar">-</button>
                </div>
              </div>
              <div class="flex items-center w-3/6 place-content-between mx-auto">
                <button class="bg-[#ED6C66]/25 border-black border-2 rounded-3xl py-2 px-6" data-close-modal-estandar>Cancelar</button>
                <button class="bg-[#ED6C66]/25 border-black border-2 rounded-3xl py-2 px-6">Agregar</button>
              </div>
            </dialog>
          </div>
          <br>
          <!-- BOLETO COMBO -->
          <div class="flex flex-col items-center w-5/12 text-center h-fit border-[0.5px] shadow-2xl bg-[#F8F3F3] p-5 border-black rounded-3xl text-black text-2xl font-['K2D'] mx-auto py-6"> 
            <div class="border-[0.5px] border-black rounded-3xl px-10">
              <img src="public/boletos/boletoCombo.svg" class="size-52 aspect-video" alt="imagen de un boleto">
            </div>
            <p class="text-3xl font-semibold my-5">Combo Semana</p>
            <p class="text-3xl">¡Valido desde el lunes hasta el jueves!</p>
            <p class="text-3xl font-semibold mt-5">$50</p>
            <p class="text-3xl">Pesos Mexicanos</p>
            <br>
            <button class="py-7 px-16 text-[35px] bg-[#CBFFCA]/70 rounded-3xl font-medium border-2 border-black" data-open-modal-combo>Agregar</button>
            <dialog class="w-5/12 bg-[#F8F3F3] border-[0.5px] border-black rounded-3xl text-black text-3xl h-fit py-8" data-modal-combo>
              <p class="mb-10">Agregar</p>
              <div class="flex items-center w-3/6 place-content-between mx-auto mb-5">
                <p >Boleto Combo</p>
                <div class="flex items-center">
                  <p id="contadorCombo">0</p>
                  <button class="w-fit p-1 mx-5 bg-red-400 border-black border-2 px-3 rounded-xl" id="aumentarCombo">+</button>
                  <button class="w-fit p-1 bg-blue-400 border-black border-2 px-3 rounded-xl" id="disminuirCombo">-</button>
                </div>
              </div>
              <div class="flex items-center w-3/6 place-content-between mx-auto">
                <button class="bg-[#ED6C66]/25 border-black border-2 rounded-3xl py-2 px-6" data-close-modal-combo>Cancelar</button>
                <button class="bg-[#ED6C66]/25 border-black border-2 rounded-3xl py-2 px-6">Agregar</button>
              </div>
            </dialog>
          </div>
          <br>
        </div>
      </div>

      <!-- SCRIPTS -->
      <script>
        /* ABRIR Y CERRAR MODAL BOLETO JUNIOR */
        const openButton =  document.querySelector("[data-open-modal]")
        const closeButton = document.querySelector("[data-close-modal]")
        const modal = document.querySelector("[data-modal]")

        openButton.addEventListener("click", () => {
          modal.showModal();
        })

        closeButton.addEventListener("click", () => {
          modal.close();
        })

        /* LOGICA DEL CONTADOR */

        let contador = 0;
        const aumentar = () => {
          contador++;
        }

        const decrementar = () => {
          contador--;
        }

        const renderValorContador = () => {
          document.getElementById("contador").innerText = contador;
        }

        /* CONTADOR DEL MODAL */
        const botonIncrementar = document.getElementById('aumentar');
        botonIncrementar.addEventListener("click", (event) => {
          aumentar();
          renderValorContador();
        })

        const botonDecrementar = document.getElementById('disminuir');
        botonDecrementar.addEventListener("click", (event) => {
          decrementar();
          renderValorContador();
        })

        /* ------------------------------------------------------------------------------------------------- */
        /* ABRIR Y CERRAR MODAL BOLETO JUNIOR */
        const openButtonE =  document.querySelector("[data-open-modal-estandar]")
        const closeButtonE = document.querySelector("[data-close-modal-estandar]")
        const modalE = document.querySelector("[data-modal-estandar]")

        openButtonE.addEventListener("click", () => {
          modalE.showModal();
        })

        closeButtonE.addEventListener("click", () => {
          modalE.close();
        })

        /* LOGICA DEL CONTADOR BOLETO ESTANDAR */

        let contadorE = 0;
        const aumentarE = () => {
          contadorE++;
        }

        const decrementarE = () => {
          contadorE--;
        }

        const renderValorContadorE = () => {
          document.getElementById("contadorEstandar").innerText = contadorE;
        }

        /* CONTADOR DEL MODAL */
        const botonIncrementarE = document.getElementById('aumentarEstandar');
        botonIncrementarE.addEventListener("click", (event) => {
          aumentarE();
          renderValorContadorE();
        })

        const botonDecrementarE = document.getElementById('disminuirEstandar');
        botonDecrementarE.addEventListener("click", (event) => {
          decrementarE();
          renderValorContadorE();
        })

        /* ------------------------------------------------------------------------------------------------- */
        /* ABRIR Y CERRAR MODAL COMBO SEMANAL */
        const openButtonC =  document.querySelector("[data-open-modal-combo]")
        const closeButtonC = document.querySelector("[data-close-modal-combo]")
        const modalC = document.querySelector("[data-modal-combo]")

        openButtonC.addEventListener("click", () => {
          modalC.showModal();
        })

        closeButtonC.addEventListener("click", () => {
          modalC.close();
        })

        /* LOGICA DEL CONTADOR BOLETO ESTANDAR */

        let contadorC = 0;
        const aumentarC = () => {
          contadorC++;
        }

        const decrementarC = () => {
          contadorC--;
        }

        const renderValorContadorC = () => {
          document.getElementById("contadorCombo").innerText = contadorC;
        }

        /* CONTADOR DEL MODAL */
        const botonIncrementarC = document.getElementById('aumentarCombo');
        botonIncrementarC.addEventListener("click", (event) => {
          aumentarC();
          renderValorContadorC();
        })

        const botonDecrementarC = document.getElementById('disminuirCombo');
        botonDecrementarC.addEventListener("click", (event) => {
          decrementarC();
          renderValorContadorC();
        })
      </script>
    </body>
</html>
