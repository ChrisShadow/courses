<?php
if (!isset($_SESSION["validateLogin"])) {
    echo '<script>
        window.location = "index.php?action=in";
        </script>';
    return;
} else {
    if ($_SESSION["validateLogin"] != "ok") {
        echo '<script>
        window.location = "index.php?action=in";
        </script>';
        return;
    }
}

$user = FormsController::ctrBringData(null, null);
//var_dump($user);

//$edit = new FormsController();
//$edit->ctrEditUser();

?>

<table class="table table-striped">
    <thead>
        <tr>
            <th>#</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Email</th>
            <th>Fecha</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>

        <?php foreach ($user as $key => $value): ?>
            <tr>
                <td><?php echo ($key + 1); ?></td>
                <td><?php echo $value["nombre"]; ?></td>
                <td><?php echo $value["apellido"]; ?></td>
                <td><?php echo $value["correo"]; ?></td>
                <td><?php echo $value["fecha_registro"]; ?></td>
                <td>
                    <div class="btn-gruop">
                        <form method="post">
                            <a href="index.php?action=edit&token=<?php echo $value["token"]; ?>" class="btn btn-warning">
                                <i class="fas fa-edit"></i>
                            </a>
                            <input type="hidden" value="<?php echo $value["token"]; ?>" name="delete-user">
                            <button type="submit" class="btn btn-danger">
                                <i class="fas fa-trash"></i>
                            </button>
                            <?php
                            $delete = new FormsController();
                            $delete->ctrDeleteUser();
                            ?>
                        </form>
                    </div>
                </td>
            </tr>
        <?php endforeach; ?>
        <!-- <tr>
            <td>John</td>
            <td>Doe</td>
            <td>john@example.com</td>
            <td>10/05/2024</td>
            <td>
                <div class="btn-gruop">
                    <button class="btn btn-warning">
                        <i class="fas fa-edit"></i>
                    </button>
                    <button class="btn btn-danger">
                        <i class="fas fa-trash"></i>
                    </button>
                </div>
            </td>
        </tr> -->

    </tbody>
</table>