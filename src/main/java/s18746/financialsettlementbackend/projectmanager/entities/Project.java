package s18746.financialsettlementbackend.projectmanager.entities;


import lombok.*;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
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


    @OneToMany
    private Set<WorkUnderProject> workUnderProject;

}
