package DB.DBStrucure.Tables;

import DB.DBStrucure.Individuals.IIndividual;
import DB.DBStrucure.Individuals.Settlement;

import java.util.ArrayList;
import java.util.List;

public class Settlement_tbl implements ITable<Settlement> {
    private static Settlement_tbl instance;
    private List<Settlement> listSettlement;

    public static Settlement_tbl GetInstance() {
        if (instance.equals(null)) {
            instance = new Settlement_tbl();
        }
        return  instance;
    }

    private Settlement_tbl() {
        listSettlement = new ArrayList<Settlement>();
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

    @Override
    public List<Settlement> SelectAll() {
        return listSettlement;
    }
}
