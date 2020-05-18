package DB.DBStrucure.Tables;

import Client.RowSettlement;
import DB.DBStrucure.Individuals.IndividualFactory;
import DB.DBStrucure.Individuals.Settlement;

import java.util.ArrayList;
import java.util.List;

public class Settlement_tbl implements ITable<RowSettlement,Settlement> {
    private static volatile Settlement_tbl instance;
    private List<Settlement> listSettlement;
    private int rowId;

    public static Settlement_tbl GetInstance() {
        if (instance == null) {
            instance = new Settlement_tbl();
        }
        return  instance;
    }

    private Settlement_tbl() {
        listSettlement = new ArrayList<Settlement>();
        rowId = 0;
    }

    @Override
    public void Insert(RowSettlement individual) {
        rowId++;
        Settlement concrateIndividual =
                (Settlement)IndividualFactory.GetInstance().GetIndividual(rowId, "Settlement");
        concrateIndividual.setSettlementName(individual.getSettlementName());
        listSettlement.add(concrateIndividual);
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
    public void Update(int ID, RowSettlement individual) {
        int counter = 0;
        while (counter < listSettlement.size()){
            if (listSettlement.get(counter).GetID() == ID){
                Settlement concrateIndividual =
                        (Settlement)IndividualFactory.GetInstance().GetIndividual(ID, "Settlement");
                concrateIndividual.setSettlementName(individual.getSettlementName());
                listSettlement.set(counter, concrateIndividual);
                counter = listSettlement.size() + 1;
            }
            counter++;
        }
        if (counter == listSettlement.size()){
            throw  new ArrayIndexOutOfBoundsException("Settlement_tbl.listSettlement does not contain this ID");
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

    @Override
    public List<Settlement> SelectAll() throws CloneNotSupportedException {
        List<Settlement> cloneList = new ArrayList<Settlement>();
        for (Settlement x: listSettlement) {
            cloneList.add((Settlement)x.clone());
        }
        return cloneList;
    }
}
