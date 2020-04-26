package DB.DBStrucure.Tables;

import DB.DBStrucure.Individuals.Enterprise;
import DB.DBStrucure.Individuals.IIndividual;

import java.util.ArrayList;
import java.util.List;

public class Enterprise_tbl implements ITable<Enterprise> {
    private static volatile Enterprise_tbl instance;
    private List<Enterprise>  listEnterprise;
    private Enterprise_tbl(){
        listEnterprise= new ArrayList<Enterprise>();
    }
    public static Enterprise_tbl GetInstance(){
        if (instance.equals(null)){
            instance = new Enterprise_tbl();
        }
        return instance;
    }

    @Override
    public List<Enterprise> SelectAll() {
        //deep copy kell
        return listEnterprise;
    }

    @Override
    public void Insert(IIndividual individual) {

    }

    @Override
    public void Delete(IIndividual individual) {

    }

    @Override
    public void Update(IIndividual individual) {

    }

    @Override
    public void AddRelation() {

    }
}
