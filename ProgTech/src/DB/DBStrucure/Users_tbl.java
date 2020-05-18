package DB.DBStrucure;

import java.util.*;

public class Users_tbl {
    private static volatile Users_tbl instance;
    private Map<String, String> userList;
    private Users_tbl()
    {
        userList = new HashMap<String, String>();
    }

    public static Users_tbl GetInstance() {
        if (instance == null) {
            instance = new Users_tbl();
        }
        return  instance;
    }

    public void AddUser(User newuser) throws Exception{
        if (userList.containsKey(newuser.GetUserName())) {
            throw new Exception("Username already exist.");
        }
        else {
            userList.put(newuser.GetUserName(), newuser.GetUserPass());
        }
    }
    public boolean CheckUser(User user){
        boolean result = false;
        if (userList.containsKey(user.GetUserName()) && userList.get(user.GetUserName()) == user.GetUserPass()) {
            result = true;
        }
        return result;
    }

    public void DeleteUser(User deleteduser) throws Exception{
        if (userList.containsKey(deleteduser.GetUserName())) {
            userList.remove(deleteduser.GetUserName());
        }
        else {
            throw new Exception("Invalid username.");
        }
    }
}
