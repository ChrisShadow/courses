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

    static public function ctrBringData($item, $value)
    {
        $table = "usuario";
        $response = FormsModel::mdlBringData($table, $item, $value);
        return $response;
    }

    public function ctrLogin()
    {
        if (isset($_POST["login-email"])) {
            $table = "usuario";
            $item = "correo";
            $value = $_POST["login-email"];
            $response = FormsModel::mdlBringData($table, $item, $value);

            if ($response["correo"] == $_POST["login-email"] && $response["clave"] == $_POST["login-pwd"]) {

                $_SESSION["validateLogin"] = "ok";

                echo '<script>
                if (window.history.replaceState) {
                    window.history.replaceState(null, null, window.location.href);
                }
                window.location = "index.php?page=index";
                </script>';
            } else {
                $_SESSION["validateLogin"] = "error";
                echo '<script>
                if (window.history.replaceState) {
                    window.history.replaceState(null, null, window.location.href);
                }
                </script>';

                echo '<div class="alert alert-danger mt-2">Error: User or password incorrect</div>';
            }
        }
    }

    static public function ctrEditUser()
    {
        if (isset($_POST["edit-name"])) {
            if ($_POST["edit-pss"] != "") {
                $password = $_POST["edit-pss"];
            } else {
                $password = $_POST["current-pwd"];
            }

            $table = "usuario";
            $data = array(
                "id" => $_POST["id-user"],
                "nombre" => $_POST["edit-name"],
                "apellido" => $_POST["edit-lastn"],
                "correo" => $_POST["edit-email"],
                "clave" => $password
            );

            $response = FormsModel::mdlEditUser($table, $data);
            return $response;
        }
    }

    static public function ctrDeleteUser()
    {
        if (isset($_POST["delete-user"])) {
            $table = "usuario";
            $value = $_POST["delete-user"];
            $response = FormsModel::mdlDeleteUser($table, $value);

            if ($response == "ok") {
                echo '<script>
                if (window.history.replaceState) {
                    window.history.replaceState(null, null, window.location.href);
                }
                window.location = "index.php?action=index";
                </script>';
            }
        }
    }
}
