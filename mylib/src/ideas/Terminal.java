package ideas;

import java.util.Scanner;
import java.util.regex.Pattern;

public final class Terminal {
    private static Scanner sc;
    private static final String pattern = "-?\\d+(\\.\\d+)?";
    
    public static void print(final Object obj) {
        System.out.print(obj);
    }
    
    public static void printLine(final Object obj) {
        System.out.println(obj);
    }
    
    public static String readString(final String prompt) {
        sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextLine();
    }
    
    public static String readString(final String prompt, boolean strict) {
        String rawInput = readString(prompt);
        
        return (strict) ? rawInput.replaceAll("[^a-zA-Z ]", "") : rawInput;
    }
    
    private static boolean isNumeric(String str) {
        if (str == null) {
            return false; 
        }
        
        return Pattern.matches(pattern, str);
    }
    
    public static int readInt(final String prompt) {
        String rawInput = readString(prompt);
        
        if(!isNumeric(rawInput)) {
            rawInput = rawInput.replaceAll("[^0-9]", "").trim();
            
            if(rawInput.equals("")) return 0;
        }
        
        return Integer.parseInt(rawInput);
    }
    
    public static double readDouble(final String prompt) {
        String rawInput = readString(prompt);
        
        if(!isNumeric(rawInput)) {
            rawInput = rawInput.replaceAll("[^0-9.]", "").trim();
            
            if(rawInput.equals("")) return 0;
        }
        
        return Double.parseDouble(rawInput);
    }
}
