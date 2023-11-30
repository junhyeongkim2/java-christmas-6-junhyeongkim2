package christmas.model;

public record EventType(String name) {
    @Override
    public String name() {
        return name;
    }
}
