package com.sidneyrod.sidsbmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sidneyrod.sidsbmongodb.domain.User;
import com.sidneyrod.sidsbmongodb.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		
		User beatrice = new User(null, "Beatrice Rodrigues", "beatrice@gmail.com");
		User michael = new User(null, "Michael Rodrigues", "michael@gmail.com");
		User mark = new User(null, "Mark Rodrigues", "mark@gmail.com");
		
		userRepository.saveAll(Arrays.asList(beatrice, michael, mark));
		
	}
}
