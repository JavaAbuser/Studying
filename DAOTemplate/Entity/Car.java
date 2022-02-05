package DAOTemplate.Entity;

public class Car {
    private int id;
    private int mark;
    private String model;
    private int price;

    public Car(int mark, String model, int price) {
        this.mark = mark;
        this.model = model;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car: " + " id=" + id +
                ", mark=" + mark +
                ", model='" + model + '\'' +
                ", price=" + price;
    }
}
