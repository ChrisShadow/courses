<?php
namespace Model;

use Model\LugarTrabajo;
use Model\Horario;

use Ds\Map;

#region doc
https: //www.php.net/manual/en/class.ds-map.php#:~:text=A%20Map%20is%20a%20sequential,map%20using%20the%20same%20key.
#endregion


class ListaHorario
{
    #region att
    private $MapaHorario; //[{Lugar trabajo:Horario}]
    //private LugarTrabajo $lugarTrabajo;
    #endregion

    #region const
    function __construct(

    ) {
        $this->MapaHorario = new Map(); // Tarea: implementar librería, pasos en gpt para el  17/08
    }
    #endregion

    #region getter
    public function get_MapaHorario()
    {
        return $this->MapaHorario;
    }
    #endregion 

    #region setter
    public function set_MapaHorario_lugarTrabajo(LugarTrabajo $lugarTrabajo)
    {
        $this->MapaHorario[$lugarTrabajo->get_nombreEmpresa() . " - " . $lugarTrabajo->get_sucursal()] = $this->ArrayHorario;
    }
    #endregion

    #region methods
    //Creating and setting the new map
    //Just for the first time


    //Adding new elements to horario list which is the value in the map
    public function set_value_horario(Horario $horario)
    {
        if (isset($this->ArrayHorario))
            $index = 0;
        $this->ArrayHorario[$index] = $horario;
        $index++;
    }
    //Probar si actualiza o no para la lógica de encontrar el mapa y volver a instanciar actualizado


    public function show_data()
    {
        $response = "Lista horario: [Lugar de trabajo: " . $this->get_MapaHorario() . "]";
        return json_encode($response);
    }
    //Validar que en el get mapa exista o no el recorrido previo antes de la vista 

    #endregion
}

?>