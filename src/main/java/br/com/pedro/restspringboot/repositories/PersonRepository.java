package br.com.pedro.restspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pedro.restspringboot.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
