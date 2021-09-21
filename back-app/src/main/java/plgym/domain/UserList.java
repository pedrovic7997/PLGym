package plgym.domain;

public class UserList extends DataList<User> {

    public UserList()
    {
        super("../../../resources/userDatabase.json");
    }

    public UserList(String PATH_TO_FILE)
    {
        super(PATH_TO_FILE);
    }
}
