package test;

import data.ClackData;
import data.FileClackData;
import data.MessageClackData;

import java.io.IOException;

public class TestClackData {
    public static void main(String[] args) throws IOException {

        // Used for getData(String key) calls.
        ClackData newData = new MessageClackData("zhalovgv", "hello world", "CHECK", 2);
        FileClackData newData2 = new FileClackData("zhalovgv", "testclass.txt", 3);
        FileClackData errorData = new FileClackData("zhalovgv", "beans.txt", 2);

        System.out.println("Testing MessageClackData's getData(String key), original message is \"hello world\"");
        System.out.println(newData.getData("CHECK"));

        newData2.readFileContents("CHECK");
        System.out.println("Testing FileClackData's getData(String key), original fileContents is \"hello world\"");
        System.out.println("Encrypted file is " + newData2.getData());
        System.out.println(newData2.getData("CHECK"));

        //Testing errors
        errorData.readFileContents();
        errorData.readFileContents("BEANS");

        System.out.println("******************************\n" + "MessageClackData Tests: \n");
        ClackData data1 = new MessageClackData("zhalovgv", "hello world", 2);
        ClackData sameData1 = new MessageClackData("zhalovgv", "hello world", 2);
        ClackData data2 = new MessageClackData();

        // Testing data.ClackData and data.MessageClackData Methods on first object which
        // uses data.MessageClackData's first constructor
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

        // Testing data.ClackData and data.MessageClackData Methods on first object which
        // uses data.MessageClackData's second constructor
        System.out.println(data2.getType());
        System.out.println(data2.getUserName());
        System.out.println(data2.getDate());
        System.out.println(data2.getData());
        System.out.println("Hashed Value: " + data2.hashCode());
        System.out.println(data2.toString());

        // Testing equals() method of data.MessageClackData
        System.out.println(data1.equals(data2));
        System.out.println(data2.equals(data1));
        System.out.println(sameData1.equals(data1));
        System.out.println(data1.equals(sameData1));


        //Testing data.FileClackData
        System.out.println("******************************\n" + "data.FileClackData Tests: \n");
        FileClackData fileData1 = new FileClackData("andrewam", "testfile", 2);
        FileClackData sameFileData1 = new FileClackData("andrewam", "testfile", 2);
        FileClackData fileData2 = new FileClackData();
        FileClackData tester = new FileClackData("zhalovgv", "test.txt", 2);

        // Uses test.txt to test our reading and writing fileContents with and without a key
        tester.readFileContents();
        tester.writeFileContents();

        tester.readFileContents("BEANS");
        tester.writeFileContents("BEANS");

        // Testing data.ClackData and data.MessageClackData Methods on first object which
        // uses data.MessageClackData's first constructor
        System.out.println(fileData1.getType());
        System.out.println(fileData1.getUserName());
        System.out.println(fileData1.getFileName());
        fileData1.setFileName("test2file");
        System.out.println(fileData1.getFileName());
        System.out.println(fileData1.getDate());
        System.out.println(fileData1.getData());
        System.out.println("Hashed Value: " + fileData1.hashCode());
        System.out.println(fileData1.toString());

        System.out.println("");
        System.out.println(sameFileData1.getType());
        System.out.println(sameFileData1.getUserName());
        System.out.println(sameFileData1.getFileName());
        sameFileData1.setFileName("test2file");
        System.out.println(sameFileData1.getFileName());
        System.out.println(sameFileData1.getDate());
        System.out.println(sameFileData1.getData());
        System.out.println("Hashed Value: " + sameFileData1.hashCode());
        System.out.println(sameFileData1.toString());

        // Testing data.ClackData and data.MessageClackData Methods on first object which
        // uses data.MessageClackData's second constructor
        System.out.println(fileData2.getType());
        System.out.println(fileData2.getUserName());
        System.out.println(fileData2.getFileName());
        fileData2.setFileName("test3file");
        System.out.println(fileData2.getFileName());
        System.out.println(fileData2.getDate());
        System.out.println(fileData2.getData());
        System.out.println("Hashed Value: " + fileData2.hashCode());
        System.out.println(fileData2.toString());

        // Testing equals() method of data.MessageClackData
        System.out.println(fileData1.equals(fileData2));
        System.out.println(fileData2.equals(fileData1));
        System.out.println(sameFileData1.equals(fileData1));
        System.out.println(fileData1.equals(sameFileData1));

    }

}
