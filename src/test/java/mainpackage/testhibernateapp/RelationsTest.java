package mainpackage.testhibernateapp;

import jakarta.transaction.Transactional;
import mainpackage.testhibernateapp.entity.Adress;
import mainpackage.testhibernateapp.entity.Person;
import mainpackage.testhibernateapp.repo.AdressesRepo;
import mainpackage.testhibernateapp.repo.PersonRepo;
import org.hibernate.LazyInitializationException;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RelationsTest {

    @Autowired
    PersonRepo personRepo;
    @Autowired
    AdressesRepo adressesRepo;
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void lazyLoadingException() throws Exception{
        try{
            List<Person> anna = personRepo.findByFirstname("Anna");
            //session closed
            System.out.println(anna.get(0).getPhones());
        }catch (LazyInitializationException lz){
            System.out.println("fd");
        }
    }
    @Test
    @Transactional//session not closed
    public void lazyLoading() throws Exception{
        List<Person> anna = personRepo.findByFirstname("Anna");
        System.out.println(anna.get(0).getPhones());
    }
    @Test
    public void deleteAdress() throws Exception{
        List<Adress> cities = adressesRepo.findByCity("Samara");
        assertThat(cities).hasSize(1);

        adressesRepo.delete(cities.get(0));
        List<Person> people = personRepo.findAll();
        assertThat(people).hasSize(2);
    }
    @Test
    public void deletePerson() throws Exception{
        List<Person> people = personRepo.findByFirstname("Olesya");
        personRepo.delete(people.get(0));
        List<Adress> adresses = (List<Adress>) adressesRepo.findAll();

        assertThat(adresses).hasSize(2);
    }
    @Test
    public void fetchTypeLoading() throws Exception{
        List<Person> people = personRepo.findAll();
    }
}
