package mainpackage.testhibernateapp.repo;


import mainpackage.testhibernateapp.entity.Passport;
import mainpackage.testhibernateapp.entity.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonRepoTest {
    @Autowired
    PersonRepo personRepo;
    @Autowired
    PassportRepo passportRepo;

    @Test
    public void findByFirstname() throws Exception{
        List<Person> people = personRepo.findByFirstname("Anna");
        assertThat(people).hasSize(1);
        assertThat(people.get(0).getLastname()).isEqualTo("Andreevna");
        System.out.println(people);
    }
    @Test
    public void findAllOrderedByFirstname() throws Exception{
        List<Person> people = personRepo.findAllOrderedByFirstname();
        assertThat(people).hasSize(3);
        assertThat(people.get(2).getFirstname()).isEqualTo("Olesya");
        assertThat(people.get(1).getFirstname()).isEqualTo("Anna");
        System.out.println(people);
    }
    @Test
    public void deletePassport() throws Exception{
        Passport passport = passportRepo.findByNumber("O1111");
        passport.getPerson().setPassport(null);
        passportRepo.delete(passport);
        List<Person> people = personRepo.findAll();
        assertThat(people).hasSize(2);

        List<Passport> passports = passportRepo.findAll();
        assertThat(passports).hasSize(1);
    }
}