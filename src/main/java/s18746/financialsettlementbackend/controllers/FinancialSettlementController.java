package s18746.financialsettlementbackend.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlementManagerFacade;
import s18746.financialsettlementbackend.financialsettelmentsmanager.dtos.FinancialSettlementDto;
import s18746.financialsettlementbackend.financialsettelmentsmanager.dtos.FinancialSettlementRequest;
import s18746.financialsettlementbackend.financialsettelmentsmanager.dtos.FinancialSettlementResponse;
import s18746.financialsettlementbackend.financialsettelmentsmanager.exceptions.FinancialSettlementNotFoundException;
import s18746.financialsettlementbackend.financialsettelmentsmanager.exceptions.SettlementTypeModifyException;
import s18746.financialsettlementbackend.financialsettelmentsmanager.exceptions.StatusChangeException;
import s18746.financialsettlementbackend.projectmanager.WorkUnderProjectException;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/financialsettlement")
public class FinancialSettlementController {

    private final FinancialSettlementManagerFacade financialSettlementManagerFacade;

    @GetMapping("/{uuid}")
    public ResponseEntity<?> getFinancialSettlementById(@PathVariable String uuid) {
        Optional<FinancialSettlement> financialSettlement = financialSettlementManagerFacade.getFinancialSettlementByUuId(uuid);
        if (financialSettlement.isPresent()) {
            return new ResponseEntity<>(financialSettlement, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> deleteFinancialSettlementById(@PathVariable String uuid) {
        try {
            Optional<FinancialSettlement> financialSettlement = financialSettlementManagerFacade.getFinancialSettlementByUuId(uuid);
            financialSettlementManagerFacade.deleteFinancialSettlementByUuid(uuid);
            return new ResponseEntity<>(financialSettlement, HttpStatus.OK);
        } catch (FinancialSettlementNotFoundException exception) {

            return ResponseEntity.badRequest().body(new FinancialSettlementResponse("Financial settlement not found"));
        }

    }

    @PostMapping
    public ResponseEntity<?> addFinancialSettlement(@RequestBody FinancialSettlementRequest financialSettlementRequest) {
        try {
            financialSettlementManagerFacade.createNewSettlement(financialSettlementRequest);
            return ResponseEntity.ok().body(new FinancialSettlementResponse("Settlement created!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new FinancialSettlementResponse("Something went wrong"));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllFinancialSettlements() {
        List<FinancialSettlementDto> financialSettlementsDto = financialSettlementManagerFacade.getAllFinancialSettlementsDto();
        return new ResponseEntity<>(financialSettlementsDto,
                HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<?> modifyFinancialSettlement(@RequestBody FinancialSettlementDto modifiedFinancialSettlement) {
        try {
            financialSettlementManagerFacade.updateFinancialSettlement(modifiedFinancialSettlement);
            return ResponseEntity.ok(new FinancialSettlementResponse("Settlement modified"));
        } catch (FinancialSettlementNotFoundException e) {
            return ResponseEntity.badRequest().body(new FinancialSettlementResponse("Settlement not found"));

        } catch (SettlementTypeModifyException e) {
            return ResponseEntity.badRequest().body(new FinancialSettlementResponse("You can't change financial settlement type!"));

        } catch (StatusChangeException e) {
            return ResponseEntity.badRequest().body(new FinancialSettlementResponse("You can't change settlement when its resolved"));
        }
    }


    @GetMapping("/employee/{uuid}")
        public ResponseEntity<?> getFinancialSettlementsByEmployeeUuid(@PathVariable String uuid) {
        return ResponseEntity.ok(financialSettlementManagerFacade.findFinancialSettlementsByEmployeeUuid(uuid));
    }

    @GetMapping("work/{uuid}")
    public ResponseEntity<?> getFinancialSettlementsByWorkUnderProjectUuid(@PathVariable String uuid) {
        try {
            return ResponseEntity.ok(financialSettlementManagerFacade.findFinancialSettlementsByWorkUnderProjectUuid(uuid));
        } catch (WorkUnderProjectException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
