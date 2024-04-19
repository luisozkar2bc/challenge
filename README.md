# App Challenge

>Challenge - Spring Boot

Este proyecto es un desafío implementado con Spring Boot. 

Proporciona una aplicación web con diversas funcionalidades, construida utilizando las dependencias y configuraciones definidas en el archivo pom.xml.

>Requisitos

Java Development Kit (JDK) - Se requiere JDK 17 o superior.

Maven - Se utiliza para la gestión de dependencias y la construcción del proyecto.

>Descripción

El proyecto Challenge utiliza Spring Boot para crear una aplicación con características avanzadas y seguras. Algunas de las dependencias principales incluyen:

* Spring Boot Starter
* Spring Boot Starter Web
* Spring Boot Starter Cache
* Spring Boot Starter Test
* Spring Boot Starter Data JPA
* Spring Boot Starter Security
* JSON Web Token (JWT) para autenticación y seguridad
* H2 Database para persistencia en memoria
* Lombok para la generación de código
* Swagger para la documentación de la API
* Liquibase para el control de versiones de la base de datos

> Inicio Rápido
 
- Asegúrate de tener JDK 17 y Maven instalados en tu sistema.
- Clona este repositorio: git clone https://github.com/luisozkar2bc/challenge.git
- Navega al directorio del proyecto: cd challenge
- Compila y ejecuta el proyecto: mvn spring-boot:run
- Abre tu navegador y visita: http://localhost:8080/challenge/
- Explora la API documentada en: http://localhost:8080/challenge/swagger-ui.html
- Para el login obtener el token de: localhost:8080/challenge/login 
 con este json: { "email" : "luisozkar2@gmail.com", "password" : "medina" }

> Inicio de la aplicación con Docker

Si prefieres ejecutar la aplicación utilizando Docker, sigue estos pasos:

- Desde la raíz del proyecto, construye la imagen Docker ejecutando el siguiente comando:

   ```
   docker build -t challenge-app .
   
Esto creará una imagen Docker llamada challenge-app utilizando el Dockerfile proporcionado en el proyecto.

- Una vez que la imagen se haya construido con éxito, puedes iniciar un contenedor Docker con el siguiente comando:
   ```
  docker run -p 8080:8080 challenge-app
  
- Esto iniciará un contenedor Docker a partir de la imagen challenge-app y mapeará el puerto 8080 del contenedor al puerto 8080 de tu máquina local.
¡Listo!


> Documentación

La documentación de la API se genera automáticamente utilizando Swagger. 
Puedes acceder a la documentación en http://localhost:8080/challenge/swagger-ui.html una vez que el proyecto esté en ejecución.

> Contribución

Las contribuciones son bienvenidas. Si encuentras mejoras, problemas o nuevas características que quisieras añadir, no dudes en crear un pull request.

>Licencia

Este proyecto está bajo la Licencia MIT.
¡Disfruta trabajando en el proyecto Challenge! Si tienes alguna pregunta o problema, no dudes en abrir un issue en este repositorio. ¡Gracias por contribuir!
