package data;

/**
 * MessageClackData is the subclass of ClackData, which is meant to create messages sent in Clack.
 * It contains 1 local data member, message, which stores the message being sent.
 * In addition, MessageClackData inherits teh 3 data members from Clack data, storing the Username associated with the data, the type of the data, and the date that the member was created
 * @author Gabriella Zhalov
 */
public class MessageClackData extends ClackData {
    private String message;


    /** main constructor for MessageClackData, utilizes the constructor for ClackData to initialize the userName, message, and type
     * @param userName userName of user creating message
     * @param message message to be sent
     * @param type type of data
     */
    public MessageClackData(String userName, String message, int type){
        super(userName, type);
        this.message = message;
    }

    /**
     * default constructor for MessageClackData, calls main constructor and sets default values for the object
     */
    public MessageClackData() {
        this("Anon", "N/A", 1);
    }

    /**
     * Accessor method for message
     * @return <code>String</code> message
     */
    public String getData() {
        return message;
    }

    /**
     * Overriding hashCode method to hash a MessageClackData object
     * @return <code>int</code> hashedValue
     */
    public int hashCode() {
        int hashedValue = 0;
        hashedValue += super.userName.hashCode();
        hashedValue += message.hashCode();
        hashedValue += Integer.toString(super.type).hashCode();
        hashedValue += super.date.hashCode();
        return hashedValue;
    }

    /**
     * Overriding equals method to determine if a MessageClackData object equals another MessageClackData object
     * @return <code>boolean</code>
     */
    public boolean equals(Object obj) {
        MessageClackData messageClackData = (MessageClackData) obj;
        return this.getUserName() == messageClackData.userName &&
                this.message == messageClackData.message &&
                this.getType() == messageClackData.type &&
                this.getDate().equals(messageClackData.date);
    }

    /**
     * Overriding toString method to print out a MessageClackData object
     * @return <code>String</code>
     */
    public String toString() {
        return "User: " + getUserName() + "\nMessage: " + message + "\nType of Data: " + getType() + "\nDate: " + getDate();
     }

}
