package plgym.domain;

import com.google.gson.reflect.TypeToken;
import java.util.Map;

public class ExerciseList extends DataList<Exercise>
{
    public static final String DB_FILE_PATH = "../../../resources/exerciseDatabase.json";
    
    public ExerciseList()
    {
        super(new TypeToken<Map<String, Exercise>>() {});
    }
    
    public ExerciseList(String PATH_TO_FILE)
    {
        super(PATH_TO_FILE, new TypeToken<Map<String, Exercise>>() {});
    }

    public ExerciseList(String[] ids, DataList<Exercise> database, TypeToken<Map<String, Exercise>> mapType)
    {
        super(ids, database, new TypeToken<Map<String, Exercise>>() {});
    }
}
