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

/**
 * Stores and manages instances of either Users or Exercises.
 * @author leodeorce
 * @author pedrovic7997
 */
public class DataList<T>
{
    private Map<String, T> map;

    /**
     * Creates DataList using specified file.
     * @param PATH_TO_FILE Full path to file to be opened.
     * @param mapType TypeToken<Map<String, T>> where T is either User or Exercise.
     *                Necessary for gson to be able to read the JSON formatted file.
     */
    public DataList(String PATH_TO_FILE, TypeToken<Map<String, T>> mapType)
    {
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

    /**
     * Creates DataList using specified IDs.
     * @param ids Array of IDs of exercises to be added on construction.
     * @param database Instantiated database.
     * @param mapType TypeToken<Map<String, T>> where T is either User or Exercise.
     *                Necessary for gson to be able to read the JSON formatted file.
     */
    public DataList(String[] ids, DataList<T> database, TypeToken<Map<String, T>> mapType)
    {
        this.map = new HashMap<>();

        for (String id : ids) {
            T value = database.getValue(id);
            if (value != null) this.map.put(id, value);
        }
    }
    
    /**
     * Creates empty DataList.
     * @param mapType TypeToken<Map<String, T>> where T is either User or Exercise.
     *                Necessary for gson to be able to read the JSON formatted file.
     */
    public DataList(TypeToken<Map<String, T>> mapType)
    {
        this.map = new HashMap<>();
    }
	
    /**
     * Retrieves the map of <String, T> pairs DataList<T> uses.
     * @return Map of type Map<String, T>.
     */
    public Map<String, T> getMap()
    {
        return map;
    }
    
    /**
     * Adds a pair <String, T> to the map DataList<T> uses.
     */
    public void addPair(String id, T content)
    {
        map.put(id, content);
    }

    /**
     * Retrieves a value from the map DataList<T> uses associated with the specified key.
     * @param id Key to which the value desired is associated.
     * @return Value of type T associated with 'id'.
     */
    public T getValue(String id)
    {
        return map.get(id);
    }

    /**
     * Removes a pair <String, T> from the map DataList<T> uses.
     */
    public void removePair(String id)
    {
        map.remove(id);
    }

    /**
     * Updates a <key, value> pair in the map DataList<T> uses.
     * @param id Key to which the value to be updated is associated.
     * @param content The value with which to update the pair.
     */
    public void updateValue(String id, T content)
    {
        map.replace(id, content);
    }

    /**
     * Transform the map DataList<T> uses into a JSON string.
     * @return String containing the JSON-formatted map.
     */
    public String toJson()
    {
        Gson gson = new Gson();
        return gson.toJson(map);
    }
    
    public String getNewId()
    {
        String id = "";
        boolean idExists = true;

        // If a generated ID is already in use, while loops
        while(idExists) {

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
