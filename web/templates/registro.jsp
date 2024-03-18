<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <script src="https://cdn.tailwindcss.com"></script>
          <style type="text/tailwindcss">
            @layer utilities {
                .text-border {
                  -webkit-text-stroke: 1px black;
                }
                .rounded-2-5xl {
                  border-radius: 20px;
                }

                .fondo-color {
                  background-color: rgba(129, 226, 94, 0.3);
                }
            }
          </style>
    </head>
    <body style="background-image: url(public/fondo.jpeg);">
      <div class="flex justify-center items-center w-screen h-screen flex-col">
        <!-- IMAGEN DEL CONTENEDOR, TIENE EL LOGO -->
        <img src="public/logo.png" alt="logo del zoologico" class="absolute top-0 z-10">
        <!-- CONTENEDOR DEL FORMULARIO -->
        <div class="w-5/12 border-2 border-white fondo-color py-2 px-14 rounded-3xl relative">
          <br><br><br><br>
          <!-- FORMULARIO -->
          <form action="" method="">
            <!-- NOMBRE -->
            <div class="relative h-10 w-full min-w-[200px]">
              <input placeholder="Nombre" 
                class="peer h-14 w-full rounded-[7px] border border-blue-gray-200 border-t-transparent px-3 py-2.5 font-sans text-2xl font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-blue-gray-200 placeholder-shown:border-t-blue-gray-200 focus:border-2 focus:border-gray-900 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-blue-gray-50 placeholder:opacity-0 focus:placeholder:opacity-100" />
              <label
                class="font-bold text-3xl text-[#8CD771] text-border
                before:content[' '] after:content[' ']
                pointer-events-none absolute left-0 -top-1.5
                flex h-full w-full select-none !overflow-visible
                truncate leading-[0] text-[#8CD771]
                transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-blue-gray-200 before:transition-all 
                after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-blue-gray-200 after:transition-all 
                peer-placeholder-shown:text-2xl peer-placeholder-shown:leading-[2.75] peer-placeholder-shown:text-blue-gray-500 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-3xl 
                peer-focus:leading-[0] peer-focus:text-[#8CD771] peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:!border-gray-900 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:!border-gray-900 
                peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-[#8CD771]">
                Nombre
              </label>
            </div>
            <br>
            <!-- APELLIDOS PATERNO Y MATERNO -->
            <div class="flex">
              <!-- APELLIDO PATERNO -->
              <div class="relative h-10 w-6/12 mr-5 min-w-[200px]">
                <input placeholder="Apellido Paterno" 
                  class="peer h-14 w-full rounded-[7px] border border-blue-gray-200 border-t-transparent px-3 py-2.5 font-sans text-2xl font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-blue-gray-200 placeholder-shown:border-t-blue-gray-200 focus:border-2 focus:border-gray-900 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-blue-gray-50 placeholder:opacity-0 focus:placeholder:opacity-100" />
                <label
                  class="font-bold text-3xl text-[#8CD771] text-border
                  before:content[' '] after:content[' ']
                  pointer-events-none absolute left-0 -top-1.5
                  flex h-full w-full select-none !overflow-visible
                  truncate leading-[0] text-[#8CD771]
                  transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-blue-gray-200 before:transition-all 
                  after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-blue-gray-200 after:transition-all 
                  peer-placeholder-shown:text-2xl peer-placeholder-shown:leading-[2.75] peer-placeholder-shown:text-blue-gray-500 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-3xl 
                  peer-focus:leading-[0] peer-focus:text-[#8CD771] peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:!border-gray-900 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:!border-gray-900 
                  peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-[#8CD771]">
                  Apellido Paterno
                </label>
              </div>
              <br>
              <!-- APELLIDO MATERNO -->
              <div class="relative h-10 w-6/12 min-w-[200px]">
                <input placeholder="Apellido Materno" 
                  class="peer h-14 w-full rounded-[7px] border border-blue-gray-200 border-t-transparent px-3 py-2.5 font-sans text-2xl font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-blue-gray-200 placeholder-shown:border-t-blue-gray-200 focus:border-2 focus:border-gray-900 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-blue-gray-50 placeholder:opacity-0 focus:placeholder:opacity-100" />
                <label
                  class="font-bold text-3xl text-[#8CD771] text-border
                  before:content[' '] after:content[' ']
                  pointer-events-none absolute left-0 -top-1.5
                  flex h-full w-full select-none !overflow-visible
                  truncate leading-[0] text-[#8CD771]
                  transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-blue-gray-200 before:transition-all 
                  after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-blue-gray-200 after:transition-all 
                  peer-placeholder-shown:text-2xl peer-placeholder-shown:leading-[2.75] peer-placeholder-shown:text-blue-gray-500 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-3xl 
                  peer-focus:leading-[0] peer-focus:text-[#8CD771] peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:!border-gray-900 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:!border-gray-900 
                  peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-[#8CD771]">
                  Apellido Materno
                </label>
              </div>
            </div>
            <br>
            <!-- EDAD Y SEXO -->
            <div class="flex">
              <div class="relative h-10 w-6/12 mr-5 min-w-[200px]">
                <input placeholder="Edad" 
                  class="peer h-14 w-full rounded-[7px] border border-blue-gray-200 border-t-transparent px-3 py-2.5 font-sans text-2xl font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-blue-gray-200 placeholder-shown:border-t-blue-gray-200 focus:border-2 focus:border-gray-900 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-blue-gray-50 placeholder:opacity-0 focus:placeholder:opacity-100" />
                <label
                  class="font-bold text-3xl text-[#8CD771] text-border
                  before:content[' '] after:content[' ']
                  pointer-events-none absolute left-0 -top-1.5
                  flex h-full w-full select-none !overflow-visible
                  truncate leading-[0] text-[#8CD771]
                  transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-blue-gray-200 before:transition-all 
                  after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-blue-gray-200 after:transition-all 
                  peer-placeholder-shown:text-2xl peer-placeholder-shown:leading-[2.75] peer-placeholder-shown:text-blue-gray-500 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-3xl 
                  peer-focus:leading-[0] peer-focus:text-[#8CD771] peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:!border-gray-900 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:!border-gray-900 
                  peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-[#8CD771]">
                  Edad
                </label>
              </div>
              <br>
              <!-- SEXO -->
              <span class="font-bold text-3xl mr-2 text-[#8CD771] text-border">Sexo: </span>
              <input type="checkbox" id="" name="" value="" class="mr-2 w-5">
              <label for="" class="font-bold text-xl text-white text-border"> Masculino</label>
              <input type="checkbox" id="" name="" value="" class="ml-2 mr-2 w-5">
              <label for="" class="font-bold text-xl text-white text-border"> Femenino</label>
            </div>


            <br>
            <!-- CORREO -->
            <div class="relative h-10 w-full min-w-[200px]">
              <input placeholder="Correo" type="email"
                class="peer h-14 w-full rounded-[7px] border border-blue-gray-200 border-t-transparent px-3 py-2.5 font-sans text-2xl font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-blue-gray-200 placeholder-shown:border-t-blue-gray-200 focus:border-2 focus:border-gray-900 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-blue-gray-50 placeholder:opacity-0 focus:placeholder:opacity-100" />
              <label
                class="font-bold text-3xl text-[#8CD771] text-border
                before:content[' '] after:content[' ']
                pointer-events-none absolute left-0 -top-1.5
                flex h-full w-full select-none !overflow-visible
                truncate leading-[0] text-[#8CD771]
                transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-blue-gray-200 before:transition-all 
                after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-blue-gray-200 after:transition-all 
                peer-placeholder-shown:text-2xl peer-placeholder-shown:leading-[2.75] peer-placeholder-shown:text-blue-gray-500 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-3xl 
                peer-focus:leading-[0] peer-focus:text-[#8CD771] peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:!border-gray-900 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:!border-gray-900 
                peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-[#8CD771]">
                Correo
              </label>
            </div>
            <br>
            <!-- CONTRASEÑA -->
            <div class="relative h-10 w-full min-w-[200px]">
              <input placeholder="Contraseña" type="email"
                class="peer h-14 w-full rounded-[7px] border border-blue-gray-200 border-t-transparent px-3 py-2.5 font-sans text-2xl font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-blue-gray-200 placeholder-shown:border-t-blue-gray-200 focus:border-2 focus:border-gray-900 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-blue-gray-50 placeholder:opacity-0 focus:placeholder:opacity-100" />
              <label
                class="font-bold text-3xl text-[#8CD771] text-border
                before:content[' '] after:content[' ']
                pointer-events-none absolute left-0 -top-1.5
                flex h-full w-full select-none !overflow-visible
                truncate leading-[0] text-[#8CD771]
                transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-blue-gray-200 before:transition-all 
                after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-blue-gray-200 after:transition-all 
                peer-placeholder-shown:text-2xl peer-placeholder-shown:leading-[2.75] peer-placeholder-shown:text-blue-gray-500 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-3xl 
                peer-focus:leading-[0] peer-focus:text-[#8CD771] peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:!border-gray-900 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:!border-gray-900 
                peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-[#8CD771]">
                Contraseña
              </label>
            </div>
            <br>
            <!-- CONTRASEÑA VERIFICACIÓN -->
            <div class="relative h-10 w-full min-w-[200px]">
              <input placeholder="Verificar Contraseña" type="email"
                class="peer h-14 w-full rounded-[7px] border border-blue-gray-200 border-t-transparent px-3 py-2.5 font-sans text-2xl font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-blue-gray-200 placeholder-shown:border-t-blue-gray-200 focus:border-2 focus:border-gray-900 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-blue-gray-50 placeholder:opacity-0 focus:placeholder:opacity-100" />
              <label
                class="font-bold text-3xl text-[#8CD771] text-border
                before:content[' '] after:content[' ']
                pointer-events-none absolute left-0 -top-1.5
                flex h-full w-full select-none !overflow-visible
                truncate leading-[0] text-[#8CD771]
                transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-blue-gray-200 before:transition-all 
                after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-blue-gray-200 after:transition-all 
                peer-placeholder-shown:text-2xl peer-placeholder-shown:leading-[2.75] peer-placeholder-shown:text-blue-gray-500 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-3xl 
                peer-focus:leading-[0] peer-focus:text-[#8CD771] peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:!border-gray-900 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:!border-gray-900 
                peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-[#8CD771]">
                Verificar Contraseña
              </label>
            </div>
            <br><br>
            <button type="submit" class="bg-[#8CD771] border-2 border-white rounded-3xl w-[276px] h-[63px]
            text-3xl font-semibold absolute right-20">Registrar</button>
          </form>
          <br><br><br><br>
        </div>
      </div>
    </body>
</html>
