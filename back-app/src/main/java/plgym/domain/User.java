package plgym.domain;

public class User {
    private final String name;
    private final String birthdate;
    private final String email;
    private String password;
    private float height;
    private float weight;

    public User( String name, String birthdate, String email, String password,
                 float height, float weight )
    {
        this.name = name;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.height = height;
        this.weight = weight;
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
}