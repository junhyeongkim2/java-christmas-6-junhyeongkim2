package christmas;

import christmas.controller.ChristmasController;
import christmas.model.Calculator;
import christmas.model.Planner;

public class Application {
    public static void main(String[] args) {
        Planner planner = new Planner();
        ChristmasController christmasController = new ChristmasController(planner);
        christmasController.start();
    }
}
