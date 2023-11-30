package christmas.model;

import java.util.Collections;
import java.util.List;

public class EventResult {
    private final List<EventType> events;

    public EventResult(List<EventType> events) {
        this.events = events;
    }

    public List<EventType> getEvents() {
        return Collections.unmodifiableList(events);
    }
}
