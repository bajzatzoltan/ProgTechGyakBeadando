package DB.DBStrucure;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Person implements IIndividual{
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
        //this.age = currentDay-birthDay;
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
    public Person(int ID)
    {
        this.ID = ID;
    }
}
