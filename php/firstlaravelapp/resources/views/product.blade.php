<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- Fontawesome -->
    <script src="https://kit.fontawesome.com/e632f1f723.js" crossoringin="anonymous"></script>
</head>

<body>
    <center>
        <h1>All products</h1>
        <table class="table table-sm table-hover table-bordered table-responsive-lg">
            <tr>
                <th>#</th>
                <th>Product title</th>
                <th>Product description</th>
                <th>Product image</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>
            @foreach($data as $product)
                <tr>
                    <td>{{$product->id}}</td>
                    <td>{{$product->title}}</td>
                    <td>{{$product->description}}</td>
                    <td><img src="imagesP/{{$product->image}}" alt="image" width="100px" height="100px"></td>
                    <td><a onclick="return confirm('Are you sure?');" class="btn btn-danger"
                            href="{{url('/delete_product/' . $product->id)}}"><i class="fas fa-trash"></i></a></td>
                    <td><a class="btn btn-warning" href="{{url('/update_product/' . $product->id)}}"><i
                                class="fas fa-edit"></i></a></td>
                </tr>
            @endforeach

        </table>
        <a class="btn btn-primary" href="{{url('/indexP')}}">Add new product</a>
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