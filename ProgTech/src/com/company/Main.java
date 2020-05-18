package com.company;

import DB.DBStrucure.Individuals.Settlement;
import DB.DBStrucure.Tables.Settlement_tbl;
import Deployer.Deployer;

import java.util.List;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Deployer deployDB = new Deployer();
        List<Settlement> settlementList = Settlement_tbl.GetInstance().SelectAll();
        for (Settlement x:settlementList ) {
            System.out.println(x.GetID() + ": " + x.getSettlementName());
        }
    }
}
