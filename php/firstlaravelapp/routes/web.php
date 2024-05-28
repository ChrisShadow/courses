<?php

use App\Http\Controllers\HomeController;
use Illuminate\Support\Facades\Route;

Route::get('/home', function () {
    return view('home');
});
Route::get('/', function () {
    return view('welcome');
});
route::get('/indexP', [HomeController::class, 'index']);
route::post('/add_product', [HomeController::class, 'add_product']);
route::get('show_product', [HomeController::class, 'show_product']);
route::get('/delete_product/{id}', [HomeController::class, 'delete_product']);
route::get('/update_product/{id}', [HomeController::class, 'update_product']);
route::post('/edit_product/{id}', [HomeController::class, 'edit_product']);