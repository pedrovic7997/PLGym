package plgym.domain;

public class ExerciseList extends DataList<Exercise>
{
    public ExerciseList()
    {
        super("../../../resources/exerciseDatabase.json");
    }
    
    public ExerciseList(String PATH_TO_FILE)
    {
        super(PATH_TO_FILE);
    }
}
