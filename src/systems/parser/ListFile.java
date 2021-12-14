package systems.parser;

/**
 *
 * @author Yahia, Nour, Moustafa, Ahmed, Ramy
 */
public class ListFile {
    
    boolean commentline,error;
    public int line,memory;
    public String label,mnemonic,operands,comments,errorMessage,objcode;

    public ListFile(boolean commentline, int line, int memory, String label, String mnemonic, String operands, String comments,boolean error,String errorMessage) {
        this.commentline = commentline;
        this.line = line;
        this.memory = memory;
        this.label = label;
        this.mnemonic = mnemonic;
        this.operands = operands;
        this.comments = comments;
        this.errorMessage = errorMessage;
        this.error=error;
        this.objcode=null;
    }

    public ListFile() {
    }
    
    
    ListFile reset_ListFile(ListFile one)
    {
        one.operands=null;
        one.comments=null;
        one.label=null;
        one.line=-1;
        one.memory=-1;
        one.mnemonic=null;
        one.commentline=false;
        one.error=false;
        one.errorMessage=null;
        
        return one;
                
    }
    
    int checkNull(){//Used in printing the output text to check if there is a field that is null
        
        if(this.label == null)
            return 1;
        else if(this.mnemonic == null)
            return 2;
        else if(this.operands == null)
            return 3;
        
        return -1;//No nulls exist
                   
    }
    
}
