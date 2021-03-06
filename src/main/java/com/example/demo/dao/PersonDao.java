package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    String insertPerson(UUID uid, Person person);

    default String insertPerson(Person person) {
        UUID uid = UUID.randomUUID();
        return insertPerson(uid, person);
    }

    List<Person> displayAllPerson();

    int deletePersonById(UUID uid);

    int updatePersonById(UUID uid, Person person);

    Optional<Person> selectPersonById(UUID uid);
}