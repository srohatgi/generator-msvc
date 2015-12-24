package com.<%=orgName%>.services;

import com.<%=orgName%>.dao.PersonRepository;
import com.<%=orgName%>.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class PersonServiceImpl implements PersonService {

    private static Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findPersonByLastName(String lastName) {
        logger.debug("name = {}", lastName);
        List<Person> personList = new ArrayList<>();
        personList.addAll(personRepository.findByLastName(lastName));
        return personList;
    }

    @Override
    public Person add(Person person) {
        personRepository.save(person);
        return personRepository.findOne(person.getId());
    }

    @Override
    public Person get(String id) {
        return personRepository.findOne(id);
    }

    @Override
    public Person update(Person person) {
        if (personRepository.findOne(person.getId()) != null) {
            personRepository.save(person);
        }
        return personRepository.findOne(person.getId());
    }

    @Override
    public void delete(String id) {
        if (personRepository.findOne(id) != null) {
            personRepository.delete(id);
        }
    }

}
