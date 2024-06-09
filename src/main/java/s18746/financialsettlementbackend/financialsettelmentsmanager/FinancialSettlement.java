package s18746.financialsettlementbackend.financialsettelmentsmanager;


import lombok.*;
import s18746.financialsettlementbackend.projectmanager.entities.WorkUnderProject;
import s18746.financialsettlementbackend.employeemanager.Employee;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class FinancialSettlement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "describe shouldn't be null")
    @Max(1000)
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
