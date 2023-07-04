<?php
namespace Model;

/**Horario como candidato a ser atributo  desglosado de lugar trabajo */
class Horario
{
    #region attributes
    private static string $dia;
    private static string $horaInicio;
    private static string $horaFin;
    #endregion

    #region constructors
    function __construct(string $dia, string $horaInicio, string $horaFin)
    {
        self::$dia = $dia;
        self::$horaInicio = $horaInicio;
        self::$horaFin = $horaFin;

    }
    #endregion

    #region getter
    public function get_dia()
    {
        return self::$dia;
    }
    public function get_horaInicio()
    {
        return self::$horaInicio;
    }
    public function get_horaFin()
    {
        return self::$horaFin;
    }
    #endregion

    #region setter
    public function set_dia($dia)
    {
        self::$dia = $dia;
    }
    public function set_horaInicio($horaInicio)
    {
        self::$horaInicio = $horaInicio;
    }
    public function set_horaFin($horaFin)
    {
        self::$horaFin = $horaFin;
    }
    #endregion

    #region methods
    public function show_data()
    {
        $response = "Horario: [Dia: " . self::get_dia() . " ,Hora inicio: " .
            self::get_horaInicio() . " ,Hora fin: " . self::get_horaFin() . "]";
        return json_encode($response);
    }
    #endregion

}

?>