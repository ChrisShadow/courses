<?php

namespace App\Http\Controllers;

use App\Models\Task;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;

/**
 * @OA\Info(title="API de Gestión de Tareas", version="1.0")
 */
class TaskController extends Controller
{
    /**
     * @OA\Get(
     *     path="/api/tasks",
     *     summary="Obtener lista de tareas",
     *     @OA\Response(
     *         response=200,
     *         description="Lista de tareas"
     *     )
     * )
     */
    public function index()
    {
        $tasks = Task::all();
        return response()->json($tasks);
    }

    /**
     * @OA\Post(
     *     path="/api/tasks",
     *     summary="Crear nueva tarea",
     *     @OA\RequestBody(
     *         required=true,
     *         @OA\JsonContent(
     *             @OA\Property(property="title", type="string"),
     *             @OA\Property(property="description", type="string")
     *         )
     *     ),
     *     @OA\Response(
     *         response=201,
     *         description="Tarea creada"
     *     )
     * )
     */
    public function store(Request $request)
    {
        $request->validate([
            'title' => 'required',
            'description' => 'nullable',
        ]);

        $task = Task::create($request->all());

        return response()->json($task, 201);
    }

    /**
     * @OA\Get(
     *     path="/api/tasks/{id}/show",
     *     summary="Obtener tarea por ID",
     *     @OA\Parameter(
     *         name="id",
     *         in="path",
     *         required=true,
     *         @OA\Schema(type="integer")
     *     ),
     *     @OA\Response(
     *         response=200,
     *         description="Tarea obtenida"
     *     )
     * )
     */
    public function show($id)
    {
        $task = Task::find($id);
        if (!$task) {
            return response()->json(['message' => 'Tarea no encontrada'], 404);
        }
        return response()->json($task);
    }

    /**
     * @OA\Put(
     *     path="/api/tasks/{id}/update",
     *     summary="Actualizar tarea",
     *     @OA\Parameter(
     *         name="id",
     *         in="path",
     *         required=true,
     *         @OA\Schema(type="integer")
     *     ),
     *     @OA\RequestBody(
     *         required=true,
     *         @OA\JsonContent(
     *             @OA\Property(property="title", type="string"),
     *             @OA\Property(property="description", type="string")
     *         )
     *     ),
     *     @OA\Response(
     *         response=200,
     *         description="Tarea actualizada"
     *     )
     * )
     */
    public function update(Request $request, $id)
    {
        $task = Task::find($id);
        if (!$task) {
            return response()->json(['message' => 'Tarea no encontrada'], 404);
        }

        $request->validate([
            'title' => 'required',
            'description' => 'nullable',
        ]);

        $task->update($request->all());

        return response()->json($task);
    }

    /**
     * @OA\Delete(
     *     path="/api/tasks/{id}/delete",
     *     summary="Eliminar tarea",
     *     @OA\Parameter(
     *         name="id",
     *         in="path",
     *         required=true,
     *         @OA\Schema(type="integer")
     *     ),
     *     @OA\Response(
     *         response=200,
     *         description="Tarea eliminada"
     *     )
     * )
     */
    public function destroy($id)
    {
        $task = Task::find($id);
        if (!$task) {
            return response()->json(['message' => 'Tarea no encontrada'], 404);
        }

        $task->delete();

        return response()->json(['message' => 'Tarea eliminada']);
    }
}


/* 
class TaskController extends Controller
{
    /**
     * Display a listing of the resource.
     *
    public function index()
    {
        $tasks = Task::all();
        return view('tasks.index', compact('tasks'));
    }

    
      Show the form for creating a new resource.
     
    public function create()
    {
        return view('tasks.create');
    }

    
      Store a newly created resource in storage.
     
    public function store(Request $request)
    {
        $request->validate([
            'title' => 'required',
            'description' => 'nullable',
        ]);

        Task::create($request->all());

        return redirect()->route('tasks.index')->with('success', 'Task created successfully.');
    }

    
      Display the specified resource.
     
    public function show(Task $task)
    {
        return view('tasks.show', compact('task'));
    }

    
     Show the form for editing the specified resource.
     
    public function edit(Task $task)
    {
        return view('tasks.edit', compact('task'));
    }

    
      Update the specified resource in storage.
     
    public function update(Request $request, Task $task)
    {
        $request->validate([
            'title' => 'required',
            'description' => 'nullable',
        ]);

        $task->update($request->all());

        return redirect()->route('tasks.index')->with('success', 'Task updated successfully.');
    }

    
     Remove the specified resource from storage.
     
    public function destroy(Task $task)
    {
        $task->delete();

        return redirect()->route('tasks.index')->with('success', 'Task deleted successfully.');
    }
} */
