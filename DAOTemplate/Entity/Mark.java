package DAOTemplate.Entity;

public class Mark {
    private int id;
    private String markName;

    public Mark(String markName) {
        this.markName = markName;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }
}
