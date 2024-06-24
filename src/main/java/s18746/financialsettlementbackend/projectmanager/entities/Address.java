package s18746.financialsettlementbackend.projectmanager.entities;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import s18746.financialsettlementbackend.utils.UuidGenerator;


@Getter
@Setter
@Entity
@Builder
@Table(name = "addressUuid")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id", nullable = false)
    private Long id;

    private String uuid;

    private String street;


    public Address(Long id, String uuid, String street) {
        this.id = id;
        this.uuid = UuidGenerator.generateUuid();
        this.street = street;
    }

    public Address() {
        this.uuid = UuidGenerator.generateUuid();
    }
}