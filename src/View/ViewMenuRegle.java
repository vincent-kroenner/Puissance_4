package View;

import Controller.ControllerRegle;
import Model.Regle;
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

public class ViewMenuRegle {
    private ControllerRegle controllerRegle;
    private Regle regle;
    private Group root;
    private Text regles;
    private Text regless;
    private ImageView imgBg;
    private Button retourOption;

    public ViewMenuRegle(Group root, ViewHandler vh) {
        this.root = root;
        this.regle = new Regle();
        this.controllerRegle = new ControllerRegle(this, vh, regle);
        initRegle();
        initBackground();
        initRegles();
        initButtons();
    }
    private void initBackground() {
        imgBg = new ImageView(Path.fondMenu);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
        imgBg.setFitHeight((int) primaryScreenBounds.getHeight());
        imgBg.setFitWidth((int) primaryScreenBounds.getWidth());
    }

    private void initRegle() {
        Font police = Font.loadFont(getClass().getResourceAsStream(Path.fontHeadCase), 150);
        regles = new Text("Regles");
        regles.setTranslateX(650);
        regles.setTranslateY(175);
        regles.setStyle("-fx-fill: blue;");
        regles.setFont(police);
    }

    private void initRegles(){
        Font police = Font.loadFont(getClass().getResourceAsStream(Path.fontHeadCase), 50);
        regless = new Text("Il faut aligner 4 jetons de la meme couleur.");
        regless.setTranslateX(450);
        regless.setTranslateY(600);
        regless.setStyle("-fx-fill: red;");
        regless.setFont(police);
    }
    private void initButtons() {
        retourOption = new Button("Retour");
        retourOption.setTranslateX(700);
        retourOption.setTranslateY(950);
        retourOption.setStyle("-fx-background-color: transparent; -fx-text-fill: #ff0000;");
        retourOption.setFont(Font.loadFont(getClass().getResourceAsStream(Path.fontHeadCase), 90));
        retourOption.setOnMouseClicked(controllerRegle);

        retourOption.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                retourOption.setStyle("-fx-background-color: transparent; -fx-text-fill: yellow;");
            }
        });

        retourOption.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                retourOption.setStyle("-fx-background-color: transparent; -fx-text-fill: #ff0000;");
            }
        });
    }


    public void setRegle(){
        root.getChildren().clear();
        root.getChildren().add(imgBg);
        root.getChildren().add(regles);
        root.getChildren().add(regless);
        root.getChildren().add(retourOption);
    }

    public Button getRetourOption(){return retourOption;}
}
