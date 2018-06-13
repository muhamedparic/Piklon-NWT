package ba.team12.articles.models;

import ba.team12.articles.Condition;

public class Pomocniartikl {
    String name;
    String location;
    int price;
    Condition condition;
    String category;
    Long userId;

    public Pomocniartikl() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public Pomocniartikl(String name, String location, int price, Condition condition, String category, Long userId) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.condition = condition;
        this.category = category;
        this.userId = userId;
    }
}
