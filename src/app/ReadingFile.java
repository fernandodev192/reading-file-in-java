
package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;


public class ReadingFile {
    
    static String enter(String str, Scanner sc) {
        System.out.print(str);
        return sc.nextLine();
    }
    
    static void header(String product, String price, String quantity) {
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-30s %20s %20s\n", product, price + " [Kz]", quantity);
        System.out.println("------------------------------------------------------------------------");
    }
    
    static String currency(double amount) {
        
        String pattern = "###,##0.00";
        
        Locale locale = Locale.of("pt", "AO");
        
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(locale);
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        
        DecimalFormat df = new DecimalFormat(pattern, dfs);
        
        return df.format(amount);
    }
    
    static void fileRead(String sourceFileStr) {
        
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
            
            String[] head = br.readLine().split(",");
            
            header(head[0], head[1], head[2]);
            
            String line = br.readLine();
            
            while (line != null) {
                
                String[] fields = line.split(",");
                
                String product = fields[0];
                double price   = Double.parseDouble(fields[1]);
                int quantity   = Integer.parseInt(fields[2]);
                
                System.out.printf("%-30s %20s %20s\n", product, currency(price), quantity);
                
                line = br.readLine();
            }
            
            System.out.println("------------------------------------------------------------------------");
            System.out.println("\nREADING SUCCESS!!!\n\n");
            
        } catch (IOException e) {
            System.out.println("Falha ao ler o arquivo: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            
            String sourceFileStr = enter("Enter the file path: ", sc);
            
            System.out.println("");
            
            fileRead(sourceFileStr);
        }
        
    }
    
}
