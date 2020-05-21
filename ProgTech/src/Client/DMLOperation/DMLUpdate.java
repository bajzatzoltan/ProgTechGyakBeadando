package Client.DMLOperation;

import Client.Individuals.IRowIndividual;
import Client.Individuals.RowEnterprise;
import Client.Individuals.RowPerson;
import Client.Individuals.RowSettlement;
import DB.DBStrucure.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
//template
public class DMLUpdate extends AbsDMLOperation {
    private int ID;
    public DMLUpdate(User user, int ID, IRowIndividual rowIndividual){
        this.user = user;
        this.ID = ID;
        this.rowIndividual = rowIndividual;
    }

    @Override
    protected void ExecuteCommand() throws Exception {
        if (rowIndividual.getClass() == RowPerson.class){
            interfaceFacade.Person_tbl_Update(ID, rowIndividual);
        }
        else if (rowIndividual.getClass() == RowSettlement.class){
            interfaceFacade.Settlement_tbl_Update(ID, rowIndividual);
        }
        else if (rowIndividual.getClass() == RowEnterprise.class) {
            interfaceFacade.Enterprise_tbl_Update(ID, rowIndividual);
        }
        else{
            throw new NotImplementedException();
        }

    }
}
