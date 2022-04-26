#Manual de instalacion:

Manual de instalación, configuración y operación
1- Verificar tener instalado Java en su computadora, con una versión de Jdk 15 o 16. 
2- Una vez descargados los .jar, abrir primero el receptor y configurar el puerto en el que se va a estar escuchando al/los emisores y apretar el botón “escuchar”. 
3- Luego, abrir el emisor y en los campos ip, puerto y puesto, ingresar la ip en la que se encuentra el receptor o “localhost” en caso de que el receptor se esté ejecutando en la misma computadora, el puerto en el que el receptor está escuchando y el nombre que identifique al lugar de trabajo emisor, respectivamente.
4- No olvidar configurar en el/los receptores qué tipo de solicitudes se quieren escuchar, seleccionando los botones correspondientes a cada tipo (esto se puede realizar en cualquier momento).
5- Para mandar una solicitud desde el emisor, se tiene que tocar el botón “solicitar” correspondiente a cada tipo, y se le abrirá una ventana con los datos de su solicitud y un mensaje que le indicará si la solicitud fue o no recibida o si fue rechazada. Mientras podrá seguir mandando solicitudes desde la ventana Emisor.
6- En los casos en que la solicitud haya sido rechazada, o haya sido confirmada la recepción, se activará el botón “Ok” el cual se debe tocar para cerrar la ventana de “confirmación de la recepción”. IMPORTANTE: no tocar la ‘X’ para cerrar la ventana porque sino se cerrarán todas las ventanas.
7- Cuando se reciba una solicitud, el receptor mostrará los datos de la misma en los campos “tipo de solicitud”, “hora” y “lugar”, y además se agregara en el campo “historial de solicitudes” el cual respetará el orden en el que fueron llegando. Los datos de la solicitud que aparezcan en los campos “tipo de solicitud”, “hora” y “lugar” serán los de la última solicitud recibida SIN responder.
8- Para confirmar la recepción de una solicitud, se deberá tocar el botón “confirmar recepción” el cual enviará el mensaje de confirmación de la solicitud al Emisor, y actualizará los campos “tipo de solicitud”, “hora” y “lugar” con la próxima solicitud sin atender.
