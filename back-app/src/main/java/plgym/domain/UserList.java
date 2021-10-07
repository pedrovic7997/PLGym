package plgym.domain;

import com.google.gson.reflect.TypeToken;
import java.util.Map;

/**
 * Heir to {@code DataList<T>} which specifies T as 'User'.
 * @author leodeorce
 * @author pedrovic7997
 */
public class UserList extends DataList<User>
{
    /**
     * Creates empty list of users.
     */
    public UserList()
    {
        super(new TypeToken<Map<String, User>>() {});
    }
    
    /**
     * Creates list of users by reading JSON from file.
     * @param PATH_TO_FILE Full path to user database JSON file.
     */
    public UserList(String PATH_TO_FILE)
    {
        super(PATH_TO_FILE, new TypeToken<Map<String, User>>() {});
    }
}
