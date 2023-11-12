package christmas.model;

import christmas.model.Event.EventType;
import java.util.Collections;
import java.util.List;

public class EventResult {

    private final List<EventType> eventResult;

    private long totalBenefitAmount;

    public EventResult(List<EventType> eventResult) {
        this.eventResult = eventResult;
    }

    public static EventResult createOf(List<EventType> eventResult) {

        return new EventResult(eventResult);
    }

    public List<EventType> getEventResult() {
        return Collections.unmodifiableList(this.eventResult);
    }


    public long calculateTotalBenefit() {
        totalBenefitAmount = eventResult.stream().mapToLong(EventType::getDiscount).sum();
        return totalBenefitAmount;
    }


    public long calculateExpectedPaymentAmount(long totalOrderAmount) {
        return totalOrderAmount - eventResult.stream().skip(1).limit(4).mapToLong(EventType::getDiscount).sum();
    }

    public Badge generateBadge() {
        return Badge.valueOf(totalBenefitAmount);
    }


}
