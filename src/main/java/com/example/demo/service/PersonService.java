package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public String addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> listPersons() {
        return personDao.displayAllPerson();
    }

    public Optional<Person > getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePeron(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePersonById(UUID id, Person newPerson){
        return personDao.updatePersonById(id,newPerson);
    }

}
