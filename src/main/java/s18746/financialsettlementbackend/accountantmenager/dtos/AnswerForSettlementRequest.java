package s18746.financialsettlementbackend.accountantmenager.dtos;

public record AnswerForSettlementRequest (  String settlementType,
                                            String settlementUuid,
                                            String settlementAnswerStatus,
                                            String answerForSettlement){
}
