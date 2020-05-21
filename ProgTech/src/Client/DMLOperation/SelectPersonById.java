package Client.DMLOperation;

import DB.DBStrucure.Individuals.Person;
import DB.DBStrucure.User;
import DB.InterfaceFacade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SelectPersonById extends JoinSelectDecorator{
    int ID;
    User user;
    InterfaceFacade interfaceFacade;
    public SelectPersonById(User user, int ID, IJoinSelect joinSelect) throws Exception {
        super(joinSelect);
        this.user = user;
        interfaceFacade = new InterfaceFacade(user);
        this.ID = ID;
    }

    public String decorate() throws Exception {
        return super.decorate() + decorateWithPerson();
    }

    private String decorateWithPerson() throws Exception {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd");
        Person person = interfaceFacade.Person_tbl_GetInstanceByID(ID);
        return " " + person.GetID() + ": " +
                person.GetFirstName() + " " +
                person.GetLastName() + ", " +
                dateFormatter.format(person.GetBirthDay()) + ", " +
                person.GetAge() ;
    }
}
