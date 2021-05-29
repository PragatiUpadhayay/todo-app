package com.todo.service;

import java.util.List;

import com.todo.model.ToDo;

public interface ToDoService {
	
	public List<ToDo> getAll();

	public ToDo save(ToDo toDo);

	public ToDo update(ToDo toDo);

	public ToDo getById(String id);

	public boolean deleteById(String id);

}
