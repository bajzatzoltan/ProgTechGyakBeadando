package DB.DBStrucure.Tables;

import DB.DBStrucure.Individuals.IIndividual;
import DB.DBStrucure.Individuals.IndividualFactory;
import DB.DBStrucure.Individuals.Person;
import DB.DBStrucure.Individuals.Settlement;
import DB.DBStrucure.Relation;
import DB.DBStrucure.Relations_tbl;

import java.util.ArrayList;
import java.util.List;

public class Settlement_tbl<P> implements ITable<Settlement> {
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
    public void Delete(int ID) {
        int counter = 0;
        while (counter < listSettlement.size()){
            if (listSettlement.get(counter).GetID() == ID){
                listSettlement.remove(counter);
                counter = listSettlement.size() + 1;
            }
            counter++;
        }
        if (counter == listSettlement.size()){
            throw  new ArrayIndexOutOfBoundsException("Settlement_tbl.listSettlement does not contain this ID");
        }
    }

    @Override
    public void Update(int ID, Settlement individual) {
        for (Settlement x :  listSettlement) {
            if (x.GetID() == ID) {
                x = individual;
            }
        }
    }

    @Override
    public Settlement GetInstanceByID(int ID) throws CloneNotSupportedException {
        int counter = 0;
        Settlement resultInstance = null;
        while (counter < listSettlement.size()){
            if (listSettlement.get(counter).GetID() == ID){
                resultInstance = listSettlement.get(counter);
            }
            counter++;
        }
        if (resultInstance == null){
            throw  new IndexOutOfBoundsException("Settlement_tbl.listSettlement does not contain this ID");
        }
        return (Settlement) resultInstance.clone();
    }


    private void AddRelation(P parent) {
        Relations_tbl.GetInstance().AddRelation(parent, instance);
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
