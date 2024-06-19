package s18746.financialsettlementbackend.financialsettelmentsmanager;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
@Getter
@Setter
public class TripSettlement extends FinancialSettlement{

    private String country;


}
