package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todo.model.ToDo;
import com.todo.service.ToDoService;

@RestController
@RequestMapping("to-do")
public class ToDoController {
	@Autowired
	private ToDoService toDoService;

	@GetMapping("all")
	public List<ToDo> getAllToDos() {
		return toDoService.getAll();
	}

	@PostMapping
	public ToDo addToDo(@RequestBody ToDo toDo) {
		ToDo savedToDo = toDoService.save(toDo);
		return savedToDo;
	}

	@PutMapping
	public ToDo updateToDo(@RequestBody ToDo toDo) {
		ToDo updatedToDo = toDoService.update(toDo);
		return updatedToDo;
	}

	@GetMapping("/{id}")
	public ToDo findToDoById(@RequestParam(value = "id") String id) {
		ToDo toDo = toDoService.getById(id);
		return toDo;
	}

	@DeleteMapping("/{id}")
	public String deleteToDoById(@RequestParam(value = "id") String id) {
		boolean deleted = toDoService.deleteById(id);
		if (deleted) {
			return String.format("Todo with id: %s, deleted succesfully", id);
		}
		return String.format("Could not delete Todo with id: %s", id);
	}
}
