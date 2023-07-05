<?php
    include_once './core/Request.php';
    include_once './core/Route.php';
    include_once './core/Utils.php';
    include_once './core/App.php';
    include_once './routes/Web.php';
    include_once './app/controller/MainController.php';

    use Core\Route;
    $request= new Request();
    App::assets($request->getPublicUrl());
    //echo App::getPath();
    $routes=Route::getRoutes();
    $url=$request->getUrl();
    $request->validate($routes,$url);

    /*echo $request-> getPublicUrl();
    echo "<br>Hi";*/
?>