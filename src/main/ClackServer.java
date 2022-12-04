package main;
import data.*;
import java.net.*;
import java.io.*;
import java.util.*;

/**
 * ClackServer contains the information about the port that the client connects to and the data being sent to and received from the client
 * It also contains a boolean value closeConnection which says if the server needs to be closed or not
 * @author Aengus Andrew
 */
public class ClackServer {
    private int port;
    private boolean closeConnection;
    private ArrayList <ServerSideClientIO> serverSideClientIOList;
    private static final int DEFAULT_PORT = 7099;


    /**
     * ClackServer(int port) is the main constructor for this class
     * The main constructor takes a single integer port as argument and sets the port number to this value, then sets the data to be sent and received to null
     * @param port port number to access
     */
    public ClackServer(int port) throws IllegalArgumentException {
        if (port < 1024) {
            throw new IllegalArgumentException("The port cannot be lesser than 1024.");
        }
        serverSideClientIOList = new ArrayList<ServerSideClientIO>();
        this.port = port;
        this.closeConnection = false;
    }

    /**
     * ClackServer() is the default constructor for this class
     * The default constructor calls the main constructor with the default port 7000
     */
    public ClackServer() throws IllegalArgumentException {
        this(DEFAULT_PORT);
    }

    /**
     * start() initializes the Server to accept Clients and then accepts them. It also receives the data and processes it before sending data back to the client.Throws IOE for IO exceptions.
     */
    public void start() {
        try {
            ServerSocket sskt = new ServerSocket(port);
            while(!closeConnection) {
                Socket clientSkt = sskt.accept();
                ServerSideClientIO sclient = new ServerSideClientIO(this, clientSkt);
                serverSideClientIOList.add(sclient);

                Thread ssclioThread = new Thread(sclient);
                ssclioThread.start();
                if (serverSideClientIOList.isEmpty()) {
                    closeConnection = true;
                }
            }
            sskt.close();

        }
        catch (IOException ioe) {
            System.err.println("IOException occured.");
        }
    }


    public synchronized void remove(ServerSideClientIO ssc) { serverSideClientIOList.remove(ssc);}

    public synchronized void broadcast(ClackData dataToBroadcastToClient){
        for(ServerSideClientIO SSCI : serverSideClientIOList) {
            SSCI.setDataToSendToClient(dataToBroadcastToClient);
            SSCI.sendData();
        }
    }

    /**
     * Returns the current value of port for the class
     * @return port
     */
    public int getPort() {
        return this.port;
    }

    public String listusers() {
        String userNameList = "";
        for (ServerSideClientIO sscio : serverSideClientIOList) {
            userNameList += (sscio.getUserName() + '\n');
        }
        return userNameList;
    }


    /**
     * hashCode() is overridden from the Object class and creates a unique integer for this ClackServer object
     * @return <code>int</code> hashCode
     */
    public int hashCode() {
        int hashedValue = 0;
        hashedValue += this.port;
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
                this.closeConnection == clackServer.closeConnection;
    }

    /**
     * toString() is overridden from the Object class and returns a string which represents all data in the ClackServer object
     * @return <code>String</code> representing all data in the ClackServer object
     */
    public String toString() {
        return ("Port Number: " + this.port + "\nClose Connection: " + closeConnection);
    }

    /**
     * Main method is used for testing
     * @param args Arguments of port for Client to connect to
     */
    public static void main(String[] args) {
        if(args.length == 0) {
            ClackServer server = new ClackServer();
            server.start();
        } else {
            ClackServer server = new ClackServer(Integer.parseInt(args[0]));
            server.start();
        }

    }

}
