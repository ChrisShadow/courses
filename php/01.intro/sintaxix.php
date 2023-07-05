<?php

/*the first five fibonacci numbers
$accu=-1;
$lap=0;
$sentinel=array();
$arrlength=count($sentinel);     
print"<h1>The first six fibonacci numbers</h1>";

**Iterative Control
for($arrlength=count($sentinel);$arrlength<7;$lap++){
    if($accu==-1){
        $accu++;
        print"0+0=$accu";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }elseif($accu==0){
        $accu++;
        echo"<br>1+0=$accu";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }
    elseif($accu==1){
        $accu=$accu+1;
        echo"<br>1+1=$accu";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }
    elseif($accu==2){
        $accu=$accu+1;
        echo"<br>2+1=$accu";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }
    elseif($accu==3){
        $accu=$accu+2;
        echo"<br>3+2=$accu";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }
    elseif($accu==5){
        $accu=$accu+3;
        echo"<br>","5+3=$accu","<br>To infinity...";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }else{
        echo"<br>These are the first $arrlength numbers of the fibonacci sequence";
        break;
    }
}


**loop control: While(initial condition) and do While(final condition)
do{
    if($accu==-1){
        $accu++;
        print"0+0=$accu";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }elseif($accu==0){
        $accu++;
        echo"<br>1+0=$accu";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }
    elseif($accu==1){
        $accu=$accu+1;
        echo"<br>1+1=$accu";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }
    elseif($accu==2){
        $accu=$accu+1;
        echo"<br>2+1=$accu";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }
    elseif($accu==3){
        $accu=$accu+2;
        echo"<br>3+2=$accu";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }
    elseif($accu==5){
        $accu=$accu+3;
        echo"<br>","5+3=$accu","<br>To infinity...";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }else{
        echo"<br>These are the first $arrlength numbers of the fibonacci sequence";
        break;
    }
    $lap++;
}while ($arrlength<7);

while ($arrlength<7){
    if($accu==-1){
        $accu++;
        print"0+0=$accu";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }elseif($accu==0){
        $accu++;
        echo"<br>1+0=$accu";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }
    elseif($accu==1){
        $accu=$accu+1;
        echo"<br>1+1=$accu";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }
    elseif($accu==2){
        $accu=$accu+1;
        echo"<br>2+1=$accu";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }
    elseif($accu==3){
        $accu=$accu+2;
        echo"<br>3+2=$accu";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }
    elseif($accu==5){
        $accu=$accu+3;
        echo"<br>","5+3=$accu","<br>To infinity...";
        $sentinel[]=$accu;
        $arrlength=count($sentinel);
    }else{
        echo"<br>These are the first $arrlength numbers of the fibonacci sequence";
        break;
    }
    $lap++;
}
echo"<br>Lap $lap of $arrlength <br>Array length: $arrlength <br>";
print_r($sentinel);*/



//multiple condition control
/*$day="Tuesday";

switch($day){
    case 'Saturday':
        echo "$day: Just work";
    break;

    case 'Sunday':
        echo "$day: Day off";
    break;

    default: echo "$day: Work and College day";
}*/


