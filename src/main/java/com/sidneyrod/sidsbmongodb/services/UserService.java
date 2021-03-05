package com.sidneyrod.sidsbmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidneyrod.sidsbmongodb.domain.User;
import com.sidneyrod.sidsbmongodb.dto.UserDTO;
import com.sidneyrod.sidsbmongodb.repositories.UserRepository;
import com.sidneyrod.sidsbmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
		}
	
	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}

	
}
