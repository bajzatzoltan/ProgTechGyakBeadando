package Deployer;

import Client.Individuals.RowEnterprise;
import Client.Individuals.RowPerson;
import Client.Individuals.RowSettlement;
import DB.DBStrucure.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class IndividualFactory {
    private Object result;
    public Object GetIndividual(String type) {
        if (type == "RowSettlement"){
            result = new RowSettlement();
        }
        else if(type == "RowPerson")
        {
            result = new RowPerson();
        }
        else if(type == "RowEnterprise")
        {
            result = new RowEnterprise();
        }
        else{
            throw new NotImplementedException();
        }
        return result;
    }

}
