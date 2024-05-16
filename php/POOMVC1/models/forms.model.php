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
    static public function mdlBringData($table)
    {
        $stmt = Conexion::connect()->prepare("SELECT *,DATE_FORMAT(fecha_registro,'%d/%m/%Y') AS fecha_registro FROM $table ORDER BY id DESC");
        $stmt->execute();
        return $stmt->fetchAll();
        $stmt->close();
        $stmt = null;
    }
}