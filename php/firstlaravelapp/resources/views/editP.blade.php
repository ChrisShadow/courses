<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- Fontawesome -->
    <script src="https://kit.fontawesome.com/e632f1f723.js" crossoringin="anonymous"></script>
    <style type="text/css">
        .div-deg {
            padding: 10px;
        }
    </style>

</head>

<body>
    <center>
        <h1>Edit Product</h1>
        <form action="{{url('/edit_product', $data->id)}}" method="Post" enctype="multipart/form-data">
            @csrf
            <div class="div-deg">
                <label for="title-up">Product title: </label>
                <input type="text" id="title-up" name="uptitle" value="{{$data->title}}">
            </div>
            <div class="div-deg">
                <label for="description-up">Product description: </label>
                <textarea name="updescription" id="description-up">
                    {{$data->description}}
                </textarea>
            </div>
            <div class="div-deg">
                <label>Current image </label>
                <img src="/imagesP/{{$data->image}}" alt="image" width="100px" height="100px">
            </div>
            <div class="div-deg">
                <label for="mage-up">Change image: </label>
                <input type="file" id="image-up" name="upimage" value>
            </div>
            <div class="div-deg">
                <input class="btn btn-primary" type="submit" value="Edit product">
            </div>

        </form>
        <br>
        <a class="btn btn-success" href="{{url('/show_product')}}">Show product</a>
    </center>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
        crossorigin="anonymous"></script>
</body>

</html>