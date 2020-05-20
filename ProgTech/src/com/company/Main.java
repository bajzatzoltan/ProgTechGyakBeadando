package com.company;

import DB.DBStrucure.Individuals.Person;
import DB.DBStrucure.Individuals.Settlement;
import DB.DBStrucure.Tables.Person_tbl;
import DB.DBStrucure.Tables.Settlement_tbl;
import Deployer.Deployer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException, ParseException {
        Deployer deployDB = new Deployer();

        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

        List<Settlement> settlementList = Settlement_tbl.GetInstance().SelectAll();
        for (Settlement x:settlementList ) {
            System.out.println(x.GetID() + ": " + x.getSettlementName());
        }
        List<Person> personList = Person_tbl.GetInstance().SelectAll();
        for (Person x:personList ) {
            System.out.println(x.GetID() + ": " +
                    x.GetFirstName() + " " +
                    x.GetLastName() + ", " +
                    x.GetBirthDay() + ", " +
                    x.GetAge()
            );
        }
    }
}
