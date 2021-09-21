package plgym.domain;

import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class ExerciseList {
    private Map<String, Exercise> map;
    static private final Type EXERCISE_MAP_TYPE = new TypeToken<Map<String, Exercise>>() {}.getType();

    // Mapa do BD local.
    public ExerciseList()
    {
        File file = new File("../../../resources/exerciseDatabase.json");

        try{
            FileReader filereader = new FileReader(file);
            JsonReader jReader= new JsonReader(filereader);
            Gson gson = new Gson();
            this.map = gson.fromJson(jReader, EXERCISE_MAP_TYPE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Mapa para acessar pela ferramenta de administrador.
    public ExerciseList(String directory)
    {
        File file = new File(directory);

        try{
            FileReader filereader = new FileReader(file);
            JsonReader jReader = new JsonReader(filereader);
            Gson gson = new Gson();
            this.map = gson.fromJson(jReader, EXERCISE_MAP_TYPE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    // Mapa para consulta de cada usuario.
    public ExerciseList(String[] ids, ExerciseList database)
    {
        this.map = new HashMap<>();

        for (String id : ids) {
            for (String keyId : database.map.keySet()) {
                if (id == keyId) this.map.put(id, database.map.get(keyId));
            }
        }
    }
	
    public Map<String, Exercise> getMap()
    {
        return map;
    }
    
    // insere
    public void addPair(String id, Exercise exercise)
    {
        map.put(id, exercise);
    }

    // resgata
    public Exercise readPair(String id)
    {
        return map.get(id);
    }

    // remove
    public void removePair(String id)
    {
        map.remove(id);
    }

    // Jsonfy
    public String toJson()
    {
        Gson gson = new Gson();
        return gson.toJson(map);
    }

}
