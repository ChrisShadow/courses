<?php
class FormsController
{
    static public function ctrRegister()
    {
        if (isset($_POST["reg-name"])) {
            return "ok";
            //return $_POST["reg-name"] . "<br>" . $_POST["reg-lastn"] . "<br>" . $_POST["reg-email"] . "<br>" . $_POST["reg-pss"] . "<br>";
        }
    }
}
