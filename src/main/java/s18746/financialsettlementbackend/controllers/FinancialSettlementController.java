package s18746.financialsettlementbackend.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;
import s18746.financialsettlementbackend.financialsettelmentsmanager.dtos.FinancialSettlementDto;
import s18746.financialsettlementbackend.financialsettelmentsmanager.dtos.FinancialSettlementRequest;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlementManagerFacade;
import s18746.financialsettlementbackend.employeemanager.EmployeeDto;
import s18746.financialsettlementbackend.financialsettelmentsmanager.dtos.FinancialSettlementResponse;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/financialsettlement")
public class FinancialSettlementController {

    private final FinancialSettlementManagerFacade financialSettlementManagerFacade;




    @GetMapping("/{uuid}")
    public ResponseEntity<?> getFinancialSettlementById(@PathVariable String uuid){
        Optional<FinancialSettlement> financialSettlement = financialSettlementManagerFacade.getFinancialSettlementByUuId(uuid);
        if(financialSettlement.isPresent()) {
            return new ResponseEntity<>(financialSettlement,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> deleteFinancialSettlementById(@PathVariable String uuid){
        Optional<FinancialSettlement> financialSettlement = financialSettlementManagerFacade.getFinancialSettlementByUuId(uuid);
//            financialSettlementManagerFacade.deleteFinancialSettlementById(id);
            return new ResponseEntity<>(financialSettlement,HttpStatus.OK);

//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> addFinancialSettlement(@RequestBody FinancialSettlementRequest financialSettlementRequest){

            financialSettlementManagerFacade.createNewSettlement(financialSettlementRequest);
           try {
               return ResponseEntity.ok().body(new FinancialSettlementResponse("Settlement created!"));
           }catch (Exception e){
               return ResponseEntity.badRequest().body(new FinancialSettlementResponse("Something went wrong"));
           }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllFinancialSettlements(){
        List<FinancialSettlementDto> financialSettlementsDto = financialSettlementManagerFacade.getAllFinancialSettlements();
        return new ResponseEntity<>(financialSettlementsDto,
                HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> modifyFinancialSettlement(@RequestBody FinancialSettlement modifiedFinancialSettlement){
        return null;

    }

    @GetMapping("/employee")
    public ResponseEntity<?> findAllFinancialSettlementByEmployee(EmployeeDto employee){
        List<FinancialSettlementRequest> financialSettlementRequests = financialSettlementManagerFacade.getFinancialSettlementsByEmployeee(employee);

        return new ResponseEntity<>(financialSettlementRequests,HttpStatus.OK);
    }

    @GetMapping("/employee/{uuid}")
    public  ResponseEntity<?> getFinancialSettlementsByEmployeeUuid(@PathVariable String uuid ){
        return ResponseEntity.ok(financialSettlementManagerFacade.findFinancialSettlementsByEmployeeUuid(uuid));
    }





}
