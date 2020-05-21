package Client.DMLOperation;

import Client.Individuals.IRowIndividual;
import Client.Individuals.RowEnterprise;
import Client.Individuals.RowPerson;
import Client.Individuals.RowSettlement;
import DB.DBStrucure.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
//template
public class DMLDelete extends AbsDMLOperation {
    protected int ID;
    public DMLDelete(User user, int ID, IRowIndividual rowIndividual){
        this.user = user;
        this.ID = ID;
        this.rowIndividual = rowIndividual;
    }

    @Override
    protected void ExecuteCommand() throws CloneNotSupportedException {
        if (rowIndividual.getClass() == RowPerson.class){
            interfaceFacade.Person_tbl_Delete(ID);
        }
        else if (rowIndividual.getClass() == RowSettlement.class){
            interfaceFacade.Settlement_tbl_Delete(ID);
        }
        else if (rowIndividual.getClass() == RowEnterprise.class) {
            interfaceFacade.Enterprise_tbl_Delete(ID);
        }
        else{
            throw new NotImplementedException();
        }
    }
}
