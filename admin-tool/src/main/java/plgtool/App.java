package plgtool;

import plgym.domain.Exercise;
import plgym.domain.ExerciseList;
import plgym.domain.subdomain.Category;
import plgym.domain.subdomain.Difficulty;

import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void main(String[] args)
    {
        // 'option' stores the user's desired activity for each menu loop
        int option = -1;
        BufferedReader keyReader = new BufferedReader( new InputStreamReader(System.in) );
        
        try {
            System.out.println("Provide full path to .json: ");
            String PATH_TO_JSON = keyReader.readLine();
            
            // Menu loops until 'Exit' is chosen
            while(option != 0) {
                System.out.println("Choose an option:");
                System.out.println("0. Exit");
                System.out.println("1. Add new exercise");
                System.out.println("2. Delete exercise");
                // TODO updateExercise()
                System.out.println("3. List all exercises");
                System.out.print("Option: ");
                option = keyReader.read();
                if(option == 1) {
                    addNewExercise(keyReader, PATH_TO_JSON);
                }
                if(option == 2) {
                    deleteExercise(keyReader, PATH_TO_JSON);
                }
                if(option == 3) {
                    listAllExercises(PATH_TO_JSON);
                }
            }
            keyReader.close();
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteExercise(BufferedReader keyReader, String PATH_TO_JSON) throws IOException
    {
        System.out.print("Exercise ID: ");
        String id = keyReader.readLine();
        
        // deleta
        
        System.out.println("Deleted exercise [" + id + "] successfully.");
    }

    private static void addNewExercise(BufferedReader keyReader, String PATH_TO_JSON) throws IOException
    {
        // Retrieves exercise name
        System.out.print("Exercise name: ");
        String name = keyReader.readLine();
        
        // Category list according to enum in class 'Exercise'
        System.out.println("\n1.  OMBRO" +
                           "\n2.  COSTAS" +
                           "\n3.  LOMBAR" +
                           "\n4.  TRICEPS" +
                           "\n5.  BICEPS" +
                           "\n6.  ANTEBRAÇO" +
                           "\n7.  PEITO" +
                           "\n8.  ABDOMEN" +
                           "\n9.  QUADRIL" +
                           "\n10. COXA" +
                           "\n11. PANTURRILHA");
        System.out.print("Number corresponding to exercise category: ");
        String categoryString = keyReader.readLine();
        Category category = Category.values()[Integer.parseInt(categoryString) - 1];
        
        // Retrieves exercise METS value
        System.out.print("\nExercise METS: ");
        String metsString = keyReader.readLine();
        float mets = Float.parseFloat(metsString);
        
        // Difficulty list according to enum in class 'Exercise'
        System.out.println("\n1. FACIL" +
                           "\n2. MEDIO" +
                           "\n3. DIFICIL");
        System.out.print("Number corresponding to exercise difficulty: ");
        String difficultyString = keyReader.readLine();
        Difficulty difficulty = Difficulty.values()[Integer.parseInt(difficultyString) - 1];
        
        // Retrieves exercise chosen YouTube link
        System.out.print("\nExercise YouTube link: ");
        String linkYT = keyReader.readLine();
        
        // Creates auxiliary exercise list with all registered exercises as objects
        ExerciseList exerciseList = new ExerciseList(PATH_TO_JSON);
        String id = getNewId(exerciseList);
        
        // New exercise is added to the list
        Exercise exercise = new Exercise(name, mets, difficulty, category, linkYT);
        exerciseList.addPair(id, exercise);
        
        // Creates JSON string to be written to file
        String json = exerciseList.toJson();
        
        // Writes json to file
        BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_TO_JSON));
        writer.write(json);
        writer.close();
        
        System.out.println("\nCreated successfully. Exercise ID is " + id);
    }
    
    private static String getNewId(ExerciseList exerciseList)
    {
        return "0000000001"; // Placeholder
    }
    
    private static void listAllExercises(String PATH_TO_JSON)
    {
        ExerciseList exerciseList = new ExerciseList(PATH_TO_JSON);
        Map<String, Exercise> map = exerciseList.getMap();
    }
}
