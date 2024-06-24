package s18746.financialsettlementbackend.projectmanager.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "workunderproject")
public class WorkUnderProject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    private String name;

    private String description;

    @OneToMany(mappedBy = "workUnderProject")
    private Set<FinancialSettlement> financialSettlements;



}
