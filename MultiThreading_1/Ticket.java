package MultiThreading_1;

public class Ticket {
    private int id;
    private String movieName;

    public Ticket(int id, String movieName) {
        this.id = id;
        this.movieName = movieName;
    }

    public int getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                '}';
    }
}
