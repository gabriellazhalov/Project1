import java.util.*;
public class TestClackData {
    public static void main(String[] args) {
        //Testing MessageClackData

        System.out.println("******************************\n" + "MessageClackData Tests: \n");
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


        //Testing FileClackData
        System.out.println("******************************\n" + "FileClackData Tests: \n");
        ClackData fileData1 = new FileClackData("andrewam", "testfile", 2);
        ClackData sameFileData1 = new FileClackData("andrewam", "testfile", 2);
        ClackData fileData2 = new FileClackData();

        // Testing ClackData and MessageClackData Methods on first object which
        // uses MessageClackData's first constructor
        System.out.println(fileData1.getType());
        System.out.println(fileData1.getUserName());
        System.out.println(fileData1.getDate());
        System.out.println(fileData1.getData());
        System.out.println("Hashed Value: " + fileData1.hashCode());
        System.out.println(fileData1.toString());

        System.out.println("");
        System.out.println(sameFileData1.getType());
        System.out.println(sameFileData1.getUserName());
        System.out.println(sameFileData1.getDate());
        System.out.println(sameFileData1.getData());
        System.out.println("Hashed Value: " + sameFileData1.hashCode());
        System.out.println(sameFileData1.toString());

        // Testing ClackData and MessageClackData Methods on first object which
        // uses MessageClackData's second constructor
        System.out.println(fileData2.getType());
        System.out.println(fileData2.getUserName());
        System.out.println(fileData2.getDate());
        System.out.println(fileData2.getData());
        System.out.println("Hashed Value: " + fileData2.hashCode());
        System.out.println(fileData2.toString());

        // Testing equals() method of MessageClackData
        System.out.println(fileData1.equals(fileData2));
        System.out.println(fileData2.equals(fileData1));
        System.out.println(sameFileData1.equals(fileData1));
        System.out.println(fileData1.equals(sameFileData1));

    }

}
