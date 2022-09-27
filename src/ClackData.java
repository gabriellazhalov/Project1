import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class ClackData {
    protected String userName;
    protected int type;
    protected java.time.LocalDate date;
    public final int CONSTANT_LISTUSERS = 0;
    public final int CONSTANT_LOGOUT = 1;
    public final int CONSTANT_SENDMESSAGE = 2;
    public final int CONSTANT_SENDFILE = 3;

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
    public abstract String getData();
}
