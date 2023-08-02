<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>RRHH-Cargo</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Fontawesome -->
    <script src="https://kit.fontawesome.com/e632f1f723.js" crossoringin="anonymous"></script>
    <style>
        .container span {
            font-weight: 500;
        }
    </style>

</head>

<body>

    <div class="container-fluid">
        <h3 class="text-center py-3">Datos para las lista horario</h3>
    </div>

    <div class="container-fluid">
        <div class="container pt-3 d-flex-inline text-center">
            <?php
            require_once "test/test.php";
            $test = new Test();
            $test->TestingMap();

            print("<table><tr><th>Sede</th><th>Horario</th></tr>");
            foreach ($test->listaH as $keyM => $value) {
                print("<tr><td>" + $keyM->show_data() + "</td><td>");
                foreach ($value as $keyA => $value) {
                    print(($keyA + 1) + " - " + $value->show_data() + "</td></tr>");
                }
            }
            print("</table>");
            ?>
        </div>
    </div>
</body>

</html>