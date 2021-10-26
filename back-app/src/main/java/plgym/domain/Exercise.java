package plgym.domain;

import plgym.domain.subdomain.Category;
import plgym.domain.subdomain.Difficulty;

/**
 * Represents an exercise.
 * @author leodeorce
 * @author pedrovic7997
 */
public class Exercise
{
    private String linkYT;

    private final String name;
    private final double mets;
    private final Difficulty difficulty;
    private final Category category;

    public Exercise(String name, double mets, Difficulty difficulty, Category category, String linkYT)
    {
        this.name = name;
        this.mets = mets;
        this.difficulty = difficulty;
        this.category = category;
        this.linkYT = linkYT;
    }

    public String getName() { return name; }
    public String getLinkYT() { return linkYT; }
    public double getMets() { return mets; }
    public Difficulty getDifficulty() { return difficulty; }
    public Category getCategory() { return category; }

    // Video isn't necessarily accessible forever
    public void setLinkYT(String linkYT) { this.linkYT = linkYT; }

    @Override
    public String toString()
    {
        String str = "Name: " + name;
        str += "\nMETS: " + mets;
        str += "\nDifficulty: " + difficulty;
        str += "\nCategory: " + category;
        str += "\nYouTube link: " + linkYT;
        return str;
    }
}
