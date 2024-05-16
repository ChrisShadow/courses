<?php
class FormsController
{
    static public function ctrRegister()
    {
        if (isset($_POST["reg-name"])) {

            $table = "usuario";
            $data = array(
                "nombre" => $_POST["reg-name"],
                "apellido" => $_POST["reg-lastn"],
                "clave" => $_POST["reg-pss"],
                "correo" => $_POST["reg-email"]
            );

            $response = FormsModel::mdlRegister($table, $data);
            return $response;

            //return "ok";
            //return $_POST["reg-name"] . "<br>" . $_POST["reg-lastn"] . "<br>" . $_POST["reg-email"] . "<br>" . $_POST["reg-pss"] . "<br>";
        }
    }

    static public function ctrBringData()
    {
        $table = "usuario";
        $response = FormsModel::mdlBringData($table);
        return $response;
    }
}
