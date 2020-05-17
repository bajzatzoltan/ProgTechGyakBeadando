package DB.DBStrucure.Tables;

import DB.DBStrucure.Individuals.IIndividual;
import DB.DBStrucure.Individuals.IndividualFactory;
import DB.DBStrucure.Individuals.Person;
import DB.DBStrucure.Relations_tbl;

import java.util.ArrayList;
import java.util.List;

//singleton

public class Person_tbl<P> implements ITable<Person> {
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
    public void Delete(int ID) {
        int counter = 0;
        while (counter < listPerson.size()){
            if (listPerson.get(counter).GetID() == ID){
                listPerson.remove(counter);
                counter = listPerson.size() + 1;
            }
            counter++;
        }
        if (counter == listPerson.size()){
            throw  new ArrayIndexOutOfBoundsException("Person_tbl.listPerson does not contain this ID");
        }
    }
    @Override
    public void Update(int ID, Person individual) {
        for (Person x :  listPerson) {
            if (x.GetID() == ID) {
                x = individual;

            }
        }
    }

    @Override
    public Person GetInstanceByID(int ID) throws CloneNotSupportedException {
        int counter = 0;
        Person resultInstance = null;
        while (counter < listPerson.size()){
            if (listPerson.get(counter).GetID() == ID){
                resultInstance = listPerson.get(counter);
            }
            counter++;
        }
        if (resultInstance == null){
            throw  new IndexOutOfBoundsException("Person_tbl.listPerson does not contain this ID");
        }
        return (Person)resultInstance.clone();
    }
    private void AddRelation(P parent) {
        Relations_tbl.GetInstance().AddRelation(parent, instance);
    }


}
