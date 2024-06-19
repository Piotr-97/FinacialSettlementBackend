package s18746.financialsettlementbackend.pdfcreator;


import lombok.*;
import s18746.financialsettlementbackend.accountantmenager.AnswerForSettlement;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pdfdata")
public class PdfFileData {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @OneToOne
    @JoinColumn(name = "financialsettlement_id")
    private FinancialSettlement financialSettlement;


    @OneToOne
    private AnswerForSettlement answerForSettlement;

    private String pathToFile;

    private LocalDateTime dateTime;

}
