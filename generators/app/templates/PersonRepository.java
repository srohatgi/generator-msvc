package com.<%=orgName%>.dao;

import com.<%=orgName%>.domain.Person;
import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public interface PersonRepository extends MongoRepository<Person, String> {

    Person findByFirstName(String firstName);
    List<Person> findByLastName(String lastName);

}
