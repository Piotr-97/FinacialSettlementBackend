package s18746.financialsettlementbackend.financialsettelmentsmanager;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;
import s18746.financialsettlementbackend.employeemanager.Employee;
import s18746.financialsettlementbackend.projectmanager.entities.WorkUnderProject;
import s18746.financialsettlementbackend.utils.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class FinancialSettlement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "answerForSettlement shouldn't be null")
    @Length(min = 1, max = 10000)
    private String description;

    private BigDecimal amountOfMoney;

    private String uuid;

    @Enumerated
    private FinancialSettlementStatus status;

    @ManyToOne
    @JoinColumn(name = "workunderproject_id")
    private WorkUnderProject workUnderProject;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Enumerated
    private SettlementType settlementType;


    private LocalDateTime date;


    public FinancialSettlement(Long id, @NotBlank(message = "describe shouldn't be null") @Max(1000) String description, BigDecimal amountOfMoney, String uuid, FinancialSettlementStatus status, WorkUnderProject workUnderProject, Employee employee, SettlementType settlementType, LocalDateTime date) {
        this.id = id;
        this.description = description;
        this.amountOfMoney = amountOfMoney;
        this.uuid = uuid;
        this.status = status;
        this.workUnderProject = workUnderProject;
        this.employee = employee;
        this.settlementType = settlementType;
        this.date = date;
        this.uuid = UuidGenerator.generateUuid();
    }

    public FinancialSettlement() {
        this.uuid = UuidGenerator.generateUuid();
    }
}
