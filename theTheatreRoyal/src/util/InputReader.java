package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputReader {
private Scanner scanner;
    
    /**
     * Constructor for objects of class InputReader
     */
    public InputReader()
    {
        scanner = new Scanner(System.in); // read from the keyboard
    }
    
    public InputReader(String fileName) throws FileNotFoundException{
        File dataInput = new File(fileName);
        scanner = new Scanner(dataInput);
    }
    
    public Scanner getScanner() {
        return scanner;
    }
    
    public int getNumber(String prompt) {
        System.out.println(prompt);
        int n = scanner.nextInt(); // use the scanner to get the next integer from the input
        scanner.nextLine(); // fix new line character is left unread
        return n;
    }
    
    public String getText(String prompt) {
        System.out.println(prompt);
        String value = scanner.nextLine();
        return value;
    }
    
    public void close() {
        scanner.close();
    }
}
