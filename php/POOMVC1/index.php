<?php
//Mostrará la salida de las vistas al usuario y también enviará las distintas acciones que el usuario envíe al controlador

//el archivo invocado es requerido, comecta el contenido del archivo requerido
require_once "controlers/controltemp.php";
require_once "models/model.php";
require_once "controlers/forms.contr.php";
$plantilla = new TempController();
$plantilla->ctrBringTemp();

?>