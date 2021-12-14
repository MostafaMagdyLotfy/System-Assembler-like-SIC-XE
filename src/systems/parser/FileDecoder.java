package systems.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;


public class FileDecoder
{
    
    public  ArrayList<statements> stat       = new ArrayList<>();
    public  ArrayList<String>     Registers  = new ArrayList<>();
    public  ArrayList<String>     opcodeReg  = new ArrayList<>();
    public  ArrayList<ListFile>   listfile   = new ArrayList<>();
    public  ArrayList<String>     fileLines  = new ArrayList<>();
    public  ArrayList<directive>  direct     = new ArrayList<>();
    public  ArrayList<lblfile>    lbllist    = new ArrayList<>();
    int     increment = 0, mainmemory = -1,linecounter = 1;
    public  ListFile each = new ListFile();
    public  String fileName; 
    boolean end_flag = false;
    boolean fixedFormat = false, hexaNumber = false, Byte = false, resw = false, resb = false, Word = false;
    String  fixedOperation[] = new String[1];
    public  ArrayList<String> fixedLabelTabel = new ArrayList<>();
    int locctr,noerror=-1;
    public String op_hex;
    
    public FileDecoder(String fileName) {
        
      
      this.fileName = "D:\\College\\6th Term\\System programming\\New folder\\Systems Parser Final\\Systems Parser Final\\src\\systems\\parser\\test.txt";
     statements RMO  = new statements("RMO",2,2,"r","10101100");
     statements LDx  = new statements("LDx",0,3,"m","000001");
     statements lLDx  = new statements("+LDx",0,4,"m","000001");
     statements LDs  = new statements("LDs",0,3,"m","011011");
     statements lLDs  = new statements("+LDs",0,4,"m","011011");
     statements LDt  = new statements("LDt",0,3,"m","011101");
     statements lLDt  = new statements("+LDt",0,4,"m","011101");
     statements LDb  = new statements("LDb",0,3,"m","011010");
     statements lLDb  = new statements("+LDb",0,4,"m","011010");
     statements LDa  = new statements("LDa",0,3,"m","000000");
     statements lLDa  = new statements("+LDa",0,4,"m","000000");
     statements STs  = new statements("STs",0,3,"m","011111");
     statements sSTs  = new statements("+STs",0,4,"m","011111");
     statements STt  = new statements("STt",0,3,"m","100001");
     statements sSTt  = new statements("+STt",0,4,"m","100001");
     statements STx  = new statements("STx",0,3,"m","000100");
     statements sSTx  = new statements("+STx",0,4,"m","000100");
     statements STb  = new statements("STb",0,3,"m","011110");
     statements sSTb  = new statements("+STb",0,4,"m","011110");
     statements STa  = new statements("STa",0,3,"m","000011");
     statements sSTa  = new statements("+STa",0,4,"m","000011");
     statements LDCH = new statements("LDCH",0,3,"m","010100");
     statements lLDCH = new statements("+LDCH",0,4,"m","010100");
     statements STCH = new statements("STCH",0,3,"m","010101");
     statements sSTCH = new statements("+STCH",0,4,"m","010101");
     statements ADD  = new statements("ADD",0,3,"m","000110");
     statements aADD  = new statements("+ADD",0,4,"m","000110");
     statements SUB  = new statements("SUB",0,3,"m","000111");
     statements sSUB  = new statements("+SUB",0,4,"m","000111");
     statements ADDR = new statements("ADDR",2,3,"r","100100");
     statements aADDR = new statements("+ADDR",2,4,"r","100100");
     statements SUBR = new statements("SUBR",2,2,"r","10010100");
     statements COMP = new statements("COMP",0,3,"m","001010");
     statements cCOMP = new statements("+COMP",0,4,"m","001010");
     statements COMR = new statements("COMPR",2,2,"r","10100000");
     statements J    = new statements("J",0,3,"m","001111");
     statements jJ    = new statements("+J",0,4,"m","001111");
     statements JEQ  = new statements("JEQ",0,3,"m","001100");
     statements jJEQ  = new statements("+JEQ",0,4,"m","001100");
     statements JLT  = new statements("JLT",0,3,"m","001110");
     statements jJLT  = new statements("+JLT",0,4,"m","001110");
     statements JGT  = new statements("JGT",0,3,"m","001101");
     statements jJGT  = new statements("+JGT",0,4,"m","001101");
     statements TIX  = new statements("TIX",0,3,"m","001011");
     statements tTIX  = new statements("+TIX",0,4,"m","001011");
     statements TIXR = new statements("TIXR",1,2,"r","10111000");
        stat.add(lLDs);
        stat.add(RMO);
        stat.add(LDx);
        stat.add(lLDx);
        stat.add(LDs);
        stat.add(LDt);
        stat.add(lLDt);
        stat.add(LDa);
        stat.add(lLDa); 
        stat.add(LDb);
        stat.add(lLDb);
        stat.add(STx);
        stat.add(sSTx);
        stat.add(STs);
        stat.add(sSTs);
        stat.add(STt);
        stat.add(sSTt);
        stat.add(STb);
        stat.add(sSTb);
        stat.add(STa);
        stat.add(sSTa);
        stat.add(LDCH);
        stat.add(STCH);
        stat.add(ADD);
        stat.add(SUB);
        stat.add(ADDR);
        stat.add(lLDCH);
        stat.add(sSTCH);
        stat.add(aADD);
        stat.add(sSUB);
        stat.add(aADDR);
        stat.add(SUBR);
        stat.add(COMP);
        stat.add(cCOMP);
        stat.add(COMR);
        stat.add(J);
        stat.add(jJ);
        stat.add(JEQ);
        stat.add(JLT);
        stat.add(JGT);
        stat.add(jJEQ);
        stat.add(jJLT);
        stat.add(jJGT);
        stat.add(TIX);
        stat.add(tTIX);
        stat.add(TIXR);
        
        Registers.add("A");
        Registers.add("B");
        Registers.add("X");
        Registers.add("S");
        Registers.add("T");
        opcodeReg.add("0000");
        opcodeReg.add("0011");
        opcodeReg.add("0010");
        opcodeReg.add("0100");
        opcodeReg.add("0101");
        
        
    }

    
    void storeFile(){
        
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(this.fileName));
            String line = reader.readLine();
           
