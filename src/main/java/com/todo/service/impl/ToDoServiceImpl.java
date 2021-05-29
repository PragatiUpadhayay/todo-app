package com.todo.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.dao.ToDoRepository;
import com.todo.model.ToDo;
import com.todo.service.ToDoService;

@Service
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	ToDoRepository repository;

	@Override
	public List<ToDo> getAll() {
		return repository.findAll();
	}

	@Override
	public ToDo save(ToDo toDo) {
		return repository.save(toDo);
	}

	@Override
	public ToDo update(ToDo toDo) {
		if (toDo != null) {
			ToDo existing = repository.findById(toDo.getId()).orElse(null);
			if (existing != null) {
				BeanUtils.copyProperties(toDo, existing);
				return repository.saveAndFlush(existing);
			}
		}
		return null;
	}

	@Override
	public ToDo getById(String id) {
		if (!StringUtils.isBlank(id)) {
			return repository.findById(id).orElse(null);
		}
		return null;
	}

	@Override
	public boolean deleteById(String id) {
		if (!StringUtils.isBlank(id)) {
			boolean exists = repository.existsById(id);
			if (exists) {
				repository.deleteById(id);
				return true;
			}
		}
		return false;
	}

}
