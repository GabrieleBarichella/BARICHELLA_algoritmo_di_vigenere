import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int key;
        int choice;
        String message;
        String modifiedMessage;

        key = GetKey();
        message = GetMessage();
        choice = GetChoice();
        modifiedMessage = GetOutputMessage(key, message, choice);
        PrintMessage(modifiedMessage);
    }

    private static int GetKey() {
        System.out.println("Enter a key: ");
        return Integer.parseInt(sc.nextLine());
    }

    private static String GetMessage() {
        System.out.println("Enter a message: ");
        return sc.nextLine();
    }

    private static int GetChoice() {
        System.out.println("Decrypt(0) or Encrypt(1): ");
        return Integer.parseInt(sc.next());
    }

    private static String GetOutputMessage(int key, String encryptedMessage, int k) {
        char[] splittedKey = String.valueOf(key).toCharArray();
        char[] splittedMessage = encryptedMessage.toCharArray();
        StringBuilder sb = new StringBuilder();

        char messageChar;

        for (int i = 0; i < splittedMessage.length; i++) {
            int index = i % splittedKey.length;
            if(k == 0) messageChar = (char)(splittedMessage[i] - Character.getNumericValue(splittedKey[index]));
            else messageChar = (char)(splittedMessage[i] + Character.getNumericValue(splittedKey[index]));
            sb.append(messageChar);
        }

        return sb.toString();
    }

    private static void PrintMessage(String modifiedMessage) {
        System.out.println("Output Message: " + modifiedMessage);
    }
}
