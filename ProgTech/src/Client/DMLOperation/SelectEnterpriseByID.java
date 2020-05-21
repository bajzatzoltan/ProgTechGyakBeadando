package Client.DMLOperation;

import DB.DBStrucure.Individuals.Enterprise;
import DB.DBStrucure.User;
import DB.InterfaceFacade;

public class SelectEnterpriseByID extends JoinSelectDecorator{
    int ID;
    User user;
    InterfaceFacade interfaceFacade;
    public SelectEnterpriseByID(User user, int ID, IJoinSelect joinSelect) throws Exception {
        super(joinSelect);
        this.user = user;
        interfaceFacade = new InterfaceFacade(user);
        this.ID = ID;
    }

    public String decorate() throws Exception {
        return super.decorate() + decorateWithEnterprise();
    }

    private String decorateWithEnterprise() throws CloneNotSupportedException {
        Enterprise enterprise = interfaceFacade.Enterprise_tbl_GetInstanceByID(ID);
        return " " + enterprise.GetID() + ": " +
                enterprise.getName() + ", " +
                enterprise.getTaxNumber() + ", " +
                enterprise.getSettlement_ID_fk() ;
    }
}
