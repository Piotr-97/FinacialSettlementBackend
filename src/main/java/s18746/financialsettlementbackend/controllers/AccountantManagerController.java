package s18746.financialsettlementbackend.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s18746.financialsettlementbackend.accountantmenager.AccountantManagerFacade;
import s18746.financialsettlementbackend.accountantmenager.AnswerForSettlement;
import s18746.financialsettlementbackend.accountantmenager.dtos.AnswerForSettlementDto;
import s18746.financialsettlementbackend.accountantmenager.AnswerForSettlementResponse;
import s18746.financialsettlementbackend.accountantmenager.dtos.AnswerForSettlementRequest;
import s18746.financialsettlementbackend.financialsettelmentsmanager.exceptions.FinancialSettlementNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/accountant")
public class AccountantManagerController {

   private final AccountantManagerFacade accountantManagerFacade;

    @GetMapping
    public ResponseEntity<?> getAllAnswerForSettlement() {
        List<AnswerForSettlementDto> answerForSettlementDtos = accountantManagerFacade.getAllAnswerForSettlements();

        return new ResponseEntity<>(answerForSettlementDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findAnswerForSettlementsById(@PathVariable Long id) {
        Optional<AnswerForSettlementDto> answer = accountantManagerFacade.findAnswerForSettlementById(id);
        if (answer.isPresent()) {
            return new ResponseEntity<>(answer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping()
    public ResponseEntity<?> addAnswerForSettlement(@RequestBody AnswerForSettlementRequest answerForSettlementRequest){
        try {
            AnswerForSettlement responseForSettlement = accountantManagerFacade.createResponseForSettlement(answerForSettlementRequest);
            return ResponseEntity.ok(responseForSettlement);
        }catch (FinancialSettlementNotFoundException e){
            return ResponseEntity.badRequest().body(new AnswerForSettlementResponse(e.getMessage()));
        }

    }

    @GetMapping("/report")
    public ResponseEntity<byte[]> getPdfReport() {


        byte[] pdfContents = accountantManagerFacade.createReport();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf");
        headers.set(HttpHeaders.CONTENT_TYPE, "application/pdf");

        return new ResponseEntity<>(pdfContents, headers, HttpStatus.OK);
    }






}
