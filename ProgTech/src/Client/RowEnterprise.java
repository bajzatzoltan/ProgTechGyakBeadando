package Client;

public class RowEnterprise {
    private String name;
    private String taxNumber;
    private int settlement_ID_fk;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public int getSettlement_ID_fk() {
        return settlement_ID_fk;
    }

    public void setSettlement_ID_fk(int settlement_ID_fk) {
        this.settlement_ID_fk = settlement_ID_fk;
    }
}
