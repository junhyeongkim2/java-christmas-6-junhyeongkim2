package christmas.model;

import christmas.model.Event.ChristmasDdayEvent;
import christmas.model.Event.GiveawayEvent;
import christmas.model.Event.SpecialEvent;
import christmas.model.Event.WeekdayEvent;
import christmas.model.Event.WeekendEvent;
import java.util.Collections;
import java.util.List;

public class EventResult {
    private final List<EventPolicy> events;

    private EventResult(List<EventPolicy> events) {
        this.events = events;
    }

    public static EventResult from(int day, Order order) {
        return new EventResult(
                List.of(new ChristmasDdayEvent(day, order), new WeekdayEvent(day, order),
                        new WeekendEvent(day, order), new SpecialEvent(day, order), new GiveawayEvent(day, order)));
    }


    public List<EventPolicy> getEvents() {
        return Collections.unmodifiableList(events);
    }

    public int calculateTotalBenefit() {
        return events.stream().mapToInt(EventPolicy::discount).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        events.stream().filter(eventPolicy -> eventPolicy.isWinningEvents())
                .forEach(eventPolicy -> sb.append(eventPolicy.getEventName() + ": " + eventPolicy.discount() + "원\n"));
        return sb.toString();
    }


}
