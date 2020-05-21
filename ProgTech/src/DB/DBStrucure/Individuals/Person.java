package DB.DBStrucure.Individuals;

import DB.DBStrucure.Relation;
import DB.DBStrucure.Relations_tbl;
import DB.DBStrucure.Tables.Person_tbl;
import DB.DBStrucure.Tables.Settlement_tbl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Person implements IIndividual, Cloneable{
    private int ID;
    public int GetID()
    {
        return ID;
    }
    private String firstName;
    public String GetFirstName()
    {
        return firstName;
    }
    public void SetFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    private String lastName;
    public String GetLastName()
    {
        return lastName;
    }
    public void SetLastName(String lastName)
    {
        this.lastName = lastName;
    }
    private Date birthDay;
    public Date GetBirthDay()
    {
        return birthDay;
    }
    public void SetBirthDay(Date birthDay) throws Exception {
        if (birthDay.before(new Date())){
            this.birthDay = birthDay;
        }
        else{
            throw new Exception("Invalid birthday date.");
        }
        int tempCurrentYear = Calendar.getInstance().get(Calendar.YEAR);
        LocalDate localdateBirthday = birthDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int birthdayYear = localdateBirthday.getYear();
        this.age = tempCurrentYear - birthdayYear;
    }
    private int age;
    public int GetAge()
    {
        return  age;
    }

    private int settlement_ID_fk;
    public int getSettlement_ID_fk() {
        return settlement_ID_fk;
    }
    public void setSettlement_ID_fk(int settlement_ID_fk) throws  IndexOutOfBoundsException, CloneNotSupportedException {
        Relation<Settlement_tbl, Person_tbl> relation = new Relation<>(Settlement_tbl.GetInstance(), Person_tbl.GetInstance());
        if (Relations_tbl.GetInstance().IsContainRelation(relation)){
            Settlement settlement = Settlement_tbl.GetInstance().GetInstanceByID(settlement_ID_fk);
            this.settlement_ID_fk = settlement_ID_fk;
        }
        else {
            throw new ArrayStoreException("Relations_tbl.listRelations does not contain this relation.");
        }

    }
    public Person(int ID) // konstruktorba csak kötelező adatok kerülnek
    {
        this.ID = ID;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
