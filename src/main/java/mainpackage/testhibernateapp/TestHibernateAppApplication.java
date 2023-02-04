package mainpackage.testhibernateapp;

import mainpackage.testhibernateapp.dao.PersonDAO;
import mainpackage.testhibernateapp.entity.Adress;
import mainpackage.testhibernateapp.entity.Passport;
import mainpackage.testhibernateapp.entity.Person;
import mainpackage.testhibernateapp.entity.Phone;
import mainpackage.testhibernateapp.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TestHibernateAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestHibernateAppApplication.class, args);
	}
	@Autowired
	PersonRepo personRepo;
	@Override
	public void run(String... args) throws Exception {
		Person anna = new Person("Anna", "Andreevna");
		Person olesya = new Person("Olesya", "Andreevna");
		//Person alex = new Person("Alex", "Andreev", "Omsk");
		Passport passportAnna = new Passport("A1111");
		Passport passportOlesya = new Passport("O1111");
		Phone phone1 = new Phone("123-123-123");
		Phone phone2 = new Phone("222-222-222");
		Phone phone3 = new Phone("333-333-333");
		Phone phone4 = new Phone("444-444-444");
		Adress adress2 = new Adress("Omsk");
		Adress adress1 = new Adress("Samara");
		Adress adress3 = new Adress("Novosibirsk");
		Adress adress4 = new Adress("Moscow");
		anna.setPassport(passportAnna);//установить паспорт для людей
		anna.setPhones(Arrays.asList(phone1, phone2));
		anna.setAdresses(Arrays.asList(adress1, adress2));

		olesya.setPassport(passportOlesya);
		olesya.setPhones(Arrays.asList(phone3, phone4));
		olesya.setAdresses(Arrays.asList(adress3, adress4));

		List<Person> people = Arrays.asList(anna, olesya);
		personRepo.saveAll(people);
		//System.out.println("\n " + personRepo.findAll());
	}
}
