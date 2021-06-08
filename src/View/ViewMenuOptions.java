package View;

import Controller.ControllerOptions;
import Model.Options;
import Music.Music;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class ViewMenuOptions {
    private ControllerOptions controllerOptions;
    private Options options;
    private Group root;
    private ImageView imgBg;
    private Button musique;
    private Button choisirSaCouleur;
    private Button retour;
    private Text titre;
    private Slider musiqueSlider;
    private Slider couleurSlider;


    public ViewMenuOptions(Group root, ViewHandler vh) {

        this.root = root;
        this.options = new Options();
        this.controllerOptions = new ControllerOptions(this, vh, options);

        initSlider();
        initTitre();
        initButtons();
        initBackground();
        initMusique();
    }

    private void initMusique() {
        Music.startMainMenuMusic();
    }


    private void initBackground() {
        imgBg = new ImageView(Path.fondMenu);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
        imgBg.setFitHeight((int) primaryScreenBounds.getHeight());
        imgBg.setFitWidth((int) primaryScreenBounds.getWidth());
    }

    private void initTitre() {
        Font police = Font.loadFont(getClass().getResourceAsStream(Path.fontHeadCase), 150);
        titre = new Text("Options");
        titre.setTranslateX(650);
        titre.setTranslateY(175);
        titre.setStyle("-fx-fill: blue;");
        titre.setFont(police);
    }

    private void initSlider() {
        musiqueSlider = new Slider(0, 100, 50);
        musiqueSlider.setTranslateX(750);
        musiqueSlider.setTranslateY(400);
        musiqueSlider.setShowTickMarks(true);
        musiqueSlider.setShowTickLabels(true);
        musiqueSlider.valueProperty().addListener(
                (observable, oldValue, newValue) -> Music.setVolume(newValue.intValue() / 100.));
    }

    private void initButtons() {
        musique = new Button("Musique");
        musique.setTranslateX(325);
        musique.setTranslateY(325);
        musique.setStyle("-fx-background-color: transparent; -fx-text-fill: red;");
        Font policeTitre = Font.loadFont(getClass().getResourceAsStream(Path.fontHeadCase), 90);
        musique.setFont(policeTitre);
        musique.setOnMouseClicked(controllerOptions);

        choisirSaCouleur = new Button("Regles");
        choisirSaCouleur.setTranslateX(325);
        choisirSaCouleur.setTranslateY(485);
        choisirSaCouleur.setStyle("-fx-background-color: transparent; -fx-text-fill: red; ");
        choisirSaCouleur.setFont(policeTitre);
        choisirSaCouleur.setOnMouseClicked(controllerOptions);
        choisirSaCouleur.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                choisirSaCouleur.setStyle("-fx-background-color: transparent; -fx-text-fill: yellow;");
            }
        });

        choisirSaCouleur.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                choisirSaCouleur.setStyle("-fx-background-color: transparent; -fx-text-fill: #ff0000;");
            }
        });

        retour = new Button("Retour");
        retour.setTranslateX(700);
        retour.setTranslateY(950);
        retour.setStyle("-fx-background-color: transparent; -fx-text-fill: #ff0000;");
        retour.setFont(policeTitre);
        retour.setOnMouseClicked(controllerOptions);

        retour.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                retour.setStyle("-fx-background-color: transparent; -fx-text-fill: yellow;");
            }
        });

        retour.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                retour.setStyle("-fx-background-color: transparent; -fx-text-fill: #ff0000;");
            }
        });
    }

    public void setVueOptions() {
        root.getChildren().clear();
        root.getChildren().add(imgBg);
        root.getChildren().add(musique);
        root.getChildren().add(choisirSaCouleur);
        root.getChildren().add(retour);
        root.getChildren().add(titre);
        root.getChildren().add(musiqueSlider);
    }

    public Button getChoisirSaCouleur() {
        return choisirSaCouleur;
    }

    public Button getMusique() {
        return musique;
    }

    public Button getRetour() {
        return retour;
    }
}
