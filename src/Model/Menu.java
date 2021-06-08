package Model;

public class Menu {
    public final static String textBoutonJouer ="Jouer";
    private Partie partie;

    public Menu() {
        this.partie = null;
    }

    public void initGame() {
        partie = new Partie();
    }

    public Partie getPartie() {
        return partie;
    }
}
