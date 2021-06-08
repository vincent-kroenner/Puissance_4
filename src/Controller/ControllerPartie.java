package Controller;

import Model.Partie;
import View.ViewGame;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerPartie implements EventHandler<MouseEvent> {
    private ViewGame vue;
    private ViewHandler vg;
    private Partie partie;

    public ControllerPartie(ViewGame vue, ViewHandler vg, Partie partie) {
        this.vue = vue;
        this.vg = vg;
        this.partie = partie;
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(vue.getRetourPrincipale())){
            vg.afficherMenuPrincipal();
        }
        else if (event.getX() > 600 & event.getX() < 700) {
            partie.majPlateau(0);
            vue.majPlateau();
            //vue.majVictory();
        } else if (event.getX() > 700 & event.getX() < 800) {
            partie.majPlateau(1);
            vue.majPlateau();
        }else if (event.getX() > 800 & event.getX() < 900) {
            partie.majPlateau(2);
            vue.majPlateau();
        }else if (event.getX() > 900 & event.getX() < 1000) {
            partie.majPlateau(3);
            vue.majPlateau();
        }else if (event.getX() > 1000 & event.getX() < 1100) {
            partie.majPlateau(4);
            vue.majPlateau();
        }else if (event.getX() > 1100 & event.getX() < 1200) {
            partie.majPlateau(5);
            vue.majPlateau();
        }else{
            partie.majPlateau(6);
            vue.majPlateau();
        }
    }
}
