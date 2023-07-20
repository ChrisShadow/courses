<?php
namespace Model;

use Model\LugarTrabajo;
use Model\Horario;

#region doc
https: //www.php.net/manual/en/class.ds-map.php#:~:text=A%20Map%20is%20a%20sequential,map%20using%20the%20same%20key.
#endregion

class ListaHorario
{
    #region att
    private static $MapaHorario = []; //[{Lugar trabajo:Horario}]
    private static $ArrayHorario; //posición y el objeto instanciado horario
    private LugarTrabajo $lugarTrabajo;
    #endregion

    #region const
    function __construct(

    ) {
        self::$MapaHorario = (object) [];
        self::$ArrayHorario = array();
    }
    #endregion

    #region getter
    public function get_lugarTrabajo()
    {
        return $this->lugarTrabajo->show_data();
    }
    #endregion 

    #region setter
    public function set_lugarTrabajo($lugarTrabajo)
    {
        $this->lugarTrabajo = $lugarTrabajo;
    }
    #endregion

    #region methods
    //Creating and setting the new map
    //Just for the first time
    public function set_key_lista_horario()
    {
        self::$MapaHorario = [$this->lugarTrabajo => self::$ArrayHorario]; //[{Lugar trabajo:Horario}]
    }

    //Adding new elements to horario list which is the value in the map
    public function set_value_horario(Horario $horario)
    {
        if (self::$ArrayHorario == array())
            $index = 0;
        self::$ArrayHorario[$index] = $horario;
        $index++;
    }

    /*Next act, do a test with an aux class regardin listahorario for looking which goes first= either set_key_lista_horario or set_value_horario
    Then the other functions: delete, seek/edit. Lastly show_data
    Format for horainicio & horafin in Horario
    */

    public function show_data()
    {
        $response = "Lista horario: [Lugar de trabajo: " . $this->get_lugarTrabajo() . "]";
        return json_encode($response);
    }


    #endregion
}

?>