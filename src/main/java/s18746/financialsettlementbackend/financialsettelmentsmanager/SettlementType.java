package s18746.financialsettlementbackend.financialsettelmentsmanager;

public enum SettlementType {

    BUSSINESTRIP("businesstrip"), TAXI("TAXI"), GENERAL("general"), BUSSINESMEETING("businessmeeting");



    private final String type;

    SettlementType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
