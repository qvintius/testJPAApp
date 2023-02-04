package mainpackage.testhibernateapp.dao;

import mainpackage.testhibernateapp.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll(){
        List<Person> people = jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
        return people;
    }
//void
    /*public int insert(Person person){
        return jdbcTemplate.update("INSERT INTO person (id, firstname, lastname, adress) VALUES (?, ?, ?, ?)", new Object[]{
              person.getId(),  person.getFirstname(), person.getLastname(), person.getAdress()});
    }*/
}
