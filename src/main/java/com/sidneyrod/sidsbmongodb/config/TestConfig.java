package com.sidneyrod.sidsbmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sidneyrod.sidsbmongodb.domain.Post;
import com.sidneyrod.sidsbmongodb.domain.User;
import com.sidneyrod.sidsbmongodb.dto.AuthorDTO;
import com.sidneyrod.sidsbmongodb.repositories.PostRepository;
import com.sidneyrod.sidsbmongodb.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User beatrice = new User(null, "Beatrice Rodrigues", "beatrice@gmail.com");
		User michael = new User(null, "Michael Rodrigues", "michael@gmail.com");
		User mark = new User(null, "Mark Rodrigues", "mark@gmail.com");
		
		userRepository.saveAll(Arrays.asList(beatrice, michael, mark));
		
		Post post1 = new Post(null, sdf.parse("12/01/2021"), "On Vacation", "Traveling to rest!", new AuthorDTO(beatrice));
		Post post2 = new Post(null, sdf.parse("16/01/2021"), "Backing", "Returning to home!", new AuthorDTO(beatrice));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		beatrice.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(beatrice);
		
	}
}
