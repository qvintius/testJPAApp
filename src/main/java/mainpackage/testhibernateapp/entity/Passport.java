package mainpackage.testhibernateapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "number", unique = true, nullable = false)
    private String number;
    @OneToOne(mappedBy = "passport", //название атрибута у Person для присоединения
             cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    //все cascade, кроме remove, чтобы при удалении passport оставался person
    private Person person;

    public Passport(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "\nPassport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", person=" + person +
                '}';
    }
}
