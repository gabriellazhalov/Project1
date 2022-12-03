package main;
import data.*;
import java.io.*;
import java.net.*;

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


    public ServerSideClientIO (ClackServer server, Socket clientSocket) {
        closeConnection = false;
        this.server = server;
        this.clientSocket = clientSocket;

        dataToReceiveFromClient = null;
        dataToSendToClient = null;
        inFromClient = null;
        outToClient = null;
    }

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
            System.err.println("read erro.");
        }
    }

    public void receiveData() {
        try {
            dataToReceiveFromClient = (ClackData) inFromClient.readObject();
            if(dataToReceiveFromClient.getType() == 0) {
                System.out.println(server.listusers());
                dataToReceiveFromClient = new MessageClackData(this.userName, server.listusers(),KEY,0);
            }
            else if (dataToReceiveFromClient.getType() == 1) {
                clientSocket.close();
                closeConnection = true;
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

    public void sendData() {
        try {
            outToClient.writeObject(dataToSendToClient);
        }
        catch (IOException ioe) {
            System.err.println("IOException, cannot write object.");
        }
    }

    public void setDataToSendToClient(ClackData dataToSendToClient) {
        this.dataToSendToClient = dataToSendToClient;
    }

    public String getUserName() {
        return this.userName;
    }
}
