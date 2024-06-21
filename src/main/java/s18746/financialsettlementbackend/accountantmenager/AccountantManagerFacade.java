package s18746.financialsettlementbackend.accountantmenager;


import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlementManagerFacade;
import s18746.financialsettlementbackend.financialsettelmentsmanager.dtos.FinancialSettlementDto;
import s18746.financialsettlementbackend.pdfcreator.PdfCreatorFacade;
import s18746.financialsettlementbackend.utils.AnswerForSettlementMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static s18746.financialsettlementbackend.utils.AnswerForSettlementMapper.mapListAnswerForDto;

public class AccountantManagerFacade {


    private final FinancialSettlementResponseCreator financialSettlementResponseCreator;

    private final FinancialSettlementManagerFacade financialSettlementManagerFacade;
    private final AnswerForSettlementRepository answerForSettlementRepository;

    private final PdfCreatorFacade pdfCreatorFacade;

    public AccountantManagerFacade(FinancialSettlementResponseCreator financialSettlementResponseCreator, FinancialSettlementManagerFacade financialSettlementManagerFacade, AnswerForSettlementRepository answerForSettlementRepository, PdfCreatorFacade pdfCreatorFacade) {
        this.financialSettlementResponseCreator = financialSettlementResponseCreator;
        this.financialSettlementManagerFacade = financialSettlementManagerFacade;
        this.answerForSettlementRepository = answerForSettlementRepository;
        this.pdfCreatorFacade = pdfCreatorFacade;
    }

    public void addResponseToSettlement(AnswerForSettlementDto answerForSettlementDto) {
    }

    public AnswerForSettlement createResponseForSettlement(AnswerForSettlementDto answerForSettlementDto) {
        FinancialSettlement settlementByUUid = financialSettlementManagerFacade.findSettlementByUUid(answerForSettlementDto.settlementUUID());
        return AnswerForSettlement.builder()
                .createdDate(LocalDateTime.now())
                .anwserForSettlement(answerForSettlementDto.answerForSettlement())
                .settlementAnswerStatus(SettlementAnswerStatus.valueOf(answerForSettlementDto.answerForSettlement()))
                .financialSettlement(settlementByUUid)
                .build();
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
        return AnswerForSettlementMapper.mapAnswerForDto(answerForSettlement);
    }

    public byte[] createReport() {
        List<FinancialSettlement> settlements = financialSettlementManagerFacade.getAllFinancialSettlements();
        return pdfCreatorFacade.createReport(settlements);

    }
}