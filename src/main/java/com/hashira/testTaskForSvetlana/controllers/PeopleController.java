package com.hashira.testTaskForSvetlana.controllers;

import com.hashira.testTaskForSvetlana.dto.PersonDTO;
import com.hashira.testTaskForSvetlana.entity.Person;
import com.hashira.testTaskForSvetlana.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("api")
public class PeopleController {

    private PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    @GetMapping("users/{id}")
    public PersonDTO sendPerson(@PathVariable(name = "id") Long id){
        return convertToDTO(peopleService.findById(id));
    }

    private PersonDTO convertToDTO(Person person){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName(person.getName());
        personDTO.setSurname(person.getSurname());
        if (person.getBirthday() != null) {
            personDTO.setAge(Period.between(person.getBirthday(),LocalDate.now()).getYears());
        }
        return personDTO;
    }

}
