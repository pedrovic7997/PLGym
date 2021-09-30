package plgym.domain;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private String birthdate;
    private String email;
    private String password;
    private double height;
    private double weight;
    private Set<String> exerciseIdList = new HashSet<>();

    public User(){}

    public User( String name, String birthdate, String email, String password,
                  double height, double weight)
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
                 double height, double weight, Set<String> exercises)
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
                 double height, double weight, String[] exercises)
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
    public double getHeight() { return this.height;}
    public double getWeight() { return this.weight; }
    public Set<String> getExercisesId() { return this.exerciseIdList; }

    public void setPassword( String password ) { this.password = password; }
    public void setHeight( double height ) { this.height = height; }
    public void setWeight( double weight ) { this.weight = weight; }
//    public void setExerciseIdList( String[] exercises ) {
//        this.exerciseIdList = new HashSet<>();
//        for (String exercise : exercises) {
//            this.exerciseIdList.add(exercise);
//        }
//    }

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

//package plgym.domain;
//
//import java.util.List;
//import javax.annotation.Generated;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//        "name",
//        "email",
//        "password",
//        "weight",
//        "height",
//        "birthdate",
//        "exerciseIdList"
//})
//@Generated("jsonschema2pojo")
//public class User {
//
//    @JsonProperty("name")
//    private String name;
//    @JsonProperty("email")
//    private String email;
//    @JsonProperty("password")
//    private String password;
//    @JsonProperty("weight")
//    private String weight;
//    @JsonProperty("height")
//    private String height;
//    @JsonProperty("birthdate")
//    private String birthdate;
//    @JsonProperty("exerciseIdList")
//    private List<String> exerciseIdList = null;
//
//    /**
//     * No args constructor for use in serialization
//     *
//     */
//    public User() {
//    }
//
//    /**
//     *
//     * @param password
//     * @param birthdate
//     * @param exerciseIdList
//     * @param name
//     * @param weight
//     * @param email
//     * @param height
//     */
//    public User(String name, String email, String password, String weight, String height, String birthdate, List<String> exerciseIdList) {
//        super();
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.weight = weight;
//        this.height = height;
//        this.birthdate = birthdate;
//        this.exerciseIdList = exerciseIdList;
//    }
//
//    @JsonProperty("name")
//    public String getName() {
//        return name;
//    }
//
//    @JsonProperty("name")
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @JsonProperty("email")
//    public String getEmail() {
//        return email;
//    }
//
//    @JsonProperty("email")
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @JsonProperty("password")
//    public String getPassword() {
//        return password;
//    }
//
//    @JsonProperty("password")
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @JsonProperty("weight")
//    public String getWeight() {
//        return weight;
//    }
//
//    @JsonProperty("weight")
//    public void setWeight(String weight) {
//        this.weight = weight;
//    }
//
//    @JsonProperty("height")
//    public String getHeight() {
//        return height;
//    }
//
//    @JsonProperty("height")
//    public void setHeight(String height) {
//        this.height = height;
//    }
//
//    @JsonProperty("birthdate")
//    public String getBirthdate() {
//        return birthdate;
//    }
//
//    @JsonProperty("birthdate")
//    public void setBirthdate(String birthdate) {
//        this.birthdate = birthdate;
//    }
//
//    @JsonProperty("exerciseIdList")
//    public List<String> getExerciseIdList() {
//        return exerciseIdList;
//    }
//
//    @JsonProperty("exerciseIdList")
//    public void setExerciseIdList(List<String> exerciseIdList) {
//        this.exerciseIdList = exerciseIdList;
//    }
//
//    public void addExerciseId( String exerciseId ) { this.exerciseIdList.add(exerciseId); }
//
//}