package s18746.financialsettlementbackend.financialsettelmentsmanager;

public enum SettlementType {

    BUSINESSTRIP("businesstrip"), TAXI("TAXI"), GENERAL("general"), BUSINESSMEETING("businessmeeting");



    private final String type;

    SettlementType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
