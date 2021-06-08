package Controller;

import Model.Options;
import View.ViewHandler;
import View.ViewMenuOptions;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerOptions implements EventHandler<MouseEvent> {
    private ViewMenuOptions vue;
    private ViewHandler vh;
    private Options options;

    public ControllerOptions(ViewMenuOptions vue, ViewHandler vh, Options options) {
        this.vue = vue;
        this.vh = vh;
        this.options = options;
    }


    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(vue.getMusique())) {
            //le comportement si je clic sur jouer
        } else if (event.getSource().equals(vue.getChoisirSaCouleur())) {
            vh.afficherRegle();
        } else if (event.getSource().equals(vue.getRetour())) {
            vh.afficherMenuPrincipal();
        }
    }
}
