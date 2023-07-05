<?php
namespace Model;

use Model\LugarTrabajo;

#region doc
https: //www.php.net/manual/en/class.ds-map.php#:~:text=A%20Map%20is%20a%20sequential,map%20using%20the%20same%20key.
#endregion

class ListaHorario
{
    #region att
    private static $MapaHorario = (object) []; //[{Lugar trabajo:Horario}]
    private static $ArrayHorario = array(); //posición y el objeto instanciado horario
    private LugarTrabajo $lugarTrabajo;
    #endregion

    #region const
    function __construct(
        LugarTrabajo $lugarTrabajo
    ) {
        $this->lugarTrabajo = $lugarTrabajo;
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
    public function show_data()
    {
        $response = "Lista horario: [Lugar de trabajo: " . $this->get_lugarTrabajo() . "]";
        return json_encode($response);
    }
    #endregion
}

?>
