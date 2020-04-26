package DB.DBStrucure.Tables;

import DB.DBStrucure.Individuals.Enterprise;
import DB.DBStrucure.Individuals.IIndividual;
import DB.DBStrucure.Individuals.IndividualFactory;

import java.util.ArrayList;
import java.util.List;

public class Enterprise_tbl implements ITable<Enterprise> {
    private static volatile Enterprise_tbl instance;
    private List<Enterprise>  listEnterprise;
    private int rowId;
    private Enterprise_tbl(){
        listEnterprise= new ArrayList<Enterprise>();
        rowId = 0;
    }
    public static Enterprise_tbl GetInstance(){
        if (instance.equals(null)){
            instance = new Enterprise_tbl();
        }
        return instance;
    }

    @Override
    public List<Enterprise> SelectAll() throws CloneNotSupportedException{
        List<Enterprise> cloneList = new ArrayList<Enterprise>();
        for (Enterprise x: listEnterprise) {
            cloneList.add((Enterprise)x.clone());
        }
        return cloneList;
    }

    @Override
    public void Insert(Enterprise individual) {
        rowId++;
        listEnterprise.add((Enterprise)(IndividualFactory.GetInstance().GetIndividual(rowId, "Enterprise")));
    }

    @Override
    public void Delete(Enterprise individual) {

    }

    @Override
    public void Update(Enterprise individual) {

    }

    @Override
    public void AddRelation() {

    }
}
