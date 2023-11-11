package christmas.model;

public enum Badge {

    없음("없음", 0),
    별("별", 5000),
    트리("트리", 10000),
    산타("산타", 20000);

    private final String name;
    private final int price;

    Badge(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static Badge valueOf(long totalBenefitAmount) {
        if (totalBenefitAmount >= Badge.별.price && totalBenefitAmount < Badge.트리.price) {
            return Badge.별;
        }
        if (totalBenefitAmount >= Badge.트리.price && totalBenefitAmount < Badge.산타.price) {
            return Badge.트리;
        }
        if (totalBenefitAmount >= Badge.산타.price) {
            return Badge.산타;
        }
        return Badge.없음;
    }

}
