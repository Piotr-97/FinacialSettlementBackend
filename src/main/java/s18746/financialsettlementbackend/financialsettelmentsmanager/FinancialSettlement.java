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
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "financialsettlement")
public class FinancialSettlement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String describe;

    private BigDecimal amountOfMoney;

    @Enumerated
    private FinancialSettlementStatus status;

    @ManyToOne
    @JoinColumn(name = "workunderproject_id")
    private WorkUnderProject workUnderProject;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Enumerated
    private SettlementType settlementType;


    private LocalDateTime date;






}
