<?php
require_once "conntedb.php";

class FormsModel
{
    static public function mdlRegister($table, $data)
    {
        $stmt = Conexion::connect()->prepare("INSERT INTO $table(nombre,apellido, clave, correo) VALUES (:nombre,:apellido, :clave, :correo)");
        $stmt->bindParam(":nombre", $data["nombre"], PDO::PARAM_STR);
        $stmt->bindParam(":apellido", $data["apellido"], PDO::PARAM_STR);
        $stmt->bindParam(":clave", $data["clave"], PDO::PARAM_STR);
        $stmt->bindParam(":correo", $data["correo"], PDO::PARAM_STR);

        if ($stmt->execute()) {
            return "ok";
        } else {
            print_r(Conexion::connect()->errorInfo());
        }
        $stmt->close();
        $stmt = null;
    }
}