package mainpackage.testhibernateapp.repo;

import mainpackage.testhibernateapp.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepo extends JpaRepository<Passport, Integer> {
    Passport findByNumber(String number);
}
