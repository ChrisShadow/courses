<?php
$user = FormsController::ctrBringData();
//var_dump($user);
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
                        <button class="btn btn-warning">
                            <i class="fas fa-edit"></i>
                        </button>
                        <button class="btn btn-danger">
                            <i class="fas fa-trash"></i>
                        </button>
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