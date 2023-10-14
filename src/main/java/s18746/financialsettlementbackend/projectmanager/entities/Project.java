package s18746.financialsettlementbackend.projectmanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project {


    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String name;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @ManyToOne
    @JoinColumn(name = "work_under_project_id")
    private WorkUnderProject workUnderProject;

}
