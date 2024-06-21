package s18746.financialsettlementbackend.accountantmenager;

public enum SettlementAnswerStatus {

    WAITING_FOR_RESPONSE("Waiting"),DENIED("DENIED"), RESOLVED("RESOLVED");



    private final String status;
    SettlementAnswerStatus(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
