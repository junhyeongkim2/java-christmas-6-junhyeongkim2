package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class EventResult {

    private final List<Long> eventResult;

    public EventResult(List<Long> eventResult) {
        this.eventResult = eventResult;
    }

    public List<Long> createEventResult() {
        List<Long> result = new ArrayList<>();

        result.add(eventResult.get(0) * 25000);
        result.add(eventResult.get(1) * 2023);
        result.add(eventResult.get(2) * 2023);
        result.add(eventResult.get(3) * 1000);
        result.add(eventResult.get(4) * 100 + 900);

        return result;
    }


}
