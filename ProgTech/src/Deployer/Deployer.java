package Deployer;

import Client.RowSettlement;
import DB.DBStrucure.Tables.Settlement_tbl;

public class Deployer {
    private IndividualFactory factory;
    public Deployer (){
        factory = new IndividualFactory();
        InsertSettlements();
        InsertPersons();
        InsertEnterprise();
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
    public  void InsertPersons(){

    }
    public  void InsertEnterprise(){

    }


}
