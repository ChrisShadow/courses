<?php


class TempController
{
    #Llamada a la plantilla
    public function ctrBringTemp()
    {
        //invoca el archivo  que contiene codigo html-php
        include "view/templateview.php";

    }

    public function ctrBringTest()
    {
        //invoca el archivo  que contiene codigo html-php
        include "view/templatest.php";


    }

}


?>