package s18746.financialsettlementbackend.financialsettelmentsmanager;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import s18746.financialsettlementbackend.projectmanager.entities.Address;

@Entity
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaxiSettlement extends FinancialSettlement{

    @ManyToOne
    @JoinColumn(name = "start_address_id")
    private Address startAddress;

    @ManyToOne
    @JoinColumn(name = "target_address_id")
    private Address targetAddress;


}
