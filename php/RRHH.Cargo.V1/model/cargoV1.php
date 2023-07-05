<?php

class Cargo{
    public $nombre;
    public $relacionVerticalArriba; //lista o clase: nombre
    public $relacionVerticalAbajo; //lista o clase: nombre
    public $funcion; //lista o clase: nombre
    public $lugarTrabajo;//lista o clase: nombre, ubicacion         
     //Horario, lista o clase: día, horainicio,horafin   
    public $dia; //atributo de horario
    public $horainicio;//atributo de horario
    public $horafin;//atributo de horario
    //Económico, lista o clase: asalariado/tercerizado, clase: salario/viatico, clase: tipomoneda, porcentajecomisión
    public $tipoFuncionario; //atributo de Económico
    public $pagoFuncionario; //atributo de tipo Funcionario
    public $divisa; //atributo de pagoFuncionario
    public $porcentajeComision; //atributo de pagoFuncionario

    public $periodoPago; //lista o clase: diario, semanal, quincenal, mensual

    public function show(){


        echo "<p><strong>Nombre del Cargo:</strong><br>$this->nombre</p>",
             "<p><strong>Relación vertical arriba:</strong><br>$this->relacionVerticalArriba</p>",
             "<p><strong>Relación vertical abajo:</strong><br>$this->relacionVerticalAbajo</p>",
             "<p><strong>Funciones (1:prioridad baja, 10:prioridad alta):</strong><br>$this->funcion</p>",
             "<p><strong>Lugar de trabajo:</strong><br>$this->lugarTrabajo</p>",
             "<p><strong>Horario:</strong><br><span>Día:</span>$this->dia     |      <span>Hora inicio:</span>$this->horainicio       |       <span>Hora fin:</span>$this->horafin</p>",
             "<p><strong>Económico:</strong><br><span>Tipo de funcionario:</span>$this->tipoFuncionario    |   <span>Tipo de remuneración:</span>$this->pagoFuncionario   |   <span>Moneda:</span>$this->divisa |   <span>Comisión:</span>$this->porcentajeComision</p>",
             "<p><strong>Frecuencia de pago:</strong><br>$this->periodoPago</p>";
    }
    
}

?>