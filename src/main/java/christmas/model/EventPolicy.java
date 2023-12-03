package christmas.model;

import christmas.model.Event.EventInfo;
import java.util.Map;

public interface EventPolicy {

    public EventInfo getEventInfo();

    public String getEventName();

    public boolean isSatisfied(int day, Order order);

    public int discount();

    public boolean isWinningEvents();

    boolean isGiveaway();
}
