public abstract class MessageClackData extends ClackData {
    private String message;

    public MessageClackData(String userName, String message, int type){
        super(userName, type);
        this.message = message;
    }

    public MessageClackData() {
        this("Anon", "N/A", 0);
    }

}
