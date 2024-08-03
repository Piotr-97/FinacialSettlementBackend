package s18746.financialsettlementbackend.utils;

import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;
import s18746.financialsettlementbackend.financialsettelmentsmanager.dtos.FinancialSettlementDto;

import java.util.ArrayList;
import java.util.List;


public class SettlementMapper {

    public static FinancialSettlementDto mapSettlementToDto(FinancialSettlement financialSettlement){
        return new FinancialSettlementDto(financialSettlement.getUuid(),financialSettlement.getStatus().getStatus(), financialSettlement.getSettlementType().getType(),financialSettlement.getWorkUnderProject().getProject().getName(),financialSettlement.getWorkUnderProject().getName(),financialSettlement.getAmountOfMoney().toString(),financialSettlement.getDescription(),financialSettlement.getEmployee().getUuid(),financialSettlement.getEmployee().getFirstname() + " " + financialSettlement.getEmployee().getLastname(),financialSettlement.getDate().toString());
    }

    public static List<FinancialSettlementDto> mapSettlementsToDtos(List<FinancialSettlement> financialSettlement){
        List<FinancialSettlementDto> settlements = new ArrayList<>();
        financialSettlement.forEach(x ->settlements.add(new FinancialSettlementDto(x.getUuid(),x.getStatus().getStatus(),x.getSettlementType().getType(),x.getWorkUnderProject().getProject().getName(),x.getWorkUnderProject().getName(),x.getAmountOfMoney().toString(),x.getDescription(),x.getEmployee().getUuid(),x.getEmployee().getFirstname() + " " + x.getEmployee().getLastname(),x.getDate().toString())) );
        return settlements;
    }


}
