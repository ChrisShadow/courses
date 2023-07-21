<?php
use Model\Horario;
use Model\LugarTrabajo;
use Model\ListaHorario;

class Test
{
    public ListaHorario $listaH;

    function __construct()
    {
        $this->listaH = new ListaHorario();
    }

    public function TestingMap()
    {

        $sede1 = new LugarTrabajo("Proinso", "Sede Central", "Luque", "Ytororo e Itaipu");
        $sede2 = new LugarTrabajo("QUATTRO", "Sede Central", "Asunción", "Ytororo");

        $this->listaH->set_lugarTrabajo($sede1);
        $this->listaH->set_key_lista_horario();
        self::TestingArray();
        $this->listaH->set_lugarTrabajo($sede2);
        $this->listaH->set_key_lista_horario();
        self::TestingArray();
    }

    public function TestingArray()
    {
        $horarioL = new Horario("Lunes", "07:50", "17:00");
        $horarioM = new Horario("Martes", "14:00", "22:00");
        $horarioV = new Horario("Viernes", "3:00", "10:00");

        $this->listaH->set_value_horario($horarioL);
        $this->listaH->set_value_horario($horarioM);
        $this->listaH->set_value_horario($horarioV);

    }

}


/**
 * Next, do an echo but first mvc in test folder
 * 
 */
?>