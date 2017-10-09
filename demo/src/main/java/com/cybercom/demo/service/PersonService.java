package com.cybercom.demo.service;

import com.cybercom.demo.model.Person;
import com.cybercom.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public Person createPerson(@NotNull Person person) {
        Person temp = null;

        try {
            temp = personRepository.save(person);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return temp;
    }

}