            while(line!=null){                
               
                fileLines.add(line);
                line = reader.readLine();            
            }
            reader.close();
        }catch(IOException e){
        }
    }
    
    void decode()
    {
        boolean opfound = false;
        int x,reg = 0;
        char dot;
        for(int i = 0; i < fileLines.size(); i++)
        {   
            increment = 0;
            each = each.reset_ListFile(each);
            String[] splited = (fileLines.get(i)).split("\\s+");
           
            each.line = linecounter++;
         try{   
             splited[0].charAt(0);
             }
         catch(Exception e )
             {
              String temp[] = new String[splited.length - 1];
                
                for(int k = 1; k< splited.length; k++)
                {
                    temp[k-1] = splited[k];
                }
               
                splited = temp;
             }
          
            dot  = splited[0].charAt(0);
            if( dot != '.')
            {
            // System.out.println("not comment");
               
               if(directive_detect(splited,0)== -1)    
               {//String r[]=splited[0].split("+");
                   if(operation_detect(splited,0)!= -1)
                         { //System.out.println("herh");
                                 each.mnemonic = splited[0];
                                 //reg=stat.get(operation_detect(splited[0])).opreands;
                                 
                              if(splited.length<2 || splited[1].charAt(0) == '.')
                                  error_handler(3);
                              else{
                                  
                                  register_check(splited, 1);    
                                 
                                  if(splited.length >= 3)
                                     comment_detect(splited[2]); 
                                  }
                         }
                 
                    else {
                        
                                each.label=splited[0];
                                
                                if(directive_detect(splited,1) == -1)
                                {
                                    if(operation_detect(splited,1) != -1)
                                   {
                                        each.mnemonic=splited[1];
                                        
                                        if(splited.length<3 || splited[2].charAt(0) == '.')
                                            error_handler(3);
                                        else
                                        {
                                            register_check(splited,2); 
                                            
                                             if(splited.length>=4)
                                                comment_detect(splited[3]);                                                                             
                                            
                                        }
                                        
                                        
                                   }
                                  else
                                   {
                                       error_handler(2);
                                   }
                                }
                        
                             if(!splited[1].equalsIgnoreCase("equ"))     
                                update_label(splited[0],mainmemory);
                         }
               }
               
            if(splited.length>3)
             {   
                if(splited[3].charAt(0)=='.')
                {
                   each.comments=splited[3];               
                }
             }
            
            }
         
            else 
            {    
           // System.out.println("comment");
            each = each.reset_ListFile(each);
            each.line = linecounter - 1;
            each.commentline = true;
            each.comments = fileLines.get(i);
            
            
            
            }
            each.memory = mainmemory;
            listfile.add(new ListFile(each.commentline,each.line,each.memory,each.label,each.mnemonic,each.operands,each.comments,each.error,each.errorMessage));
            mainmemory = mainmemory + increment;
        }
        if(!end_flag)
            error_handler(13);
        
        //display_label();
       //display_list();
        
    }
     
   
    void fixedDecode(){
        
        boolean opfound = false;
        int x,reg = 0;
        
        fixedFormat = true;
        storeFixedLabels();
        
        for(int i = 0; i < fileLines.size(); i++){
            
            boolean isDirective = false;
            Byte = resw = resb = hexaNumber = false;
            increment = 0;
            each.reset_ListFile(each);
            boolean error = false;
            each.line = linecounter++;
            
            String line = fileLines.get(i);
            
            if(line.length() == 0){//If the line is empty
                               
               each.reset_ListFile(each);
               error_handler(2);
               error = true;
                               
            }
            else if( line.charAt(0) == '.' ){//If the entire line is a comment
                
               each.reset_ListFile(each);
               if(line.length() > 66 )//If the line exceeds the maximum allowed bytes in a single line, only scan till 66th byte
                    each.comments = line.substring(0, 66);
               //each.comments = line.substring(0, 65);
               else
                   each.comments = line;
               
               each.line = linecounter-1;
               each.commentline = true;
                
            }
            else{
                
                String splited[] = new String[4];
                String word = new String();
            
                //-----------------------------------------
                //      Reading the FIRST word(label)
                
                if(line.length() < 10){//If there is NOT enough space for an "operation" to fit in
                    
                    word = line.substring(0, line.length());
                    //word = line.substring(0, line.length() - 1);
                    word = word.replaceAll("\\s", "");//Remove any spaces that may exist AT THE END of the scanend word      
                    each.label  = word;
                    splited[0]  = word;
                    update_label(word,mainmemory);
                    
                    error_handler(2);//Missing or misplaced operation mnemonic
                    error = true;
                }
                else{
                    
                    word = line.substring(0,8); 
                    //word = line.substring(0,7);
                    
                    if(word.charAt(0) == ' '){//Checks if the label has an empty space at the begining
                                              //If true, then either 1)there is no label or 2) the label starts with a whitespace, which is error(1)
                        
                        boolean label = false;
                        for(int j = 0; j < word.length(); j++){
                            
                            if(word.charAt(j) != ' ')                             
                                label = true;
                            
                        }
                        
                        if(label == false){//If this condition is met, then this means that there is no label
                            each.label = null;
                            splited[0] = null;
                        }
                        else{//Else, there is a label that starts with a space, which is error(1)
                                                      
                            error_handler(1);
                            each.label = word;
                            //update_label(word.replaceAll("\\s", ""));
                            update_label(word,mainmemory);
                            error = true;
                        }
                        
                    }
                    else{
                        
                        word = word.replaceAll("\\s", "");//Remove any spaces that may exist AT THE END of the scanend word
                        each.label = word;
                        splited[0] = word;
                        update_label(word,mainmemory);
                    }
                }
                
                //-----------------------------------------
                //      Reading the second word(operation)
                
                if( (error == false) && (line.length() < 15 ) ){//If the lenght is < 15 and no previous errors detected, then it is error 3
                    
                    error_handler(3);
                    error = true;
                }
                else if(error == false){//Check that no error happened before scaning the operation
                    
                    //word = line.substring(9,14);
                    word = line.substring(9,15);
                    word = word.replaceAll("\\s", ""); 
                    splited[1] = word;                        
                    
                    if(directive_detect(splited, 1) == -1){//Check it s a directive
                        
                        if(operation_detect(splited,1)!= -1){//check if it is a mnemonic
                                               
                            each.mnemonic = word;
                            fixedOperation[0] = word;
                        }
                        else{//Else the operation in urecognized or misplaced/missing
                            
                            fixedOperation[0] = word;
                            each.mnemonic = word;
                            error_handler(8);
                            error = true;
                        }
                    }
                    else{//Else the operation is a directive
                        
                        isDirective = true;                        
                        each.mnemonic = word;
                        fixedOperation[0] = word;
                    }
                }
                
                 //-----------------------------------------
                //      Reading the Third word(operand)
                
                if( (error == false) ){
                    
                    if(line.length() < 35){//If the length is les than 35, then there is no comment
                        
                        //word = line.substring(17, line.length() - 1);
                        word = line.substring(17, line.length() );
                        word = word.replaceAll("\\s", ""); 
                        splited[2] = word;
                        
                        if(! isDirective)
                          register_check(splited,2);//Checks for errors and saves the operand
                        else{
                            
                            storeDirectiveOperand(word);
                        }
                                                
                    }
                    else{//Else after there is a comment. So after scanning the operand, scan the comment as well
                        
                        word = line.substring(17, 35);
                        //word = line.substring(17, 34);
                        word = word.replaceAll("\\s", ""); 
                        splited[2] = word;
                        
                        if(! isDirective)
                          register_check(splited,2);//Checks for errors and saves the operand
                        else{
                            
                            storeDirectiveOperand(word);
                        }
                        
                         //-----------------------------------------
                        //      Reading the fourth word(Comment)
                        
                        if(line.length() > 66){//If the comment exceeds the allowed limit, only scan until the 66th byte
                            
                            //word = line.substring(35, 65);
                            word = line.substring(35, 66);
                            //Since it is a comment there is no need to remove any space ath the end of it
                            //word = word.replaceAll("\\s", "");
                            each.comments = word;
                            splited[3] = word;
                        }
                        else{//Else,scan the entire comment
                            
                            word = line.substring(35, line.length());
                            //word = line.substring(35, line.length() - 1);
                            //word = word.replaceAll("\\s", "");
                            each.comments = word;
                            splited[3] = word;
                        }
                        
                    }
                }
                               
             
            }
            
            //---------------------------------
            //     Saving the results
            each.memory = mainmemory;
            listfile.add(new ListFile(each.commentline,each.line,each.memory,each.label,each.mnemonic,each.operands,each.comments,each.error,each.errorMessage));
            mainmemory = mainmemory + increment;
        }
        
        if(!end_flag)
            error_handler(13);

        //display_label();
        //display_list();       
        
    }
   
    //A function that deals with storing the operand of a directive and handling all special cases and errors
    void storeDirectiveOperand(String word){
        
                            if(hexaNumber == true){//Check if the operand is "EXPECTED TO BE" hexa, then convert it. Used with "START" & "ORG"
                            
                                mainmemory = each.memory = getDecimal(word);
                                each.operands = word;
                            }                   
                            else if(Byte){//Special case used only in the operation is directive "BYTE"
                                checkByte(word);
                            }
                            else if(Word){
                                each.operands = word;
                            }
                            else if(resw){//Special case used only in the operation is directive "RESW"          
                                
                                try{
                                    increment = 3*Integer.parseInt(word);
                                }
                                catch(NumberFormatException e){
                                    error_handler(14);
                                }
                                each.operands = word;
                            }
                            else if(resb){//Special case used only in the operation is directive "RESB"
                                try{
                                    increment = Integer.parseInt(word);
                                }
                                catch(NumberFormatException e){
                                    error_handler(14);
                                }
                                each.operands = word;                               
                            }
                            else{
                                
                                if(checkHexaAddress(word) && !Word){//Check if operand is a hexa address
                                    
                                    if( ! checkLabelOperand(word.substring(1) ) )//check if it is defined/exists
                                        error_handler(9);
                                    
                                    each.operands = word;
                                    
                                }
                                else{
                                    
                                    boolean isHexa = true;
                                    int t;
                                    try{
                                        t = Integer.parseInt(word,16);

                                    }
                                    catch(NumberFormatException e){
                                        isHexa = false;
                                    }
                                    
                                    if(isHexa){
                                        each.operands = word;
                                    }
                                    else{                                      
                                        
                                        if( ! checkLabelOperand(word) )//check if it is defined/exists
                                             error_handler(9);
                                    
                                        each.operands = word;
                                    }
                                }
                                
                                
                            }        
        
    }
    
    boolean Register_detect(String line)
    {
       for(int i=0;i<Registers.size();i++)
       {
        if(line.equalsIgnoreCase(Registers.get(i)))
        { //System.out.println(i);
            return true;
           
        }
            
       }
       return false;
        
    
    }
    
    
    int operation_detect(String[] line,int q)
    {
        for(int i =0; i<stat.size(); i++)
        {
            if(line[q].equalsIgnoreCase(stat.get(i).name))
            {   
                 memory_incremenation(stat.get(i).format, line[q]);                
                return i;
            }
        }
        return -1;
        
    }
    
    
    int directive_detect(String[] line,int i)
    {
        if(line[i].equalsIgnoreCase("START"))
        {
            
            each.mnemonic = line[i];
            
            if(fixedFormat == false){
                
                mainmemory = each.memory = getDecimal(line[i+1]);
                each.operands = line[i+1];
                
            }
            else
            {
                
                hexaNumber = true;      
                
            }
            
            
            return i;
        }
        else if(line[i].equalsIgnoreCase("END"))
        {   
            if(each.label != null)
                error_handler(5);
            
            end_flag = true;           
            each.mnemonic = line[i];
            
            if(fixedFormat == false)
                each.operands = line[i+1];
                
            return i;
            
        }
        
        else if(line[i].equalsIgnoreCase("ORG"))
        {lblfile o=null;
            if(each.label != null)//Check for error first
                error_handler(5);
               
            each.mnemonic = line[i];
            
            if(fixedFormat == false)
            {
              o=checklabel(line[i+1]);  
                if(o==null)
                {
                
                increment = getDecimal(line[i+1]) - mainmemory;
                each.operands = line[i+1];
                    
                }
                else
                { String n= Integer.toString(o.memory);
                 increment = o.memory-mainmemory;
                 each.operands=line[i+1];
                }
            }
             else{
                    
                  hexaNumber = true;                    
                }
            
               return i;        
            
        }
       else if(line[i].equalsIgnoreCase("BYTE"))
       {
           each.mnemonic = line[i];
           
           if(fixedFormat == false){
               
            switch (line[i+1].charAt(0)) {
                
                case 'C':
                    increment = 1;
                    break;
                case 'X':
                    increment = 1;
                    if(!check_hexa(line[i+1]))
                        error_handler(10);
                    break;
          
                default:
                  //String r[]=line[i+1].split("'");
                  //  System.out.println(r[0]);
                    error_handler(9);
                    break;
            }
            each.operands = line[i+1];
           }
           else{
               Byte = true;
           }
          
           return i;
       }
        else if(line[i].equalsIgnoreCase("WORD"))
        {
            increment = 3;
            each.mnemonic = line[i];
            
            if(fixedFormat == false)
                each.operands = line[i+1];
            else 
                Word = true;
            
            return i;
        }
        else if(line[i].equalsIgnoreCase("RESB"))
        { 
          
          each.mnemonic = line[i];
          
          if(fixedFormat == false){
              each.operands = line[i+1];
              increment = Integer.parseInt(line[i+1]);
          }
          else
              resb = true;
          
          return i;
        }
        else if(line[i].equalsIgnoreCase("RESW"))
        {
            each.mnemonic = line[i];
            
            if(fixedFormat == false){
                increment = 3*Integer.parseInt(line[i+1]);          
                each.operands = line[i+1];
            }
            else
                resw = true;
          
          return i;
            
        }
        else if(line[i].equalsIgnoreCase("EQU"))
        {
          each.mnemonic=line[i];
          each.operands=line[i+1];
            
          lblfile o=  checklabel(line[i+1]);
          
          if(o!=null)
          {  // System.out.println("found");
              update_label(line[i-1],o.memory);
              
          }
          else
          
           if(arithematic_evaluate(line[i+1])!=-1)
               update_label(line[i-1],arithematic_evaluate(line[i+1]));
          else
              error_handler(9);
          
            
            return i;
        }
        else if(line[i].equalsIgnoreCase("BASE"))
        {
            return i;
        }
        
        if( fixedFormat == false){
            
            if(line.length >= i+2+1 )
            {
                 if(line[i+2].charAt(0) == '.')
                {
                    each.comments = line[i+2];
                 }
            }
        }
        
        return -1;
    }
    
    public int register_check(String[] line ,int i)
    {
        int reg,form = 0,address=0;
        
        if(fixedFormat == false)
        {   reg = stat.get(operation_detect(line,i-1)).opreands;
            form=stat.get(operation_detect(line,i-1)).format;
        }
        else
        {
            reg = stat.get(operation_detect(fixedOperation,0)).opreands;
            //reg = operation_detect(line,i-1);
            //System.out.println(reg + "REG");              
        }
        
                        if (reg>0)
                                    {
                                        if(reg<2)
                                        {
                                            if(Register_detect(line[i]))
                                            {
                                                
                                 //             System.out.println("Register Found");
                                                each.operands=line[i];
                                                return 0;
                                           
                                            }
                                            else
                                            {
                                    //            System.out.println("Register undefined"); 
                                                error_handler(12);
                                                each.operands=line[i];
                                                return -1;
                                            }
                                        }
                                        else
                                        {
                                 //           System.out.println("two registers");
                                            String[] divided=line[i].split(",");
                                            
                                            for (String divided1 : divided) 
                                            {
                                                 if(! Register_detect(divided1) )
                                                    error_handler(12);
                                            }
                                            
                                            each.operands=line[i];
                                            
                                        return 0;
                                        }
                                    }
                        else
                        {//Else, the operand is a memory location or direct
                            
                            
                            
                            each.operands = line[i];
                            String ar[]=line[i].split(",");
                            if( (line[i].charAt(0) == '@' || line[i].charAt(0) == '#' )&& ar.length>1)                                        
                                error_handler(9);    
                            else if(ar.length>2)
                                error_handler(9);
                            if(ar.length==2 && Register_get(ar[1])==-1 )
                                error_handler(9);
                            if(ar.length==2 || ar.length==1)
                            {   if(arithematic_evaluate(ar[0])!=-1)
                            {
                                if(arithematic_evaluate(ar[0])>4095)
                                error_handler(15);
                            }
                            else 
                                        error_handler(9);
                            }
                            
                                
                            
                            
                        if(fixedFormat == true){
                                
                            String word = line[i];
                            
                            if(checkHexaAddress(word)){//Check if operand is a hexa address
                                    
                                if( ! checkLabelOperand(word.substring(1)) )//check if it is defined/exists
                                    error_handler(9);
                                    
                                each.operands = word;
                                    
                            }
                            else{
                                    
                                boolean isHexa = true;
                                int t;
                               try{
                                    t = Integer.parseInt(word,16);

                                }
                                catch(NumberFormatException e){
                                    isHexa = false;
                                }
                                    
                                if(isHexa){
                                    each.operands = word;
                                }
                                else{                                      
                                    
                                    if( word.charAt(0) != '@' && word.charAt(0) != '#')//Check if the operand is direct or not
                                        if( ! checkLabelOperand(word.substring(1)) )//check if it is defined/exists
                                            error_handler(9);
                                    
                                    each.operands = word;
                                    }
                            }
                        }                            
                            
                            return 0;
                        }
        
      
    }
   
    
   public  int getDecimal(String hex)
   {
        boolean isHexa = true;
        int x;
        try{
            x = Integer.parseInt(hex,16);
           
        }
        catch(NumberFormatException e){
            isHexa = false;
        }
   
        if(isHexa == true){ 
            
             String digits = "0123456789ABCDEF";  
             hex = hex.toUpperCase();  
             int val = 0;  
             for (int i = 0; i < hex.length(); i++)  
             {  
                 char c = hex.charAt(i);  
                 int d = digits.indexOf(c);  
                 val = 16*val + d;  
             }  
             return val;  
        }
        else//If the input is not a hexa, set it to default zero and siplay error(14)
        {
            error_handler(14);
            return 0;
        }
   }  
    
    void display_list()
    {
        for(int i=0;i<fileLines.size();i++)
        {
            if(!listfile.get(i).commentline)
                System.out.println(listfile.get(i).line+"    "+listfile.get(i).memory+"    "+listfile.get(i).label+"   "+listfile.get(i).mnemonic+"   "+listfile.get(i).operands+"    "+listfile.get(i).comments);
            else
                System.out.println(listfile.get(i).line+"    "+listfile.get(i).memory+"    "+listfile.get(i).comments+"  ");
        
        }
    }
    
    void comment_detect(String line)
    {
        if(line.charAt(0)=='.')
        {
            each.comments=line;
        }
         
        
    }
    
    void memory_incremenation(int i,String line)
    {
        if(i == 2)
        {
            increment = 2;
            if(line.charAt(0) == '+')
            {
                error_handler(11);
            }
            //else
                //increment = 2;
        }
       else if(i==3)
        {
            if(line.charAt(0) == '+')
            {
                increment = 4;
            }
            else if(  ( (line.charAt(0) >= 'a' && line.charAt(0) <= 'z') || (line.charAt(0) >= 'A' && line.charAt(0) <= 'Z')||(line.charAt(0) >= '0' && line.charAt(0) <= '9')|| line.charAt(0)=='@' ||line.charAt(0)=='#' ) )
            {
                increment = 3;
                
            }
            else
            {
                error_handler(7);
                increment = 3;
            }
        }
    }
   
    void update_label(String line, int location)
    { 
        boolean found = false;
    
        for(int i=0;i<lbllist.size();i++)
        {
            if(line.equalsIgnoreCase(lbllist.get(i).name))
            {
               
                
                
                found=true;
            }
        }
        if(!found)
        { 
            lbllist.add(new lblfile(line, location));
        }
        else 
        {
            error_handler(4);
        }
        
    }
    
    void display_label()
    {
        for ( int i = 0 ; i<lbllist.size();i++)
        {
            System.out.println(lbllist.get(i).memory+"    "+lbllist.get(i).name);
        }
    }
    
    boolean check_hexa(String line)
    {
        int x;
        String rt[] = line.split("'");
        try{
            x = Integer.parseInt(rt[1],16);
           
        }
        catch(NumberFormatException e){
            return false;
        }
         return true;
        
    }
    void error_handler(int error)
    {
        noerror=1;
       switch(error){
           
           case 1:
            each.error = true;
            each.errorMessage = "Misplaced Label";
            break;
           case 2:
            each.error = true;
            each.errorMessage = "Missing or misplaced operation mnemonic";
            break;
           case 3:
            each.error = true;
            each.errorMessage = "Missing or misplaced operand field";
            break;
           case 4:
            each.error = true;
            each.errorMessage = "Duplicate label definition";
            break;
           case 5:
            each.error = true;
            each.errorMessage = "This statement can't have a label";
            break;
           case 6:
            each.error = true;
            each.errorMessage = "This staement can't have a label";
            break;
           case 7:
            each.error = true;
            each.errorMessage = "Wrong operation prefix";
            break;
           case 8:
            each.error = true;
            each.errorMessage = "Unrecognized operation code";
            break;
            //Error 9
            //Happens when the operand has a symbol other than "#" or "@" 
            //OR when the operand is a memory location that was not defined
           case 9:
            each.error = true;
            each.errorMessage = "Undefined symbol in operand";
            break;
           case 10:
            each.error = true;
            each.errorMessage = "Not a hexadecimal string";
            break;
           case 11:
            each.error = true;
            each.errorMessage = "Can't be format 4";
            break;
           case 12:
            each.error = true;
            each.errorMessage = "Illegal address for a register";
            break;
           case 13:
            each.error = true;
            each.errorMessage = "Missing END statement";   
            
           //Additional error:Happens when either "START" / "ORG" recieve a non hexa operand
           case 14:
            each.error = true;
            each.errorMessage = "Illegal operand";
            break;
           case 15:
            each.error=true;
            each.errorMessage="Memory out of Range";
            break;
       }
    }      
    String pure_operation(String mixed)
    {
          if(mixed.charAt(0) == '+')
          {
              String[] pure=mixed.split("+");
              return pure[1];
          }
          else
        return null;
        
          
      } 
    void checkByte(String operand)
    {
          
          switch (operand.charAt(0)) {
                
                case 'C':
                    increment = 1;
                    break;
                    
                case 'X':
                    increment = 1;
                    if(!check_hexa(operand))
                        error_handler(10);
                    break;

                default:
                  //String r[]=line[i+1].split("'");
                  //  System.out.println(r[0]);
                    error_handler(9);
                    break;
            }
            each.operands = operand;
      }
    boolean checkHexaAddress(String operand)
    {
        
        boolean aTof;
      
        aTof = (operand.charAt(1) >= 'A' && operand.charAt(1) <= 'F') || (operand.charAt(1) >= 'a' && operand.charAt(1) <= 'f');
        
        return aTof && operand.charAt(0) == '0';
    }   
    void storeFixedLabels()
    {//A function that goes through all labels and stores them
        
        String line = new String();
        for(int i = 0; i < fileLines.size(); i++){
           
            line = fileLines.get(i);
            line = line.substring(0, 8);
            line = line.replaceAll("\\s", "");
            System.out.println(line);
            fixedLabelTabel.add(line);
        }
    }
    
    boolean checkLabelOperand(String operand){//Checks if the operand of type memory has been defined or not
        
         for(int i = 0; i < fixedLabelTabel.size(); i++){
             if( operand.equalsIgnoreCase(fixedLabelTabel.get(i)) )
                 return true;
         }
         return false;
    }
    
    lblfile checklabel (String label)
    {
        for(int i=0;i<lbllist.size();i++)
        {
            if(label.equalsIgnoreCase(lbllist.get(i).name))
            {
               
                
                
                return lbllist.get(i);
            }
        }
        
        
        return null;
        
    }
    
    int opcode_generate ()
    {
        String op="";
        int lin=-1;
        Print_objfile l = new Print_objfile();
        l.starting_adress=listfile.get(0).memory;
        l.program_name=listfile.get(0).label;
        l.length=listfile.get(listfile.size()-1).memory-listfile.get(0).memory-1;
        for(int i=0;i<listfile.size();i++)
        { op="";
            if(listfile.get(i).mnemonic.equals("Start"))
            {
                locctr=Integer.parseInt(listfile.get(i).operands);
                listfile.get(i).objcode=listfile.get(i).operands;
            }
            else if(listfile.get(i).error)
            {
                return -1;
            }
            else
            {
                lin =getop(listfile.get(i).mnemonic);
                if(!(lin<0))
                op=op+stat.get(lin).opcode;
                       
            }
           
            if(!(lin<0))
            {
                //Format 2
                
                if(stat.get(lin).format==2)
            {
                String a[]=listfile.get(i).operands.split(",");
                //System.out.println(a[0]+" "+a[1]);
                op=op+opcodeReg.get(Register_get(a[0]))+opcodeReg.get(Register_get(a[1]));
                System.out.println(op);
                op_hex = convertBinaryToHexadecimal(op);
                System.out.println(op_hex);
                l.opcode=l.opcode+op_hex;
            }
                //Format 3 or Format 4
                
            else
            { 
                
                switch (listfile.get(i).operands.charAt(0))
                {
                    case '@': 
                        op=op+"100";
                        break;
                    case '#':
                        op=op+"010";
                        break;
                    default:
                        op=op+"11";
                        String a[]=listfile.get(i).operands.split(",");
                        
                        if(a.length>2)
                            error_handler(9);
                        else if(a.length==2)
                            op=op+"1";
                        else
                            op=op+"0";
                        break;
                }
               System.out.println(listfile.get(i).mnemonic+" "+listfile.get(i).operands+" "+op); 
               
           //Format 4
           
               if (stat.get(lin).format==4)
            {
                op=op+"001";
                //System.out.println("lol: "+listfile.get(i).operands);
                char y[]=new char[listfile.get(i).operands.length()];
                System.out.println("lol: "+listfile.get(i).operands.charAt(0));
                if(listfile.get(i).operands.charAt(0)=='@'|| listfile.get(i).operands.charAt(0)=='#'){
                    
                    for(int z=0;z<listfile.get(i).operands.length()-1;z++){
                    y[z]=listfile.get(i).operands.charAt(z+1);
                }
                }
                else
                {
                      for(int z=0;z<listfile.get(i).operands.length();z++){
                    y[z]=listfile.get(i).operands.charAt(z);
                } 
                }
             op_hex = convertBinaryToHexadecimal(op);
            //System.out.println(op_hex);
                System.out.println("y: "+y[0]);
                if(y.length==5)
                op_hex=op_hex+"0";
                if (y.length==4)
                  op_hex=op_hex+"00";
                if(y.length==3)
                  op_hex=op_hex+"000";
                if(y.length==2)
                    op_hex=op_hex+"0000";
             for(int z=0;z<y.length;z++)   
            op_hex=op_hex+y[z];
                System.out.println("op:"+op_hex);
                l.opcode=l.opcode+op_hex;
            }
               
            //Format 3
               
            else
            {
                char f[]=new char[listfile.get(i).operands.length()];
                if(listfile.get(i).operands.charAt(0)=='@'|| listfile.get(i).operands.charAt(0)=='#'){
                   for(int z=0;z<listfile.get(i).operands.length()-1;z++){
                    f[z]=listfile.get(i).operands.charAt(z+1);
                }
                }
                 else
                {
                      for(int z=0;z<listfile.get(i).operands.length();z++){
                    f[z]=listfile.get(i).operands.charAt(z);
                }  
                        }
                System.out.println("f: "+f[0]);
                char []kl=new char[f.length-1];
                for(int k=0;k<f.length-1;k++)
                    kl[k]=f[k];
                     if( Integer.parseInt(new String(kl))-listfile.get(i+1).memory<2047 && Integer.parseInt(new String(kl))-listfile.get(i+1).memory>-2048 )
                         {
                            op=op+"010";
                             System.out.println(op);
                         }
                    else 
                         { 
                            op=op+"100";
                             System.out.println(op);
                         }
            char y[]=new char[listfile.get(i).operands.length()];
                System.out.println("lol: "+listfile.get(i).operands.charAt(0));
                if(listfile.get(i).operands.charAt(0)=='@'|| listfile.get(i).operands.charAt(0)=='#'){
                    
                    for(int z=0;z<listfile.get(i).operands.length()-1;z++){
                    y[z]=listfile.get(i).operands.charAt(z+1);
                }
                }
                else
                {
                      for(int z=0;z<listfile.get(i).operands.length();z++){
                    y[z]=listfile.get(i).operands.charAt(z);
                } 
                }
                     op_hex = convertBinaryToHexadecimal(op);
            //System.out.println(op_hex);
                System.out.println("y: "+y[0]);
                if(y.length==4)
                op_hex=op_hex+"0";
                if (y.length==3)
                  op_hex=op_hex+"00";
                if(y.length==2)
                  op_hex=op_hex+"000";
             for(int z=0;z<y.length;z++)   
            op_hex=op_hex+y[z];
                System.out.println("op:"+op_hex);
                l.opcode=l.opcode+op_hex;
            }
            }
            }
        listfile.get(i).operands=op;

        }
        
        
    //    System.out.println("here");
        
        l.print();
        return 0;
        
    }
    
     public static String convertBinaryToHexadecimal(String number) {
        String hexa = "";
        char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        if (number != null && !number.isEmpty()) {
            int decimal = convertBinaryToDecimal(number);
            while (decimal > 0) {
                hexa = hex[decimal % 16] + hexa;
                decimal /= 16;
            }
            //System.out.println("The hexa decimal number is: " + hexa);
        }
        return hexa;
    }
     public static int convertBinaryToDecimal(String number) {
        int length = number.length() - 1;
        int decimal = 0;
        if (isBinary(number)) {
            char[] digits = number.toCharArray();
            for (char digit : digits) {
                if (String.valueOf(digit).equals("1")) {
                    decimal += Math.pow(2, length);
                }
                --length;
            }
           //System.out.println("The decimal number is : " + decimal);
        }
        return decimal;
    }
    public static boolean isBinary(String number) {
        boolean isBinary = false;
        if (number != null && !number.isEmpty()) {
            long num = Long.parseLong(number);
            while (num > 0) {
                if (num % 10 <= 1) {
                    isBinary = true;
                } else {
                    isBinary = false;
                    break;
                }
                num /= 10;
            }
        }
        return isBinary;
    }
    int getop(String name)
    {
         for(int j=0;j<stat.size();j++)
               {
                   if(stat.get(j).name.equalsIgnoreCase(name))
                   {
                      return j;
                   }
               }
        return -1;
    }
    
    int Register_get(String line)
    {
       for(int i=0;i<Registers.size();i++)
       {
        if(line.equalsIgnoreCase(Registers.get(i)))
        { //System.out.println(i);
            return i;
           
        }
            
       }
       return -1;
    }
    
    int arithematic_evaluate(String a)
    { int left,right;
       
        if(a.contains("@"))
        { 
          String str[]=a.split("@");
          lblfile indirects=checklabel(str[1]);
          if(indirects==null)
          {try{Integer.parseInt(str[1]);}
           catch (Exception e)
            {
              return -1;
            }
          return Integer.parseInt(str[1]);
          }
          else
          {   System.out.println("here "+indirects.memory);
              return indirects.memory;
          }
        }
         if(a.contains("#"))
        { 
          String str[]=a.split("#");
          lblfile indirects=checklabel(str[1]);
          if(indirects==null)
          {try{Integer.parseInt(str[1]);}
           catch (Exception e)
            {
              return -1;
            }
          return Integer.parseInt(str[1]);
          }
          else
          {   System.out.println("here "+indirects.memory);
              return indirects.memory;
          }
        }
        else if(a.contains("h"))
        { 
          String str[]=a.split("h");
          
          
          {
           try
          {
              Integer.parseInt(str[0],16);
          }
           catch (Exception e)
            {
              return -1;
            }
              System.out.println("hexa "+Integer.parseInt(str[0],16));
           return Integer.parseInt(str[0],16);
          }
          
        }
        else if(a.contains("-"))
        {
          String str[]=a.split("-");
          if(str.length>2)
          {
              error_handler(9);
              return -1;
          }   
          lblfile first  =  checklabel(str[0]);
          lblfile second = checklabel(str[1]);  
          
          if(first!=null)
          {
              left=first.memory;
          }
          else
          { 
          try
          {
              left=Integer.parseInt(str[0]);
              
          }
          catch (Exception e)
          {
              return -1;
          }
              
          }
          
              if(second!=null)
          {
              right=second.memory;
          }
          else
          { 
          try
          {
              right=Integer.parseInt(str[1]);
              
          }
          catch (Exception e)
          {
              return -1;
          }
              
          }
           System.out.println("here "+ (left-right));
             return left-right;
        }
        
        else if(a.contains("+"))
        {
          String str[]=a.split("\\+");
          if(str.length>2)
          {
              error_handler(9);
              return -1;
          }   
          lblfile first  =  checklabel(str[0]);
          lblfile second = checklabel(str[1]);  
          
          if(first!=null)
          {
              left=first.memory;
          }
          else
          { 
          try
          {
              left=Integer.parseInt(str[0]);
              
          }
          catch (Exception e)
          {
              return -1;
          }
              
          }
          
              if(second!=null)
          {
              right=second.memory;
          }
          else
          { 
          try
          {
              right=Integer.parseInt(str[1]);
              
          }
          catch (Exception e)
          {
              return -1;
          }
              
          }
             System.out.println("here "+ (left+right));
             return left+right;
        }
        else if(a.contains("*"))
        {
          String str[]=a.split("\\*");
          if(str.length>2)
          {
              error_handler(9);
              return -1;
          }   
          lblfile first  =  checklabel(str[0]);
          lblfile second = checklabel(str[1]);  
          
          if(first!=null)
          {
              left=first.memory;
          }
          else
          { 
          try
          {
              left=Integer.parseInt(str[0]);
              
          }
          catch (Exception e)
          {
              return -1;
          }
              
          }
          
              if(second!=null)
          {
              right=second.memory;
          }
          else
          { 
          try
          {
              right=Integer.parseInt(str[1]);
              
          }
          catch (Exception e)
          {
              return -1;
          }
              
          }
             System.out.println("here "+ (left*right));
             return left*right;
        }
        else if(a.contains("/"))
        {
          String str[]=a.split("\\/");
          if(str.length>2)
          {
              error_handler(9);
              return -1;
          }   
          lblfile first  =  checklabel(str[0]);
          lblfile second = checklabel(str[1]);  
          
          if(first!=null)
          {
              left=first.memory;
          }
          else
          { 
          try
          {
              left=Integer.parseInt(str[0]);
              
          }
          catch (Exception e)
          {
              return -1;
          }
              
          }
          
              if(second!=null)
          {
              right=second.memory;
          }
          else
          { 
          try
          {
              right=Integer.parseInt(str[1]);
              
          }
          catch (Exception e)
          {
              return -1;
          }
              
          }
             System.out.println("here "+ (left/right));
             return left/right;
        }
         else
        {
            
            try{ Integer.parseInt(a);}
            catch(Exception e)
            {
                return -1;
            }
            return Integer.parseInt(a);
        }
    
       
       
    }
    
}