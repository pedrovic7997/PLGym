package plgym.domain;

import com.google.gson.reflect.TypeToken;
import java.util.Map;

public class UserList extends DataList<User> {

    public UserList()
    {
        super("../../../resources/userDatabase.json", new TypeToken<Map<String, User>>() {});
    }

    public UserList(String PATH_TO_FILE)
    {
        super(PATH_TO_FILE, new TypeToken<Map<String, User>>() {});
    }
}
