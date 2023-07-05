<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MV2</title>
    <!-- En este caso tenemos Bootstrap -->
    <link rel="stylesheet" href="<?=assets('style.css')?>">
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Fontawesome -->
    <script src="https://kit.fontawesome.com/e632f1f723.js" crossoringin="anonymous"></script>
</head>
<body>
    <div class="container-fluid">
        <h3 class="text-center py-3">Example two of OO MVC</h3>
    </div>
    
    <div class="container-fluid bg-light">
        <div class="container">
            <ul class="nav nav-justified py-2 nav-pills">

                <li class="nav-item">
                    <a class="nav-link " href=<?=url('/api/5')?>>Home</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href=<?=url('/api/4')?>>Register</a>
                </li>
                
                <li class="nav-item">   
                    <a class="nav-link" href=<?=url('/api/3')?>>Log in</a>
                </li>
                
                <li class="nav-item">
                    <!-- data-toggle="modal" data-target="#logoutModal" -->
                    <a class="nav-link" href=<?=url('/api/2')?> >Log out</a>
                </li>
            </ul>
        </div>

    </div>
</body>
</html>