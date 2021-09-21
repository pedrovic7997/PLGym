package plgym.domain;

public class Exercise
{
    private String linkYT;

    private final String name;
    private final float mets;
    private final Difficulty difficulty;
    private final Category category;

    public enum Difficulty
    {
        FACIL,
        MEDIO,
        DIFICIL,
    }
    
    public enum Category
    {
        OMBRO,
        COSTAS,
        LOMBAR,
        TRICEPS,
        BICEPS,
        ANTEBRACO,
        PEITO,
        ABDOMEN,
        QUADRIL,
        COXA,
        PANTURRILHA,
    }

    public Exercise(String name, float mets, Difficulty difficulty, Category category, String linkYT)
    {
        this.name = name;
        this.mets = mets;
        this.difficulty = difficulty;
        this.category = category;
        this.linkYT = linkYT;
    }

    public String getName() { return name; }
    public String getLinkYT() { return linkYT; }
    public float getMets() { return mets; }
    public Difficulty getDifficulty() { return difficulty; }
    public Category getCategory() { return category; }

    // Video isn't necessarily accessible forever
    public void setLinkYT(String linkYT) { this.linkYT = linkYT; }
}
