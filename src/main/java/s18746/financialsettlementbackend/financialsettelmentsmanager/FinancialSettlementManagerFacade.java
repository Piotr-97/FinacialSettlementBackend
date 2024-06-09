package s18746.financialsettlementbackend.financialsettelmentsmanager;

import lombok.AllArgsConstructor;
import s18746.financialsettlementbackend.employeemanager.EmployeeDto;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class FinancialSettlementManagerFacade {

    private final FinancialSettlementRepository financialSettlementRepository;
    private final SettlementGenerator settlementGenerator;


    public FinancialSettlement createNewSettlement(FinancialSettlementDto financialSettlementDto) {
       return null;

    }

    public List<FinancialSettlement> getAllFinancialSettlements(){
         List<FinancialSettlement> financialSettlementList = financialSettlementRepository.findAll();
        return financialSettlementList;
    }

    public Optional<FinancialSettlement> getFinancialSettlementById(Long id) {
        return financialSettlementRepository.findById(id);
    }

    public void deleteFinancialSettlementById(Long id) {
        financialSettlementRepository.deleteById(id);
    }

    public List<FinancialSettlementDto> getFinancialSettlementsByEmployeee(EmployeeDto employee) {
        Long employeeId = employee.id();
        List<FinancialSettlement>  settlementsByUser = financialSettlementRepository.findAllByEmployeeId(employeeId);
        return null;
    }
}
