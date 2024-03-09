# ZooTechnology

Sistema hecho para gestionar un zoologico.
## Versiones necesarias

 - [Apache NetBeans IDE 21](https://www.apache.org/dyn/closer.lua/netbeans/netbeans-installers/21/Apache-NetBeans-21-bin-windows-x64.exe)
 - GlassFish Server 7.0.9 (se instala desde el NetBeans)
 - [JDK 21](https://www.oracle.com/mx/java/technologies/downloads/)
 - [Java mysql connector 8.3.0](https://dev.mysql.com/downloads/connector/j/)

## Diseño

- [Figma de ZooTechnology](https://www.figma.com/file/5JuHcsqudYDOojJU1BWD6v/ZooTechnology?type=design&node-id=0-1&mode=design)
## Funciones

| Usuarios |
| :-------- |
| `Registrarse` |
| `Editar su informacion` |
| `Revisar sus compras` |
| `Comprar de boletos` |

| Vendedores en taquilla |
| :-------- |
| `Registrar ventas` |

| Administradores |
| :-------- |
| `ABC de ventas` |
| `ABC de tipos de boletos` |
| `ABC de usuarios` |
| `ABC de animales` |
| `ABC de habitats` |
| `ABC de zonas` |

- **ABC**: Altas, Bajas y Cambios.
## Creación del proyecto

### Crear el proyecto como `Web Application`
![Paso 1](https://simp6.host.church/images3/howToCreateProject1136700f94d6aba80.png)  

![Paso 2](https://simp6.host.church/images3/howToCreateProject2e416ebec1b7d1371.png)  
### Utilizar `GlassFish Server`
![Paso 3](https://simp6.host.church/images3/howToCreateProject3ae7a772b41320c13.png)  
### Agregar el conector de java-mysql
![Paso 4](https://simp6.host.church/images3/howToCreateProject476298f91a7ce4834.png)  

![Paso 5](https://simp6.host.church/images3/howToCreateProject589c8d6c08c901dda.png)  
## Estructura

![Paso 1](https://simp6.host.church/images3/structure145f2e27bfe4e1910.png)  
### Creacion de controladores
- Para crear a los controladores, es necesario crearlos como **`servlets`**
![Paso 2](https://simp6.host.church/images3/structure2d2572c649ba6bdb3.png)  

![Paso 3](https://simp6.host.church/images3/structure31dcddd8995c585d1.png)  
- **Importante** activar la casilla, para que el `servlet` sea registrado en el `xml`
![Paso 4](https://simp6.host.church/images3/structure4adc59020fcdb3e96.png)  

### **Correcciones**
- Despues de generar el servlet es importante cambiar la palabra "javax" a **`jakarta`**
![Paso 1](https://simp6.host.church/images3/corrections1378cfceb493884ac.png)  

![Paso 2](https://simp6.host.church/images3/corrections2f526c50cf900a6f7.png)  

## Github desde NetBeans

- Copiar el enlace HTTPS
![Paso 1](https://simp6.host.church/images3/github16da92cf24f98bb97.png)  

- Antes de darle a la opción es importante tener **seleccionado** el proyecto con anterioridad
![Paso 2](https://simp6.host.church/images3/github2d3148e3393b2d56d.png)  

- Presionamos **`OK`**  
![Paso 3](https://simp6.host.church/images3/github3ec07a2e6529368ba.png)  

### Para hacer un Commit
- Click derecho al proyecto y nos vamos a **`Commit`**  
![Paso 4](https://simp6.host.church/images3/github47a2527fcdca8f5b2.png)  

- En **Commit Message** escribimos el mensaje que tendra nuestro commit.  
![Paso 5](https://simp6.host.church/images3/github5e6ad0d1cbbcca1ea.png)  
### Para hacer un Push  
![Paso 6](https://simp6.host.church/images3/github6e7c749e288ffe03b.png)  

Pegar el enlace HTTPS copiado anteriormente y escribir usuario y contraseña
- **User:** Nombre de usuario de tu cuenta de github
- **Password:** Es un token que se tiene que generar
![Paso 7](https://simp6.host.church/images3/github72c363d578ce9a5ee.png)  

- Seleccionamos la siguiente rama o la rama que se desea hacer el push  
![Paso 8](https://simp6.host.church/images3/github8da260f85df5b20c9.png)  

![Paso 9](https://simp6.host.church/images3/github9a462b87fb513abcd.png)  

- Seleccionamos **Yes**  
![Paso 10](https://simp6.host.church/images3/github1018c1ffb7585d5623.png)  

### Para hacer un token
- En nuestra cuenta de GitHub seleccionamos **Settings**  
![Paso 1](https://simp6.host.church/images3/createToken15e992ba28b832c3c.png)  

- Seleccionamos **Developer settings**  
![Paso 2](https://simp6.host.church/images3/createToken2272705552c41d5db.png)  

- Seleccionamos **Generate new token (classic)**  
![Paso 3](https://simp6.host.church/images3/createToken3f1f99c7a95cceba8.png)  

- Escribimos el nombre del token y activar la casilla **`repo`**  
![Paso 4](https://simp6.host.church/images3/createToken47db64efd892969f1.png)  

- Copiamos el token  
![Paso 5](https://simp6.host.church/images3/createToken53c14a029001ee84b.png)  

