package com.<%=orgName%>.dao;

import com.<%=orgName%>.domain.Person;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends PagingAndSortingRepository<Person, String> {

	List<Person> findByLastName(@Param("name") String name);

}
