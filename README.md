# PAI-1: Aseguramiento de la integridad en nube no confiable
### Security Team 13
- Fernando Andrés
- Francisco Murillo
- Jose Antonio Grande

## Despliegue del proyecto

Este proyecto esta formado por la parte de cliente realizado en `Vanilla JavaScript` y empaquetado con `Vite.js`. Desde aquí el cliente podrá consultar el archivo que
especifique, con su reto y su token para comprobar que el hashing continúa siendo el mismo que él almacenó y por lo tanto que el archivo permanece íntegro.
Esto lo hará rellenando un formulario donde se solicitan estos tres campos.

Para desplegar la parte de cliente deberemos acceder al directorio del cliente y ejecutar el siguiente comando:
````
cd client/ssii-pai-1
npm run dev
````
Ahora podremos acceder a la parte de cliente medianta http://localhost:5173

A continuación la parte del servidor, desarrollada con Java y el framework `Spring-Boot`, consta de un servicio y un controlador muy sencillo con funciones de búsqueda de archivos de forma binaria y usando librerias de funciones de hashing.

Para desplegar el servidor ejecutaremos los siguientes comandos:
````
cd pai1
mvnw spring-boot:run
````
O también accediendo a la clase `Pai1Application.java` desde tu IDE preferido y dandole a ejecutar.

El servidor estará en http://localhost:8080 esperando peticiones del cliente.

Una vez está todo desplegado ya solo queda probarlo escribiendo algún nombre de archivo que este en la carpeta `ficheros` y veremos desde el cliente cómo nos devuelve un hash que el cliente podrá comprobar para afirmar si su archivo está íntegro o no.

