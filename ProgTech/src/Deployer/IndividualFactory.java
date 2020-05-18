package Deployer;

import Client.RowSettlement;
import DB.DBStrucure.Individuals.Enterprise;
import DB.DBStrucure.Individuals.IIndividual;
import DB.DBStrucure.Individuals.Person;
import DB.DBStrucure.Individuals.Settlement;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class IndividualFactory {
    private Object result;
    public Object GetIndividual(String type) {
        if (type == "RowSettlement"){
            result = new RowSettlement();
        }
        else{
            throw new NotImplementedException();
        }
        return result;
    }

}
