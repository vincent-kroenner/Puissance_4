package View;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewHandler extends Application {
    private ViewMenuPrincipal mp;
    private ViewMenuOptions op;
    private ViewMenuRegle mr;
    private ViewGame vg;

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        Scene scene = new Scene(root);

        mp = new ViewMenuPrincipal(root, this);
        op = new ViewMenuOptions(root, this);
        vg = new ViewGame(root,this);
        mr = new ViewMenuRegle(root,this);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Puissance 4");
        primaryStage.setFullScreenExitHint("");
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setFullScreen(true);
        primaryStage.show();

        afficherMenuPrincipal();
    }

    public void afficherRegle(){mr.setRegle();}
    public void afficherMenuPrincipal() {
        mp.setVueMenu();
    }
    public void afficherMenuOptions() {
        op.setVueOptions();
    }
    public void afficherJeu() { vg.setVueCompleteGame(); }

    public ViewMenuPrincipal getMp() {
        return mp;
    }
}