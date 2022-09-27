import java.util.*;
public class TestClackData {
    public static void main(String[] args) {
        ClackData data1 = new MessageClackData("zhalovgv", "hello world", 2);
        ClackData sameData1 = new MessageClackData("zhalovgv", "hello world", 2);
        ClackData data2 = new MessageClackData();

        // Testing ClackData and MessageClackData Methods on first object which
        // uses MessageClackData's first constructor
        System.out.println(data1.getType());
        System.out.println(data1.getUserName());
        System.out.println(data1.getDate());
        System.out.println(data1.getData());
        System.out.println("Hashed Value: " + data1.hashCode());
        System.out.println(data1.toString());

        System.out.println("");
        System.out.println(sameData1.getType());
        System.out.println(sameData1.getUserName());
        System.out.println(sameData1.getDate());
        System.out.println(sameData1.getData());
        System.out.println("Hashed Value: " + sameData1.hashCode());
        System.out.println(sameData1.toString());

        // Testing ClackData and MessageClackData Methods on first object which
        // uses MessageClackData's second constructor
        System.out.println(data2.getType());
        System.out.println(data2.getUserName());
        System.out.println(data2.getDate());
        System.out.println(data2.getData());
        System.out.println("Hashed Value: " + data2.hashCode());
        System.out.println(data2.toString());

        // Testing equals() method of MessageClackData
        System.out.println(data1.equals(data2));
        System.out.println(data2.equals(data1));
        System.out.println(sameData1.equals(data1));
        System.out.println(data1.equals(sameData1));
    }

}
