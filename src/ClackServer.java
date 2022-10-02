public class ClackServer {
    private int port;
    private boolean closeConnection;
    private ClackData dataToReceiveFromClient;
    private ClackData dataToSendToClient;

    private final int DEFAULT_PORT = 7000;

    public ClackServer(int port) {
        this.port = port;
        dataToReceiveFromClient = null;
        dataToSendToClient = null;
    }

    public ClackServer() {
        this(7000);
    }

    public void start() {

    }

    public void receiveData() {

    }

    public void sendData() {

    }

    public int getPort() {
        return this.port;
    }

    public int hashCode() {
        int hashedValue = 0;
        hashedValue += this.port;
        if(dataToReceiveFromClient != null) hashedValue += dataToReceiveFromClient.hashCode();
        if(dataToSendToClient != null) hashedValue += dataToSendToClient.hashCode();
        if(closeConnection) hashedValue += 1;
        return hashedValue;
    }

    public boolean equals(Object obj) {
        ClackServer clackServer = (ClackServer) obj;
        return this.port == clackServer.port &&
                this.closeConnection == clackServer.closeConnection &&
                this.dataToReceiveFromClient == clackServer.dataToReceiveFromClient &&
                this.dataToSendToClient == clackServer.dataToSendToClient;
    }

    public String toString() {
        return ("Port Number: " + this.port + "\nClose Connection: " + closeConnection + "\nData to send to Client: " + dataToSendToClient + "\nData to receive from Client: " + dataToReceiveFromClient);
    }


}
