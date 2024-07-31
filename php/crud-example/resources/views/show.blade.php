@extends('layout')

@section('content')
<h1>{{ $task->title }}</h1>
<p>{{ $task->description }}</p>
<a href="{{ route('tasks.edit', $task->id) }}">Edit</a>
<form action="{{ route('tasks.destroy', $task->id) }}" method="POST" style="display:inline">
    @csrf
    @method('DELETE')
    <button type="submit">Delete</button>
</form>
<a href="{{ route('tasks.index') }}">Back</a>
@endsection