package DB.DBStrucure.Tables;

import DB.DBStrucure.Individuals.IIndividual;
import DB.DBStrucure.Individuals.Person;
import DB.DBStrucure.Relations_tbl;

import java.util.List;

//singleton

public class Person_tbl implements ITable {
    private static volatile List<Person> instance;


    public static List<Person> SelectAll() {
        // deep copy-ra van szükség
        return instance;
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
        //ez hívja meg: Relations_tbl.AddRelation(Parent_tbl.getInstance,this.GetInstance);
    }


}
