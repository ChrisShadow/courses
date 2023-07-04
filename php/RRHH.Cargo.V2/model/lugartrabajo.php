<?php
namespace Model;

class LugarTrabajo
{
    #region attributes
    private static string $nombreEmpresa;
    private static string $sucursal;
    private static string $ciudad;
    private static string $ubicacion;
    
    #endregion

    #region constructor
    function __construct(string $nombreEmpresa, string $sucursal, string $ciudad, string $ubicacion)
    {
        self::$nombreEmpresa = $nombreEmpresa;
        self::$sucursal = $sucursal;
        self::$ciudad = $ciudad;
        self::$ubicacion = $ubicacion;

    }
    #endregion

    #region getter
    public function get_nombreEmpresa()
    {
        return self::$nombreEmpresa;
    }
    public function get_sucursal()
    {
        return self::$sucursal;
    }
    public function get_ciudad()
    {
        return self::$ciudad;
    }
    public function get_ubicacion()
    {
        return self::$ubicacion;
    }
    #endregion

    #region setter
    public function set_nombreEmpresa($nombreEmpresa)
    {
        self::$nombreEmpresa = $nombreEmpresa;
    }
    public function set_sucursal($sucursal)
    {
        self::$sucursal = $sucursal;
    }
    public function set_ciudad($ciudad)
    {
        self::$ciudad = $ciudad;
    }
    public function set_ubicacion($ubicacion)
    {
        self::$ubicacion = $ubicacion;
    }
    #endregion

    #region methods
    public function show_data()
    {
        $response = "Lugar de trabajo: [Empresa: " . self::get_nombreEmpresa() . " ,Sucursal: " . self::get_sucursal() .
            " ,Ciudad: " . self::get_ciudad() . " ,Ubicacion: " . self::get_ubicacion() . "]";
        return json_encode($response);
    }
    #endregion

}
?>