<?php
namespace Model;

use Model\Cargo;

/**Las relaciones representan a objetos de Cargo */
class RelacionVAbajo
{
    #region attributes
    private static string $cargo;
    private Cargo $nombreCargo;
    #endregion

    #region constructor
    function __construct(string $cargo, Cargo $nombreCargo)
    {
        self::$cargo = $cargo;
        $this->nombreCargo = $nombreCargo;
    }
    #endregion

    #region getter
    public function get_cargo()
    {
        return self::$cargo;

    }
    public function get_nombreCargo()
    {
        return $this->nombreCargo->show_data();
    }
    #endregion

    #region setter
    public function set_cargo($cargo)
    {
        self::$cargo = $cargo;
    }
    public function set_nombreCargo($nombreCargo)
    {
        $this->nombreCargo = $nombreCargo;
    }
    #endregion

    #region methods
    public function show_data()
    {
        $response = "Relación Vertical abajo: [Cargo: " . self::get_cargo() . " ,Nombre del cargo: " . $this->get_nombreCargo() . "]";

        return json_encode($response);
    }
    #endregion

}

?>