package christmas;

import christmas.controller.ChristmasController;
import christmas.model.Planner;

public class Application {
    public static void main(String[] args) {
        ChristmasController christmasController = new ChristmasController(planner);
        christmasController.start();
    }
}
