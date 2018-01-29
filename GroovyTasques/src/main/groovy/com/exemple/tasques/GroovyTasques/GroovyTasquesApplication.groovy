package com.exemple.tasques.GroovyTasques

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GeneratedValue
import javax.persistence.Id
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.Repository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@SpringBootApplication
class GroovyTasquesApplication {

	static void main(String[] args) {
		SpringApplication.run GroovyTasquesApplication, args
	}
}
@Entity
class Tasca {
    @Id 
    @GeneratedValue 
    long id
    String codigo
    String descripcion
    Integer horas   
}

@RepositoryRestResource( path = "tasques")
public interface UserRepository extends  CrudRepository<Tasca, Long> {
    List<Tasca> findByDescripcion(@Param("descripcion") String descripcion);
}