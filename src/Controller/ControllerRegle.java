package Controller;

import Model.Regle;
import View.ViewHandler;
import View.ViewMenuRegle;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerRegle implements EventHandler<MouseEvent> {
    private ViewMenuRegle vue;
    private ViewHandler vh;
    private Regle regle;

    public ControllerRegle(ViewMenuRegle vue, ViewHandler vh, Regle regle) {
        this.vue = vue;
        this.vh = vh;
        this.regle = regle;
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(vue.getRetourOption())) {
            vh.afficherMenuOptions();
        }
    }
}
