package s18746.financialsettlementbackend.accountantmenager;

import java.time.LocalDateTime;

public class FinancialSettlementResponseCreator {





    public AnswerForSettlement createNewAnswer(String answer,SettlementStatus status){
        return AnswerForSettlement.builder()
                .createdDate(LocalDateTime.now())
                .anwserForSettlement(answer)
                .settlementStatus(status)
                .build();

    }


}
