package christmas.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventResult {

    private final List<Long> eventResult;

    public EventResult(List<Long> eventResult) {
        this.eventResult = eventResult;
    }

    public static EventResult createOf(List<Long> eventResult) {
        List<Long> result = new ArrayList<>();

        result.add(eventResult.get(0) * 25000);
        result.add(eventResult.get(1) * 2023);
        result.add(eventResult.get(2) * 2023);
        result.add(eventResult.get(3) * 1000);
        result.add(eventResult.get(4) * 100 + 900);

        return new EventResult(result);
    }

    public long calculateTotalBenefit() {
        return eventResult.stream().mapToLong(Long::longValue).sum();
    }

    public List<Long> getEventResult() {
        return Collections.unmodifiableList(this.eventResult);
    }


}
