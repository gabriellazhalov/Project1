package data;
import java.io.*;

/**
 * FileClackData is a subclass of ClackData which stores data for files which are going to be sent
 * @author Aengus Andrew
 */
public class FileClackData extends ClackData{

    private String fileName;
    private String fileContents;

    /**
     * This constructor is the main constructor for the FileClackData object, it creates the object initializing the parameters using a super-constructor, setting the filename and setting the file contents to null
     * @param userName UserName of client sending file
     * @param fileName Name of file being sent
     * @param type type of ClackData object, see ClackData comments for more
     */
    public FileClackData(String userName, String fileName, int type) {
        super(userName, type);
        this.fileName = fileName;
        this.fileContents = "";
    }

    /**
     * The default constructor here calls the default super-constructor, sets the filename and file contents to null
     */
    public FileClackData() {
        super();
        this.fileName = null;
        this.fileContents = "";
    }

    /**
     * Changes the value of the object filename to the filename passed
     * @param fileName New name of file
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Accessor method for filename of object
     * @return <code>String</code> fileName
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * Accessor method for contents of file
     * @return <code>String</code> fileContents
     */
    public String getData() {
        return this.fileContents;
    }

    /**
     * Accessor method for decrypted contents of file
     * @param key Key to decrypt encrypted data
     * @return Decrypted file contents
     */
    public String getData(String key) { return decrypt(fileContents, key); }

    /**
     * Reads contents of a file into the fileContents data member
     */
    public void readFileContents() throws IOException {
        try {
            File file = new File(fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String nextLine = bufferedReader.readLine();
            if (nextLine != null) {
                fileContents += nextLine;
            }
            while ((nextLine = bufferedReader.readLine()) != null) {
                fileContents += "\n" + nextLine;
            }
            bufferedReader.close();
        } catch (FileNotFoundException fnfe){
                System.err.println("File not found.");
        } catch(IOException ioe) {
            System.err.println("IOException occurred.");
        }
    }

    /**
     * Reads contents of a file and encrypts them using <code>key</code> before storing it into fileContents data member
     * @param key Key to encrypt filecontents with
     */
    public void readFileContents(String key) {
        try{
            File file = new File(fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String nextLine = bufferedReader.readLine();
            if (nextLine != null) {
                nextLine = encrypt(nextLine, key);
                fileContents += nextLine;
            }
            while ( (nextLine = bufferedReader.readLine()) != null ){
                nextLine = encrypt(nextLine, key);
                fileContents += "\n" + nextLine;
            }
            bufferedReader.close();
        } catch (FileNotFoundException fnfe){
            System.err.println("File does not exist");
        } catch( IOException ioe) {
            System.err.println("IOException occurred");
        }
    }

    /**
     * Writes file contents to a file
     */
    public void writeFileContents() {
        try{
            File file = new File(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(fileContents);
            bufferedWriter.close();
        }catch (FileNotFoundException fnfe){
            System.err.println("File does not exist");
        } catch(IOException ioe) {
            System.err.println("IOException occurred");
        }

    }

    /**
     * Decrypts fileContents and writes decrypted data to a file
     * @param key Key for decrypting data
     */
    public void writeFileContents(String key) {
        try{
            File file = new File(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                fileContents = decrypt(fileContents, key);
                bufferedWriter.write(fileContents);
            bufferedWriter.close();
        }catch (FileNotFoundException fnfe){
            System.err.println("File does not exist");
        } catch( IOException ioe) {
            System.err.println("IOException occurred");
        }
    }

    /**
     * hashCode() is overridden from the Object class and returns an integer which is unique to the data of this FileClackData object, if fileName and fileContents are null they are excluded from the hashCode
     * @return <code>int</code> hashCode
     */
    public int hashCode() {
        int hashedValue = 0;
        hashedValue += super.userName.hashCode();
        if(fileName != null) hashedValue += fileName.hashCode();
        if(fileContents != null) hashedValue += fileContents.hashCode();
        hashedValue += super.type;
        hashedValue += super.date.hashCode();
        return hashedValue;
    }

    /**
     * equals() method is overridden from the Object class and returns true if the comparison of all data members of both the object passed and the FileClackData object calling the method are true
     * @param obj object to be compared
     * @return <code>true</code> if every data member is equivalent between both classes
     */
    public boolean equals(Object obj) {
        FileClackData fileClackData = (FileClackData) obj;
        return super.userName == fileClackData.userName &&
                this.fileName == fileClackData.fileName &&
                this.fileContents == fileClackData.fileContents &&
                super.type == fileClackData.type &&
                super.date.equals(fileClackData.date);
    }

    /**
     * toString is overridden from the Object class and returns a string that writes out all information for all data members of the object
     * @return <code>String</code> representing all data of the object
     */
    public String toString() {
        return "User: " + super.userName + "\nFile Name: " + fileName + "\nFile Contents: " + fileContents + "\nType of Data: " + super.type + "\nDate: " + super.date;
    }

}
