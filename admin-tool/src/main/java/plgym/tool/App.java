package plgym.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void main(String[] args)
    {
        int option = -1;
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in) );
        try {
            while(option != 0) {
                System.out.println("Choose an option:");
                System.out.println("0. Exit");
                System.out.println("1. Add new exercise");
                System.out.println("2. Delete exercise");
                System.out.print("Option: ");
                option = reader.read();
                if(option == 1) {
                    addNewExercise();
                }
                if(option == 2) {
                    deleteExercise();
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteExercise()
    {

    }

    private static void addNewExercise()
    {

    }
}
