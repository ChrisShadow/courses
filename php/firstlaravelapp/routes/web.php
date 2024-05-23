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