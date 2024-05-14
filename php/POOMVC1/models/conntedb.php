<?php

class Conexion
{

    static public function connect()
    {

        $link = new PDO("mysql:host=localhost;dbname=cursephp", "root", "");
        $link->exec("set names utf8");


        return $link;
    }
}
