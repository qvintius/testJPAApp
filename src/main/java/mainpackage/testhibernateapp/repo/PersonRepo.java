package mainpackage.testhibernateapp.repo;

import mainpackage.testhibernateapp.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Integer> {
    List<Person> findByFirstname(String firstname);
    @Query("select p from Person p order by firstname")//определение запроса
    List<Person> findAllOrderedByFirstname();
}
