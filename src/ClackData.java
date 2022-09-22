import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class ClackData {
    private String userName;
    private int type;
    private java.time.LocalDate date;

    public ClackData(String userName, int type) {
        this.userName = userName;
        this.type = type;
        date = java.time.LocalDate.now();
    }

    public ClackData(int type) {
        this("Anon",type);
    }

    public ClackData() {
        this(0);
    }

    public int getType() {
        return type;
    }

    public String getUserName() {
        return userName;
    }

    public java.time.LocalDate getDate() {
        return date;
    }

    //Abstract Method
    public abstract MessageClackData getData();
}
