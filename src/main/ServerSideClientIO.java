package main;
import data.*;
import java.io.*;
import java.net.*;

/**
 * ServerSideClientIO handles all the input and output for each of the Clients connected to the ClackServer, it implements Runnable to allow for multithreading of the clients
 */
public class ServerSideClientIO implements Runnable {
    private boolean closeConnection;
    private ClackData dataToReceiveFromClient;
    private ClackData dataToSendToClient;
    private ObjectInputStream inFromClient;
    private ObjectOutputStream outToClient;
    private ClackServer server;
    private Socket clientSocket;
    private final String KEY = "BEANSYEAH";
    private String userName;

    /**
     * main constructor for ServerSideClientIO, initialized appropriate variables
     * @param server Server that the Client is connected to
     * @param clientSocket Socket the Client has used to connect to the server
     */
    public ServerSideClientIO (ClackServer server, Socket clientSocket) {
        closeConnection = false;
        this.server = server;
        this.clientSocket = clientSocket;

        dataToReceiveFromClient = null;
        dataToSendToClient = null;
        inFromClient = null;
        outToClient = null;
    }

    /**
     * run() is the main looping method for ServerSideClientIO, it initializes the streams to and from the client, and loops receiving and broadcasting data until the connection is closed.
     */
    @Override
    public void run() {
        try {
            inFromClient = new ObjectInputStream(clientSocket.getInputStream());
            outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
            this.userName = (String) inFromClient.readObject();

            while(!closeConnection) {
                receiveData();
                server.broadcast(dataToReceiveFromClient);
            }
        }
        catch (IOException ioe) {
            System.err.println("IO Exception in getting streams.");
        }
        catch (ClassNotFoundException cnd){
            System.err.println("read error.");
        }
    }

    /**
     * receiveData() reads data from the client and casts it to a ClackData object. If it is type 0 or 1 it conditions it appropriately for processing these requests.
     */
    public void receiveData() {
        try {
            dataToReceiveFromClient = (ClackData) inFromClient.readObject();
            if(dataToReceiveFromClient.getType() == 0) {
                dataToReceiveFromClient = new MessageClackData(this.userName, server.listusers(), KEY,0);
            }
            else if (dataToReceiveFromClient.getType() == 1) {
                closeConnection = true;
                clientSocket.close();
                server.remove(this);
            }
        }
        catch (IOException ioe) {
            System.err.println("IOException in reading object.");
        }
        catch (ClassNotFoundException cnfe) {
            System.err.println("Class not found.");
        }
    }

    /**
     * sendData() sends the data to the client
     */
    public void sendData() {
        try {
            outToClient.writeObject(dataToSendToClient);
        }
        catch (IOException ioe) {
            System.err.println("IOException, cannot write object.");
        }
    }

    /**
     * Mutator method for dataToSendToClient
     * @param dataToSendToClient new data to set variable value to
     */
    public void setDataToSendToClient(ClackData dataToSendToClient) {
        this.dataToSendToClient = dataToSendToClient;
    }

    /**
     * Accessor method for userName object
     * @return userName associated with ServerSideClientIO object
     */
    public String getUserName() {
        return this.userName;
    }
}
