package DB.DBStrucure.Tables;

import DB.DBStrucure.Individuals.IIndividual;
import DB.DBStrucure.Individuals.IndividualFactory;
import DB.DBStrucure.Individuals.Person;

import java.util.ArrayList;
import java.util.List;

//singleton

public class Person_tbl implements ITable<Person> {
    private List<Person> listPerson;
    private int rowId;
    private static volatile Person_tbl instance;
    private Person_tbl(){
        listPerson = new ArrayList<Person>();
        rowId = 0;
    }
    public static Person_tbl GetInstance(){
        if (instance.equals(null)) {
            instance = new Person_tbl();
        }
        return instance;
    }
    @Override
    public List<Person> SelectAll() throws CloneNotSupportedException {
        List<Person> cloneList = new ArrayList<Person>();
        for (Person x: listPerson) {
            cloneList.add((Person)x.clone());
        }
        return cloneList;
    }
    @Override
    public void Insert(Person individual) {
        rowId++;
        listPerson.add((Person)(IndividualFactory.GetInstance().GetIndividual(rowId, "Person")));
    }
    @Override
    public void Delete(Person individual) {

    }
    @Override
    public void Update(Person individual) {

    }
    @Override
    public void AddRelation() {
        //ez hívja meg: Relations_tbl.AddRelation(Parent_tbl.getInstance,this.GetInstance);
    }


}
