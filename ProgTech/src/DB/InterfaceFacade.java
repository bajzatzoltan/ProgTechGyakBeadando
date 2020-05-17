package DB;

import DB.DBStrucure.Individuals.Enterprise;
import DB.DBStrucure.Relations_tbl;
import DB.DBStrucure.Tables.Enterprise_tbl;
import DB.DBStrucure.Tables.Person_tbl;
import DB.DBStrucure.Tables.Settlement_tbl;

public class InterfaceFacade {
    private Enterprise_tbl enterprise_tbl;
    private Person_tbl person_tbl;
    private Settlement_tbl settlement_tbl;
    private Relations_tbl relations_tbl;

    public InterfaceFacade(){
        enterprise_tbl = Enterprise_tbl.GetInstance();
        person_tbl = Person_tbl.GetInstance();
        settlement_tbl = Settlement_tbl.GetInstance();
        relations_tbl = Relations_tbl.GetInstance();
    }

    public void Enterprise_tbl_Insert(Enterprise individual){

    }
    public void Enterprise_tbl_Delete(int ID){

    }


}
