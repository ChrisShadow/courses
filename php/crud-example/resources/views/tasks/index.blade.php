@extends('layout')

@section('content')
<h1>Your Tasks</h1>
<a href="{{ route('tasks.create') }}" class="btn btn-primary">Create Task</a>

@if ($message = Session::get('success'))
    <div class="alert alert-success">
        {{ $message }}
    </div>
@endif

<ul class="list-group mt-4">
    @foreach ($tasks as $task)
        <li class="list-group-item">
            <a href="{{ route('tasks.show', $task->id) }}">{{ $task->title }}</a>
            <span class="float-end">
                <a href="{{ route('tasks.edit', $task->id) }}" class="btn btn-secondary btn-sm">Edit</a>
                <form action="{{ route('tasks.destroy', $task->id) }}" method="POST" style="display:inline">
                    @csrf
                    @method('DELETE')
                    <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                </form>
            </span>
        </li>
    @endforeach
</ul>
@endsection