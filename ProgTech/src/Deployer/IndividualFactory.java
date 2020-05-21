package Deployer;

import Client.Individuals.IRowIndividual;
import Client.Individuals.RowEnterprise;
import Client.Individuals.RowPerson;
import Client.Individuals.RowSettlement;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class IndividualFactory {
    private IRowIndividual result;
    public IRowIndividual GetIndividual(String type) {
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
