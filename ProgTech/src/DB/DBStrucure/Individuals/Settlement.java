package DB.DBStrucure.Individuals;


public class Settlement implements IIndividual, Cloneable  {

    private int ID;
    public int GetID() {
        return ID;
    }
    private String settlementName;

    public String getSettlementName() {
        return settlementName;
    }
    public void setSettlementName(String settlementName) {
        this.settlementName = settlementName;
    }


    public Settlement(int ID) // konstruktorba csak kötelező adatok kerülnek
    {
        this.ID = ID;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
