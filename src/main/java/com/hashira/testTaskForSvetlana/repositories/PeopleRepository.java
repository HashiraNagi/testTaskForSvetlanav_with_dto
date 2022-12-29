package com.hashira.testTaskForSvetlana.repositories;

import com.hashira.testTaskForSvetlana.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PeopleRepository extends JpaRepository<Person,Long> {

}
