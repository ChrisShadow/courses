<?php
if (isset($_GET["id"])) {
    $item = "id";
    $value = $_GET["id"];
    $user = FormsController::ctrBringData($item, $value);
    //print_r($user);
}
?>

<div class="d-flex justify-content-center">
    <form class="form-horizontal p-5 bg-light" method="post">
        <div class="form-group">
            <div class="col-sm-10">
                <input type="text" class="form-control my-2" id="name" name="edit-name" placeholder="Enter a name"
                    value="<?php echo $user["nombre"]; ?>">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-10">
                <input type="text" class="form-control my-2" id="lname" name="edit-lastn"
                    placeholder="Enter a last name" value="<?php echo $user["apellido"]; ?>">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-10">
                <input type="email" class="form-control my-2" id="email" name="edit-email" placeholder="Enter email"
                    value="<?php echo $user["correo"]; ?>">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-10">
                <input type="password" class="form-control my-2" id="pwd" name="edit-pss" placeholder="Enter password">
                <input type="hidden" name="current-pwd" value="<?php echo $user["clave"]; ?>">
                <input type="hidden" name="id-user" value="<?php echo $user["id"]; ?>">
            </div>
        </div>
        <!-- <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox my-2">
                    <label><input type="checkbox"> Remember me</label>
                </div>
            </div>
        </div> -->

        <?php
        $edit = FormsController::ctrEditUser();
        if ($edit == "ok") {
            echo '<script>
                if (window.history.replaceState) {
                    window.history.replaceState(null, null, window.location.href);
                }
                </script>';
            echo '<div class="alert alert-success mt-2">User updated successfully</div>
                
                <script>
                setTimeout(function() {
                    window.location = "index.php?page=index";
                }, 3000);
                </script>';
        }
        ?>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10 my-2">
                <button type="submit" class="btn btn-primary">Apply</button>
            </div>
        </div>
    </form>
</div>