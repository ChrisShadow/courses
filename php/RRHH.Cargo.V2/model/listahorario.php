<?php
namespace Model;

use Model\LugarTrabajo;

class ListaHorario
{
    #region att
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