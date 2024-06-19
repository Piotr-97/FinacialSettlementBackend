package s18746.financialsettlementbackend.utils;

import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;
import s18746.financialsettlementbackend.financialsettelmentsmanager.dtos.FinancialSettlementDto;



public class SettlementMapper {

    public static FinancialSettlementDto mapSettlementToDto(FinancialSettlement financialSettlement){
        return new FinancialSettlementDto(financialSettlement.getUuid(),financialSettlement.getStatus().getStatus(), financialSettlement.getSettlementType().getType(),financialSettlement.getWorkUnderProject().getProject().getName(),financialSettlement.getWorkUnderProject().getName(),financialSettlement.getAmountOfMoney().toString(),financialSettlement.getDescribe(),financialSettlement.getEmployee().getUuid(),financialSettlement.getEmployee().getFirstname() + " " + financialSettlement.getEmployee().getLastname(),financialSettlement.getDate());
    }
}
