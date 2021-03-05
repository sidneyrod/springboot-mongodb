package com.sidneyrod.sidsbmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sidneyrod.sidsbmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
