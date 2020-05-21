package Deployer;

import Client.Individuals.RowEnterprise;
import Client.Individuals.RowPerson;
import Client.Individuals.RowSettlement;
import DB.DBStrucure.Relations_tbl;
import DB.DBStrucure.Tables.Enterprise_tbl;
import DB.DBStrucure.Tables.Person_tbl;
import DB.DBStrucure.Tables.Settlement_tbl;
import DB.DBStrucure.User;
import DB.DBStrucure.Users_tbl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Deployer {
    private IndividualFactory factory;
    public Deployer () throws Exception {
        factory = new IndividualFactory();

        CreateRelations();
        CreateUsers();
        InsertSettlements();
        InsertPersons();
        InsertEnterprise();
    }

    private void CreateRelations(){
        Relations_tbl.GetInstance().AddRelation(Settlement_tbl.GetInstance(), Person_tbl.GetInstance());
        Relations_tbl.GetInstance().AddRelation(Settlement_tbl.GetInstance(), Enterprise_tbl.GetInstance());
    }

    private void CreateUsers() throws Exception {
        User user01 = new User("userName01", "pass01");
        Users_tbl.GetInstance().AddUser(user01);
        User user02 = new User("userName02", "pass02");
        Users_tbl.GetInstance().AddUser(user02);
    }


    private void InsertSettlements(){
        RowSettlement individual01 = (RowSettlement) factory.GetIndividual("RowSettlement");
        individual01.setSettlementName("Eger");
        RowSettlement individual02 = (RowSettlement) factory.GetIndividual("RowSettlement");
        individual02.setSettlementName("Miskolc");
        RowSettlement individual03 = (RowSettlement) factory.GetIndividual("RowSettlement");
        individual03.setSettlementName("Gyöngyös");


        Settlement_tbl.GetInstance().Insert(individual01);
        Settlement_tbl.GetInstance().Insert(individual02);
        Settlement_tbl.GetInstance().Insert(individual03);
    }
    private  void InsertPersons() throws Exception {
        RowPerson individual01 = (RowPerson) factory.GetIndividual("RowPerson");
        individual01.SetFirstName("Kis");
        individual01.SetLastName("Cica");
        individual01.SetBirthDay(new SimpleDateFormat("yyyy-mm-dd").parse("2000-01-01"));
        individual01.setSettlement_ID_fk(1);

        RowPerson individual02 = (RowPerson) factory.GetIndividual("RowPerson");
        individual02.SetFirstName("Nagy");
        individual02.SetLastName("Kutya");
        individual02.SetBirthDay(new SimpleDateFormat("yyyy-mm-dd").parse("1999-01-01"));
        individual02.setSettlement_ID_fk(2);

        Person_tbl.GetInstance().Insert(individual01);
        Person_tbl.GetInstance().Insert(individual02);
    }

    private  void InsertEnterprise() throws CloneNotSupportedException {
        RowEnterprise individual01 = (RowEnterprise) factory.GetIndividual("RowEnterprise");
        individual01.setName("MIKROSZOFT e.v.");
        individual01.setTaxNumber("12345678-1-01");
        individual01.setSettlement_ID_fk(1);

        RowEnterprise individual02 = (RowEnterprise) factory.GetIndividual("RowEnterprise");
        individual02.setName("EPL Bt.");
        individual02.setTaxNumber("87654321-2-02");
        individual02.setSettlement_ID_fk(3);

        Enterprise_tbl.GetInstance().Insert(individual01);
        Enterprise_tbl.GetInstance().Insert(individual02);
    }


}
