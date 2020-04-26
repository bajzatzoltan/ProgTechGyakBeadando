package DB.DBStrucure.Individuals;

public class Enterprise implements IIndividual, Cloneable {
    private int ID;
    public int GetID()
    {
        return ID;
    }
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String taxNumber;
    public String getTaxNumber() {
        return taxNumber;
    }
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }
    private int settlement_ID_fk;
    public int getSettlement_ID_fk() {
        return settlement_ID_fk;
    }
    public void setSettlement_ID_fk(int settlement_ID_fk) {
        // a tábla példányban vizsgálni kell hogy a settlement tábla tartalmazza-e a fk-t ezt a táblában kell definiálni
        this.settlement_ID_fk = settlement_ID_fk;
    }

    public Enterprise(int ID) // konstruktorba csak kötelező adatok kerülnek
    {
        this.ID = ID;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
