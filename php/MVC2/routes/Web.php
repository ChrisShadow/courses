    <?php
    use Core\Route;
    Route::get('/',"MainController@index");
    Route::get('/api/{id}',function($route){
        echo $route['id'];
        return $route[
            'id'
        ];
    });
    Route::get('/persona/{id}',"MainController@show");
    //Route::post('/',"initial Post");
    Route::group('/producto',function(){
        Route::get('/id',function(){
            return view("index");
        });
        Route::get('/nombre/{nombre}',function($route){
            return view("producto.index",["nombre"=>$route['nombre']]);
        });
        //Route::post('/id',"producto id Post");
    });
    /*$routes =Route::getRoutes();
    print_r($routes[3]['class']);*/
?>
