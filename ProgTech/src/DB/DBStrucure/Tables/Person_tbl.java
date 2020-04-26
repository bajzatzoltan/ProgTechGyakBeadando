package DB.DBStrucure.Tables;

import DB.DBStrucure.Individuals.IIndividual;
import DB.DBStrucure.Individuals.Person;

import java.util.ArrayList;
import java.util.List;

//singleton

public class Person_tbl implements ITable<Person> {
    private List<Person> listPerson;
    private static volatile Person_tbl instance;
    private Person_tbl(){
        listPerson = new ArrayList<Person>();
    }
    public static Person_tbl GetInstance(){
        if (instance.equals(null)) {
            instance = new Person_tbl();
        }
        return instance;
    }
    @Override
    public List<Person> SelectAll() {
        // deep copy-ra van szükség
        return listPerson;
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
