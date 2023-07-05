<?php
Class PagesLinks{

    public function linkModelPages($urlModel){

        if($urlModel=="reg" || $urlModel=="in" || $urlModel=="out"){

            $view="views/pages/".$urlModel.".php";

        }else if($urlModel=="index"){
            $view="views/pages/index.php";
        }else{
            $view="views/pages/index.php";
        }

        return $view;                                                                                                                                                                                                                                                                                           
    }
}
?>