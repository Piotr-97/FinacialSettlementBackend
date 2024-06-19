package s18746.financialsettlementbackend.accountantmenager;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;
import s18746.financialsettlementbackend.utils.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@Table(name = "answerforsettlement")
public class AnswerForSettlement {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String uuid;


    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "financialsettlement_id")
    private FinancialSettlement financialSettlement;


    private String anwserForSettlement;

    private SettlementAnswerStatus settlementAnswerStatus;


    public AnswerForSettlement(Long id, String uuid, LocalDateTime createdDate, FinancialSettlement financialSettlement, String anwserForSettlement, SettlementAnswerStatus settlementAnswerStatus) {
        this.id = id;
        this.uuid = uuid;
        this.createdDate = createdDate;
        this.financialSettlement = financialSettlement;
        this.anwserForSettlement = anwserForSettlement;
        this.settlementAnswerStatus = settlementAnswerStatus;
        this.uuid = UuidGenerator.generateUuid();

    }

    public AnswerForSettlement() {
        this.uuid = UuidGenerator.generateUuid();
    }
}
