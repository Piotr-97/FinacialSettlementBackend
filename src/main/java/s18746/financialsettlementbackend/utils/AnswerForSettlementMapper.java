package s18746.financialsettlementbackend.utils;

import s18746.financialsettlementbackend.accountantmenager.AnswerForSettlement;
import s18746.financialsettlementbackend.accountantmenager.AnswerForSettlementDto;

import java.util.ArrayList;
import java.util.List;

public class AnswerForSettlementMapper {
    public static  List<AnswerForSettlementDto> mapListAnswerForDto(List<AnswerForSettlement> answerForSettlementList) {
        List<AnswerForSettlementDto> dtoList = new ArrayList<>();
        answerForSettlementList.forEach(x -> dtoList.add(new AnswerForSettlementDto(x.getCreatedDate(), x.getFinancialSettlement(), x.getAnwserForSettlement(), x.getSettlementAnswerStatus())));
        return dtoList;
    }

    public static AnswerForSettlementDto mapAnswerForDto(AnswerForSettlement answerForSettlement) {
        return new AnswerForSettlementDto(answerForSettlement.getCreatedDate(), answerForSettlement.getFinancialSettlement(), answerForSettlement.getAnwserForSettlement(), answerForSettlement.getSettlementAnswerStatus());
    }
}
