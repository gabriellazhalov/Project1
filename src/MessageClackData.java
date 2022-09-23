public abstract class MessageClackData extends ClackData {
    private String message;

    public MessageClackData(String userName, String message, int type){
        super(userName, type);
        this.message = message;
    }

    public MessageClackData() {
        this("Anon", "N/A", 0);
    }

    public int hashCode() {
        int hashedValue = 0;
        hashedValue += getUserName().hashCode();
        hashedValue += message.hashCode();
        hashedValue += Integer.toString(getType()).hashCode();
        hashedValue += getDate().hashCode();
        return hashedValue;
    }

    public boolean equals(Object obj) {
        MessageClackData messageClackData = (MessageClackData) obj;
        return this.getUserName() == messageClackData.getUserName() &&
                this.message == messageClackData.message &&
                this.getType() == messageClackData.getType() &&
                this.getDate() == messageClackData.getDate();
    }

    public String toString() {
        return "User: " + getUserName() + "\nMessage: " + message + "\nType of Data: " + getType() + "\nDate: " + getDate();
     }

}
