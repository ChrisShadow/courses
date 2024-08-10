<?php

namespace App\Http\Controllers;

use App\Models\Task;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Illuminate\Foundation\Auth\Access\AuthorizesRequests;

/**
 * @OA\Info(title="API de Gestión de Tareas", version="1.0")
 */
class TaskController extends Controller
{
    use AuthorizesRequests;
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

        // Devuelve todas las tareas del usuario autenticado en formato JSON
        return response()->json(auth()->user()->tasks);

        /* $tasks = Task::all();
        return response()->json($tasks); */
    }

    /**
     * @OA\Post(
     *     path="/api/tasks/create",
     *     summary="Crear nueva tarea",
     *     @OA\RequestBody(
     *         required=true,
     *         @OA\JsonContent(
     *             @OA\Property(property="title", type="string"),
     *             @OA\Property(property="description", type="string"),
     *            @OA\Property(property="user_id", type="integer")
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
            'title' => 'required|string|max:255',
            'description' => 'nullable|string',
            'user_id' => 'required|integer',
        ]);

        // Crea una nueva tarea y la asocia con el usuario autenticado
        $task = auth()->user()->tasks()->create($request->all());

        return response()->json($task, 201); // Devuelve la tarea creada en formato JSON

        /* $request->validate([
            'title' => 'required',
            'description' => 'nullable',
        ]);

        $task = Task::create($request->all());

        return response()->json($task, 201); */
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
    public function show(Task $task)
    {
        // Verifica que la tarea pertenezca al usuario autenticado
        $this->authorize('view', $task);

        return response()->json($task); // Devuelve la tarea en formato JSON
    }
    /* public function show($id)
    {
        $task = Task::find($id);
        if (!$task) {
            return response()->json(['message' => 'Tarea no encontrada'], 404);
        }
        return response()->json($task);
    } */

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
     *             @OA\Property(property="description", type="string"),
     *            @OA\Property(property="user_id", type="integer")
     *         )
     *     ),
     *     @OA\Response(
     *         response=200,
     *         description="Tarea actualizada"
     *     )
     * )
     */
    public function update(Request $request, Task $task)
    {
        $this->authorize('update', $task);

        $request->validate([
            'title' => 'required|string|max:255',
            'description' => 'nullable|string',
            'user_id' => 'required|integer',
        ]);

        $task->update($request->all());

        return response()->json($task); // Devuelve la tarea actualizada en formato JSON
    }
    /* public function update(Request $request, $id)
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
    } */

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
    public function destroy(Task $task)
    {
        $this->authorize('delete', $task);

        $task->delete();

        return response()->json(null, 204); // Devuelve una respuesta vacía indicando que la tarea fue eliminada
    }
    /* public function destroy($id)
    {
        $task = Task::find($id);
        if (!$task) {
            return response()->json(['message' => 'Tarea no encontrada'], 404);
        }

        $task->delete();

        return response()->json(['message' => 'Tarea eliminada']);
    } */
}

