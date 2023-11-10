package christmas.model;

public class EventChecker {
    public void checkEvent(int totalOrderAmount) {
        checkGiveawayMenu(totalOrderAmount);
    }

    public Boolean checkGiveawayMenu(int totalOrderAmount) {
        if (totalOrderAmount >= 120000) {
            return true;
        }
        return false;
    }


}
