package mainpackage.testhibernateapp;

import mainpackage.testhibernateapp.entity.Adress;
import mainpackage.testhibernateapp.entity.Person;
import mainpackage.testhibernateapp.repo.AdressesRepo;
import mainpackage.testhibernateapp.repo.PassportRepo;
import mainpackage.testhibernateapp.repo.PersonRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OwnerRelationsTest {
    @Autowired
    PersonRepo personRepo;
    @Autowired
    AdressesRepo adressesRepo;

    @Test
    public void inverseEndTest() throws Exception{
        List<Person> people = personRepo.findByFirstname("Anna");
        Person anna = people.get(0);
        anna.setLastname("Kuznesova");
        anna.setAdresses(Arrays.asList(new Adress("Vologda")));
        personRepo.save(anna);
    }
    @Test
    public void ownerTest() throws Exception{
        List<Adress> cities = adressesRepo .findByCity("Samara");
        Adress samara = cities.get(0);

        samara.setHouse_number(23);
        samara.setPerson(new Person("Alex", "Semenov"));
        adressesRepo.save(samara);
    }
}
