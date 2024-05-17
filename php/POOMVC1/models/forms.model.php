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
        //$stmt->close();
        $stmt = null;
    }
    static public function mdlBringData($table, $item, $value)
    {
        if ($item == null && $value == null) {
            $stmt = Conexion::connect()->prepare("SELECT *,DATE_FORMAT(fecha_registro,'%d/%m/%Y') AS fecha_registro FROM $table ORDER BY id DESC");
            $stmt->execute();
            return $stmt->fetchAll();
        } else {
            $stmt = Conexion::connect()->prepare("SELECT *,DATE_FORMAT(fecha_registro,'%d/%m/%Y') AS fecha_registro FROM $table WHERE $item = :$item ORDER BY id DESC");
            $stmt->bindParam(":" . $item, $value, PDO::PARAM_STR);
            $stmt->execute();
            return $stmt->fetch();

        }


        //$stmt->close();
        //$stmt = null;
    }
}