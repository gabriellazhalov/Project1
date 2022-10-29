package main;
import data.*;

/**
 * ClackServer contains the information about the port that the client connects to and the data being sent to and received from the client
 * It also contains a boolean value closeConnection which says if the server needs to be closed or not
 * @author Aengus Andrew
 */
public class ClackServer {
    private int port;
    private boolean closeConnection;
    private ClackData dataToReceiveFromClient;
    private ClackData dataToSendToClient;

    private static final int DEFAULT_PORT = 7000;


    /**
     * ClackServer(int port) is the main constructor for this class
     * The main constructor takes a single integer port as argument and sets the port number to this value, then sets the data to be sent and received to null
     * @param port port number to access
     */
    public ClackServer(int port) {
        this.port = port;
        dataToReceiveFromClient = null;
        dataToSendToClient = null;
    }

    /**
     * ClackServer() is the default constructor for this class
     * The default constructor calls the main constructor with the default port 7000
     */
    public ClackServer() {
        this(7000);
    }

    /**
     * This function is currently undefined
     */
    public void start() {

    }

    /**
     * This function is currently undefined
     */
    public void receiveData() {

    }

    /**
     * This function is currently undefined
     */
    public void sendData() {

    }

    /**
     * Returns the current value of port for the class
     * @return port
     */
    public int getPort() {
        return this.port;
    }

    /**
     * hashCode() is overridden from the Object class and creates a unique integer for this ClackServer object
     * @return <code>int</code> hashCode
     */
    public int hashCode() {
        int hashedValue = 0;
        hashedValue += this.port;
        if(dataToReceiveFromClient != null) hashedValue += dataToReceiveFromClient.hashCode();
        if(dataToSendToClient != null) hashedValue += dataToSendToClient.hashCode();
        if(closeConnection) hashedValue += 1;
        return hashedValue;
    }

    /**
     * equals() is overridden from the Object class and compares two ClackServer objects and tests the equality of each data member of the objects, if every data member is equivalent it returns true
     * @param obj object to be compared
     * @return <code>true</code> if the objects are equivalent
     */
    public boolean equals(Object obj) {
        ClackServer clackServer = (ClackServer) obj;
        return this.port == clackServer.port &&
                this.closeConnection == clackServer.closeConnection &&
                this.dataToReceiveFromClient == clackServer.dataToReceiveFromClient &&
                this.dataToSendToClient == clackServer.dataToSendToClient;
    }

    /**
     * toString() is overridden from the Object class and returns a string which represents all data in the ClackServer object
     * @return <code>String</code> representing all data in the ClackServer object
     */
    public String toString() {
        return ("Port Number: " + this.port + "\nClose Connection: " + closeConnection + "\nData to send to Client: " + dataToSendToClient + "\nData to receive from Client: " + dataToReceiveFromClient);
    }


}
