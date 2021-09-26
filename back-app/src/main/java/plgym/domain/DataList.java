package plgym.domain;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class DataList<T>
{
    private Map<String, T> map;
    // private final Type MAP_TYPE = new TypeToken<Map<String, T>>() {}.getType();
    private TypeToken<Map<String, T>> mapType;

    // Creates DataList using specified file
    public DataList(String PATH_TO_FILE, TypeToken<Map<String, T>> mapType)
    {
        this.mapType = mapType;
        File file = new File(PATH_TO_FILE);
        
        if(file.exists()) {
            // File should be at least an empty object
            try {
                FileReader filereader = new FileReader(file);
                JsonReader jReader = new JsonReader(filereader);
                
                Gson gson = new Gson();
                this.map = gson.fromJson(jReader, mapType.getType());
                
                jReader.close();
                filereader.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                file.createNewFile();
                map = new HashMap<>();
                
                Gson gson = new Gson();
                String json = gson.toJson(map);
                
                BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_TO_FILE));
                writer.write(json);
                
                writer.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO Testar criação da DataList abaixo com os IDs de uma array de exercícios desserializada

    // Creates DataList using specified IDs in 'database'
    public DataList(String[] ids, DataList<T> database, TypeToken<Map<String, T>> mapType)
    {
        this.map = new HashMap<>();
        this.mapType = mapType;

        for (String id : ids) {
            T value = database.getValue(id);
            if (value != null) this.map.put(id, value);
        }
    }

    public DataList(TypeToken<Map<String, T>> mapType)
    {
        this.map = new HashMap<>();
        this.mapType = mapType;
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

    //  Get a new and valid id value
    public String getNewId()
    {
        String id = "";
        boolean idExists = true;

        // If a generated ID is already in use, while loops
        while(idExists == true) {

            int leftLimit = 48;    // char '0'
            int rightLimit = 57;   // char '9'
            int stringLength = 10;
            Random random = new Random();

            StringBuilder buffer = new StringBuilder(stringLength);

            // Generates string of length 10 consisting strictly of numbers 0-9
            for (int i = 0; i < stringLength; i++) {
                /*  (rightLimit - leftLimit + 1) is how many possible values we want;
                    random.nextFloat() acts as a random percentage;
                    leftLimit is a baseline to which we add the product of the above.   */
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            id = buffer.toString();

            idExists = false;

            for(String key : map.keySet()) {
                if( id.equals(key) ) {
                    idExists = true;
                    break;
                }
            }
        }

        return id;
    }
    
}
