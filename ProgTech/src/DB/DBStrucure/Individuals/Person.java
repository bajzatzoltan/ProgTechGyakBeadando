package DB.DBStrucure.Individuals;

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
    public void SetBirthDay(Date birthDay)
    {
        this.birthDay = birthDay;
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
    public void setSettlement_ID_fk(int settlement_ID_fk) {
        // a tábla példányban vizsgálni kell hogy a settlement tábla tartalmazza-e a fk-t ezt a táblában kell definiálni
        this.settlement_ID_fk = settlement_ID_fk;
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
