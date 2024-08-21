
package app;

import java.util.Scanner;


public class ReadingFile {
    
    static String enter(String str, Scanner sc) {
        System.out.print(str);
        return sc.nextLine();
    }
    
    static void header(String product, String price, String quantity) {
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-30s %20s %20s\n", product, price, quantity);
        System.out.println("------------------------------------------------------------------------");
    }
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            
            String sourceFileStr = enter("Enter the file path: ", sc);
            
            
        }
        
    }
    
}
