package s18746.financialsettlementbackend.projectmanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyClient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
