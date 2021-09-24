package plgym.domain;

import plgym.domain.subdomain.Category;
import plgym.domain.subdomain.Difficulty;

public class Exercise
{
    private String linkYT;

    private final String name;
    private final float mets;
    private final Difficulty difficulty;
    private final Category category;

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

    @Override
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Name: " + name);
        strBuilder.append("\nMETS: " + mets);
        strBuilder.append("\nDifficulty: " + difficulty);
        strBuilder.append("\nCategory: " + category);
        strBuilder.append("\nYouTube link: " + linkYT);
        return strBuilder.toString();
    }
}
