package test;

import main.ClackClient;

public class TestClackClient {
    public static void main(String[] args) {
        //ClackClient tester = new ClackClient(null, "gabi");

        ClackClient client1 = new ClackClient("zhalovgv", "gabi", -1000);
        ClackClient sameClient1 = new ClackClient("zhalovgv", "gabi", 1);
        ClackClient client2 = new ClackClient("zhalovgv", "gabi");
        ClackClient client3 = new ClackClient("zhalovgv");
        ClackClient client4 = new ClackClient();

        //Testing IAE
        //ClackClient iUser = new ClackClient("zhalovgv", null, 1025);

        // Testing methods for client1
        System.out.println(client1.getUserName());
        System.out.println(client1.getHostName());
        System.out.println(client1.getPort());
        System.out.println("Hash Value: " + client1.hashCode());
        System.out.println(client1.toString());

        // Testing methods for client2
        System.out.println(client2.getUserName());
        System.out.println(client2.getHostName());
        System.out.println(client2.getPort());
        System.out.println("Hash Value: " + client2.hashCode());
        System.out.println(client2.toString());

        // Testing methods for client3
        System.out.println(client3.getUserName());
        System.out.println(client3.getHostName());
        System.out.println(client3.getPort());
        System.out.println("Hash Value: " + client3.hashCode());
        System.out.println(client3.toString());

        // Testing methods for client4
        System.out.println(client4.getUserName());
        System.out.println(client4.getHostName());
        System.out.println(client4.getPort());
        System.out.println("Hash Value: " + client4.hashCode());
        System.out.println(client4.toString());

        //Testing equals method
        System.out.println(client1.equals(sameClient1));
        System.out.println(sameClient1.equals(client1));
        System.out.println(client1.equals(client2));
        System.out.println(client2.equals(client1));
    }

}

