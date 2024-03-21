package s18746.financialsettlementbackend.accountantmenager;



import lombok.*;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "answerforsettlement")
public class AnswerForSettlement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "financialsettlement_id")
    private FinancialSettlement financialSettlement;


    private String anwserForSettlement;

    private SettlementAnswerStatus settlementAnswerStatus;



}