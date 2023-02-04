package mainpackage.testhibernateapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @OneToOne(cascade = CascadeType.ALL)//действия, примененные к объекту, также применяются к ассоциируемому
    @JoinColumn(name = "passport_id")//название атрибута в бд
    private Passport passport;

    //Uni-directional однонаправленная связь
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)//при удалении человека удаляются все телефоны
    @JoinColumn(name = "person_id")
    private List<Phone> phones;

    //Bi-directional двунаправленная
    @OneToMany(mappedBy = "person",//маппиться по переменной, соответствующей по названию атрибуту сущности
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Adress> adresses;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setAdresses(List<Adress> adresses) {
        if (adresses != null) {
            adresses.forEach(a -> a.setPerson(this));
        }
        this.adresses = adresses;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", passport=" + passport +
                '}';
    }
}
