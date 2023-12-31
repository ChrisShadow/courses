<?php
namespace Core;

class Route
{
    private static $group = "";
    private static $params = [];

    //API annotations
    public static function get($path, $class)
    {
        self::$params[] = [
            "path" => self::$group.$path,
            "http" => "GET",
            "class"=>$class,
        ];
    }
    public static function post($path, $class)
    {
        self::$params[] = [
            "path" => self::$group.$path,
            "http" => "POST",
            "class"=>$class,
        ];
    }

    // /Producto
    //  /ID => /Producto/ID
    //  /NAME =>/Producto/NAME
    public static function group($path, $class)
    {
        self::$group = $path;
        return $class();
    }
    public static function getRoutes(){
        return self::$params;
    }
}

?>