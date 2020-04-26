package DB.DBStrucure.Individuals;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.function.Supplier;

public class IndividualFactory implements IIndividualFactory{
    private static IndividualFactory instance;
    private IndividualFactory(){

    }
    public static IndividualFactory GetInstance(){
        if(instance.equals(null))
        {
            instance = new IndividualFactory();
        }
        return instance;
    }


    IIndividual individual;

    @Override
    public IIndividual GetIndividual(int ID, String tableName) {
        if(tableName == "Enterprise")
        {
            individual = new Enterprise(ID);
        }
        else if (tableName == "Person")
        {
            individual = new Person(ID);
        }
        else if (tableName == "Settlement")
        {
            individual = new Settlement(ID);
        }
        else
        {
            throw new NotImplementedException();
        }
        return  individual;
    }
}
