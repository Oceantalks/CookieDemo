package com.cybercom.demo.repository;

import com.cybercom.demo.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findById(Long id);
    Person findByUserName(String userName);

}
