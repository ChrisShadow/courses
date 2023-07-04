<?php
namespace Model;

class Divisa
{
    #region #attributes
    private static string $simbolo;
    private static string $moneda; //Descripción del simbolo
    private static $valor; //$valor=18455250.787845
    private static string $valorMostrar; //$valorMostrar=Gs 18.455.250,78, 
    #endregion

    #region constructor
    function __construct(string $simbolo, string $moneda, float $valor)
    {
        self::$simbolo = $simbolo;
        self::$moneda = $moneda;
        self::$valor = $valor;
        self::set_valorMostrar($simbolo, $valor);
    }
    #endregion

    #region getter
    public function get_simbolo()
    {
        return self::$simbolo;
    }
    public function get_moneda()
    {
        return self::$moneda;
    }
    public function get_valor()
    {
        return self::$valor;
    }
    public function get_valorMostrar()
    {
        return self::$valorMostrar;
    }

    #endregion

    #region setter
    public function set_simbolo($simbolo)
    {
        self::$simbolo = $simbolo;
    }
    public function set_moneda($moneda)
    {
        self::$moneda = $moneda;
    }
    public function set_valor($valor)
    {
        self::$valor = $valor;
    }
    public function set_valorMostrar($simbolo, $valor)
    {
        (self::$moneda == "Guarani" || self::$moneda == "Guaranies") ? self::$valorMostrar = $simbolo . " " . number_format($valor, 0, ",", ".") : self::$valorMostrar = $simbolo . " " . number_format($valor, 2, ".", ",");
    }
    #endregion

    #region methods
    public function show_data()
    {
        $response = "Divisa: [Moneda: " . self::get_moneda() . " ,Monto: " . self::get_valorMostrar() . "]";
        return json_encode($response);
    }
    #endregion
}

?>