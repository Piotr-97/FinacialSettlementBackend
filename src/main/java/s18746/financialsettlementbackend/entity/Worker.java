package s18746.financialsettlementbackend.entity;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;

@Entity

public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person personalData;

    private PositionEmum position;

    @OneToOne
    @JoinColumn(name = "supervisor_id")
    @Nullable
    private Worker supervisor;



}
