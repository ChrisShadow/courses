<?php
class PagesLinks
{

    public function linkModelPages($urlModel)
    {

        if ($urlModel == "reg" || $urlModel == "in" || $urlModel == "out" || $urlModel == "edit") {

            $view = "views/pages/" . $urlModel . ".php";

        } else if ($urlModel == "index") {
            $view = "views/pages/index.php";
        } else {
            $view = "views/pages/error404.php";
        }

        return $view;
    }
}
?>