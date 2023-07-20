<?php
use Model\Horario;
use Model\LugarTrabajo;
use Model\ListaHorario;

$horarioL = new Horario("Lunes", "07:50", "17:00");
$horarioM = new Horario("Martes", "14:00", "22:00");
$horarioV = new Horario("Viernes", "3:00", "10:00");

$sede1 = new LugarTrabajo("Proinso", "Sede Central", "Luque", "Ytororo e Itaipu");
$sede2 = new LugarTrabajo("QUATTRO", "Sede Central", "Asunción", "Ytororo");

$listaH = new ListaHorario();
$listaH->set_lugarTrabajo($sede1);
$listaH->set_key_lista_horario();
/**
 * Next, do an echo but first mvc in test folder
 * 
 */
?>