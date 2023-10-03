package s18746.financialsettlementbackend.financialsettelmentsmanager;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import s18746.financialsettlementbackend.projectmanager.entities.Client;
import s18746.financialsettlementbackend.projectmanager.entities.WorkUnderProject;
import s18746.financialsettlementbackend.workerManager.Employee;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FinancialSettlement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String describe;

    private BigDecimal amountOfMoney;

    @Enumerated
    private FinancialSettlementStatus status;

    @OneToOne
    @JoinColumn(name = "work_under_project_id")
    private WorkUnderProject workUnderProject;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;




}
