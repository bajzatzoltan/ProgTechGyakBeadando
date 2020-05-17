package DB.DBStrucure.Tables;

import DB.DBStrucure.Individuals.Enterprise;
import DB.DBStrucure.Individuals.IIndividual;
import DB.DBStrucure.Individuals.IndividualFactory;
import DB.DBStrucure.Relations_tbl;

import java.util.ArrayList;
import java.util.List;

public class Enterprise_tbl<P> implements ITable<Enterprise> {

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
    public void Delete(int ID) {
        int counter = 0;
        while (counter < listEnterprise.size()){
            if (listEnterprise.get(counter).GetID() == ID){
                listEnterprise.remove(counter);
                counter = listEnterprise.size() + 1;
            }
            counter++;
        }
        if (counter == listEnterprise.size()){
            throw  new ArrayIndexOutOfBoundsException("Enterprise_tbl.listEnterprise does not contain this ID");
        }
    }

    @Override
    public void Update(int ID, Enterprise individual) {
        for (Enterprise x :  listEnterprise) {
            if (x.GetID() == ID){
                x = individual;
            }
        }
        

    }

    @Override
    public Enterprise GetInstanceByID(int ID) throws CloneNotSupportedException{
        int counter = 0;
        Enterprise resultInstance = null;
        while (counter < listEnterprise.size()){
            if (listEnterprise.get(counter).GetID() == ID){
                resultInstance = listEnterprise.get(counter);
            }
            counter++;
        }
        if (resultInstance == null){
            throw  new IndexOutOfBoundsException("Enterprise_tbl.listEnterprise does not contain this ID");
        }
        return (Enterprise) resultInstance.clone();
    }


    private void AddRelation(P parent) {
        Relations_tbl.GetInstance().AddRelation(parent, instance);
    }
}
