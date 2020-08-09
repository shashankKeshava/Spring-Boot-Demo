package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public int deletePersonById(UUID uid) {
        Optional<Person> fetchPerson = selectPersonById(uid);
        if (fetchPerson.isPresent()) {
            DB.remove(fetchPerson.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePersonById(UUID uid, Person newPerson) {
        return selectPersonById(uid)
                .map(person -> {
                    int indexToDelete = DB.indexOf(person);
                    if (indexToDelete >= 0) {
                        DB.set(indexToDelete, new Person(uid, newPerson.getName()));
                        return 1;
                    } else {
                        return 0;
                    }
                }).orElse(0);
    }

    @Override
    public Optional<Person> selectPersonById(UUID uid) {
        return DB.stream()
                .filter(person -> person.getId().equals(uid))
                .findFirst();
    }


}
