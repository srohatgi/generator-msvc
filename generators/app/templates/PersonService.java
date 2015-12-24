package com.<%=orgName%>.services;

import com.<%=orgName%>.domain.Person;

import java.util.List;

public interface PersonService {

    List<Person> findPersonByLastName(String name);

    Person add(Person person);

    Person get(String id);

    Person update(Person person);

    void delete(String id);

}
