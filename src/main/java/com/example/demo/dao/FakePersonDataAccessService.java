package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<>();

    @Override
    public String insertPerson(UUID uid, Person person) {
        DB.add(new Person(uid, person.getName()));
        return "Created person " + uid.toString();
    }

    @Override
    public List<Person> displayAllPerson() {
        return DB;
    }


}
