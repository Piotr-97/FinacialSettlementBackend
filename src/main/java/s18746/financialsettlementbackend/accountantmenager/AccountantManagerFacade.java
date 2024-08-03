package s18746.financialsettlementbackend.accountantmenager;


import s18746.financialsettlementbackend.accountantmenager.dtos.AnswerForSettlementDto;
import s18746.financialsettlementbackend.accountantmenager.dtos.AnswerForSettlementRequest;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlementManagerFacade;
import s18746.financialsettlementbackend.utils.AnswerForSettlementMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static s18746.financialsettlementbackend.utils.AnswerForSettlementMapper.mapListAnswerForDto;

public class AccountantManagerFacade {



    private final FinancialSettlementManagerFacade financialSettlementManagerFacade;
    private final AnswerForSettlementRepository answerForSettlementRepository;

    private final PdfCreator pdfCreatorFacade;

    public AccountantManagerFacade(FinancialSettlementManagerFacade financialSettlementManagerFacade, AnswerForSettlementRepository answerForSettlementRepository, PdfCreator pdfCreatorFacade) {
        this.financialSettlementManagerFacade = financialSettlementManagerFacade;
        this.answerForSettlementRepository = answerForSettlementRepository;
        this.pdfCreatorFacade = pdfCreatorFacade;
    }

    public AnswerForSettlement createResponseForSettlement(AnswerForSettlementRequest answerForSettlementRequest) {
        FinancialSettlement settlementByUUid = financialSettlementManagerFacade.findSettlementByUUid(answerForSettlementRequest.settlementUuid());
        AnswerForSettlement answerForSettlement = AnswerForSettlement.builder()
                .createdDate(LocalDateTime.now())
                .answerForSettlement(answerForSettlementRequest.answerForSettlement())
                .settlementAnswerStatus(SettlementAnswerStatus.valueOf(answerForSettlementRequest.settlementAnswerStatus()))
                .financialSettlement(settlementByUUid)
                .build();
       return answerForSettlementRepository.save(answerForSettlement);

    }


    public Optional<AnswerForSettlementDto> findAnswerForSettlementById(Long id) {
        Optional<AnswerForSettlement> answerForSettlement = answerForSettlementRepository.findById(id);
        return answerForSettlement.map(this::mapAnswerForDto);
    }

    public List<AnswerForSettlementDto> getAllAnswerForSettlements() {
        List<AnswerForSettlement> answerForSettlementList = answerForSettlementRepository.findAll();
        return mapListAnswerForDto(answerForSettlementList);
    }

    public List<AnswerForSettlementDtoResponse> getAllAnswerForSettlementsTest() {
        List<AnswerForSettlement> answerForSettlementList = answerForSettlementRepository.findAll();
        return AnswerForSettlementMapper.mapListAnswersForSettlementsToDto(answerForSettlementList);
    }


    private AnswerForSettlementDto mapAnswerForDto(AnswerForSettlement answerForSettlement) {
        return AnswerForSettlementMapper.mapAnswerForDto(answerForSettlement);
    }

    public byte[] createReport() {
        List<FinancialSettlement> settlements = financialSettlementManagerFacade.getAllFinancialSettlements();
        return pdfCreatorFacade.createReport(settlements);

    }

    public AnswerForSettlementDtoResponse findAnswerForSettlementByUuid(String uuid) {
        Optional<AnswerForSettlement> answerForSettlementByUuid = answerForSettlementRepository.findAnswerForSettlementByUuid(uuid);
        if(answerForSettlementByUuid.isPresent()){

            return AnswerForSettlementMapper.mapAnswerForResponseDto(answerForSettlementByUuid.get());
        }
        return  null;
    }
}