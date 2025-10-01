import java.util.Scanner;

public class Main {

    public static int key;
    public static String message;
    public static String encryptedMessage;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        InsertKey();
        InsertMessage();
        EncryptMessage();
        PrintEncryptedMessage();
    }

    private static void InsertKey() {
        key = Integer.parseInt(sc.nextLine());
    }

    private static void InsertMessage() {
        message = sc.nextLine();
    }

    private static void EncryptMessage() {
        char[] splittedKey = String.valueOf(key).toCharArray();
        char[] splittedMessage = message.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < splittedMessage.length; i++) {
            int index = i % splittedKey.length;
            char encryptedChar = (char)(splittedMessage[i] + Character.getNumericValue(splittedKey[index]));
            sb.append(encryptedChar);
        }

        encryptedMessage = sb.toString();
    }


    private static void PrintEncryptedMessage() {
        System.out.println("Encrypted Message: " + encryptedMessage);
    }
}
