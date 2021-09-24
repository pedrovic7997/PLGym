package plgym.domain;

import com.google.gson.reflect.TypeToken;
import java.util.Map;

public class ExerciseList extends DataList<Exercise>
{
    public ExerciseList()
    {
        super("../../../resources/exerciseDatabase.json", new TypeToken<Map<String, Exercise>>() {});
    }
    
    public ExerciseList(String PATH_TO_FILE)
    {
        super(PATH_TO_FILE, new TypeToken<Map<String, Exercise>>() {});
    }
}
