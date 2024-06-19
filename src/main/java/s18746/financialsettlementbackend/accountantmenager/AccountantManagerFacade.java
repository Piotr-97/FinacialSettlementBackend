package s18746.financialsettlementbackend.accountantmenager;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static s18746.financialsettlementbackend.utils.AnswerForSettlementMapper.mapListAnswerForDto;

public class AccountantManagerFacade {


    private final FinancialSettlementResponseCreator financialSettlementResponseCreator;
    private final AnswerForSettlementRepository answerForSettlementRepository;

    public AccountantManagerFacade(FinancialSettlementResponseCreator financialSettlementResponseCreator, AnswerForSettlementRepository answerForSettlementRepository) {
        this.financialSettlementResponseCreator = financialSettlementResponseCreator;
        this.answerForSettlementRepository = answerForSettlementRepository;
    }

    public void addResponseToSettlement( AnswerForSettlementDto answerForSettlementDto) {
    }

    public AnswerForSettlement createResponseForSettlement(AnswerForSettlementDto answerForSettlementDto) {
        return financialSettlementResponseCreator.createNewAnswer(answerForSettlementDto.anwserForSettlement(), answerForSettlementDto.settlementAnswerStatus());
    }


    public Optional<AnswerForSettlementDto> findAnswerForSettlementById(Long id) {
        Optional<AnswerForSettlement> answerForSettlement = answerForSettlementRepository.findById(id);
        return answerForSettlement.map(this::mapAnswerForDto);
    }

    public List<AnswerForSettlementDto> getAllAnswerForSettlements() {
        List<AnswerForSettlement> answerForSettlementList = answerForSettlementRepository.findAll();
        return mapListAnswerForDto(answerForSettlementList);
    }



    private AnswerForSettlementDto mapAnswerForDto(AnswerForSettlement answerForSettlement) {
        return new AnswerForSettlementDto(answerForSettlement.getCreatedDate(), answerForSettlement.getFinancialSettlement(), answerForSettlement.getAnwserForSettlement(), answerForSettlement.getSettlementAnswerStatus());
    }

}