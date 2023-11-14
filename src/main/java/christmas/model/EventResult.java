package christmas.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EventResult {

    private final List<DiscountInfo> eventResult;


    private long totalBenefitAmount;

    public EventResult(List<DiscountInfo> eventResult) {
        this.eventResult = eventResult;
    }

    public static EventResult createFrom(List<DiscountInfo> eventResult) {
        List<DiscountInfo> results = eventResult.stream()
                .filter(result -> result.isZeroDiscount() == false)
                .collect(Collectors.toList());
        return new EventResult(results);
    }

    public List<DiscountInfo> getEventResult() {
        return Collections.unmodifiableList(this.eventResult);
    }


    public long calculateTotalBenefit() {
        totalBenefitAmount = eventResult.stream().mapToLong(DiscountInfo::getDiscount).sum();
        return totalBenefitAmount;
    }


    public long calculateExpectedPaymentAmount(long totalOrderAmount) {
        return totalOrderAmount + eventResult.stream().filter(result -> result.isGiveaway() == false)
                .mapToLong(DiscountInfo::getDiscount).sum();
    }

    public Badge generateBadge() {
        return Badge.valueOf(totalBenefitAmount);
    }


}
