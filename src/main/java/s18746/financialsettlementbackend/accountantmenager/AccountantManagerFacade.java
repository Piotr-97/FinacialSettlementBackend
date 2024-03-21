package s18746.financialsettlementbackend.accountantmenager;


import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlementDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountantManagerFacade {


    private final FinancialSettlementResponseCreator financialSettlementResponseCreator;
    private final AnswerForSettlementRepository answerForSettlementRepository;

    public AccountantManagerFacade(FinancialSettlementResponseCreator financialSettlementResponseCreator, AnswerForSettlementRepository answerForSettlementRepository) {
        this.financialSettlementResponseCreator = financialSettlementResponseCreator;
        this.answerForSettlementRepository = answerForSettlementRepository;
    }

    public void addResponseToSettlement(Long settlementId, AnswerForSettlementDto answerForSettlementDto){
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

    private List<AnswerForSettlementDto> mapListAnswerForDto(List<AnswerForSettlement> answerForSettlementList) {
        List<AnswerForSettlementDto> dtoList = new ArrayList<>();
        answerForSettlementList.forEach(x ->
                dtoList.add(new AnswerForSettlementDto
                                                (x.getId(),
                                                        x.getCreatedDate(),
                                                        x.getFinancialSettlement()
                                                        ,x.getAnwserForSettlement()
                                                        ,x.getSettlementAnswerStatus())));

        return dtoList;
    }

    private AnswerForSettlementDto mapAnswerForDto(AnswerForSettlement answerForSettlement){
        return new AnswerForSettlementDto
                (       answerForSettlement.getId(),
                        answerForSettlement.getCreatedDate(),
                        answerForSettlement.getFinancialSettlement(),
                        answerForSettlement.getAnwserForSettlement(),
                        answerForSettlement.getSettlementAnswerStatus());
    }

}