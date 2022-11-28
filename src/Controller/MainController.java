package Controller;

import Model.ModelManager;
import View.View;

public class MainController {

    private final View view;
    private final ModelManager model;
    public MainController(View view, ModelManager model) {
        this.view = view;
        this.model = model;
    }

    public void start(){
        boolean exit = false;
        while(!exit){
            switch (view.initialView()){
                case 1:
                    startOrder();
                    break;
                case 2:
                    exit = true;
                    break;
            }
        }
    }

    private void startOrder(){
        view.newOrder();
    }

}


