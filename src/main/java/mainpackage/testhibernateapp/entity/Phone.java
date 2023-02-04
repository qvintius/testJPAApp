package mainpackage.testhibernateapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "phone")
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "number")
    private String number;

    public Phone(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "\nPhone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
