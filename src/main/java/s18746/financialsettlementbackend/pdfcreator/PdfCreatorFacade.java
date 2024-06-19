package s18746.financialsettlementbackend.pdfcreator;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
public class PdfCreatorFacade {

    private final PdfCreatorRepository pdfCreatorRepository;

    private final PdfDataCreator pdfDataCreator;

    private final PdfFileDataGenerator pdfFileDataGenerator;
/*
    public PdfFileData createPDFFileData(AnswerForSettlementRequest answerForSettlementRequest, FinancialSettlementDto financialSettlementRequest){
        return null;
    }


    public PdfFileData createPdfFileForSettlement(FinancialSettlementDto financialSettlementRequest){

    }

*/

    public PdfFileData getPdfFileDataBySettlement()
    {
        return null;
    }




}
