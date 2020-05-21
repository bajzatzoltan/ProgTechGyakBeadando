package DB.DBStrucure.Tables;

import Client.Individuals.RowEnterprise;
import DB.DBStrucure.Individuals.Enterprise;
import DB.DBStrucure.Individuals.IndividualFactory;
import java.util.ArrayList;
import java.util.List;

public class Enterprise_tbl implements ITable<RowEnterprise, Enterprise> {

    private static volatile Enterprise_tbl instance;
    private List<Enterprise>  listEnterprise;
    private int rowId;
    private Enterprise_tbl(){
        listEnterprise= new ArrayList<Enterprise>();
        rowId = 0;
    }
    public static Enterprise_tbl GetInstance(){
        if (instance == null){
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
    public void Insert(RowEnterprise individual) throws CloneNotSupportedException {
        rowId++;
        Enterprise concrateIndividual =
                (Enterprise)IndividualFactory.GetInstance().GetIndividual(rowId, "Enterprise");
        concrateIndividual.setName(individual.getName());
        concrateIndividual.setTaxNumber(individual.getTaxNumber());
        concrateIndividual.setSettlement_ID_fk(individual.getSettlement_ID_fk());
        listEnterprise.add(concrateIndividual);
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
    public void Update(int ID, RowEnterprise individual) throws CloneNotSupportedException {
        int counter = 0;
        while (counter < listEnterprise.size()){
            if (listEnterprise.get(counter).GetID() == ID){
                Enterprise concrateIndividual =
                        (Enterprise)IndividualFactory.GetInstance().GetIndividual(ID, "Enterprise");
                concrateIndividual.setName(individual.getName());
                concrateIndividual.setTaxNumber(individual.getTaxNumber());
                concrateIndividual.setSettlement_ID_fk(individual.getSettlement_ID_fk());
                listEnterprise.set(counter, concrateIndividual);
                counter = listEnterprise.size() + 1;
            }
            counter++;
        }
        if (counter == listEnterprise.size()){
            throw  new ArrayIndexOutOfBoundsException("Enterprise_tbl.listEnterprise does not contain this ID");
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

}
