package test;

import main.ClackServer;

public class TestClackServer {
    public static void main(String[] args) {
        ClackServer C1 = new ClackServer(-1000);
        ClackServer sameC1 = new ClackServer(1000);
        ClackServer C2 = new ClackServer();

        //Testing main.ClackServer Class
        System.out.println(C1);
        System.out.println(sameC1);
        System.out.println(C2);

        System.out.println(C1.getPort());
        System.out.println(sameC1.getPort());
        System.out.println(C2.getPort());

        System.out.println(C1.hashCode());
        System.out.println(sameC1.hashCode());
        System.out.println(C2.hashCode());

        System.out.println(C1.equals(sameC1));
        System.out.println(sameC1.equals(C1));
        System.out.println(C1.equals(C2));
        System.out.println(C2.equals(C1));

    }
}
