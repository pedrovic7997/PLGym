package plgym.domain;

// TODO Verificar serialização do User

public class User {
    private final String name;
    private final String birthdate;
    private final String email;
    private String password;
    private float height;
    private float weight;
    private String[] exerciseIdList;
    // TODO exerciseIdList precisa ser não ordenado e fácil de adicionar e remover

    public User( String name, String birthdate, String email, String password,
                 float height, float weight, String[] exercises)
    {
        this.name = name;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.height = height;
        this.weight = weight;
        this.exerciseIdList = exercises;
    }

    public String getName() { return this.name; }
    public String getBirthdate() { return this.birthdate; }
    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }
    public float getHeight() { return this.height;}
    public float getWeight() { return this.weight; }

    public void setPassword( String password ) { this.password = password; }
    public void setHeight( float height ) { this.height = height; }
    public void setWeight( float weight ) { this.weight = weight; }

    @Override
    public String toString()
    {
        String userString = "Name: " + name;
        userString += "\nBirthdate: " + birthdate;
        userString += "\nEmail: " + email;
        // userString += "\nPassword: " + password;
        userString += "\nHeight: " + height;
        userString += "\nWeight: " + weight;

        return userString;
    }
}