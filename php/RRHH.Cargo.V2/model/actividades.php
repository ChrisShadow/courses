<?php
namespace Model;

/**Misma lógica que clases relación, enotnces no sería necesario su propia clase listafuncion */
class Actividad
{
    #region attibutes
    private static string $nombre;
    private static int $nivel;
    #endregion

    #region constructor
    function __construct(string $nombre, int $nivel)
    {
        self::$nombre = $nombre;
        self::$nivel = $nivel;
    }
    #endregion

    #region getter
    public function get_nombre()
    {
        return self::$nombre;
    }
    public function get_nivel()
    {
        return self::$nivel;
    }
    #endregion

    #region setter
    public function set_nombre($nombre)
    {
        self::$nombre = $nombre;
    }
    public function set_nivel($nivel)
    {
        self::$nivel = $nivel;
    }
    #endregion

    #region methods
    public function show_data()
    {
        $response = "Actividad: [Nombre: " . self::get_nombre() . " ,Nivel: " . self::get_nivel() . "]";

        return json_encode($response);
    }
    #endregion

}

?>