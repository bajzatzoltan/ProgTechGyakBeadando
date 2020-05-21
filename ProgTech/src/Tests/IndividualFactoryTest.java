package Tests;

import Client.Individuals.IRowIndividual;
import Client.Individuals.RowEnterprise;
import Client.Individuals.RowPerson;
import Client.Individuals.RowSettlement;
import Deployer.IndividualFactory;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.Assert.*;

public class IndividualFactoryTest {

    @Test
    public void getIndividual_parameterIsRowSettlement_test() {
        IndividualFactory testInstance = new IndividualFactory();
        RowSettlement expectedClass =new RowSettlement();
        String parameterOfType = "RowSettlement";

        RowSettlement resultClass = (RowSettlement)testInstance.GetIndividual(parameterOfType);
        assertEquals(expectedClass.getClass(), resultClass.getClass());
    }
    @Test
    public void getIndividual_parameterIsRowPerson_test() {
        IndividualFactory testInstance = new IndividualFactory();
        RowPerson expectedClass =new RowPerson();
        String parameterOfType = "RowPerson";

        RowPerson resultClass = (RowPerson)testInstance.GetIndividual(parameterOfType);
        assertEquals(expectedClass.getClass(), resultClass.getClass());
    }
    @Test
    public void getIndividual_parameterIsRowEnterprise_test() {
        IndividualFactory testInstance = new IndividualFactory();
        RowEnterprise expectedClass =new RowEnterprise();
        String parameterOfType = "RowEnterprise";
        RowEnterprise resultClass = (RowEnterprise)testInstance.GetIndividual(parameterOfType);
        assertEquals(expectedClass.getClass(), resultClass.getClass());
    }
    @Test(expected = NotImplementedException.class)
    public void getIndividual_parameterIsInvalid_test() {
        IndividualFactory testInstance = new IndividualFactory();
        String parameterOfType = "invalidparameter";
        IRowIndividual resultClass = testInstance.GetIndividual(parameterOfType);
    }
}