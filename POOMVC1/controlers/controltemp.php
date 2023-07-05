<?php


Class TempController{
    #Llamada a la plantilla
    public function ctrBringTemp(){
        //invoca el archivo  que contiene codigo html-php
        include "views/templates.php";
        
    }

    #Interacción
    public function linkControllerPages(){

        if(isset($_GET["action"])){
            $urlController= $_GET["action"];
        }else{
            $urlController="index";
        }

        
        #echo "$urlController";
        $resp= (new PagesLinks)->linkModelPages($urlController);   
        /*
        The difference between static and non-static is that the first one doesn't need instantiation so you can call the classname then append :: to it and call the method immediately. Like so:
        ClassName::method();
        and if the method is not static you need to initialize it like so:
        $var = new ClassName();
        $var->method();
         */
        include $resp;                                    
    }

}


?>