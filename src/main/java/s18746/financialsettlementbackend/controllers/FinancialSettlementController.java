package s18746.financialsettlementbackend.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlementsManagerFacade;

@RestController
@AllArgsConstructor
public class FinancialSettlementController {

    private final FinancialSettlementsManagerFacade financialSettlementsManagerFacade;



}
