package christmas.model.Event;

import christmas.model.EventPolicy;

public class GiveawayEvent implements EventPolicy {

    @Override
    public EventInfo getEventInfo() {
        return EventInfo.GIVEAWAY_EVENT;
    }

    @Override
    public boolean isSatisfied(int day, String menus) {
        return false;
    }

    @Override
    public int discount(int day, String menus) {
        return 0;
    }
}
