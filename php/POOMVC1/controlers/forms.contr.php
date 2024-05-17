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
        $response = FormsModel::mdlBringData($table, null, null);
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
}
