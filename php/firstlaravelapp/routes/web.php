<?php

use App\Http\Controllers\HomeController;
use Illuminate\Support\Facades\Route;

Route::get('/home', function () {
    return view('home');
});
Route::get('/', function () {
    return view('welcome');
});
route::get('test', [HomeController::class, 'test']);