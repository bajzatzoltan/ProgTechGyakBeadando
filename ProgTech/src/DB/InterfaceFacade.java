package DB;

import Client.Individuals.IRowIndividual;
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
import DB.DBStrucure.Users_tbl;

import java.util.List;

public class InterfaceFacade {

    public InterfaceFacade(User user)throws  Exception{
        if (!Users_tbl.GetInstance().CheckUser(user)){
            throw new Exception("Invalid username or password.");
        }
    }

    public void Enterprise_tbl_Insert(IRowIndividual individual) throws CloneNotSupportedException {
        Enterprise_tbl.GetInstance().Insert((RowEnterprise)individual);
    }
    public void Enterprise_tbl_Delete(int ID){
        Enterprise_tbl.GetInstance().Delete(ID);
    }
    public void Enterprise_tbl_Update(int ID, IRowIndividual individual) throws CloneNotSupportedException {
        Enterprise_tbl.GetInstance().Update(ID, (RowEnterprise)individual);
    }
    public List<Enterprise> Enterprise_tbl_SelectAll() throws  CloneNotSupportedException{
        return Enterprise_tbl.GetInstance().SelectAll();
    }
    public Enterprise Enterprise_tbl_GetInstanceByID(int ID) throws CloneNotSupportedException{
        return Enterprise_tbl.GetInstance().GetInstanceByID(ID);
    }


    public void Person_tbl_Insert(IRowIndividual individual) throws Exception {
        Person_tbl.GetInstance().Insert((RowPerson)individual);
    }
    public void Person_tbl_Delete(int ID){
        Person_tbl.GetInstance().Delete(ID);
    }
    public void Person_tbl_Update(int ID, IRowIndividual individual) throws Exception {
        Person_tbl.GetInstance().Update(ID,(RowPerson)individual);
    }
    public List<Person> Person_tbl_SelectAll()throws CloneNotSupportedException {
        return Person_tbl.GetInstance().SelectAll();
    }
    public Person Person_tbl_GetInstanceByID(int ID)throws CloneNotSupportedException{
        return Person_tbl.GetInstance().GetInstanceByID(ID);
    }


    public void Settlement_tbl_Insert(IRowIndividual individual){
        Settlement_tbl.GetInstance().Insert((RowSettlement)individual);
    }
    public void Settlement_tbl_Delete(int ID){
        Settlement_tbl.GetInstance().Delete(ID);
    }
    public void Settlement_tbl_Update(int ID, IRowIndividual individual){
        Settlement_tbl.GetInstance().Update(ID, (RowSettlement)individual);
    }
    public List<Settlement> Settlement_tbl_SelectAll() throws CloneNotSupportedException{
        return Settlement_tbl.GetInstance().SelectAll();
    }
    public Settlement Settlement_tbl_GetInstanceByID(int ID)throws CloneNotSupportedException{
        return Settlement_tbl.GetInstance().GetInstanceByID(ID);
    }


    public void DeleteUser(User deleteduser)throws Exception{
        Users_tbl.GetInstance().DeleteUser(deleteduser);
    }
    public void AddUser(User newuser)throws Exception{
        Users_tbl.GetInstance().AddUser(newuser);
    }


}
