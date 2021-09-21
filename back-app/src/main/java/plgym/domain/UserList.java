package plgym.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class UserList {
    public static Map<String, User> map;
    private static final Type USER_MAP_TYPE = new TypeToken<Map<String, User>>() {}.getType();

    public UserList()
    {
        File userFile = new File("../../../resources/userDatabase.json");

        if(userFile.exists()){
            try{
                FileReader filereader = new FileReader(userFile);
                JsonReader jReader= new JsonReader(filereader);
                Gson gson = new Gson();
                map = gson.fromJson(jReader, USER_MAP_TYPE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                userFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            map = new HashMap<>();
            Gson gson = new Gson();
            gson.toJson(map);
        }
    }
    
    // insere
    public void addUser(String id, User user)
    {
        map.put(id, user);
    }

    // altera
    public void updateUser(String id, User user)
    {
        map.replace(id, user);
    }

    // remove
    public void removeUser(String id)
    {
        map.remove(id);
    }

    // resgata
    public User getUser(String id)
    {
        return map.get(id);
    }

    // Jsonfy
    public String toJson()
    {
        Gson gson = new Gson();
        return gson.toJson(map);
    }
}
