<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MVC Template</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Fontawesome -->
    <script src="https://kit.fontawesome.com/e632f1f723.js" crossoringin="anonymous"></script>
</head>
<body>

    <div class="container-fluid">
        <h3 class="text-center py-3">MVC Template Example</h3>
    </div>
    
    <div class="container-fluid bg-light">
        <div class="container">
            <ul class="nav nav-justified py-2 nav-pills">

                <li class="nav-item">
                    <a class="nav-link " href="index.php?">Home</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="index.php?action=reg">Register</a>
                </li>
                
                <li class="nav-item">   
                    <a class="nav-link" href="index.php?action=in">Log in</a>
                </li>
                
                <li class="nav-item">
                    <!-- data-toggle="modal" data-target="#logoutModal" -->
                    <a class="nav-link" href="index.php?action=out" >Log out</a>
                </li>
            </ul>
        </div>
    </div>
    
    <div class="container-fluid">
        <div class="container pt-3">
            <?php
                $mvc= new TempController();
                $mvc-> linkControllerPages();
            ?>
        </div>
    </div>

    
    <!-- <div class="modal" id="logoutModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4>Log Out <i class="fa fa-lock"></i></h4>
                </div>
                <div class="modal-body">
                    <p><i class="fa fa-question-circle"></i> Are you sure you want to log-off? <br /></p>
                    <div class="actionsBtns">
                        <form action="/logout" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input type="submit" class="btn btn-default btn-primary" data-dismiss="modal" value="Logout" />
                            <button class="btn btn-default" data-dismiss="modal">Cancel</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div> -->
</body>
</html>