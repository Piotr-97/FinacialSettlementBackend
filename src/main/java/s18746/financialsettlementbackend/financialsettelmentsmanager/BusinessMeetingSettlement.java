package s18746.financialsettlementbackend.financialsettelmentsmanager;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class BusinessMeetingSettlement extends FinancialSettlement{

    String place;

}
