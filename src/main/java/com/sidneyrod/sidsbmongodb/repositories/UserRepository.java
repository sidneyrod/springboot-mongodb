package com.sidneyrod.sidsbmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sidneyrod.sidsbmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
