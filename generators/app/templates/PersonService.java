package com.<%=orgName%>.services;

import com.<%=orgName%>.dao.PersonRepository;
import com.<%=orgName%>.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PersonService {

    List<Person> findPersonByFirstName(String fname);

}
