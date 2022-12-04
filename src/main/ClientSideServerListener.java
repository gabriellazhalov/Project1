package main;

public class ClientSideServerListener implements Runnable {
    private ClackClient client = new ClackClient();

    public ClientSideServerListener(ClackClient client) {
        this.client = client;
    }

    /**
     * Implementation of Runnable method run(), to be used for multi-threading
     */
    @Override
    public void run() {
        while(true) {
            client.receiveData();
            if(client.getCloseConnection()) break;
            client.printData();
        }
    }
}
