package View;

import Controller.ControllerMenu;
import Model.Menu;
import Music.Music;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class ViewMenuPrincipal {

    private ControllerMenu controllerMenu;
    private Menu menu;
    private Group root;
    private ImageView imgBg;
    private Button nouvellePartie;
    private Button options;
    private Button quitter;
    private Text titre;


    public ViewMenuPrincipal(Group root, ViewHandler vh) {

        this.root = root;
        this.menu = new Menu();
        this.controllerMenu = new ControllerMenu(this, vh, menu);
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
        titre = new Text("Puissance 4");
        titre.setTranslateX(600);
        titre.setTranslateY(175);
        titre.setStyle("-fx-fill: blue;");
        titre.setFont(police);
    }

    private void initButtons() {
        nouvellePartie = new Button(Menu.textBoutonJouer);
        nouvellePartie.setTranslateX(325);
        nouvellePartie.setTranslateY(325);
        nouvellePartie.setStyle("-fx-background-color: transparent; -fx-text-fill: red;");
        Font policeTitre = Font.loadFont(getClass().getResourceAsStream(Path.fontHeadCase), 90);
        nouvellePartie.setFont(policeTitre);
        nouvellePartie.setOnMouseClicked(controllerMenu);

        options = new Button("Options");
        options.setTranslateX(325);
        options.setTranslateY(485);
        options.setStyle("-fx-background-color: transparent; -fx-text-fill: red; ");
        options.setFont(policeTitre);
        options.setOnMouseClicked(controllerMenu);

        quitter = new Button("Quitter");
        quitter.setTranslateX(325);
        quitter.setTranslateY(660);
        quitter.setStyle("-fx-background-color: transparent; -fx-text-fill: #ff0000;");
        quitter.setFont(policeTitre);
        quitter.setOnMouseClicked(controllerMenu);

        nouvellePartie.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                nouvellePartie.setStyle("-fx-background-color: transparent; -fx-text-fill: yellow;");
            }
        });

        nouvellePartie.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                nouvellePartie.setStyle("-fx-background-color: transparent; -fx-text-fill: red;");
            }
        });
        options.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                options.setStyle("-fx-background-color: transparent; -fx-text-fill: yellow;");
            }
        });

        options.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                options.setStyle("-fx-background-color: transparent; -fx-text-fill: red;");
            }
        });
        quitter.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                quitter.setStyle("-fx-background-color: transparent; -fx-text-fill: yellow;");
            }
        });

        quitter.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                quitter.setStyle("-fx-background-color: transparent; -fx-text-fill: red;");
            }
        });
    }

    public void setVueMenu() {
        root.getChildren().clear();
        // todo Etape 3) on met ici les éléments du menu à afficher.
        root.getChildren().add(imgBg);
        root.getChildren().add(nouvellePartie);
        root.getChildren().add(options);
        root.getChildren().add(quitter);
        root.getChildren().add(titre);
    }

    public Button getNouvellePartie() {
        return nouvellePartie;
    }

    public Button getOptions() {
        return options;
    }

    public Button getQuitter() {
        return quitter;
    }

    public Menu getMenu() {
        return menu;
    }
}
