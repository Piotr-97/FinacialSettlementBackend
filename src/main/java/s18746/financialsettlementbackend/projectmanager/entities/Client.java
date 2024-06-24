package s18746.financialsettlementbackend.projectmanager.entities;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import s18746.financialsettlementbackend.utils.UuidGenerator;


@Entity
@Getter
@Setter
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String uuid;

    private String nip;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;


    public Client(Long id, String name, String nip, Address address) {
        this.id = id;
        this.name = name;
        this.uuid = UuidGenerator.generateUuid();
        this.nip = nip;
        this.address = address;

    }

    public Client() {
        this.uuid = UuidGenerator.generateUuid();
    }

    public Client(Long id, String name, String uuid, String nip, Address address) {
        this.id = id;
        this.name = name;
        this.uuid = UuidGenerator.generateUuid();
        this.nip = nip;
        this.address = address;

    }
}
