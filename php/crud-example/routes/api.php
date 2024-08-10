<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\TaskController;

//Route::apiResource('tasks', TaskController::class);

/* Route::middleware('auth:sanctum')->group(function () {
    Route::apiResource('tasks', TaskController::class);
}); */

Route::get('/tasks', [TaskController::class, 'index']);
Route::post('/tasks/create', [TaskController::class, 'store']);
Route::get('/tasks/{id}/show', [TaskController::class, 'show']);
Route::put('/tasks/{id}/update', [TaskController::class, 'update']);
Route::delete('/tasks/{id}/delete', [TaskController::class, 'destroy']);
