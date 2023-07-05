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
        .container span{
            font-weight: 500;
        }
    </style>

</head>
<body>

    <div class="container-fluid">
        <h3 class="text-center py-3">Datos para el Cargo</h3>
    </div>
    
    <div class="container-fluid">
        <div class="container pt-3 d-flex-inline text-center">
            <?php
                $cargo=new Cargo();
                $cargo-> nombre="Ejecutivo de operaciones";
                $cargo-> relacionVerticalArriba="Director Ejecutivo";
                $cargo-> relacionVerticalAbajo="Jefe de operaciones legales";
                $cargo-> funcion="1:Planificar eventos diarios, 2: Monitorear avances"; 
                $cargo-> lugarTrabajo="Oficina Central, Zona IPS central";
                $cargo-> dia="Lunes,Martes,Jueves y Viernes";
                $cargo-> horainicio="8:00 am";
                $cargo-> horafin="17:00 pm";
                $cargo-> tipoFuncionario="Asalariado";
                $cargo-> pagoFuncionario="Salario";
                $cargo-> divisa="Dólares";
                $cargo-> porcentajeComision="En base a operaciones y horas extras";
                $cargo-> periodoPago="Semanal";
                $cargo-> show();
            ?>
        </div>
    </div>
</body>
</html>