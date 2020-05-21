package Tests;

import DB.DBStrucure.Individuals.Person;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class PersonTest {

    @org.junit.Test
    public void SetFirstName_ValidValue_Test() {
        Person testPerson = new Person(1);
        testPerson.SetFirstName("teszname");
        assertEquals("teszname",testPerson.GetFirstName());
    }
    @org.junit.Test
    public void GetAge_ValidValueFromBirthDay_Test() throws Exception {
        int expectedYear = 20;
        Person testPerson = new Person(1);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -20);
        Date testBirthDay = cal.getTime();

        testPerson.SetBirthDay(testBirthDay);
        assertEquals(expectedYear,testPerson.GetAge());
    }

    @org.junit.Test
    public void SetAgeFromBirthDay_InvalidValue_Test() throws Exception {
        Person testPerson = new Person(1);

        try {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, 20);
            Date testBirthDay = cal.getTime();
        }catch (Exception ex){
            assertEquals("Invalid birthday date.", ex.getMessage());
        }
    }

    @org.junit.Test
    public void SetBirthDay_ValidValueFromBirthDay_Test() throws Exception {
        Person testPerson = new Person(1);
        Date expectedDate = new SimpleDateFormat("yyyy-mm-dd").parse("2000-01-01");
        testPerson.SetBirthDay(expectedDate);
        assertEquals(expectedDate, testPerson.GetBirthDay());
    }

    @org.junit.Test
    public void SetBirthDay_InvalidValueFromBirthDay_Test() throws Exception {
        Person testPerson = new Person(1);

        try {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, 20);
            Date testBirthDay = cal.getTime();
        }catch (Exception ex){
            assertEquals("Invalid birthday date.", ex.getMessage());
        }
    }
}