package mainpackage.testhibernateapp.repo;

import mainpackage.testhibernateapp.entity.Adress;
import mainpackage.testhibernateapp.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdressesRepo extends CrudRepository<Adress, Integer> {
    List<Adress> findByCity(String city);
}
