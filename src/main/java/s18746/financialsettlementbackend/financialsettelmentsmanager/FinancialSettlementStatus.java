package s18746.financialsettlementbackend.financialsettelmentsmanager;

public enum FinancialSettlementStatus {

    DECLINED("declined"),ACCEPTED("accepted"),PENDING("pending");
    private final String status;

    FinancialSettlementStatus(String status) {
        this.status = status;
    }


    public String getStatus() {
        return status;
    }
}
