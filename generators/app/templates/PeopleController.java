package com.<%=orgName%>.controllers.api;

import com.<%=orgName%>.domain.Person;
import com.<%=orgName%>.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PeopleController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Person> findPerson() {
        return personService.findPersonByFirstName("Joe");
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Person findPerson(@PathVariable("id") String id) {
        return new Person();
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public Person update(@RequestBody Person person) {
        return person;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {

    }

    @RequestMapping(method = RequestMethod.PUT)
    public Person create(@RequestBody Person person) {
        return person;
    }
}
