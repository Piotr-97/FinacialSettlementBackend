package s18746.financialsettlementbackend.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlementManagerFacade;

@RestController
@AllArgsConstructor
public class FinancialSettlementController {

    private final FinancialSettlementManagerFacade financialSettlementManagerFacade;



}
