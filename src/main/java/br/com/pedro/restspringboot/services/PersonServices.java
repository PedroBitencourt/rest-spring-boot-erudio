package br.com.pedro.restspringboot.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedro.restspringboot.entities.Person;
import br.com.pedro.restspringboot.exceptions.ResourceNotFoundException;
import br.com.pedro.restspringboot.repositories.PersonRepository;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll() {
        logger.info("Finding all people");
        
        return personRepository.findAll();
    }
   
    public Person findById(Long id) {
        logger.info("Finding one person!");
        
        return personRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }
    

    public Person create(Person person) {
        logger.info("Create Person");
        return personRepository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating Person");
        var entity = personRepository.findById(person.getId())
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
            
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(person);
        
    }
    public void delete(Long id) {
        logger.info("Deleting Person");

        var entity = personRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        
        personRepository.delete(entity);
    }
}
