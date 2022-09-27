public class MessageClackData extends ClackData {
    private String message;

    public MessageClackData(String userName, String message, int type){
        super(userName, type);
        this.message = message;
    }

    public MessageClackData() {
        this("Anon", "N/A", 0);
    }

    public String getData() {
        return message;
    }

    public int hashCode() {
        int hashedValue = 0;
        hashedValue += super.userName.hashCode();
        hashedValue += message.hashCode();
        hashedValue += Integer.toString(super.type).hashCode();
        hashedValue += super.date.hashCode();
        return hashedValue;
    }

    public boolean equals(Object obj) {
        MessageClackData messageClackData = (MessageClackData) obj;
        return this.getUserName() == messageClackData.userName &&
                this.message == messageClackData.message &&
                this.getType() == messageClackData.type &&
                this.getDate().equals(messageClackData.date);
    }

    public String toString() {
        return "User: " + getUserName() + "\nMessage: " + message + "\nType of Data: " + getType() + "\nDate: " + getDate();
     }

}
