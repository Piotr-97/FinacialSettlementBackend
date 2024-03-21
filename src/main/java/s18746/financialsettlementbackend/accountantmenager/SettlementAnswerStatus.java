package s18746.financialsettlementbackend.accountantmenager;

public enum SettlementAnswerStatus {

    WAITING_FOR_RESPONSE("Oczekuje na Odpowiedz"),DENIED("Niezaakceptowana"), RESOLVED("Rozwiazana");



    private final String status;
    SettlementAnswerStatus(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
