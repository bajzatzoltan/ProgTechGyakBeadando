package Client.Individuals;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class RowPerson implements IRowIndividual {
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
    public void setSettlement_ID_fk(int settlement_ID_fk)
    {
        this.settlement_ID_fk = settlement_ID_fk;
    }

}
