package com.<%=orgName%>.controllers.api;

import com.<%=orgName%>.domain.Person;
import com.<%=orgName%>.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PeopleController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Person> findPersonByLastName(@RequestParam String lastName) {
        return personService.findPersonByLastName(lastName);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Person findPerson(@PathVariable("id") String id) {
        return personService.get(id);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public Person update(@RequestBody Person person) {
        return personService.update(person);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        personService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Person create(@RequestBody Person person) {
        return personService.add(person);
    }
}
