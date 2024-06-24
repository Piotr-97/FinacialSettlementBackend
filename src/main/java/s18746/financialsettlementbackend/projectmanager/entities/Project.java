package s18746.financialsettlementbackend.projectmanager.entities;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import s18746.financialsettlementbackend.utils.UuidGenerator;

import java.util.Set;

@Entity
@Builder
@Getter
@Setter
public class Project {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private String uuid;


    @OneToMany
    private Set<WorkUnderProject> workUnderProject;

    public Project(Long id, String name, Client client, String uuid, Set<WorkUnderProject> workUnderProject) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.uuid = UuidGenerator.generateUuid();
        this.workUnderProject = workUnderProject;
    }

    public Project() {
        this.uuid = UuidGenerator.generateUuid();
    }
}
