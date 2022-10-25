package main;
import data.*;
import java.util.*;

/**
 * ClackClient represents the client who is using the service. Contains information about the client,
 * host computer that is the server, port, connection status, and data to be sent and received.
 * @author Gabriella Zhalov
 */
public class ClackClient {
    private String userName;
    private String hostName;
    private int port;
    private boolean closeConnection;
    private ClackData dataToSendToServer;
    private ClackData dataToReceiveFromServer;
    private static final int DEFAULT_PORT = 7000;
    private final String KEY = "";
    private Scanner inFromStd;


    /**
     * main constructor for ClackClient
     * Takes in the username of the client, the hostname of the server computer, and port number.
     * @param userName username of client
     * @param hostName name of computer that is hosting the server
     * @param port port number to access
     */
    public ClackClient(String userName, String hostName, int port) {
            this.userName = userName;
            if (userName == null) {
                throw new IllegalArgumentException("Username must not be null.");
            }
            this.hostName = hostName;
            if (hostName == null) {
                throw new IllegalArgumentException("Hostname must not be null.");
            }
            this.port = port;
            if (port < 1024) {
                throw new IllegalArgumentException("Port number must be greater than or equal to 1024.");
            }
            dataToSendToServer = null;
            dataToReceiveFromServer = null;

    }

    /** secondary constructor for ClackClient
     * Takes in a username and hostname, but sets the port to a default value
     * @param userName username of client
     * @param hostName name of computer that is hosting the server
     */
    public ClackClient(String userName, String hostName) {
        this(userName, hostName, 7000);
    }

    /** tertiary constructor for ClackClient
     * Takes in the username of the client, sets the hostname and port to a default value
     * @param userName username of client
     */
    public ClackClient(String userName) throws IllegalArgumentException {
            this(userName, "localhost");
    }

    /** default constructor for ClackClient
     * sets the username to 'Anon', hostname to 'localhost', and port to 7000 using previous constructors
     */
    public ClackClient() {
        this("Anon");
    }

    /**
     * This function is currently undefined
     */
    public void start() {
        inFromStd = new Scanner(System.in);
        readClientData();

        dataToReceiveFromServer = dataToSendToServer;
        printData();
    };

    /**
     * This function is currently undefined
     */
    public void readClientData() {
        String dataString;
        String tempFileName;

        System.out.println("Input a command.");
        dataString = inFromStd.nextLine();
        tempFileName = dataString.substring(8);

        if (dataString.equals("DONE")) {
            dataToSendToServer = new MessageClackData();
        }
        else if (dataString.equals("SENDFILE" + tempFileName)) {
            dataToSendToServer = new FileClackData(userName, tempFileName, 3);
        }
        else if (dataString.equals("LISTUSERS")) {
        }
        else {
            dataToSendToServer = new MessageClackData(userName, "", 2);
        }
    };

    /**
     * This function is currently undefined
     */
    public void sendData() {};

    /**
     * This function is currently undefined
     */
    public void receiveData() {};

    /**
     * This function is currently undefined
     */
    public void printData() {
        dataToReceiveFromServer.toString();
    };

    /** Accessor method to get the username
     * @return <code>String</code> userName
     */
    public String getUserName() {
        return userName;
    }

    /** Accessor method to get the hostname
     * @return <code>String</code> hostName
     */
    public String getHostName() {
        return hostName;
    }

    /** Accessor method to get the port number
     * @return <code>int</code> port
     */
    public int getPort() {
        return port;
    }

    /**
     * Overriding hashCode method to hash a ClackClient object
     * @return <code>int</code> hashedValue
     */
    public int hashCode() {
        int hashedValue = 0;
        hashedValue += getUserName().hashCode();
        hashedValue += getHostName().hashCode();
        hashedValue += Integer.toString(getPort()).hashCode();
        if(dataToSendToServer != null) hashedValue += dataToSendToServer.hashCode();
        if(dataToReceiveFromServer != null) hashedValue += dataToReceiveFromServer.hashCode();
        return hashedValue;
    }

    /**
     * Overriding equals method to determine if a ClackClient object equals another ClackClient object
     * @return <code>boolean</code>
     */
    public boolean equals(Object obj) {
        ClackClient clackClient = (ClackClient) obj;
        return this.userName == clackClient.userName && this.hostName ==
                clackClient.hostName && this.port== clackClient.port &&
                this.dataToSendToServer == clackClient.dataToSendToServer && this.dataToReceiveFromServer
                == clackClient.dataToReceiveFromServer;
    }

    /**
     * Overriding toString method to print out a ClackClient object
     * @return <code>String</code>
     */
    public String toString() {
        return "User: " + userName + "\nHost: " + hostName + "\nPort: " + port + "\nData to Send: "
                + dataToSendToServer + "\nData to Receive: " + dataToReceiveFromServer;
    }

}
