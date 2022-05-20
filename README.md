Manual de instalación, configuración y operación

1- Verificar tener instalado Java en su computadora, con una versión de Jdk 16. 

2- Una vez descargados los .jar, abrir primero el servidor, completar el puerto por el cual se va a escuchar y apretar el botón “escuchar”. Todo evento que pase por el servidor será mostrado en su pantalla brindando toda la información necesaria para un seguimiento de acciones.

3- Abrir receptores/emisores a gusto.
Al ejecutar un receptor, se debe configurar el puerto en el que se va a estar escuchando, además de la ip y puerto del servidor al cual se desea conectar y no olvidar configurar qué tipo de solicitudes se quieren escuchar, seleccionando los botones correspondientes a cada tipo. Paso siguiente apretar el botón “conectar”, si previamente no se seleccionó ningún botón para escuchar algún tipo de solicitud, no se recibirá ninguna.
Por otro lado, al abrir un emisor se debe completar los campos ip, puerto y puesto, ingresar la ip en la que se encuentra el servidor o “localhost” en caso de que el servidor se esté ejecutando en la misma computadora, el puerto en el que el servidor está escuchando y el nombre que identifique al lugar de trabajo emisor, respectivamente.

4- Para mandar una solicitud desde el emisor, se tiene que tocar el botón correspondiente a cada tipo, y se le abrirá una ventana con los datos de su solicitud y un mensaje que le indicará si la solicitud fue o no recibida por algún receptor (en caso de ser confirmada el mensaje de “no recibida” cambia a “recibido”), pero si no hay ningún receptor registrado en el servidor que acepte el tipo de solicitud enviada, el mensaje será “rechazada”. Mientras podrá seguir mandando solicitudes desde la ventana Emisor.

5- En los casos en que la solicitud haya sido rechazada, o haya sido confirmada la recepción, se activará el botón “Ok” el cual se debe tocar para cerrar la ventana de “confirmación de la recepción”. IMPORTANTE: no tocar la ‘X’ para cerrar la ventana porque sino se cerrarán todas las ventanas del emisor.

6- Cuando reciba una solicitud, el receptor mostrará los datos de la misma en los campos “tipo de solicitud”, “hora” y “lugar”, y además se agregara en el campo “historial de solicitudes” el cual respetará el orden en el que fueron llegando. Los datos de la solicitud que aparezcan en los campos “tipo de solicitud”, “hora” y “lugar” serán los de la solicitud más primitiva recibida SIN responder por ningún receptor, ya que una misma solicitud llega a todos los receptores que habilitaron su recepción.

7- Para confirmar la recepción de una solicitud, se deberá tocar el botón “confirmar recepción” el cual enviará el mensaje de confirmación de la solicitud al servidor, y actualizará las solicitudes pendientes y los campos “tipo de solicitud”, “hora” y “lugar” con la próxima solicitud sin atender en cada uno los receptores.

8- IMPORTANTE: En caso de cerrar la ventana del servidor se deben cerrar todos los receptores obligatoriamente (ya que no estarían registrados en ningún servidor activo), y el emisor debe cerrarse si tiene solicitudes pendientes no confirmadas, de no ser así se puede usar la misma ventana para enviar solicitudes a un nuevo servidor (previamente se debe reabrir otro y ponerlo a escuchar).
