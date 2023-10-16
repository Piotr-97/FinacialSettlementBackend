package s18746.financialsettlementbackend.accountantmenager;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "answerforsettlement")
public class AnswerForSettlement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated
    private AnswerStatus status;


    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "financialsettlement_id")
    private FinancialSettlement financialSettlement;

}
