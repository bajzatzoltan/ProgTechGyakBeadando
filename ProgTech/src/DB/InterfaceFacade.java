package DB;

import DB.DBStrucure.Individuals.Enterprise;
import DB.DBStrucure.Individuals.Person;
import DB.DBStrucure.Individuals.Settlement;
import DB.DBStrucure.Relations_tbl;
import DB.DBStrucure.Tables.Enterprise_tbl;
import DB.DBStrucure.Tables.Person_tbl;
import DB.DBStrucure.Tables.Settlement_tbl;
import DB.DBStrucure.User;
import DB.DBStrucure.Users_tbl;

public class InterfaceFacade {
    private Enterprise_tbl enterprise_tbl;
    private Person_tbl person_tbl;
    private Settlement_tbl settlement_tbl;
    private Relations_tbl relations_tbl;

    public InterfaceFacade(User user)throws  Exception{
        enterprise_tbl = Enterprise_tbl.GetInstance();
        person_tbl = Person_tbl.GetInstance();
        settlement_tbl = Settlement_tbl.GetInstance();
        relations_tbl = Relations_tbl.GetInstance();
        if (!Users_tbl.GetInstance().CheckUser(user)){
            throw new Exception("Invalid username or password.");
        }
    }


    public void Enterprise_tbl_Insert(Enterprise individual){

    }
    public void Enterprise_tbl_Delete(int ID){

    }
    public void Enterprise_tbl_Update(int ID, Enterprise individual){

    }

    public void Enterprise_tbl_SelectAll(){

    }
    public void Enterprise_tbl_GetInstanceByID(int ID){

    }


    public void Person_tbl_Insert(Person individual){

    }
    public void Person_tbl_Delete(int ID){

    }
    public void Person_tbl_Update(int ID, Person individual){

    }

    public void Person_tbl_SelectAll(){

    }
    public void Person_tbl_GetInstanceByID(int ID){

    }


    public void Settlement_tbl_Insert(Settlement individual){

    }
    public void Settlement_tbl_Delete(int ID){

    }
    public void Settlement_tbl_Update(int ID, Settlement individual){

    }

    public void Settlement_tbl_SelectAll(){

    }
    public void Settlement_tbl_GetInstanceByID(int ID){

    }



    public void DeleteUser(User deleteduser){

    }
    public void AddUser(User newuser){

    }


}
