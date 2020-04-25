package DB;

import DB.DBStrucure.AbsTable;
import DB.DBStrucure.IIndividual;
import DB.DBStrucure.Person;
import java.util.List;

public class Person_tbl implements AbsTable {
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
}
