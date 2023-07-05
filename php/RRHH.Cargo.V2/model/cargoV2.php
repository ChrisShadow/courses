<?php
namespace Model;

use Model\RelacionVArriba;
use Model\RelacionVAbajo;
use Model\RelacionHorizontal;
use Model\ListaActividad;
use Model\ListaHorario;
use Model\Divisa;

#region Doc
/*
https://www.php.net/manual/en/language.oop5.static.php
https://fernando-gaitan.com.ar/php-orientado-a-objetos-parte-4-metodos-getters-y-setters/
Declaring class properties or methods as static makes them accessible without needing an 
instantiation of the class. These can also be accessed statically within an instantiated class object. 
Because static methods are callable without an instance of the object created, 
the pseudo-variable $this is not available inside methods declared as static.
self is used to access static or class variables or methods and this is used to access 
non-static or object variables or methods. So use self when there is a need to access something 
which belongs to a class and use $this when there is a need to access a property belonging to the 
object of the class
*/

/*
-> is used to call a method, or access a property, on the object of a class. 
=> is used to assign values to the keys of an array.
 */
/*
PHP $ and $$ Variables. The $var (single dollar) is a normal variable with the name var that stores any value 
like string, integer, float, etc. The $$var (double dollar) is a reference variable that stores the value of the 
$variable inside it
*/

/*
https://www.w3resource.com/JSON/structures.php
[{key:value},{key:value},...]
 */

#endregion

class Cargo
{
    #region attributes
    private static string $nombre;
    //clases relacion dejan de ser atributos
    private RelacionVArriba $relacionVArriba;
    private RelacionVAbajo $relacionVAbajo;
    private RelacionHorizontal $relacionHorizontal;
    private ListaActividad $listaActividad;
    private ListaHorario $listaHorario;
    private static $tipoFuncionario = [];
    private static int $indicetipoFuncionario;
    private static float $pagoFuncionario;
    private Divisa $divisa;
    private static float $porcentajeComision;

    private static $periodoPago = [];
    private static int $indicePeriodoPago;
    #endregion

    #region constructor
    //empty 
    /*function __construct()//no permite sobreescritura: métodos con mismo nombre pero de distinta firma
    {
        //echo "Primera instancia creada";
        self::$nombre = "";
        self::$relacionVArriba = RelacionVArriba::class;
        self::$relacionVAbajo = RelacionVAbajo::class;
        self::$relacionHorizontal = RelacionHorizontal::class;
        self::$listafuncion = ListaFuncion::class;
        self::$lugarTrabajo = LugarTrabajo::class;
        self::$listahorario = ListaHorario::class;
        self::$tipoFuncionario = (object) [0 => "Asalariado", 1 => "Tercerizado"];
        self::$indicetipoFuncionario = 0;
        self::$pagoFuncionario = 0.0;
        self::$divisa = Divisa::class;
        self::$porcentajeComision = 0.0;
        self::$periodoPago = (object) [1 => "Jornal", 2 => "Semanal", 3 => "Quincenal", 4 => "Mensual"];
        self::$indicePeriodoPago = 0;

    }*/
    //with Sign
    function __construct(
        string $nombre, RelacionVArriba $relacionVArriba, RelacionVAbajo $relacionVAbajo, RelacionHorizontal $relacionHorizontal,
        ListaActividad $listaActividad, ListaHorario $listaHorario, int $indicetipoFuncionario, float $pagoFuncionario,
        Divisa $divisa, float $porcentajeComision, int $indicePeriodoPago
    ) {
        //echo "Primera instancia creada";
        self::$nombre = $nombre;
        $this->relacionVArriba = $relacionVArriba;
        $this->relacionVAbajo = $relacionVAbajo;
        $this->relacionHorizontal = $relacionHorizontal;
        $this->listaActividad = $listaActividad;
        $this->listaHorario = $listaHorario;
        self::$tipoFuncionario = (object) [0 => "Asalariado", 1 => "Tercerizado"];
        self::$indicetipoFuncionario = $indicetipoFuncionario;
        self::$pagoFuncionario = $pagoFuncionario;
        $this->divisa = $divisa;
        self::$porcentajeComision = $porcentajeComision;
        self::$periodoPago = (object) [1 => "Jornal", 2 => "Semanal", 3 => "Quincenal", 4 => "Mensual"];
        self::$indicePeriodoPago = $indicePeriodoPago;
    }
    #endregion

