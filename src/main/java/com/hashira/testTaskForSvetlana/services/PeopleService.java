package com.hashira.testTaskForSvetlana.services;

import com.hashira.testTaskForSvetlana.entity.Person;
import com.hashira.testTaskForSvetlana.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PeopleService {

    private PeopleRepository personRepository;

    @Autowired
    public PeopleService(PeopleRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person findById(Long id){
        return personRepository.findById(id).orElse(new Person());
    }

}
