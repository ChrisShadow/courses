<?php
function assets($path=""){
    //$request->getPublicUrl(): /phpcourse/MVC2/resources/assets/style.css
    //obtiene la ruta y concatena a los archivos en assets
    $url=App::getPath()."/resources/assets/{$path}";
    $url=preg_replace('#/+#','/',$url);//en caso de soble barra
    return $url;
}

//Mismo que arriba solo que todas, cualquiera en general
function url($path=""){
    $url=App::getPath().$path;
    $url=preg_replace('#/+#','/',$url);
    return $url;
}

function view($path="",$data=[]){
    $url="./resources/Views/";
    $path=str_replace(".","/",$path);
    foreach($data as $key =>$value){
        /*In PHP language, $(dollar sign) is used to store variable data. 
        $$ can be used to store a variable of a variable. Data stored in $ is 
        fixed while data stored in $$(double dollar sign) can be changed dynamically.
        */
        $$key=$value;
    }
    return require_once $url.$path.".php";
}


?>