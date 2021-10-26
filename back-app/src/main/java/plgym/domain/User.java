package plgym.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a user.
 * @author leodeorce
 * @author pedrovic7997
 */
public class User
{
    private String name;
    private String birthdate;
    private String email;
    private String password;
    private String height;
    private String weight;
    private Set<String> exerciseIdList = new HashSet<>();

    public User(){}

    public User( String name, String birthdate, String email, String password,
                  String height, String weight)
     {
         super();
         this.name = name;
         this.birthdate = birthdate;
         this.email = email;
         this.password = password;
         this.height = height;
         this.weight = weight;
     }

    public User( String name, String birthdate, String email, String password,
                 String height, String weight, Set<String> exercises)
    {
        this.name = name;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.height = height;
        this.weight = weight;
        this.exerciseIdList = exercises;
    }

    public User( String name, String birthdate, String email, String password,
                 String height, String weight, String[] exercises)
    {
        this.name = name;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.height = height;
        this.weight = weight;
        this.exerciseIdList = new HashSet<>();
        for (String string : exercises) {
            this.exerciseIdList.add(string);
        }
    }

    public String getName() { return this.name; }
    public String getBirthdate() { return this.birthdate; }
    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }
    public String getHeight() { return this.height;}
    public String getWeight() { return this.weight; }
    public Set<String> getExercisesId() { return this.exerciseIdList; }

    public void setPassword( String password ) { this.password = password; }
    public void setHeight( String height ) { this.height = height; }
    public void setWeight( String weight ) { this.weight = weight; }
    public void setName( String name ) { this.name = name; }
    public void setBirthdate( String birthdate ) { this.birthdate = birthdate; }
    public void setEmail( String email ) { this.email = email; }

    public void addExerciseId( String exerciseId ) { this.exerciseIdList.add(exerciseId); }
    public void removeExerciseId( String exerciseId ) { this.exerciseIdList.remove(exerciseId); }

    @Override
    public String toString()
    {
        String userString = "Name: " + name;
        userString += "\nBirthdate: " + birthdate;
        userString += "\nEmail: " + email;
        // userString += "\nPassword: " + password;
        userString += "\nHeight: " + height;
        userString += "\nWeight: " + weight;
        userString += "\nExercises: {";
        for (String exerciseId : exerciseIdList) {
            userString += " '" + exerciseId + "'";
        }
        userString += " }";

        return userString;
    }
}
