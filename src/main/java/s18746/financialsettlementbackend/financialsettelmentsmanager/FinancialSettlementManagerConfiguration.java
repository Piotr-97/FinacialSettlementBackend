package s18746.financialsettlementbackend.financialsettelmentsmanager;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import s18746.financialsettlementbackend.employeemanager.EmployeeManagerFacade;
import s18746.financialsettlementbackend.financialsettelmentsmanager.repositories.FinancialSettlementRepository;
import s18746.financialsettlementbackend.projectmanager.ProjectManagerFacade;
import s18746.financialsettlementbackend.projectmanager.WorkUnderProjectFacade;
import s18746.financialsettlementbackend.projectmanager.repositories.AddressRepository;

@Configuration
public class FinancialSettlementManagerConfiguration {


    @Bean
    public FinancialSettlementManagerFacade financialSettlementManagerFacade(FinancialSettlementRepository financialSettlementRepository,
                                                                             WorkUnderProjectFacade workUnderProjectFacade,
                                                                             ProjectManagerFacade projectManagerFacade,
                                                                             EmployeeManagerFacade employeeManagerFacade,
                                                                             AddressRepository addressRepository) {
        return new FinancialSettlementManagerFacade(financialSettlementRepository, workUnderProjectFacade, projectManagerFacade, employeeManagerFacade, addressRepository);
    }

    public FinancialSettlementManagerFacade financialSettlementManagerFacadeForTest(FinancialSettlementRepository financialSettlementRepository,
                                                                                    WorkUnderProjectFacade workUnderProjectFacade,
                                                                                    ProjectManagerFacade projectManagerFacade,
                                                                                    EmployeeManagerFacade employeeManagerFacade,
                                                                                    AddressRepository addressRepository) {
        return new FinancialSettlementManagerFacade(financialSettlementRepository, workUnderProjectFacade, projectManagerFacade, employeeManagerFacade
                ,addressRepository);
    }


}
