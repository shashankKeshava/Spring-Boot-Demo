package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {
    @Override
    public String insertPerson(UUID uid, Person person) {
        return null;
    }

    @Override
    public List<Person> displayAllPerson() {
        return List.of(new Person(UUID.randomUUID(),"From PostGres DB"));
    }

    @Override
    public int deletePersonById(UUID uid) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID uid, Person person) {
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID uid) {
        return Optional.empty();
    }
}
