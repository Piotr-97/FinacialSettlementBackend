package s18746.financialsettlementbackend.financialsettelmentsmanager;

public enum SettlementType {

    BUSSINESTRIP("Delegacja"), TAXI("Przejazd"), GENERAL("Ogolne"), BUSSINESMEETING("Spotkanie biznesowe");



    private String type;

    SettlementType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
