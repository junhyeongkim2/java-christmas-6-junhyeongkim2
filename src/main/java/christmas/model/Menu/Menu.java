package christmas.model.Menu;


public enum Menu {


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

    private final String name;
    private final String category;
    private final int price;

    public static final String DRINK_CATEGORY = "음료";

    public static final String MAIN_CATEGORY = "메인";
    public static final String DESSERT_CATEGORY = "디저트";

    Menu(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }


    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }


}
