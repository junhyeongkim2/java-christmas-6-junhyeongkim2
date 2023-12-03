package christmas.model;

import java.util.Collections;
import java.util.List;

public class EventResult {
    private final List<EventPolicy> events;

    public EventResult(List<EventPolicy> events) {
        this.events = events;
    }

    public List<EventPolicy> getEvents() {
        return Collections.unmodifiableList(events);
    }

    public int calculateTotalBenefit() {
        return events.stream().mapToInt(EventPolicy::discount).sum();
    }
}
