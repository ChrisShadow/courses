<?php

use Illuminate\Support\Facades\Route;

use App\Http\Controllers\TaskViewController;

Route::get('/', function () {
    return view('welcome');
});

//Route::middleware(['auth'])->group(function () {
Route::resource('tasks', TaskViewController::class);
//});

/* Route::resource('tasks', TaskViewController::class); */


