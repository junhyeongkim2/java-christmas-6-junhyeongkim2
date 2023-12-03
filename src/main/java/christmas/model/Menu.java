package christmas.model;

public enum Menu {

    없음("없음", "없음", 0),
    양송이수프("양송이수프", "에피타이저", 6000),
    타파스("타파스", "에피타이저", 5500),
    시저샐러드("시저샐러드", "에피타이저", 8000),
    티본스테이크("티본스테이크", "메인", 55000),
    바비큐립("바비큐립", "메인", 54000),
    해산물파스타("해산물파스타", "메인", 35000),
    크리스마스파스타("크리스마스파스타", "메인", 25000),
    초코케이크("초코케이크", "디저트", 15000),
    아이스크림("아이스크림", "디저트", 5000),
    제로콜라("제로콜라", "음료", 3000),
    레드와인("레드와인", "음료", 60000),
    샴페인("샴페인", "음료", 25000);

    private String name;
    private String category;
    private int price;

    Menu(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Boolean isDessert() {
        if (category.equals("디저트")) {
            return true;
        }
        return false;
    }

    public Boolean isMain() {
        if (category.equals("메인")) {
            return true;
        }
        return false;
    }

    public int getPrice() {
        return price;
    }

}
