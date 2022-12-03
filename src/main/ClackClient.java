package main;
import data.*;
import java.util.*;
import java.io.*;
import java.net.*;

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
    private static final int DEFAULT_PORT = 7099;
    private Scanner inFromStd;
    private final String KEY = "BEANSYEAH";

    private ObjectInputStream inFromServer;
    private ObjectOutputStream outToServer;


    /**
     * main constructor for ClackClient
     * Takes in the username of the client, the hostname of the server computer, and port number. Throws Illegal Argument exception for port numbers below 1024
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
            inFromServer = null;
            outToServer = null;

    }

    /** secondary constructor for ClackClient
     * Takes in a username and hostname, but sets the port to a default value
     * @param userName username of client
     * @param hostName name of computer that is hosting the server
     */
    public ClackClient(String userName, String hostName) throws IllegalArgumentException {
        this(userName, hostName, DEFAULT_PORT);
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
    public ClackClient()throws IllegalArgumentException {
        this("Anon");
    }

    /**
     * start() initializes the connection to the server and loops acceptiong commands from the command line until it reads "DONE", and then closes the connection to the server.
     */
    public void start() {
        try {
            Socket skt = new Socket(hostName, port);
            outToServer = new ObjectOutputStream(skt.getOutputStream());
            inFromServer = new ObjectInputStream(skt.getInputStream());

            inFromStd = new Scanner(System.in);

            ClientSideServerListener listener = new ClientSideServerListener(this);
            Thread listenerThread = new Thread(listener);
            listenerThread.start();

            while(!closeConnection) {
                readClientData();
                sendData();
            }
            skt.close();
            outToServer.close();
            inFromServer.close();
        }
        catch (IOException ioe) {
            System.err.println("IO Exception occured.");
        }
    }

    /**
     * Receives an input from the user through standard input and accordingly sends the appropriate information to the server for the server to execute the proper actions.
     */
    public void readClientData() {
        String dataString;
        String tempFileName = "";

        System.out.println("Input a command.");
        dataString = inFromStd.nextLine();
        if (dataString.length() > 8) {
            tempFileName = dataString.substring(8);
        }

        if (dataString.equals("DONE")) {
            this.closeConnection = true;
            this.dataToSendToServer = new MessageClackData(this.userName, "", KEY,
                    1);
        }
        else if (dataString.equals("SENDFILE" + tempFileName)) {
            try {
                File file = new File(tempFileName);
                FileClackData fileData = new FileClackData(userName, tempFileName, 3);
                fileData.readFileContents(KEY);
                dataToSendToServer = fileData;
            } catch (FileNotFoundException fnfe) {
                dataToSendToServer = null;
                System.err.println("File not found.");
            } catch (IOException ioe) {
                dataToSendToServer = null;
                System.err.println("Error reading file");
            }
        }
        else if (dataString.equals("LISTUSERS")) {
        }
        else {
            dataToSendToServer = new MessageClackData(userName, "", 2);
        }
    };

    /**
     * sendData() sends the data to the server. Throws IOE exception if object doesn't write.
     */
    public void sendData() {
        try {
            outToServer.writeObject(dataToSendToServer);
        }
        catch (IOException ioe) {
            System.err.println("IOException - cannot write object.");
        }
    };

    /**
     * receiveData() receives data from the server and casts it to a ClackData object, storing it in the dataToReceiveFromServer object. Throws IE exception for unreadable objects, and throws ClassNotFoundException for classes not found.
     */
    public void receiveData() {
        try {
            dataToReceiveFromServer = (ClackData) inFromServer.readObject();
        }
        catch (IOException ioe) {
            System.err.println("IOException, cannot read object.");
        }
        catch (ClassNotFoundException cnfe) {
            System.err.println("Class not found");
        }
    };

    /**
     * printData prints all the client information sent by a particular user
     */
    public void printData() {
            System.out.println("User: " + dataToReceiveFromServer.getUserName() + "\nFile Contents: " + dataToReceiveFromServer.getData(KEY) + "\nType of Data: " + dataToReceiveFromServer.getType() + "\nDate: " + dataToReceiveFromServer.getDate());
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

    /** Accessor method to return if connection should be closed or not
     * @return <code>boolean</code> closeConnection
     */
    public boolean getCloseConnection() {return closeConnection;}

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

    /**
     * Main method is used for testing
     * @param args Arguments of how to connect to server of form username@IP:Port, Any of these objects can be omitted as long as they are omitted from the back forward. If no port provided default will be used. If no IP provided localhost and default port will be used. If nothing provided anonymous user will be created using localhost and default port number.
     */
    public static void main(String[] args) {
        if(args.length == 0) {
            ClackClient client = new ClackClient();
            client.start();
        }
        else {
            int indexOfAt = args[0].indexOf('@');
            int indexOfColon = args[0].indexOf(':');
            if(indexOfAt == -1) {
                ClackClient client = new ClackClient(args[0]);
                client.start();
            } else if (indexOfColon == -1){
                String username = args[0].substring(0,indexOfAt);
                String IPAddress = args[0].substring(indexOfAt+1);
                ClackClient client = new ClackClient(username, IPAddress);
                client.start();
            } else {
                String username = args[0].substring(0,indexOfAt);
                String IPAddress = args[0].substring(indexOfAt+1, indexOfColon);
                String portNum = args[0].substring(indexOfColon+1);
                ClackClient client = new ClackClient(username, IPAddress, Integer.parseInt(portNum));
                client.start();
            }
        }
    }

}
