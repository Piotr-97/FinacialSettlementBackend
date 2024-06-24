package s18746.financialsettlementbackend.utils;

import s18746.financialsettlementbackend.accountantmenager.AnswerForSettlement;
import s18746.financialsettlementbackend.accountantmenager.dtos.AnswerForSettlementDto;

import java.util.ArrayList;
import java.util.List;

public class AnswerForSettlementMapper {
    public static  List<AnswerForSettlementDto> mapListAnswerForDto(List<AnswerForSettlement> answerForSettlementList) {
        List<AnswerForSettlementDto> dtoList = new ArrayList<>();
        answerForSettlementList.forEach(x -> dtoList.add( new AnswerForSettlementDto(x.getFinancialSettlement().getUuid(),x.getUuid(),x.getAnswerForSettlement(),x.getCreatedDate(),x.getSettlementAnswerStatus().getStatus(),x.getFinancialSettlement().getEmployee().getUuid(),x.getFinancialSettlement().getEmployee().getFirstname() + " " +x.getFinancialSettlement().getEmployee().getLastname() )));
        return dtoList;
    }

    public static AnswerForSettlementDto mapAnswerForDto(AnswerForSettlement answerForSettlement) {
        return new AnswerForSettlementDto(answerForSettlement.getFinancialSettlement().getUuid(),answerForSettlement.getUuid(),answerForSettlement.getAnswerForSettlement(),answerForSettlement.getCreatedDate(),answerForSettlement.getSettlementAnswerStatus().getStatus(),answerForSettlement.getFinancialSettlement().getEmployee().getUuid(),answerForSettlement.getFinancialSettlement().getEmployee().getFirstname() + " " +answerForSettlement.getFinancialSettlement().getEmployee().getLastname() );
    }

}
