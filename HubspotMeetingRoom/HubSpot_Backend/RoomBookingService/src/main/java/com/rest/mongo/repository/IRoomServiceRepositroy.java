package com.rest.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rest.mongo.model.roomService;


@Repository
public interface IRoomServiceRepositroy extends MongoRepository<roomService, String> {

}
