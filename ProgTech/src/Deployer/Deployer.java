package Deployer;

import Client.RowPerson;
import Client.RowSettlement;
import DB.DBStrucure.Relations_tbl;
import DB.DBStrucure.Tables.Person_tbl;
import DB.DBStrucure.Tables.Settlement_tbl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deployer {
    private IndividualFactory factory;
    public Deployer () throws ParseException, CloneNotSupportedException {
        factory = new IndividualFactory();

        CreateRelations();
        InsertSettlements();
        InsertPersons();
        InsertEnterprise();
    }

    public void CreateRelations(){
        Relations_tbl.GetInstance().AddRelation(Settlement_tbl.GetInstance(), Person_tbl.GetInstance());
    }


    public void InsertSettlements(){
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
    public  void InsertPersons() throws ParseException, CloneNotSupportedException {
        RowPerson individual01 = (RowPerson) factory.GetIndividual("RowPerson");
        individual01.SetFirstName("Kis");
        individual01.SetLastName("Cica");
        individual01.SetBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000"));
        individual01.setSettlement_ID_fk(1);

        RowPerson individual02 = (RowPerson) factory.GetIndividual("RowPerson");
        individual02.SetFirstName("Nagy");
        individual02.SetLastName("Kutya");
        individual02.SetBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1998"));
        individual02.setSettlement_ID_fk(2);

        Person_tbl.GetInstance().Insert(individual01);
        Person_tbl.GetInstance().Insert(individual02);
    }

    public  void InsertEnterprise(){

    }


}
