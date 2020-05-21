package Client.DMLOperation;

import Client.Individuals.IRowIndividual;
import DB.DBStrucure.User;
import DB.InterfaceFacade;
//template
public abstract class AbsDMLOperation {
    protected User user;
    protected IRowIndividual rowIndividual;
    InterfaceFacade interfaceFacade;

    public void TemplateMethod() throws Exception {
        GetDbSession();
        ExecuteCommand();
    }
    protected void GetDbSession() throws Exception {
        interfaceFacade = new InterfaceFacade(user);
    }
    abstract protected void ExecuteCommand() throws CloneNotSupportedException;
}
