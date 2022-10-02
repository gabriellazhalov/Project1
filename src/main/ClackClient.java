package main;
import data.*;

public class ClackClient {
    //Variables
    private String userName;
    private String hostName;
    private int port;
    private boolean closeConnection;
    private ClackData dataToSendToServer;
    private ClackData dataToReceiveFromServer;
    public final int FIXED_PORT = 7000;

    //Constructors
    public ClackClient(String userName, String hostName, int port) {
        this.userName = userName;
        this.hostName = hostName;
        this.port = port;
        dataToSendToServer = null;
        dataToReceiveFromServer = null;
    }

    public ClackClient(String userName, String hostName) {
        this(userName, hostName, 7000);
    }

    public ClackClient(String userName) {
        this(userName, "localhost");
    }

    public ClackClient() {
        this("Anon");
    }

    //Methods
    public void start() {};
    public void readData() {};
    public void sendData() {};
    public void receiveData() {};
    public void printData() {};

    public String getUserName() {
        return userName;
    }
    public String getHostName() {
        return hostName;
    }

    public int getPort() {
        return port;
    }

    public int hashCode() {
        int hashedValue = 0;
        hashedValue += getUserName().hashCode();
        hashedValue += getHostName().hashCode();
        hashedValue += Integer.toString(getPort()).hashCode();
        hashedValue += dataToSendToServer.hashCode();
        hashedValue += dataToReceiveFromServer.hashCode();
        return hashedValue;
    }

    public boolean equals(Object obj) {
        ClackClient clackClient = (ClackClient) obj;
        return this.userName == clackClient.userName && this.hostName ==
                clackClient.hostName && this.port== clackClient.port &&
                this.dataToSendToServer == clackClient.dataToSendToServer && this.dataToReceiveFromServer
                == clackClient.dataToReceiveFromServer;
    }

    public String toString() {
        return "User: " + userName + "\nHost: " + hostName + "\nPort: " + port + "\nData to Send: "
                + dataToSendToServer.toString() + "\nData to Receive: " + dataToReceiveFromServer.toString();
    }

}
