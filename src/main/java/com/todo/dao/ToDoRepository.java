package com.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, String> {

}
