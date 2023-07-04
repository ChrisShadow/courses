<?php
//Mostrará la salida de las vistas al usuario y también enviará las distintas acciones que el usuario envíe al controlador

//el archivo invocado es requerido, comecta el contenido del archivo requerido
require_once "controller/templatecontroller.php";
require_once "controller/cargoV1.php";
$plantilla = new TempController();
$plantilla->ctrBringTemp();

?>