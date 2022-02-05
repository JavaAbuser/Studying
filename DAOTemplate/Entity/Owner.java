package DAOTemplate.Entity;

public class Owner {
    private int id;
    private String name;

    public Owner(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Owner: " +
                "id=" + id +
                ", name='" + name;
    }
}
