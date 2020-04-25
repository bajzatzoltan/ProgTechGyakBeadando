package DB;

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
