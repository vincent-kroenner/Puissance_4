package View;


import Controller.ControllerPartie;
import Model.Partie;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class ViewGame {
    private ControllerPartie controllerPartie;
    private Partie partie;
    private Group root;
    private ImageView[][] plateauDeJeu;
    private ImageView imgBg;
    private ImageView[] victory;
    private Rectangle[] rects;
    private Button retourPrincipale;

    public ViewGame(Group root, ViewHandler vg) {
        this.root = root;
        this.partie = new Partie();
        this.controllerPartie = new ControllerPartie(this, vg, partie);
        initBackground();
        initPlateauDejeu();
        initButtons();
        //initVictory();
    }

    private void initPlateauDejeu() {
        plateauDeJeu = new ImageView[Partie.LARGEUR][Partie.LONGUEUR];
        rects = new Rectangle[Partie.LARGEUR];
        for (int i = 0; i < plateauDeJeu.length; i++) {
            for (int j = 0; j < plateauDeJeu[j].length; j++) {
                plateauDeJeu[i][j] = new ImageView(getAdresseImage(partie.getCaseDuPlateauDeJeu(i, j)));
                plateauDeJeu[i][j].setX(100 * i + 600);
                plateauDeJeu[i][j].setY(100 * j + 150);
                plateauDeJeu[i][j].setFitWidth(100);
                plateauDeJeu[i][j].setFitHeight(100);
                plateauDeJeu[i][j].setOnMouseClicked(controllerPartie);
            }
        }
        for (int i = 0; i < Partie.LARGEUR; i++) {
            rects[i] = new Rectangle(100 * i + 600, 150, 100, 500);
            rects[i].setFill(Color.TRANSPARENT);
            rects[i].setStroke(Color.GREENYELLOW);
            rects[i].setStrokeType(StrokeType.INSIDE);
            rects[i].setStrokeWidth(12);
            rects[i].setVisible(false);

            root.getChildren().addAll(rects[i]);
        }
    }

    private void initVictory() {
        victory = new ImageView[2];
        victory[0] = new ImageView("Asset/Images/win.png");
        victory[1] = new ImageView("Asset/Images/loose.png");
        victory[0].setX(500);
        victory[0].setY(500);
        victory[1].setX(500);
        victory[1].setY(600);
        victory[0].setVisible(false);
        victory[1].setVisible(false);

    }

    /*public void majVictory(){
        for (int i = 0; i < victory.length; i++) {
            victory[i].setVisible(partie.getVictory()[i]);
        }
    }*/

    public void majPlateau() {
        for (int i = 0; i < plateauDeJeu.length; i++) {
            for (int j = 0; j < plateauDeJeu[j].length; j++) {
                plateauDeJeu[i][j].setImage(new ImageView(getAdresseImage(partie.getCaseDuPlateauDeJeu(i, j))).getImage());
            }
        }
    }

    private String getAdresseImage(int numueroJeton) {
        if (numueroJeton == 0) {
            return "Asset/Images/case_bleu.png";
        } else if (numueroJeton == 1) {
            return "Asset/Images/jeton_jaune.png";
        } else {
            return "Asset/Images/jeton_rouge.png";
        }
    }

    private void initBackground() {
        imgBg = new ImageView(Path.fondMenu);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
        imgBg.setFitHeight((int) primaryScreenBounds.getHeight());
        imgBg.setFitWidth((int) primaryScreenBounds.getWidth());
    }

    public void setVueCompleteGame() {
        root.getChildren().clear();
        root.getChildren().add(imgBg);
        for (int i = 0; i < plateauDeJeu.length; i++) {
            for (int j = 0; j < plateauDeJeu[i].length; j++) {
                root.getChildren().add(plateauDeJeu[i][j]);

            }
        }
        root.getChildren().add(retourPrincipale);
    }

    private void initButtons() {
        retourPrincipale = new Button("Retour");
        retourPrincipale.setTranslateX(700);
        retourPrincipale.setTranslateY(950);
        retourPrincipale.setStyle("-fx-background-color: transparent; -fx-text-fill: #ff0000;");
        retourPrincipale.setFont(Font.loadFont(getClass().getResourceAsStream(Path.fontHeadCase), 90));
        retourPrincipale.setOnMouseClicked(controllerPartie);

        retourPrincipale.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                retourPrincipale.setStyle("-fx-background-color: transparent; -fx-text-fill: yellow;");
            }
        });

        retourPrincipale.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                retourPrincipale.setStyle("-fx-background-color: transparent; -fx-text-fill: #ff0000;");
            }
        });
    }

    public Button getRetourPrincipale(){return retourPrincipale;}

    public ImageView[][] getPlateauDeJeu() {
        return plateauDeJeu;
    }

}
