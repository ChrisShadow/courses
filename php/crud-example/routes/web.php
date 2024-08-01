<?php

use Illuminate\Support\Facades\Route;

use App\Http\Controllers\TaskViewController;

Route::get('/', function () {
    return view('welcome');
});

Route::resource('tasks', TaskViewController::class);