    #region Getter
    public function get_nombre()
    {
        return self::$nombre; //$this->nombre
    }
    public function get_relacionVArriba()
    {
        return $this->relacionVArriba->show_data();
    }
    public function get_relacionVAbajo()
    {
        return $this->relacionVAbajo->show_data();
    }
    public function get_relacionHorizontal()
    {
        return $this->relacionHorizontal->show_data();
    }
    public function get_listaActividad()
    {
        return $this->listaActividad->show_data();
    }

    public function get_listaHorario()
    {
        return $this->listaHorario->show_data();
    }
    public function get_indicetipoFuncionario()
    {
        return self::$indicetipoFuncionario; //$this->indicetipoFuncionario
    }
    public function get_tipoFuncionario()
    {
        return self::$tipoFuncionario[self::get_indicetipoFuncionario()]; //$this->tipoFuncionario[$this->get_indicetipoFuncionario()]
    }

    public function get_pagoFuncionario()
    {
        return self::$pagoFuncionario; //$this->pagoFuncionario
    }
    public function get_divisa()
    {
        return $this->divisa->show_data();
    }
    public function get_porcentajeComision()
    {
        return self::$porcentajeComision; //$this->porcentajeComision
    }
    public function get_indicePeriodoPago()
    {
        return self::$indicePeriodoPago; //$this->indicePeriodoPago
    }
    public function get_periodoPago()
    {
        return self::$periodoPago[self::get_indicePeriodoPago()]; //$this->periodoPago[$this->get_indicePeriodoPago()
    }

    #endregion

    #region Setter
    public function set_nombre($nombre)
    {
        self::$nombre = $nombre; //$this->nombre
    }
    public function set_relacionVArriba($relacionVArriba)
    {
        $this->relacionVArriba = $relacionVArriba;
    }
    public function set_relacionVAbajo($relacionVAbajo)
    {
        $this->relacionVAbajo = $relacionVAbajo;
    }
    public function set_relacionHorizontal($relacionHorizontal)
    {
        $this->relacionHorizontal = $relacionHorizontal;
    }
    public function set_listaActividad($listaActividad)
    {
        $this->$listaActividad = $listaActividad;
    }

    public function set_listaHorario($listaHorario)
    {
        $this->listaHorario = $listaHorario;
    }
    /*public function set_tipoFuncionario($tipoFuncionario)
    {
        $this->tipoFuncionario = $tipoFuncionario;
    }*/

    public function set_indicetipoFuncionario($indicetipoFuncionario)
    {
        self::$indicetipoFuncionario = $indicetipoFuncionario; //$this->indicetipoFuncionario
    }
    public function set_pagoFuncionario($pagoFuncionario)
    {
        self::$pagoFuncionario = $pagoFuncionario; //$this->pagoFuncionario
    }
    public function set_divisa($divisa)
    {
        $this->divisa = $divisa;
    }
    public function set_porcentajeComision($porcentajeComision)
    {
        self::$porcentajeComision = $porcentajeComision; //$this->porcentajeComision
    }
    /*public function set_periodoPago($periodoPago)
    {
        $this->periodoPago = $periodoPago;
    }*/
    public function set_indicePeriodoPago($periodoPago)
    {
        self::$periodoPago = $periodoPago; //$this->indicePeriodoPago
    }
    #endregion

    #region Methods
    //ToString
    public function show_data()
    {
        $response = "Cargo: [Nombre: " . self::get_nombre() /**$this->get_nombre() */. ", Relación veritical arriba: " . $this->get_relacionVArriba() . ", 
            Relación veritical abajo: " . $this->get_relacionVAbajo() . ", Relación horizontal: " . $this->get_relacionHorizontal()
            . ", Lista de funciones: " . $this->get_listaActividad() . ", Lita de horario: " . $this->get_listaHorario() . ", Tipo de funcionario: " . self::get_tipoFuncionario() /**$this->get_tipoFuncionario() */
            . (self::$indicetipoFuncionario /**$this->indicetipoFuncionario*/== 0) ? ", Salario: " . self::get_pagoFuncionario() /**$this->get_pagoFuncionario() */: ", Viático: " . self::get_pagoFuncionario() /**$this->get_pagoFuncionario() */
            . ", Comisión: " . self::get_porcentajeComision() /**$this->get_porcentajeComision() */. ", Moneda: " . $this->get_divisa() . ", Período pago: " . self::get_periodoPago() /**$this->get_periodoPago() */. "]";
        return json_encode($response);
    }
    #endregion
}

?>