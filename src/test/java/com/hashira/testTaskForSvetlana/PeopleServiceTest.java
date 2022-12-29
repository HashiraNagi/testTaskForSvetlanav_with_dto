package com.hashira.testTaskForSvetlana;


import com.hashira.testTaskForSvetlana.entity.Person;
import com.hashira.testTaskForSvetlana.services.PeopleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PeopleServiceTest {

    @Autowired
    private PeopleService peopleService;

    @Test
    public void findByIdTest(){
        Person person1 = peopleService.findById(1L);
        Person person2 = peopleService.findById(2L);
        Person person3 = peopleService.findById(3L);

        assertThat(person1).isEqualTo(new Person(1L,"mock_name_1","mock_surname_1", LocalDate.parse("1990-12-12")));
        assertThat(person2).isEqualTo(new Person(2L,"mock_name_2","mock_surname_2",LocalDate.parse("2003-12-12")));
        assertThat(person3).isEqualTo(new Person(3L,"mock_name_3","mock_surname_3",LocalDate.parse("2000-12-12")));

    }

    @Test
    public void findNonexistentPersonByIdTest(){
        Person person = peopleService.findById(4L);
        assertThat(person).isEqualTo(new Person());
    }

}
