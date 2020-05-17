package DB.DBStrucure;

public class User {
    private String userName;
    public String GetUserName() {
        return userName;
    }
    private String userPass;
    public String GetUserPass() {
        return userPass;
    }

    public User( String userName, String userPass){
        this.userName = userName;
        this.userPass = userPass;
    }
}
