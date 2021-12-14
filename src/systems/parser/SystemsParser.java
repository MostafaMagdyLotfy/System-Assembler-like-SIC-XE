package systems.parser;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Yahia, Nour, Moustafa, Ahmed, Ramy
 */
public class SystemsParser {
    
    
   FileDecoder one= new FileDecoder("test");
   public static void main(String[] args) {
        
        //ArrayList<statements> stat =new ArrayList <> ();
        // new Window().setVisible(true);
         
         FileDecoder one = new FileDecoder("test");
       
         Scanner reader = new Scanner(System.in);  // Reading from System.in
         System.out.println("Choose 1 for fixed format and 2 for free fromat: ");
         int n = reader.nextInt();
                
         one.storeFile();
        
         if(n == 1)
            one.fixedDecode();
         else
            one.decode();
        
         Print output = new Print();
         output.print(one.listfile,one.lbllist, 6,one.noerror);
         one.opcode_generate();
        
    }
    
}
