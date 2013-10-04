package studycards;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 17.08.13
 * Time: 22:31
 */
public class QuizKarte {
    private String frage;
    private String antwort;

    public QuizKarte(String frage, String antwort){
        this.frage = frage;
        this.antwort = antwort;
    }

    public String getFrage(){
        return frage;
    }

    public String getAntwort(){
        return antwort;
    }

    @Override
    public String toString(){
        return "Frage: " + getFrage() + "\nAntwort: " + getAntwort();
    }
}
