package s18746.financialsettlementbackend.accountantmenager;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlementManagerFacade;
import s18746.financialsettlementbackend.pdfcreator.PdfCreatorFacade;

@Configuration
public class AccountantManagerConfiguration {


    @Bean
    public AccountantManagerFacade accountantManagerFacade(AnswerForSettlementRepository answerForSettlementRepository, FinancialSettlementManagerFacade financialSettlementManagerFacade, PdfCreatorFacade pdfCreatorFacade){
        FinancialSettlementResponseCreator financialSettlementResponseCreator = new FinancialSettlementResponseCreator();
        return new AccountantManagerFacade(financialSettlementResponseCreator, financialSettlementManagerFacade, answerForSettlementRepository, pdfCreatorFacade);
    }

    public AccountantManagerFacade accountantManagerFacadeForTest(AnswerForSettlementRepository answerForSettlementRepository, FinancialSettlementManagerFacade financialSettlementManagerFacade,FinancialSettlementResponseCreator financialSettlementResponseCreator, PdfCreatorFacade pdfCreatorFacade){
        return new AccountantManagerFacade(financialSettlementResponseCreator, financialSettlementManagerFacade, answerForSettlementRepository, pdfCreatorFacade);
    }
}
