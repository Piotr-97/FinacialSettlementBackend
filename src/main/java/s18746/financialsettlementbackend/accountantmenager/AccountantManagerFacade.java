package s18746.financialsettlementbackend.accountantmenager;


import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;

public class AccountantManagerFacade {


    public final FinancialSettlementResponseCreator financialSettlementResponseCreator;

    public AccountantManagerFacade(FinancialSettlementResponseCreator financialSettlementResponseCreator) {
        this.financialSettlementResponseCreator = financialSettlementResponseCreator;
    }

    public void addResponseToSettlement(FinancialSettlement financialSettlement, AnswerForSettlement answerForSettlement){
        answerForSettlement.setFinancialSettlement(financialSettlement);
    }


    //TODO ADD LOGIC
    public AnswerForSettlement createResponseForSettlement(AnwserForSettlementRequest anwserForSettlementRequest) {
        return  AnswerForSettlement.builder().build();
    }



}