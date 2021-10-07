package plgym.domain;

import com.google.gson.reflect.TypeToken;
import java.util.Map;

/**
 * Heir to DataList<T> which specifies T as 'Exercise'.
 * @author leodeorce
 * @author pedrovic7997
 */
public class ExerciseList extends DataList<Exercise>
{
    /**
     * Creates empty list of exercises.
     */
    public ExerciseList()
    {
        super(new TypeToken<Map<String, Exercise>>() {});
    }
    
    /**
     * Creates list of exercises by reading JSON from file.
     * @param PATH_TO_FILE Full path to exercise database JSON file.
     */
    public ExerciseList(String PATH_TO_FILE)
    {
        super(PATH_TO_FILE, new TypeToken<Map<String, Exercise>>() {});
    }

    /**
     * Creates list of exercises by filtering instantiated exercise database.
     * @param ids Array of IDs of exercises to be added upon construction.
     * @param database Instantiated database.
     */
    public ExerciseList(String[] ids, DataList<Exercise> database)
    {
        super(ids, database, new TypeToken<Map<String, Exercise>>() {});
    }
}
