package s18746.financialsettlementbackend.employeemanager;


import lombok.*;


import jakarta.persistence.*;
import s18746.financialsettlementbackend.autht.User;
import s18746.financialsettlementbackend.utils.UuidGenerator;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@Entity
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private User user;
    private PositionEnum position;
    private String firstname;
    private String lastname;
    private String email;
    private String uuid;



    public Employee() {
        this.uuid = UuidGenerator.generateUuid();
    }

    public Employee(Long id, User user, PositionEnum position, String firstname, String lastname,String email, String uuid) {
        this.id = id;
        this.user = user;
        this.position = position;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.uuid = UuidGenerator.generateUuid();
    }
    public Employee(Long id, User user, PositionEnum position, String firstname, String lastname,String email) {
        this.id = id;
        this.user = user;
        this.position = position;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.uuid = UuidGenerator.generateUuid();
    }
}
