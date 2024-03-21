package s18746.financialsettlementbackend.accountantmenager;

import java.time.LocalDateTime;

public class FinancialSettlementResponseCreator {





    public AnswerForSettlement createNewAnswer(String answer, SettlementAnswerStatus status){
        return AnswerForSettlement.builder()
                .createdDate(LocalDateTime.now())
                .anwserForSettlement(answer)
                .settlementAnswerStatus(status)
                .build();

    }


}
