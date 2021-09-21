package plgym.domain;

import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class DataList<T>
{
    private Map<String, T> map;
    private final Type MAP_TYPE = new TypeToken<Map<String, T>>() {}.getType();

    // Creates DataList using specified file
    public DataList(String PATH_TO_FILE)
    {
        File file = new File(PATH_TO_FILE);
        
        if(file.exists()) {
            try {
                FileReader filereader = new FileReader(file);
                JsonReader jReader = new JsonReader(filereader);
                Gson gson = new Gson();
                this.map = gson.fromJson(jReader, MAP_TYPE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            map = new HashMap<>();
            Gson gson = new Gson();
            gson.toJson(map);
        }
    }
    
    // Creates DataList using specified IDs in 'database'
    public DataList(String[] ids, DataList<T> database)
    {
        this.map = new HashMap<>();

        for (String id : ids) {
            for (String keyId : database.map.keySet()) {
                if (id.equals(keyId)) this.map.put(id, database.map.get(keyId));
            }
        }
    }
	
    public Map<String, T> getMap()
    {
        return map;
    }
    
    // Insert item
    public void addPair(String id, T exercise)
    {
        map.put(id, exercise);
    }

    // Get item
    public T getValue(String id)
    {
        return map.get(id);
    }

    // Remove item
    public void removePair(String id)
    {
        map.remove(id);
    }

    // Update item
    public void updateValue(String id, T exercise)
    {
        map.replace(id, exercise);
    }

    // Transform map to JSON string
    public String toJson()
    {
        Gson gson = new Gson();
        return gson.toJson(map);
    }

}
