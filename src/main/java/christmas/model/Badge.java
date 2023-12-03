package christmas.model;

public enum Badge {

    NONE("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);
    private String name;
    private int condition;

    Badge(String name, int condition) {
        this.name = name;
        this.condition = condition;
    }

    public static Badge from(int totalBenefitAmount) {
        if (totalBenefitAmount <= -20000) {
            return Badge.SANTA;
        }
        if (totalBenefitAmount <= -10000) {
            return Badge.TREE;
        }
        if (totalBenefitAmount <= -5000) {
            return Badge.STAR;
        }
        return Badge.NONE;
    }


}