//control condición simple, compuesto anidado, determina si es positivo, negativo o neutro y quién es mayor o menor
/*$nro1=-100;
$nro2=100;
$txt1="";
$txt2="";

if($nro1<0 and $nro2>0){
    $txt1="$nro1 es negativo y $nro2 es positivo";
    if($nro1>$nro2){
        $txt2="$nro1 mayor a $nro2";
    }else if($nro1<$nro2){
        $txt2="$nro1 menor a $nro2";
    }else{
        $txt2="$nro1 y $nro2 tienen el mismo valor";
    }
}
else if($nro1>0 and $nro2<0){
    $txt1="$nro1 es positivo y $nro2 es negativo";
    if($nro1<$nro2){
        $txt2="$nro1 menor a $nro2";
    }else if($nro1>$nro2){
        $txt2="$nro1 mayor a $nro2";
    }else{
        $txt2="$nro1 y $nro2 tienen el mismo valor";
    }   
}
else if($nro1<0 and $nro2<0){
    $txt1="$nro1 y $nro2 son negativos";
    if($nro1>$nro2){
        $txt2="$nro1 mayor a $nro2";
    }else if($nro1<$nro2){
        $txt2="$nro1 menor a $nro2";
    }else{
        $txt2="$nro1 y $nro2 tienen el mismo valor";
    }
}
else if($nro1>0 and $nro2>0){
    $txt1="$nro1 y $nro2 son positivos";
    if($nro1<$nro2){
        $txt2="$nro1 menor a $nro2";
    }else if($nro1>$nro2){
        $txt2="$nro1 mayor a $nro2";
    }else{
        $txt2="$nro1 y $nro2 tienen el mismo valor";
    }   
}
else if($nro1==0 and $nro2<0){
    $txt1="$nro1 es neutro y $nro2 es negativo";
    if($nro1<$nro2){
        $txt2="$nro1 menor a $nro2";
    }else if($nro1>$nro2){
        $txt2="$nro1 mayor a $nro2";
    }else{
        $txt2="$nro1 y $nro2 tienen el mismo valor";
    } 
}
else if($nro1==0 and $nro2>0){
    $txt1="$nro1 es neutro y $nro2 es positivo";
    if($nro1<$nro2){
        $txt2="$nro1 menor a $nro2";
    }else if($nro1>$nro2){
        $txt2="$nro1 mayor a $nro2";
    }else{
        $txt2="$nro1 y $nro2 tienen el mismo valor";
    } 
}
else if($nro1<0 and $nro2==0){
    $txt1="$nro1 es negativo y $nro2 es neutro";
    if($nro1<$nro2){
        $txt2="$nro1 menor a $nro2";
    }else if($nro1>$nro2){
        $txt2="$nro1 mayor a $nro2";
    }else{
        $txt2="$nro1 y $nro2 tienen el mismo valor";
    } 
}
else if($nro1>0 and $nro2==0){
    $txt1="$nro1 es positivo y $nro2 es neutro";
    if($nro1<$nro2){
        $txt2="$nro1 menor a $nro2";
    }else if($nro1>$nro2){
        $txt2="$nro1 mayor a $nro2";
    }else{
        $txt2="$nro1 y $nro2 tienen el mismo valor";
    } 
}
else{
    $txt1="ambos neutro,$nro1 y $nro2";
}
echo"$txt1<br>$txt2"*/

/*funciones
function saludo(){
    echo"hello there<br>";
}

saludo();

function despedida($adios){
    echo $adios."<br>";

}
despedida("See you soon");

function ret($retu){
    return $retu;
}

echo ret("Ok, bye")*/

/*variables y Var_DUMP()
$nro=5;
$txt="Variable numérica:";
$txt2="";
$bool=null;
*arreglos con propiedades
$opc=array("verdadero"=>"1: Sí","falso"=>" : No");*
**de tipo objeto
$opc=(object)["verdadero"=>"1: Sí","falso"=>" : No"];

echo "$txt<br>";
var_dump($txt);
echo"<br><br>";
echo"¿$nro es mayor a 5? $opc->verdadero | $opc->falso<br>";
var_dump($nro);
echo"<br><br>";
var_dump($opc);
if($nro>5){
    $bool=true;
    var_dump($bool);
    $txt2="$bool: verdadero ($nro es mayor a 5)";
    var_dump($nro);
}else{
    $bool=false; //valor vacío=0
    echo"<br><br>";
    var_dump($bool);
    $txt2="$bool: falso ($nro es no mayor a 5)";
    echo"<br><br>";
    var_dump($nro);
}
echo"<br><br>";
print"$txt2 <br>";
var_dump($txt2);*/

/*sintaxis
justo one
print"<h1>This is a hello world program!</h1>";
more than one
echo"<p>hey</p>","<h2>there</h2>";*/
?>