package DB.DBStrucure.Individuals;

import DB.DBStrucure.Relation;
import DB.DBStrucure.Relations_tbl;
import DB.DBStrucure.Tables.Enterprise_tbl;
import DB.DBStrucure.Tables.Settlement_tbl;

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
    public void setSettlement_ID_fk(int settlement_ID_fk) throws  IndexOutOfBoundsException, CloneNotSupportedException {
        Relation<Settlement_tbl, Enterprise_tbl> relation = new Relation<>(Settlement_tbl.GetInstance(), Enterprise_tbl.GetInstance());
        if (Relations_tbl.GetInstance().IsContainRelation(relation)){
            Settlement settlement = Settlement_tbl.GetInstance().GetInstanceByID(settlement_ID_fk);
            this.settlement_ID_fk = settlement_ID_fk;
        }
        else {
            throw new ArrayStoreException("Relations_tbl.listRelations does not contain this relation.");
        }
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
