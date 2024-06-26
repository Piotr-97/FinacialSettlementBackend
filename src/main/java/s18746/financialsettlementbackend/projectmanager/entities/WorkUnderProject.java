package s18746.financialsettlementbackend.projectmanager.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;
import s18746.financialsettlementbackend.utils.UuidGenerator;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "workunderproject")
public class WorkUnderProject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String uuid;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    private String name;

    private String description;

    @OneToMany(mappedBy = "workUnderProject")
    private Set<FinancialSettlement> financialSettlements;


    public WorkUnderProject(Long id, String Uuid, Project project, String name, String description, Set<FinancialSettlement> financialSettlements) {
        this.id = id;
        this.uuid = UuidGenerator.generateUuid();
        this.project = project;
        this.name = name;
        this.description = description;
        this.financialSettlements = financialSettlements;
    }

    public WorkUnderProject() {
        this.uuid = UuidGenerator.generateUuid();
    }
}
