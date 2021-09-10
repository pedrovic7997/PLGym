package plgym.domain;

public class Exercise
{
    private String linkYT;

    private final String id;    // 10 dígitos
    private final String name;
    private final float mets;
    private final Dificuldade dificuldade;

    private enum Dificuldade
    {
        FACIL,
        MEDIO,
        DIFICIL,
    }

    public Exercise(String id, String name, float mets, Dificuldade dificuldade)
    {
        this.id = id;
        this.name = name;
        this.mets = mets;
        this.dificuldade = dificuldade;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getLinkYT() { return linkYT; }
    public float getMets() { return mets; }
    public Dificuldade getDificuldade() { return dificuldade; }

    // O vídeo pode sair do ar
    public void setLinkYT(String linkYT) { this.linkYT = linkYT; }
}
