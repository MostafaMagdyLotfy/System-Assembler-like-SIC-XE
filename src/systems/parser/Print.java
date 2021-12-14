package systems.parser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Print {
 
    void print(ArrayList<ListFile> x,ArrayList<lblfile> y,int n,int error) {
        try {
            PrintWriter writer1;
            //writer1 = new PrintWriter("C:\\Users\\Lenovo\\Desktop\\Systems Parser\\src\\systems\\parser\\Output.txt");
            writer1 = new PrintWriter("D:\\College\\6th Term\\System programming\\New folder\\Systems Parser Final\\Systems Parser Final\\src\\systems\\parser\\Output.txt");
            writer1.print("");
            writer1.close();
            //try (FileWriter writer = new FileWriter("C:\\Users\\Lenovo\\Desktop\\Systems Parser\\src\\systems\\parser\\Output.txt", true)) {
            try (FileWriter writer = new FileWriter("D:\\College\\6th Term\\System programming\\New folder\\Systems Parser Final\\Systems Parser Final\\src\\systems\\parser\\Output.txt", true)) {
             //   writer.write("\r\n");
             
                writer.write("\t\t\tName\tAddress\r\n");
                writer.write("\r\n");               
                for(int q=0;q<y.size();q++)
                {
                 writer.write("\t\t\t" + y.get(q).name + "\t" + toHexa(y.get(q).memory) +"\n" );
                 writer.write("\r\n");
                }
                writer.write("\r\n");
                writer.write("Line no.\tAddress\t\tLabel\t\tOp-Code\t\tOperands\tComments");
                writer.write("\r\n");
                for (int i=0; i <x.size(); i++)              
                {
                    if(!x.get(i).commentline)
                    {
                        /*
                        if(x.get(i).label == null)
                            writer.write(x.get(i).line + "\t\t" + toHexa(x.get(i).memory) + "\t\t" + "      " + "\t\t" + x.get(i).mnemonic+"\t\t"+x.get(i).operands+"\t\t");
                       else
                            writer.write(x.get(i).line + "\t\t" + toHexa(x.get(i).memory) +"\t\t" + x.get(i).label + "\t\t" + x.get(i).mnemonic+"\t\t"+x.get(i).operands+"\t\t");   
                     */
                        if(x.get(i).checkNull() == 1){
                            
                            if(x.get(i).checkNull() == 2){
                                if(x.get(i).checkNull() == 3)
                                    writer.write(x.get(i).line + "\t\t" + toHexa(x.get(i).memory) + "\t\t" + "      " + "\t\t" + "      " +"\t\t" + "      " +"\t\t");
                                else
                                    writer.write(x.get(i).line + "\t\t" + toHexa(x.get(i).memory) + "\t\t" + "      " + "\t\t" + "      " +"\t\t" + x.get(i).operands+"\t\t");
                            }
                            else if(x.get(i).checkNull() == 3)
                                writer.write(x.get(i).line + "\t\t" + toHexa(x.get(i).memory) + "\t\t" + "      " + "\t\t" + x.get(i).mnemonic + "\t\t" + "      " +"\t\t");  
                            else                               
                                writer.write(x.get(i).line + "\t\t" + toHexa(x.get(i).memory) + "\t\t" + "      " + "\t\t" + x.get(i).mnemonic+"\t\t" + x.get(i).operands+"\t\t");
                            
                        }
                        else if(x.get(i).checkNull() == 2){
                            
                            if(x.get(i).checkNull() == 3)
                                writer.write(x.get(i).line + "\t\t" + toHexa(x.get(i).memory) +"\t\t" + x.get(i).label + "\t\t" + "      " + "\t\t" + "      " +"\t\t");
                            else                               
                                writer.write(x.get(i).line + "\t\t" + toHexa(x.get(i).memory) +"\t\t" + x.get(i).label + "\t\t" + "      " + "\t\t" + x.get(i).operands+"\t\t");
                        }
                        else if(x.get(i).checkNull() == 3)
                             writer.write(x.get(i).line + "\t\t" + toHexa(x.get(i).memory) + "\t\t" + x.get(i).label + "\t\t" + x.get(i).mnemonic + "\t\t" + "      " +"\t\t");
                        else
                            writer.write(x.get(i).line + "\t\t" + toHexa(x.get(i).memory) +"\t\t" + x.get(i).label + "\t\t" + x.get(i).mnemonic+"\t\t"+x.get(i).operands+"\t\t");
                        
                        
                        if(x.get(i).comments!=null)
                            writer.write(x.get(i).comments);
                        
                        writer.write("\r\n");
                        if(x.get(i).error)
                        {
                            writer.write("\t\t\t\t\t**********"+x.get(i).errorMessage);
                            writer.write("\r\n");
                        }
                        
                    }
                    else
                    {
                        writer.write(x.get(i).line + "\t\t"+ toHexa(x.get(i).memory) + "\t\t" + x.get(i).comments);
                        writer.write("\r\n");
                        
                    }
                }
                
                if(error==-1)
                {
                    writer.write("\n\t\t*********The Code is Assembled Correctly**************");
                }
                else
                {
                    writer.write("\n\t\t*********The Code is not Correctlly Assembled**************");
                }
            }
            
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
    
    String toHexa(int decimal){
        
        return Integer.toHexString(decimal);
    }
 
}