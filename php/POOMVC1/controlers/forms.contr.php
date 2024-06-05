<?php
class FormsController
{
    static public function ctrRegister()
    {
        if (isset($_POST["reg-name"])) {

            if (
                preg_match('/^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+$/', $_POST["reg-name"])
                && preg_match('/^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$/', $_POST["reg-lastn"])
                && preg_match('/^[a-zA-Z0-9@.-_]+$/', $_POST["reg-email"])
                && preg_match('/^[a-zA-Z0-9@.-_]+$/', $_POST["reg-pss"])
            ) {
                $table = "usuario";
                $token = md5($_POST["reg-email"] . "+" . $_POST["reg-pss"]);
                $data = array(
                    "token" => $token,
                    "nombre" => $_POST["reg-name"],
                    "apellido" => $_POST["reg-lastn"],
                    "clave" => $_POST["reg-pss"],
                    "correo" => $_POST["reg-email"]
                );

                $response = FormsModel::mdlRegister($table, $data);
                return $response;

            } else {
                $response = "error";
                return $response;
            }


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
            if (
                preg_match('/^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+$/', $_POST["edit-name"])
                && preg_match('/^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$/', $_POST["edit-lastn"])
                && preg_match('/^[a-zA-Z0-9@.-_]+$/', $_POST["edit-email"])
            ) {
                $user = FormsModel::mdlBringData("usuario", "token", $_POST["token-user"]);
                $compare = md5($user["correo"] . "+" . $_POST["current-pwd"]);
                if ($compare == $_POST["token-user"]) {
                    if ($_POST["edit-pss"] != "") {
                        if (preg_match('/^[a-zA-Z0-9@.-_]+$/', $_POST["edit-pss"])) {
                            $password = $_POST["edit-pss"];
                        }
                    } else {
                        $password = $_POST["current-pwd"];
                    }

                    $table = "usuario";
                    $data = array(
                        "token" => $_POST["token-user"],
                        "nombre" => $_POST["edit-name"],
                        "apellido" => $_POST["edit-lastn"],
                        "correo" => $_POST["edit-email"],
                        "clave" => $password
                    );

                    $response = FormsModel::mdlEditUser($table, $data);
                    return $response;
                } else {
                    $response = "error";
                    return $response;
                }

            } else {
                $response = "error";
                return $response;
            }
        }
    }

    static public function ctrDeleteUser()
    {
        if (isset($_POST["delete-user"])) {
            $user = FormsModel::mdlBringData("usuario", "token", $_POST["token-user"]);
            $compare = md5($user["correo"] . "+" . $_POST["current-pwd"]);
            if ($compare == $_POST["delete-user"]) {
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
}
