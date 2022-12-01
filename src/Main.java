import Controller.MainController;
import Model.ModelManager;
import View.View;

public class Main {
    public static void main(String[] args) {
        ModelManager model = new ModelManager();
        View view = new View();
        MainController controller = new MainController(view, model);
        controller.start();
    }

}