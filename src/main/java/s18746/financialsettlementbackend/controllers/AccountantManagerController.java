package s18746.financialsettlementbackend.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s18746.financialsettlementbackend.accountantmenager.AccountantManagerFacade;
import s18746.financialsettlementbackend.accountantmenager.AnswerForSettlementDto;

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


    public ResponseEntity<?> addAnswerForSettlement(@RequestBody AnswerForSettlementDto answerForSettlementDto){
        accountantManagerFacade.addResponseToSettlement(answerForSettlementDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }







}
