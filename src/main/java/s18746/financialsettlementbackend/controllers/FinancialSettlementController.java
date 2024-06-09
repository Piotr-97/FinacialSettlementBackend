package s18746.financialsettlementbackend.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlementDto;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlementManagerFacade;
import s18746.financialsettlementbackend.employeemanager.EmployeeDto;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/financialsettlement")
public class FinancialSettlementController {

    private final FinancialSettlementManagerFacade financialSettlementManagerFacade;


    @GetMapping("/all")
    public ResponseEntity<?> getAllFinancialSettlements(){
        List<FinancialSettlement> allFinancialSettlements = financialSettlementManagerFacade.getAllFinancialSettlements();

        return new ResponseEntity<>(allFinancialSettlements,
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFinancialSettlementById(@PathVariable Long id){
        Optional<FinancialSettlement> financialSettlement = financialSettlementManagerFacade.getFinancialSettlementById(id);
        if(financialSettlement.isPresent()) {
            return new ResponseEntity<>(financialSettlement,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFinancialSettlementById(@PathVariable Long id){
        Optional<FinancialSettlement> financialSettlement = financialSettlementManagerFacade.getFinancialSettlementById(id);
        if(financialSettlement.isPresent()) {
            financialSettlementManagerFacade.deleteFinancialSettlementById(id);
            return new ResponseEntity<>(financialSettlement,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> addFinancialSettlement(@RequestBody FinancialSettlementDto financialSettlementDto){
        FinancialSettlement financialSettlement = financialSettlementManagerFacade.createNewSettlement(financialSettlementDto);
        if(financialSettlement !=null){
            return new ResponseEntity<>(financialSettlement,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> modifyFinancialSettlement(@RequestBody FinancialSettlement modifiedFinancialSettlement,@PathVariable Long id){
        return null;

    }

    @GetMapping("/employee")
    public ResponseEntity<?> findAllFinancialSettlementByEmployee(EmployeeDto employee){
        List<FinancialSettlementDto> financialSettlementDtos = financialSettlementManagerFacade.getFinancialSettlementsByEmployeee(employee);

        return new ResponseEntity<>(financialSettlementDtos,HttpStatus.OK);
    }





}
