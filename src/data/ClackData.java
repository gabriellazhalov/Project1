package data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.lang.Character;

/**
 * ClackData is the superclass for all data transmitted through Clack, it has two child classes, MessageClackData and FileClackData
 * It contains 3 data members, storing the Username associated with the data, the type of the data, and the date that the member was created
 * @author Aengus Andrew
 * @author Gabriella Zhalov
 */
public abstract class ClackData {
    protected String userName;
    /**
     * <code>int</code> type can take 4 different forms declared constant, LISTUSERS, LOGOUT, SENDMESSAGE, SENDFILE
     */
    protected int type;
    protected java.time.LocalDate date;

    /**
     * LISTUSERS gives a list of all users connected to the session
     */
    public final int CONSTANT_LISTUSERS = 0;
    /**
     * LOGOUT closes the connection
     */
    public final int CONSTANT_LOGOUT = 1;
    /**
     * SENDMESSAGE sends a message
     */
    public final int CONSTANT_SENDMESSAGE = 2;
    /**
     * SENDFILE sends a file
     */
    public final int CONSTANT_SENDFILE = 3;

    /**
     * Main constructor for ClackData class, initializes userName and type to arguments provided, sets date to date when constructor is called
     * @param userName UserName of user creating data
     * @param type type of data
     */
    public ClackData(String userName, int type) {
        this.userName = userName;
        this.type = type;
        date = java.time.LocalDate.now();
    }

    /**
     * Constructor which takes only a type argument, and initializes userName to "Anon", calls main constructor
     * @param type type of data
     */
    public ClackData(int type) {
        this("Anon",type);
    }

    /**
     * Default constructor calls <code>ClackData(int type)</code> with type set to 0
     */
    public ClackData() {
        this(0);
    }

    /**
     * Acessor method for type of data
     * @return <code>int</code> type
     */
    public int getType() {
        return type;
    }

    /**
     * Accessor method for userName
     * @return <code>String</code> userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Accessor method for date of data creation
     * @return Date
     */
    public java.time.LocalDate getDate() {
        return date;
    }

    /**
     * Abstract Accessor to retrieve data of subclasses
     */
    public abstract String getData();

    /**
     * Abstract Accessor to retrieve unencrypted data of subclasses
     * @param key Key to decrypt encrypted data
     * @return Unencrypted data
     */
    public abstract String getData(String key);

    /**
     * encrypt takes a string to encrypt and a key and uses a Vignere cypher to encrypt it, returning the encryption
     * @param inputStringToEncrypt Input plaintext string
     * @param key Key to encrypt with
     * @return Encrypted string
     */
    protected String encrypt(String inputStringToEncrypt, String key) {
        String encryption = "";
        int j = 0;
        key.toUpperCase();
        for(int i = 0; i < inputStringToEncrypt.length(); ++i) {
            char chr = inputStringToEncrypt.charAt(i);
            if(Character.isUpperCase(chr)) {
                encryption += (char) (((chr - 'A') + (key.charAt(j) - 'A')) % 26 + 'A');
                j = ++j % key.length();
            }
            else if (Character.isLowerCase(chr)) {
                encryption += (char) (((chr - 'a') + (key.charAt(j) - 'A')) % 26 + 'a');
                j = ++j % key.length();
            }
            else if (Character.isWhitespace(chr)) encryption += chr;
        }
        return encryption;
    }

    /**
     * decrypt takes a string encrypted with a Vignere cyper and decrypts it returning the decrypted string
     * @param inputStringToDecrypt Encrypted String
     * @param key Key for decrypting string
     * @return Decrypted String
     */
    protected String decrypt(String inputStringToDecrypt, String key) {
        String decryption = "";
        int j = 0;
        key.toUpperCase();
        for(int i = 0; i < inputStringToDecrypt.length(); ++i) {
            char chr = inputStringToDecrypt.charAt(i);
            if(Character.isUpperCase(chr)) {
                decryption += (char) (((chr - 'A') - (key.charAt(j) - 'A') + 26) % 26 + 'A');
                j = ++j % key.length();
            }
            else if (Character.isLowerCase(chr)) {
                decryption += (char) (((chr - 'a') - (key.charAt(j) - 'A') + 26) % 26 + 'a');
                j = ++j % key.length();
            }
            else decryption += chr;
        }
        return decryption;
    }
}
