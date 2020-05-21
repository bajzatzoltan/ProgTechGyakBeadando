package Client.DMLOperation;

import DB.DBStrucure.Individuals.Settlement;
import DB.DBStrucure.User;
import DB.InterfaceFacade;

public class SelectSettlementById extends JoinSelectDecorator {
    int ID;
    User user;
    InterfaceFacade interfaceFacade;
    public SelectSettlementById(User user, int ID, IJoinSelect joinSelect) throws Exception {
        super(joinSelect);
        this.user = user;
        interfaceFacade = new InterfaceFacade(user);
        this.ID = ID;
    }

    public String decorate() throws Exception {
        return super.decorate() + decorateWithSettlement();
    }

    private String decorateWithSettlement() throws Exception {
        Settlement settlement = interfaceFacade.Settlement_tbl_GetInstanceByID(ID);
        return " " + settlement.GetID() + ": " +
                settlement.getSettlementName() ;
    }
}

