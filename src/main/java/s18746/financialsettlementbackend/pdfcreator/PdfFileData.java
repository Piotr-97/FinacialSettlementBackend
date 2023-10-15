package s18746.financialsettlementbackend.pdfcreator;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pdfdata")
public class PdfFileData {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;


    @OneToOne
    @JoinColumn(name = "financialsettlement_id")
    private FinancialSettlement financialSettlement;


    private String pathToFile;

    private LocalDateTime dateTime;

}
