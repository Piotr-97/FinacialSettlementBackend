package s18746.financialsettlementbackend.accountantmenager;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlementManagerFacade;

@Configuration
public class AccountantManagerConfiguration {


    @Bean
    public AccountantManagerFacade accountantManagerFacade(AnswerForSettlementRepository answerForSettlementRepository, FinancialSettlementManagerFacade financialSettlementManagerFacade, PdfCreator pdfCreatorFacade){
        return new AccountantManagerFacade( financialSettlementManagerFacade, answerForSettlementRepository, pdfCreatorFacade);
    }

    public AccountantManagerFacade accountantManagerFacadeForTest(AnswerForSettlementRepository answerForSettlementRepository, FinancialSettlementManagerFacade financialSettlementManagerFacade,FinancialSettlementResponseCreator financialSettlementResponseCreator, PdfCreator pdfCreatorFacade){
        return new AccountantManagerFacade(financialSettlementManagerFacade, answerForSettlementRepository, pdfCreatorFacade);
    }
}
