package DB.DBStrucure.Tables;

import DB.DBStrucure.Individuals.IIndividual;
import DB.DBStrucure.Individuals.IndividualFactory;
import DB.DBStrucure.Individuals.Settlement;
import DB.DBStrucure.Relation;

import java.util.ArrayList;
import java.util.List;

public class Settlement_tbl implements ITable<Settlement> {
    private static Settlement_tbl instance;
    private List<Settlement> listSettlement;
    private int rowId;

    public static Settlement_tbl GetInstance() {
        if (instance.equals(null)) {
            instance = new Settlement_tbl();
        }
        return  instance;
    }

    private Settlement_tbl() {
        listSettlement = new ArrayList<Settlement>();
        rowId = 0;
    }

    @Override
    public void Insert(Settlement individual) {
        rowId++;
        listSettlement.add((Settlement)(IndividualFactory.GetInstance().GetIndividual(rowId, "Settlement")));
    }

    @Override
    public void Delete(Settlement individual) {

    }

    @Override
    public void Update(Settlement individual) {

    }

    @Override
    public void AddRelation() {

    }

    @Override
    public List<Settlement> SelectAll() throws CloneNotSupportedException {
        List<Settlement> cloneList = new ArrayList<Settlement>();
        for (Settlement x: listSettlement) {
            cloneList.add((Settlement)x.clone());
        }
        return cloneList;
    }
}
