package data;

public class FileClackData extends ClackData{

    private String fileName;
    private String fileContents;

    public FileClackData(String userName, String fileName, int type) {
        super(userName, type);
        this.fileName = fileName;
        this.fileContents = null;
    }

    public FileClackData() {
        super();
        this.fileName = null;
        this.fileContents = null;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getData() {
        return this.fileContents;
    }

    public void readFileContents() {

    }

    public void writeFileContents() {

    }

    public int hashCode() {
        int hashedValue = 0;
        hashedValue += super.userName.hashCode();
        if(fileName != null) hashedValue += fileName.hashCode();
        if(fileContents != null) hashedValue += fileContents.hashCode();
        hashedValue += super.type;
        hashedValue += super.date.hashCode();
        return hashedValue;
    }

    public boolean equals(Object obj) {
        FileClackData fileClackData = (FileClackData) obj;
        return super.userName == fileClackData.userName &&
                this.fileName == fileClackData.fileName &&
                this.fileContents == fileClackData.fileContents &&
                super.type == fileClackData.type &&
                super.date.equals(fileClackData.date);
    }

    public String toString() {
        return "User: " + super.userName + "\nFile Name: " + fileName + "\nFile Contents: " + fileContents + "\nType of Data: " + super.type + "\nDate: " + super.date;
    }

}
