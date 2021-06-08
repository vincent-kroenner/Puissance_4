package Controller;

import Model.Menu;
import View.ViewHandler;
import View.ViewMenuPrincipal;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerMenu implements EventHandler<MouseEvent> {
    private ViewMenuPrincipal vue;
    private ViewHandler vh;
    private Menu model;

    public ControllerMenu(ViewMenuPrincipal vue, ViewHandler vh, Menu model) {
        this.vue = vue;
        this.vh = vh ;
        this.model = model;
    }


    @Override
    public void handle(MouseEvent event) {
        if(event.getSource().equals(vue.getNouvellePartie())){
            model.initGame();
            vh.afficherJeu();
        } else if(event.getSource().equals(vue.getOptions())){
           vh.afficherMenuOptions();
        }else if(event.getSource().equals(vue.getQuitter())){
            System.exit(0);
        }
    }
}
