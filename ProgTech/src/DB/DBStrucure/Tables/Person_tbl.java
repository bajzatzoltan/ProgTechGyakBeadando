package DB.DBStrucure.Tables;

import Client.Individuals.RowPerson;
import DB.DBStrucure.Individuals.IndividualFactory;
import DB.DBStrucure.Individuals.Person;

import java.util.ArrayList;
import java.util.List;

public class Person_tbl implements ITable<RowPerson, Person> {
    private List<Person> listPerson;
    private int rowId;
    private static volatile Person_tbl instance;
    private Person_tbl(){
        listPerson = new ArrayList<Person>();
        rowId = 0;
    }
    public static Person_tbl GetInstance(){
        if (instance == null) {
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
    public void Insert(RowPerson individual) throws CloneNotSupportedException {
        rowId++;
        Person concrateIndividual =
                (Person)IndividualFactory.GetInstance().GetIndividual(rowId, "Person");
        concrateIndividual.setSettlement_ID_fk(individual.getSettlement_ID_fk());
        concrateIndividual.SetFirstName(individual.GetFirstName());
        concrateIndividual.SetLastName(individual.GetLastName());
        concrateIndividual.SetBirthDay(individual.GetBirthDay());
        listPerson.add(concrateIndividual);
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
    public void Update(int ID, RowPerson individual) throws CloneNotSupportedException {
        int counter = 0;
        while (counter < listPerson.size()){
            if (listPerson.get(counter).GetID() == ID){
                Person concrateIndividual =
                        (Person)IndividualFactory.GetInstance().GetIndividual(ID, "Person");
                concrateIndividual.setSettlement_ID_fk(individual.getSettlement_ID_fk());
                concrateIndividual.SetFirstName(individual.GetFirstName());
                concrateIndividual.SetLastName(individual.GetFirstName());
                concrateIndividual.SetBirthDay(individual.GetBirthDay());
                listPerson.set(counter, concrateIndividual);
                counter = listPerson.size() + 1;
            }
            counter++;
        }
        if (counter == listPerson.size()){
            throw  new ArrayIndexOutOfBoundsException("Person_tbl.listPerson does not contain this ID");
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

}
