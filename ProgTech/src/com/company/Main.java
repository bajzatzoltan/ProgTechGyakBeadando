package com.company;

import Client.DMLOperation.*;
import Client.Individuals.RowEnterprise;
import Client.Individuals.RowPerson;
import Client.Individuals.RowSettlement;
import DB.DBStrucure.Individuals.Enterprise;
import DB.DBStrucure.Individuals.Person;
import DB.DBStrucure.Individuals.Settlement;
import DB.DBStrucure.Tables.Enterprise_tbl;
import DB.DBStrucure.Tables.Person_tbl;
import DB.DBStrucure.Tables.Settlement_tbl;
import DB.DBStrucure.User;
import DB.InterfaceFacade;
import Deployer.Deployer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd");
        Deployer deployDB = new Deployer();
        InterfaceFacade interfaceFacade = new InterfaceFacade(new User("userName01", "pass01"));
        User user = new User("userName02", "pass02");

        //region CHECK DEPLOY
        System.out.println("-----------------------------------------------------");
        System.out.println("CHECK DEPLOY:");
        System.out.println();
        try {
            List<Settlement> settlementList = Settlement_tbl.GetInstance().SelectAll();
            for (Settlement x : settlementList) {
                System.out.println(x.GetID() + ": " + x.getSettlementName());
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println();
        try {
            List<Person> personList = Person_tbl.GetInstance().SelectAll();
            for (Person x : personList) {
                System.out.println(x.GetID() + ": " +
                        x.GetFirstName() + " " +
                        x.GetLastName() + ", " +
                        dateFormatter.format(x.GetBirthDay()) + ", " +
                        x.GetAge()
                );
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println();
        try {
            List<Enterprise> enterpriseList = Enterprise_tbl.GetInstance().SelectAll();
            for (Enterprise x : enterpriseList) {
                System.out.println(x.GetID() + ": " +
                        x.getName() + ", " +
                        x.getTaxNumber() + ", " +
                        x.getSettlement_ID_fk()
                );
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println();
        //endregion

        //region CHECK INSERT OPERATION
        System.out.println("-----------------------------------------------------");
        System.out.println("CHECK INSERT OPERATION:");
        RowSettlement rowSettlement01 = new RowSettlement();
        rowSettlement01.setSettlementName("Szeged");

        RowPerson rowPerson01 = new RowPerson();
        rowPerson01.SetFirstName("Pici");
        rowPerson01.SetLastName("Egér");
        rowPerson01.SetBirthDay(new SimpleDateFormat("yyyy-mm-dd").parse("2003-03-03"));
        rowPerson01.setSettlement_ID_fk(1);

        RowEnterprise rowEnterprise01 = new RowEnterprise();
        rowEnterprise01.setName("Mikrobi e.v.");
        rowEnterprise01.setTaxNumber("3333333-1-01");
        rowEnterprise01.setSettlement_ID_fk(2);

        try{
            DMLInsert dmlInsertSettlement = new DMLInsert(user, rowSettlement01);
            DMLInsert dmlInsertPerson = new DMLInsert(user, rowPerson01);
            DMLInsert dmlInsertEnterprise = new DMLInsert(user, rowEnterprise01);
            dmlInsertSettlement.TemplateMethod();
            dmlInsertPerson.TemplateMethod();
            dmlInsertEnterprise.TemplateMethod();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println();
        try {
            List<Settlement> settlementList2 = interfaceFacade.Settlement_tbl_SelectAll();
            for (Settlement x : settlementList2) {
                System.out.println(x.GetID() + ": " + x.getSettlementName());
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println();
        try {
            List<Person> personList2 = interfaceFacade.Person_tbl_SelectAll();
            for (Person x : personList2) {
                System.out.println(x.GetID() + ": " +
                        x.GetFirstName() + " " +
                        x.GetLastName() + ", " +
                        dateFormatter.format(x.GetBirthDay()) + ", " +
                        x.GetAge()
                );
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println();
        try {
            List<Enterprise> enterpriseList2 = interfaceFacade.Enterprise_tbl_SelectAll();
            for (Enterprise x : enterpriseList2) {
                System.out.println(x.GetID() + ": " +
                        x.getName() + ", " +
                        x.getTaxNumber() + ", " +
                        x.getSettlement_ID_fk()
                );
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println();

        //endregion


        //region CHECK UPDATE OPERATION
        System.out.println("-----------------------------------------------------");
        System.out.println("CHECK UPDATE OPERATION:");
        rowSettlement01.setSettlementName("UpdatedSzeged");

        rowPerson01.SetFirstName("UpdatedPici");
        rowPerson01.SetLastName("UpdatedEgér");
        rowPerson01.SetBirthDay(new SimpleDateFormat("yyyy-mm-dd").parse("2000-01-01"));
        rowPerson01.setSettlement_ID_fk(3);

        rowEnterprise01.setName("Updated Mikrobi e.v.");
        rowEnterprise01.setTaxNumber("Updated 3333333-1-01");
        rowEnterprise01.setSettlement_ID_fk(3);

        try{
            DMLUpdate dmlUpdateSettlement = new DMLUpdate(user, 4, rowSettlement01);
            DMLUpdate dmlUpdatePerson = new DMLUpdate(user, 3, rowPerson01);
            DMLUpdate dmlUpdateEnterprise = new DMLUpdate(user, 3, rowEnterprise01);
            dmlUpdateSettlement.TemplateMethod();
            dmlUpdatePerson.TemplateMethod();
            dmlUpdateEnterprise.TemplateMethod();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println();
        try {
            List<Settlement> settlementList2 = interfaceFacade.Settlement_tbl_SelectAll();
            for (Settlement x : settlementList2) {
                System.out.println(x.GetID() + ": " + x.getSettlementName());
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println();
        try {
            List<Person> personList2 = interfaceFacade.Person_tbl_SelectAll();
            for (Person x : personList2) {
                System.out.println(x.GetID() + ": " +
                        x.GetFirstName() + " " +
                        x.GetLastName() + ", " +
                        dateFormatter.format(x.GetBirthDay()) + ", " +
                        x.GetAge()
                );
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println();
        try {
            List<Enterprise> enterpriseList2 = interfaceFacade.Enterprise_tbl_SelectAll();
            for (Enterprise x : enterpriseList2) {
                System.out.println(x.GetID() + ": " +
                        x.getName() + ", " +
                        x.getTaxNumber() + ", " +
                        x.getSettlement_ID_fk()
                );
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println();
        //endregion

        //region CHECK DELETE OPERATION
        System.out.println("-----------------------------------------------------");
        System.out.println("CHECK DELETE OPERATION:");

        try{
            DMLDelete dmlDeleteSettlement = new DMLDelete(user, 4, rowSettlement01);
            DMLDelete dmlDeletePerson = new DMLDelete(user, 3, rowPerson01);
            DMLDelete dmlDeleteEnterprise = new DMLDelete(user, 3, rowEnterprise01);
            dmlDeleteSettlement.TemplateMethod();
            dmlDeletePerson.TemplateMethod();
            dmlDeleteEnterprise.TemplateMethod();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println();
        try {
            List<Settlement> settlementList2 = interfaceFacade.Settlement_tbl_SelectAll();
            for (Settlement x : settlementList2) {
                System.out.println(x.GetID() + ": " + x.getSettlementName());
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println();
        try {
            List<Person> personList2 = interfaceFacade.Person_tbl_SelectAll();
            for (Person x : personList2) {
                System.out.println(x.GetID() + ": " +
                        x.GetFirstName() + " " +
                        x.GetLastName() + ", " +
                        dateFormatter.format(x.GetBirthDay()) + ", " +
                        x.GetAge()
                );
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println();
        try {
            List<Enterprise> enterpriseList2 = interfaceFacade.Enterprise_tbl_SelectAll();
            for (Enterprise x : enterpriseList2) {
                System.out.println(x.GetID() + ": " +
                        x.getName() + ", " +
                        x.getTaxNumber() + ", " +
                        x.getSettlement_ID_fk()
                );
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println();
        //endregion

        try {
            IJoinSelect joinSelect01 = new SelectSettlementById(user, 1, new JoinSelect());
            IJoinSelect joinSelect02 = new SelectEnterpriseByID(user, 1, (new SelectSettlementById(user, 1, (new JoinSelect()))));
            IJoinSelect joinSelect03 = new SelectPersonById(user, 1, (new SelectSettlementById(user, 1, (new JoinSelect()))));
            IJoinSelect joinSelect04 = new SelectPersonById(user, 1, (new SelectEnterpriseByID(user, 1,
                    (new SelectSettlementById(user, 1, (new JoinSelect()))))));
            System.out.println(joinSelect01.decorate());
            System.out.println(joinSelect02.decorate());
            System.out.println(joinSelect03.decorate());
            System.out.println(joinSelect04.decorate());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
