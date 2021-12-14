/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systems.parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ahmed
 */
public class Print_objfile {
    
   public int starting_adress;
   public String program_name;
   public int length;
   public String opcode="";
   void print(){
            try {
                System.out.println("start: "+toHexa(starting_adress));
                String adress = toHexa(starting_adress);
                String code_length=toHexa(length);
                PrintWriter writer1;
                
                writer1 = new PrintWriter("D:\\College\\6th Term\\System programming\\New folder\\Systems Parser Final\\Systems Parser Final\\src\\systems\\parser\\Objfile.txt");
                writer1.print("");
                writer1.close();
                try (FileWriter writer = new FileWriter("D:\\College\\6th Term\\System programming\\New folder\\Systems Parser Final\\Systems Parser Final\\src\\systems\\parser\\Objfile.txt", true)){
                if(program_name.length()==5)
                   program_name=program_name+" ";
                 if(program_name.length()==4)
                    program_name=program_name+"  ";
                  if(program_name.length()==3)
                     program_name=program_name+"   ";
                   if(program_name.length()==2)
                      program_name=program_name+"    ";
                    if(program_name.length()==1)
                       program_name=program_name+"     ";
                     if(program_name.length()==0)
                        program_name=program_name+"      ";
                if(adress.length()==5)
                   adress="0"+adress;
                 if(adress.length()==4)
                    adress="00"+adress;
                  if(adress.length()==3)
                     adress="000"+adress;
                   if(adress.length()==2)
                      adress="0000"+adress;
                    if(adress.length()==1)
                       adress="00000"+adress;
                if(code_length.length()==5)
                  code_length="0"+code_length;
                 if(code_length.length()==4)
                  code_length="00"+code_length;
                  if(code_length.length()==3)
                  code_length="000"+code_length;
                   if(code_length.length()==2)
                  code_length="0000"+code_length;
                    if(code_length.length()==1)
                  code_length="00000"+code_length;
                writer.write("H"+program_name+adress+code_length+"\n");
                writer.write("T"+adress+code_length+opcode+"\n");
                writer.write("E"+adress);
                }             
               
            } catch (IOException e) {
           e.printStackTrace();
       }
            
}
      
      String toHexa(int decimal){
        
        return Integer.toHexString(decimal);
    }
   }

